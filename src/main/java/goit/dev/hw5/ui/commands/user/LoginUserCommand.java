package goit.dev.hw5.ui.commands.user;

import goit.dev.hw5.controller.user.LoginUserController;
import goit.dev.hw5.ui.View;
import goit.dev.hw5.ui.commands.Command;

import java.io.IOException;
import java.util.Map;

public class LoginUserCommand implements Command {
    public static final String NAME = "login";
    public static final String DESC = "Logs user in (GET)";

    private LoginUserController controller;
    private View view;

    public LoginUserCommand(LoginUserController controller, View view) {
        this .controller = controller;
        this.view = view;
    }

    @Override
    public boolean canExecute(String command) {
        return NAME.equalsIgnoreCase(command);
    }

    @Override
    public void execute() throws IOException {
        view.write("Enter user name");
        String name = view.read();
        view.write("Enter user password");
        String password = view.read();
        int status = controller.send(Map.of("username", name, "password", password));

        view.write("Status: " + status);
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