package goit.dev.hw5.ui.commands.user;

import goit.dev.hw5.controller.user.DeleteUserController;
import goit.dev.hw5.ui.View;
import goit.dev.hw5.ui.commands.Command;

import java.io.IOException;
import java.util.Map;

public class RemoveUserCommand implements Command {
    public static final String NAME = "remove user";
    public static final String DESC = "Remove user by name (DELETE)";

    private DeleteUserController controller;
    private View view;

    public RemoveUserCommand(DeleteUserController controller, View view) {
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
        //view.write(controller...);
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
