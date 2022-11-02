package goit.dev.hw5.ui.commands;

import goit.dev.hw5.ResponseWrapper;
import goit.dev.hw5.controller.StringGetController;
import goit.dev.hw5.ui.View;

import java.io.IOException;

public class GetPetByStatusCommand implements Command {
    public static final String NAME = "get pet(s)";
    public static final String DESC = "Get pet by status";

    private StringGetController controller;
    private View view;

    public GetPetByStatusCommand(StringGetController controller, View view) {
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
        ResponseWrapper response = controller.get(petStatus);
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
