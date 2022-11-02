package goit.dev.hw5.ui.commands;

import com.google.gson.Gson;
import goit.dev.hw5.ResponseWrapper;
import goit.dev.hw5.controller.BodyPostController;
import goit.dev.hw5.model.Category;
import goit.dev.hw5.model.Pet;
import goit.dev.hw5.model.Tag;
import goit.dev.hw5.ui.View;

import java.io.IOException;

public class EditPetCommand implements Command{
    public static final String NAME = "edit pet";
    public static final String DESC = "Send update pet request";

    private BodyPostController controller;
    private View view;

    public EditPetCommand(BodyPostController controller, View view) {
        this .controller = controller;
        this.view = view;
    }

    @Override
    public boolean canExecute(String command) {
        return NAME.equalsIgnoreCase(command);
    }

    @Override
    public void execute() throws IOException {
        view.write("Enter a name");
        String petName = view.read();
        view.write("Enter a status");
        String petStatus = view.read();
        view.write("Enter comma separated image paths");
        String [] images = view.read().split(",");
        Pet newPet = new Pet(petName, images);
        newPet.setStatus(petStatus);
        view.write("Enter category name");
        newPet.setCategory(new Category(view.read()));
        view.write("Enter tag name");
        newPet.addTag(new Tag(view.read()));
        String json = (new Gson()).toJson(newPet);
        ResponseWrapper response = controller.post(json);
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
