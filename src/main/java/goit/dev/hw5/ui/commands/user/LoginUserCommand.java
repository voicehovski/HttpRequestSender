package goit.dev.hw5.ui.commands.user;

import goit.dev.hw5.ResponseWrapper;
import goit.dev.hw5.controller.StringController;
import goit.dev.hw5.controller.TwoStringController;
import goit.dev.hw5.ui.View;
import goit.dev.hw5.ui.commands.Command;

import java.io.IOException;

public class LoginUserCommand implements Command {
    public static final String NAME = "login";
    public static final String DESC = "Logs user in";

    private TwoStringController controller;
    private View view;

    public LoginUserCommand(TwoStringController controller, View view) {
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
        ResponseWrapper response = controller.send(name, password);

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