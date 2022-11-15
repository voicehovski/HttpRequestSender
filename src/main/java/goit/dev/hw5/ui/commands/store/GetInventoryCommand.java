package goit.dev.hw5.ui.commands.store;

import goit.dev.hw5.controller.store.GetAdditionalPropertiesController;
import goit.dev.hw5.ui.View;
import goit.dev.hw5.ui.commands.Command;

import java.io.IOException;
import java.util.Collections;

public class GetInventoryCommand implements Command {
    public static final String NAME = "get inventory";
    public static final String DESC = "Get available inventory (GET)";

    private GetAdditionalPropertiesController controller;
    private View view;

    public GetInventoryCommand(GetAdditionalPropertiesController controller, View view) {
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
