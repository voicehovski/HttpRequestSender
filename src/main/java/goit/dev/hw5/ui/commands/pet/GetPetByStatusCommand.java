package goit.dev.hw5.ui.commands.pet;

import goit.dev.hw5.controller.pet.GetPetByStatusController;
import goit.dev.hw5.ui.View;
import goit.dev.hw5.ui.commands.Command;

import java.io.IOException;
import java.util.Map;

public class GetPetByStatusCommand implements Command {
    public static final String NAME = "get pet(s)";
    public static final String DESC = "Get pet list by status (GET)";

    private GetPetByStatusController controller;
    private View view;

    public GetPetByStatusCommand(GetPetByStatusController controller, View view) {
        this .controller = controller;
        this.view = view;
    }

    @Override
    public boolean canExecute(String command) {
        return NAME.equalsIgnoreCase(command);
    }

    @Override
    public void execute() throws IOException {
        view.write("Enter status");
        String petStatus = view.read();

        int responseStatus = controller.send(Map.of("status", petStatus));
        view.write("Status: " + responseStatus);
        view.write(controller.getEntityList());
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
