package goit.dev.hw5.ui.commands;

import com.google.gson.Gson;
import goit.dev.hw5.ResponseWrapper;
import goit.dev.hw5.controller.BodyController;
import goit.dev.hw5.model.Category;
import goit.dev.hw5.model.Pet;
import goit.dev.hw5.model.Tag;
import goit.dev.hw5.ui.View;

import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Stream;

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
        view.write("Enter each value or just press <Enter> to leave default value (in braces)");
        String name = view.enterParameter("Enter a name", "Mr. Pet");
        String images = view.enterParameter("Enter a comma separated image names", "pet.jpg");
        String status = view.enterParameter("Enter a status", "available");
        String category = view.enterParameter("Enter a category", "pets");
        String tags = view.enterParameter("Enter a comma separated tags", "nice");

        Pet newPet = new Pet(
                name,
                Arrays.stream(images.split(","))
                        .map(String::trim)
                        .toArray(String[]::new)
        );
        newPet.setStatus(status);
        newPet.setCategory(new Category(category));
        newPet.setTags(Arrays.stream(tags.split(","))
                        .map(String::trim)
                        .map(Tag::new)
                        .toArray(Tag[]::new));

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
