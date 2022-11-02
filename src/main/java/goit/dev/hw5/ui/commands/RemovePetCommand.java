package goit.dev.hw5.ui.commands;

import com.google.gson.Gson;
import goit.dev.hw5.ResponseWrapper;
import goit.dev.hw5.controller.IdGetController;
import goit.dev.hw5.model.Category;
import goit.dev.hw5.model.Pet;
import goit.dev.hw5.model.Tag;
import goit.dev.hw5.ui.View;

import java.io.IOException;

public class RemovePetCommand implements Command {
    public static final String NAME = "remove pet";
    public static final String DESC = "Send delete pet request";

    private IdGetController controller;
    private View view;

    public RemovePetCommand(IdGetController controller, View view) {
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
