package goit.dev.hw5.ui.commands.user;

import com.google.gson.Gson;
import goit.dev.hw5.ResponseWrapper;
import goit.dev.hw5.controller.BodyController;
import goit.dev.hw5.model.User;
import goit.dev.hw5.ui.View;
import goit.dev.hw5.ui.commands.Command;

import java.io.IOException;
import java.util.LinkedList;

public class CreateUsersCommand implements Command {
    public static final String NAME = "create users";
    public static final String DESC = "Send create user request for several users";

    private BodyController controller;
    private View view;

    public CreateUsersCommand(BodyController controller, View view) {
        this .controller = controller;
        this.view = view;
    }

    @Override
    public boolean canExecute(String command) {
        return NAME.equalsIgnoreCase(command);
    }

    @Override
    public void execute() throws IOException {
        view.write("Enter each value or just press <Enter> to leave default value (in braces)");
        LinkedList<User> users = new LinkedList<>();
        while (true) {
            User user = reqUserData();
            String hasMoreUsers = view.enterParameter("Anybody else? y/n");
            users.add(user);
            if ("n".equalsIgnoreCase(hasMoreUsers)) {
                break;
            }
        }

        String json = (new Gson()).toJson(users);
        ResponseWrapper response = controller.send(json);

        view.write("Status: " + response.getStatus());
        view.write(response.getBody());
    }

    private User reqUserData () {
        String username = view.enterParameter("Enter a username", "username1");
        String firstName = view.enterParameter("Enter a first name", "First");
        String lastName = view.enterParameter("Enter a last name", "Last");
        String email = view.enterParameter("Enter an email", "e@mail");
        String password = view.enterParameter("Enter a password");
        String phone = view.enterParameter("Enter a phone", "+123456789");
        String status = view.enterParameter("Enter a status", "1");

        return new User(
                username,
                firstName,
                lastName,
                email,
                password,
                phone,
                Integer.parseInt(status)
        );
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public String getDesc() {
        return DESC;
    }
}
