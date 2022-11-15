package goit.dev.hw5.ui.commands.user;

import goit.dev.hw5.controller.user.GetUserController;
import goit.dev.hw5.ui.View;
import goit.dev.hw5.ui.commands.Command;

import java.io.IOException;
import java.util.Map;

public class GetUserCommand implements Command {
    public static final String NAME = "get user";
    public static final String DESC = "Get user by name (GET)";

    private GetUserController controller;
    private View view;

    public GetUserCommand(GetUserController controller, View view) {
        this .controller = controller;
        this.view = view;
    }

    @Override
    public boolean canExecute(String command) {
        return NAME.equalsIgnoreCase(command);
    }

    @Override
    public void execute() throws IOException {
        view.write("Enter name");
        String name = view.read();
        int status = controller.send(Map.of("username", name));

        view.write("Status: " + status);
        view.write(controller.getEntity());
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