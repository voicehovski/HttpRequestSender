package goit.dev.hw5.controller;

import goit.dev.hw5.ResponseWrapper;

import java.io.IOException;

public class GetPetController implements IdGetController {
    private SendArbitraryRequestController controller;

    public GetPetController(SendArbitraryRequestController controller) {
        this.controller = controller;
    }

    public ResponseWrapper get (long petId) throws IOException {
        return controller.sendGet("pet/" + petId);
    }
}

