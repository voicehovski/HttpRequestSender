package goit.dev.hw5.ui.commands.user;

import goit.dev.hw5.controller.user.LogoutUserController;
import goit.dev.hw5.ui.View;
import goit.dev.hw5.ui.commands.Command;

import java.io.IOException;
import java.util.Collections;

public class LogoutUserCommand implements Command {
    public static final String NAME = "logout";
    public static final String DESC = "Logs current user out (GET)";

    private LogoutUserController controller;
    private View view;

    public LogoutUserCommand(LogoutUserController controller, View view) {
        this .controller = controller;
        this.view = view;
    }

    @Override
    public boolean canExecute(String command) {
        return NAME.equalsIgnoreCase(command);
    }

    @Override
    public void execute() throws IOException {
        int status = controller.send(Collections.emptyMap());

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