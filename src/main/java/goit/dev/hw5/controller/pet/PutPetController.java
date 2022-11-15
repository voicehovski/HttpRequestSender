package goit.dev.hw5.controller.pet;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import goit.dev.hw5.ResponseWrapper;
import goit.dev.hw5.controller.GetEntityController;
import goit.dev.hw5.controller.SendArbitraryRequestController;
import goit.dev.hw5.controller.SendEntityController;
import goit.dev.hw5.model.Pet;

import java.io.IOException;
import java.util.Map;

public class PutPetController implements SendEntityController<Pet>, GetEntityController<Pet> {
    private SendArbitraryRequestController controller;
    private String entityString;

    public PutPetController (SendArbitraryRequestController controller) {
        this.controller = controller;
    }

    // 200 + entity, 400(invalid id)|404(unknown)|405(invalid input) + ?
    public int send (Map<String,String> params, Pet entity) throws IOException {
        ResponseWrapper wrapper = controller.sendPut("pet", new Gson () .toJson(entity, Pet.class).getBytes());
        entityString = wrapper.getBody();
        return wrapper.getStatus();
    }

    public Pet getEntity () {
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
