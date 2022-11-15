package goit.dev.hw5.ui.commands.store;

import goit.dev.hw5.controller.store.GetOrderController;
import goit.dev.hw5.ui.View;
import goit.dev.hw5.ui.commands.Command;

import java.io.IOException;
import java.util.Map;

public class GetOrderCommand implements Command {
    public static final String NAME = "get order";
    public static final String DESC = "Get order by id (GET)";

    private GetOrderController controller;
    private View view;

    public GetOrderCommand(GetOrderController controller, View view) {
        this .controller = controller;
        this.view = view;
    }

    @Override
    public boolean canExecute(String command) {
        return NAME.equalsIgnoreCase(command);
    }

    @Override
    public void execute() throws IOException {
        view.write("Enter id");
        Long petId = Long.parseLong(view.read());
        int status = controller.send(Map.of("id", petId.toString()));

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
