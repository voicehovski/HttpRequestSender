package goit.dev.hw5.controller;

import goit.dev.hw5.ResponseWrapper;

import java.io.IOException;

public class DeletePetController implements IdGetController {
    private SendArbitraryRequestController controller;

    public DeletePetController(SendArbitraryRequestController controller) {
        this.controller = controller;
    }

    @Override
    public ResponseWrapper get(long id) throws IOException {
        return controller.sendDelete("pet/" + id);
    }
}
