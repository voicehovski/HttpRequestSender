package goit.dev.hw5.ui.commands.user;

import com.google.gson.Gson;
import goit.dev.hw5.ResponseWrapper;
import goit.dev.hw5.controller.BodyController;
import goit.dev.hw5.controller.StringParamBodyController;
import goit.dev.hw5.model.User;
import goit.dev.hw5.ui.View;
import goit.dev.hw5.ui.commands.Command;

import java.io.IOException;

public class EditUserCommand implements Command {
    public static final String NAME = "edit user";
    public static final String DESC = "Send put user request";

    private StringParamBodyController controller;
    private View view;

    public EditUserCommand(StringParamBodyController controller, View view) {
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
        String id = view.enterParameter("Enter an existed user id");
        String username = view.enterParameter("Enter a username", "Currentname");
        String firstName = view.enterParameter("Enter a first name", "Current first");
        String lastName = view.enterParameter("Enter a last name", "Current last");
        String email = view.enterParameter("Enter an email", "current@email");
        String password = view.enterParameter("Enter a password");
        String phone = view.enterParameter("Enter a phone", "current phone");
        String status = view.enterParameter("Enter a status", "1");

        User user = new User(
                Long.parseLong(id),
                username,
                firstName,
                lastName,
                email,
                password,
                phone,
                Integer.parseInt(status)
        );

        String json = (new Gson()).toJson(user);
        ResponseWrapper response = controller.send(username, json);

        view.write("Status: " + response.getStatus());
        view.write(response.getBody());
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
