package goit.dev.hw5.controller;

import goit.dev.hw5.ResponseWrapper;

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
