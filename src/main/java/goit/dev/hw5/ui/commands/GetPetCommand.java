package goit.dev.hw5.ui.commands;

import goit.dev.hw5.ResponseWrapper;
import goit.dev.hw5.controller.IdController;
import goit.dev.hw5.ui.View;

import java.io.IOException;

public class GetPetCommand implements Command {
    public static final String NAME = "get pet";
    public static final String DESC = "Get pet by id";

    private IdController controller;
    private View view;

    public GetPetCommand(IdController controller, View view) {
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
        ResponseWrapper response = controller.send(petId);
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
