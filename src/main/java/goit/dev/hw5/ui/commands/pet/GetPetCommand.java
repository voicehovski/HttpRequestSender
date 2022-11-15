package goit.dev.hw5.ui.commands.pet;

import goit.dev.hw5.controller.pet.GetPetController;
import goit.dev.hw5.ui.View;
import goit.dev.hw5.ui.commands.Command;

import java.io.IOException;
import java.util.Map;

public class GetPetCommand implements Command {
    public static final String NAME = "get pet";
    public static final String DESC = "Get pet by id (GET)";

    private GetPetController controller;
    private View view;

    public GetPetCommand(GetPetController controller, View view) {
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
        int responseStatus = controller.send(Map.of("id", petId.toString()));

        view.write("Status: " + responseStatus);
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
