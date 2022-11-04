package goit.dev.hw5.ui.commands.store;

import goit.dev.hw5.ResponseWrapper;
import goit.dev.hw5.controller.IdController;
import goit.dev.hw5.ui.View;
import goit.dev.hw5.ui.commands.Command;

import java.io.IOException;

public class GetOrderCommand implements Command {
    public static final String NAME = "get order";
    public static final String DESC = "Get order by id";

    private IdController controller;
    private View view;

    public GetOrderCommand(IdController controller, View view) {
        this .controller = controller;
        this.view = view;
    }

    @Override
    public boolean canExecute(String command) {
        return NAME.equalsIgnoreCase(command);
    }

    @Override
    public void execute() throws IOException {
        view.write("Enter an id");
        Long petId = Long.parseLong(view.read());
        ResponseWrapper response = controller.send(petId);

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
