package goit.dev.hw5.controller;

import goit.dev.hw5.ResponseWrapper;

import java.io.IOException;

public class PutPetController implements BodyController {
    private SendArbitraryRequestController controller;

    public PutPetController(SendArbitraryRequestController controller) {
        this.controller = controller;
    }

    @Override
    public ResponseWrapper send(String body) throws IOException {
        return controller.sendPut("put", body.getBytes());
    }
}
