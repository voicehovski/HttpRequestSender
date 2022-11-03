package goit.dev.hw5.controller.pet;

import goit.dev.hw5.ResponseWrapper;
import goit.dev.hw5.controller.IdController;
import goit.dev.hw5.controller.SendArbitraryRequestController;

import java.io.IOException;

public class GetPetController implements IdController {
    private SendArbitraryRequestController controller;

    public GetPetController(SendArbitraryRequestController controller) {
        this.controller = controller;
    }

    public ResponseWrapper send(long petId) throws IOException {
        return controller.sendGet("pet/" + petId);
    }
}

