package goit.dev.hw5.ui.commands.store;

import goit.dev.hw5.controller.store.DeleteOrderController;
import goit.dev.hw5.ui.View;
import goit.dev.hw5.ui.commands.Command;

import java.io.IOException;
import java.util.Map;

public class RemoveOrderCommand implements Command {
    public static final String NAME = "remove order";
    public static final String DESC = "Remove order by id (DELETE)";

    private DeleteOrderController controller;
    private View view;

    public RemoveOrderCommand(DeleteOrderController controller, View view) {
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
        //view.write(controller.getBody());
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
