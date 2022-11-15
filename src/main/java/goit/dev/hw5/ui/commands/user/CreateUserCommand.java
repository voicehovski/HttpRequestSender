package goit.dev.hw5.ui.commands.user;

import goit.dev.hw5.controller.user.PostUserController;
import goit.dev.hw5.model.User;
import goit.dev.hw5.ui.View;
import goit.dev.hw5.ui.commands.Command;

import java.io.IOException;
import java.util.Collections;

public class CreateUserCommand implements Command {
    public static final String NAME = "create user";
    public static final String DESC = "Create new user (POST)";

    private PostUserController controller;
    private View view;

    public CreateUserCommand(PostUserController controller, View view) {
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
        String username = view.enterParameter("Enter a username");
        String firstName = view.enterParameter("Enter a first name");
        String lastName = view.enterParameter("Enter a last name");
        String email = view.enterParameter("Enter an email");
        String password = view.enterParameter("Enter a password");
        String phone = view.enterParameter("Enter a phone");
        String status = view.enterParameter("Enter a status", "1");

        User user = new User(
                username,
                firstName,
                lastName,
                email,
                password,
                phone,
                Integer.parseInt(status)
        );

        int responseStatus = controller.send(Collections.emptyMap(), user);

        view.write("Status: " + responseStatus);
        view.write(controller.getBody());
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
