package goit.dev.hw5.controller.pet;

import goit.dev.hw5.ResponseWrapper;
import goit.dev.hw5.controller.SendArbitraryRequestController;
import goit.dev.hw5.controller.StringController;

import java.io.IOException;

public class GetPetByStatusController implements StringController {
    private SendArbitraryRequestController controller;

    public GetPetByStatusController(SendArbitraryRequestController controller) {
        this.controller = controller;
    }

    public ResponseWrapper send(String status) throws IOException {
        return controller.sendGet("pet/findByStatus?status=" + status);
    }
}
