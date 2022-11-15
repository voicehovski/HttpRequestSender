package goit.dev.hw5.ui.commands.pet;

import goit.dev.hw5.controller.pet.PostPetController;
import goit.dev.hw5.model.Category;
import goit.dev.hw5.model.Pet;
import goit.dev.hw5.model.Tag;
import goit.dev.hw5.ui.View;
import goit.dev.hw5.ui.commands.Command;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;

public class CreatePetCommand implements Command {
    public static final String NAME = "create pet";
    public static final String DESC = "Create new pet (POST)";

    private PostPetController controller;
    private View view;

    public CreatePetCommand(PostPetController controller, View view) {
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
        String name = view.enterParameter("Enter name", "Mr. Pet");
        String images = view.enterParameter("Enter comma separated image names", "pet.jpg");
        String status = view.enterParameter("Enter status", "available");
        String category = view.enterParameter("Enter category", "pets");
        String tags = view.enterParameter("Enter comma separated tags", "nice");

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

        int responseStatus = controller.send(Collections.emptyMap(), newPet);
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
