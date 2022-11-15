package goit.dev.hw5.ui.commands.pet;

import goit.dev.hw5.controller.pet.PutPetController;
import goit.dev.hw5.model.Category;
import goit.dev.hw5.model.Pet;
import goit.dev.hw5.model.Tag;
import goit.dev.hw5.ui.View;
import goit.dev.hw5.ui.commands.Command;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;

public class EditPetCommand implements Command {
    public static final String NAME = "edit pet";
    public static final String DESC = "Edit existed pet (PUT)";

    private PutPetController controller;
    private View view;

    public EditPetCommand(PutPetController controller, View view) {
        this .controller = controller;
        this.view = view;
    }

    @Override
    public boolean canExecute(String command) {
        return NAME.equalsIgnoreCase(command);
    }

    @Override
    public void execute() throws IOException {
        view.write("Enter each value or just press <Enter> to leave current value (in braces)");
        String id = view.enterParameter("Enter an id");
        String name = view.enterParameter("Enter name", "Current name");
        String images = view.enterParameter("Enter comma separated images", "current1.jpg,current2.jpg");
        String status = view.enterParameter("Enter status", "Current status");
        String category = view.enterParameter("Enter category", "Current category");
        String tags = view.enterParameter("Enter comma separated tags", "current1,current2");

        Pet pet = new Pet(
                name,
                Arrays.stream(images.split(","))
                        .map(String::trim)
                        .toArray(String[]::new)
        );
        pet.setId(Long.parseLong(id));
        pet.setStatus(status);
        pet.setCategory(new Category(category));
        pet.setTags(Arrays.stream(tags.split(","))
                .map(String::trim)
                .map(Tag::new)
                .toArray(Tag[]::new));

        int responseStatus = controller.send(Collections.emptyMap(), pet);
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
