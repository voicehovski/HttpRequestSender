package goit.dev.hw5.ui.commands;

import com.google.gson.Gson;
import goit.dev.hw5.ResponseWrapper;
import goit.dev.hw5.controller.BodyPostController;
import goit.dev.hw5.controller.GetPetController;
import goit.dev.hw5.controller.IdGetController;
import goit.dev.hw5.model.Pet;
import goit.dev.hw5.ui.View;

import java.io.IOException;

public class GetPetCommand implements Command {
    public static final String NAME = "get pet";
    public static final String DESC = "Get pet by id";

    private IdGetController controller;
    private View view;

    public GetPetCommand(IdGetController controller, View view) {
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
        ResponseWrapper response = controller.get(petId);
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
