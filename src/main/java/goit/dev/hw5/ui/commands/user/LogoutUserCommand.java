package goit.dev.hw5.ui.commands.user;

import goit.dev.hw5.ResponseWrapper;
import goit.dev.hw5.controller.NoParametersController;
import goit.dev.hw5.controller.TwoStringController;
import goit.dev.hw5.ui.View;
import goit.dev.hw5.ui.commands.Command;

import java.io.IOException;

public class LogoutUserCommand implements Command {
    public static final String NAME = "logout";
    public static final String DESC = "Logs current user out";

    private NoParametersController controller;
    private View view;

    public LogoutUserCommand(NoParametersController controller, View view) {
        this .controller = controller;
        this.view = view;
    }

    @Override
    public boolean canExecute(String command) {
        return NAME.equalsIgnoreCase(command);
    }

    @Override
    public void execute() throws IOException {
        ResponseWrapper response = controller.send();

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