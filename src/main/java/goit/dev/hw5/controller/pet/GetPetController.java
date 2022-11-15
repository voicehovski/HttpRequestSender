package goit.dev.hw5.controller.pet;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import goit.dev.hw5.ResponseWrapper;
import goit.dev.hw5.controller.GetEntityController;
import goit.dev.hw5.controller.SendArbitraryRequestController;
import goit.dev.hw5.controller.SendController;
import goit.dev.hw5.model.Pet;

import java.io.IOException;
import java.util.Map;

public class GetPetController implements SendController, GetEntityController<Pet> {
    private SendArbitraryRequestController controller;
    private String entityString;

    public GetPetController(SendArbitraryRequestController controller) {
        this.controller = controller;
    }

    // 200 + entity, 400|404 + json
    @Override
    public int send(Map<String, String> params) throws IOException {
        String petId = params.get("id");
        ResponseWrapper wrapper = controller.sendGet("pet/" + petId);
        entityString = wrapper.getBody();
        return wrapper.getStatus();
    }

    @Override
    public Pet getEntity() {
        if (entityString == null) {
            return null;
        }

        try {
            return new Gson().fromJson(entityString, Pet.class);
        } catch (JsonSyntaxException jse) {
            return null;
        }
    }

}

