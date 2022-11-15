package goit.dev.hw5.controller.pet;

import com.google.gson.Gson;
import goit.dev.hw5.ResponseWrapper;
import goit.dev.hw5.controller.DefaultEntityController;
import goit.dev.hw5.controller.SendArbitraryRequestController;
import goit.dev.hw5.controller.SendEntityController;
import goit.dev.hw5.model.Pet;

import java.io.IOException;
import java.util.Map;

public class PostPetController extends DefaultEntityController<Pet> implements SendEntityController<Pet> {
    private SendArbitraryRequestController controller;

    public PostPetController (SendArbitraryRequestController controller) {
        this.controller = controller;
    }

    // 200 + entity, 405 (invalid input) + ?
    public int send (Map<String,String> params, Pet entity) throws IOException {
        ResponseWrapper wrapper = controller.sendPost("pet", new Gson () .toJson(entity, Pet.class));
        setBody(wrapper.getBody());
        return wrapper.getStatus();
    }
}
