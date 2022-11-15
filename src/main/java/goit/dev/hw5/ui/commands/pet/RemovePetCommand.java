package goit.dev.hw5.ui.commands.pet;

import goit.dev.hw5.controller.pet.DeletePetController;
import goit.dev.hw5.ui.View;
import goit.dev.hw5.ui.commands.Command;

import java.io.IOException;
import java.util.Map;

public class RemovePetCommand implements Command {
    public static final String NAME = "remove pet";
    public static final String DESC = "Remove pet by id (DELETE)";

    private DeletePetController controller;
    private View view;

    public RemovePetCommand(DeletePetController controller, View view) {
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
        int responseStatus = controller.send(Map.of("id", petId.toString()));

        view.write("Status: " + responseStatus);
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
