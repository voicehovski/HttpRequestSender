package goit.dev.hw5.controller.pet;

import goit.dev.hw5.ResponseWrapper;
import goit.dev.hw5.controller.BodyController;
import goit.dev.hw5.controller.SendArbitraryRequestController;

import java.io.IOException;

public class PostPetController implements BodyController {
    private SendArbitraryRequestController controller;

    public PostPetController (SendArbitraryRequestController controller) {
        this.controller = controller;
    }

    public ResponseWrapper send(String json) throws IOException {
        return controller .sendPost("pet", json);
    }
}