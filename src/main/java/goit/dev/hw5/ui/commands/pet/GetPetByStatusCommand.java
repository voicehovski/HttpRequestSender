package goit.dev.hw5.ui.commands.pet;

import goit.dev.hw5.ResponseWrapper;
import goit.dev.hw5.controller.StringController;
import goit.dev.hw5.ui.View;
import goit.dev.hw5.ui.commands.Command;

import java.io.IOException;

public class GetPetByStatusCommand implements Command {
    public static final String NAME = "get pet(s)";
    public static final String DESC = "Get pet by status";

    private StringController controller;
    private View view;

    public GetPetByStatusCommand(StringController controller, View view) {
        this .controller = controller;
        this.view = view;
    }

    @Override
    public boolean canExecute(String command) {
        return NAME.equalsIgnoreCase(command);
    }

    @Override
    public void execute() throws IOException {
        view.write("Enter a status");
        String petStatus = view.read();
        ResponseWrapper response = controller.send(petStatus);

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
