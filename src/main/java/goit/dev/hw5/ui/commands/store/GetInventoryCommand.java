package goit.dev.hw5.ui.commands.store;

import goit.dev.hw5.ResponseWrapper;
import goit.dev.hw5.controller.IdController;
import goit.dev.hw5.controller.NoParametersController;
import goit.dev.hw5.ui.View;
import goit.dev.hw5.ui.commands.Command;

import java.io.IOException;

public class GetInventoryCommand implements Command {
    public static final String NAME = "get inventory";
    public static final String DESC = "Get available inventory";

    private NoParametersController controller;
    private View view;

    public GetInventoryCommand(NoParametersController controller, View view) {
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
