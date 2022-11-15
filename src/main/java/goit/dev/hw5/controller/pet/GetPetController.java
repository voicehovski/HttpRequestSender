package goit.dev.hw5.controller.pet;

import goit.dev.hw5.ResponseWrapper;
import goit.dev.hw5.controller.DefaultEntityController;
import goit.dev.hw5.controller.SendArbitraryRequestController;
import goit.dev.hw5.controller.SendController;
import goit.dev.hw5.model.Pet;

import java.io.IOException;
import java.util.Map;

public class GetPetController extends DefaultEntityController<Pet> implements SendController {
    private SendArbitraryRequestController controller;

    public GetPetController(SendArbitraryRequestController controller) {
        this.controller = controller;
    }

    // 200 + entity, 400|404 + json
    @Override
    public int send(Map<String, String> params) throws IOException {
        String petId = params.get("id");
        ResponseWrapper wrapper = controller.sendGet("pet/" + petId);
        setBody(wrapper.getBody());
        return wrapper.getStatus();
    }
}

