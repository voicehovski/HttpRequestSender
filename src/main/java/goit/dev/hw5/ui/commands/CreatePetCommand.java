package goit.dev.hw5.ui.commands;

import com.google.gson.Gson;
import goit.dev.hw5.ResponseWrapper;
import goit.dev.hw5.controller.BodyController;
import goit.dev.hw5.model.Category;
import goit.dev.hw5.model.Pet;
import goit.dev.hw5.model.Tag;
import goit.dev.hw5.ui.View;

import java.io.IOException;

public class CreatePetCommand implements Command {
    public static final String NAME = "create pet";
    public static final String DESC = "Send create pet request";

    private BodyController controller;
    private View view;

    public CreatePetCommand(BodyController controller, View view) {
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
        Pet newPet = new Pet(petName, new String [] {"mydogdy.jpg"});
        newPet.setStatus(petStatus);
        newPet.setCategory(new Category("dogs"));
        newPet.addTag(new Tag("big"));
        String json = (new Gson()).toJson(newPet);
        ResponseWrapper response = controller.send(json);
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
