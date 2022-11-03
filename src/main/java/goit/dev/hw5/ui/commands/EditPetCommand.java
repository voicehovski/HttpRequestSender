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

public class EditPetCommand implements Command{
    public static final String NAME = "edit pet";
    public static final String DESC = "Send update pet request";

    private BodyController controller;
    private View view;

    public EditPetCommand(BodyController controller, View view) {
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
        String name = view.enterParameter("Enter a name", "Current name");
        String images = view.enterParameter("Enter a comma separated images", "current1.jpg,current2.jpg");
        String status = view.enterParameter("Enter a status", "Current status");
        String category = view.enterParameter("Enter a category", "Current category");
        String tags = view.enterParameter("Enter a comma separated tags", "current1,current2");

        Pet newPet = new Pet(
                name,
                Arrays.stream(images.split(","))
                        .map(String::trim)
                        .toArray(String[]::new)
        );
        newPet.setId(Long.parseLong(id));
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
