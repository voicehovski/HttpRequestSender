package goit.dev.hw5.ui.commands.pet;

import goit.dev.hw5.ResponseWrapper;
import goit.dev.hw5.controller.pet.PostFilePetController;
import goit.dev.hw5.ui.View;
import goit.dev.hw5.ui.commands.Command;

import java.io.File;
import java.io.IOException;

public class UploadImagePetCommand implements Command {
    public static final String NAME = "upload image";
    public static final String DESC = "Upload image for pet";

    private PostFilePetController controller;
    private View view;

    public UploadImagePetCommand(PostFilePetController controller, View view) {
        this .controller = controller;
        this.view = view;
    }

    @Override
    public boolean canExecute(String command) {
        return NAME.equalsIgnoreCase(command);
    }

    @Override
    public void execute() throws IOException, InterruptedException {
        view.write("Enter each value or just press <Enter> to leave default value (in braces)");
        String petId = view.enterParameter("Enter a pet id");
        String meta = view.enterParameter("Enter metadata");
        String imgPath = view.enterParameter("Enter a file path");

        ResponseWrapper response = controller.send(
                Long.parseLong(petId),
                meta,
                new File(imgPath)
        );

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
