package goit.dev.hw5.controller.pet;

import goit.dev.hw5.ResponseWrapper;
import goit.dev.hw5.controller.SendArbitraryRequestController;
import goit.dev.hw5.controller.SendController;

import java.io.IOException;
import java.util.Map;

public class DeletePetController implements SendController {
    private SendArbitraryRequestController controller;

    public DeletePetController(SendArbitraryRequestController controller) {
        this.controller = controller;
    }

    // 200|400|404+ json
    @Override
    public int send(Map<String, String> params) throws IOException {
        String id = params.get("id");
        ResponseWrapper wrapper = controller.sendDelete("pet/" + id);
        return wrapper.getStatus();
    }
}
