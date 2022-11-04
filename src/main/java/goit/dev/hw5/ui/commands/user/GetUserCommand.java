package goit.dev.hw5.ui.commands.user;

import goit.dev.hw5.ResponseWrapper;
import goit.dev.hw5.controller.StringController;
import goit.dev.hw5.ui.View;
import goit.dev.hw5.ui.commands.Command;

import java.io.IOException;

public class GetUserCommand implements Command {
    public static final String NAME = "get user";
    public static final String DESC = "Get user by name";

    private StringController controller;
    private View view;

    public GetUserCommand(StringController controller, View view) {
        this .controller = controller;
        this.view = view;
    }

    @Override
    public boolean canExecute(String command) {
        return NAME.equalsIgnoreCase(command);
    }

    @Override
    public void execute() throws IOException {
        view.write("Enter a name");
        String name = view.read();
        ResponseWrapper response = controller.send(name);

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