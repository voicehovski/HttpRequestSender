package goit.dev.hw5.controller.pet;

import goit.dev.hw5.ResponseWrapper;
import goit.dev.hw5.controller.IdController;
import goit.dev.hw5.controller.SendArbitraryRequestController;

import java.io.IOException;

public class DeletePetController implements IdController {
    private SendArbitraryRequestController controller;

    public DeletePetController(SendArbitraryRequestController controller) {
        this.controller = controller;
    }

    @Override
    public ResponseWrapper send(long id) throws IOException {
        return controller.sendDelete("pet/" + id);
    }
}
