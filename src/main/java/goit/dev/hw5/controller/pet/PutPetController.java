package goit.dev.hw5.controller.pet;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import goit.dev.hw5.ResponseWrapper;
import goit.dev.hw5.controller.DefaultEntityController;
import goit.dev.hw5.controller.GetEntityController;
import goit.dev.hw5.controller.SendArbitraryRequestController;
import goit.dev.hw5.controller.SendEntityController;
import goit.dev.hw5.model.Pet;
import goit.dev.hw5.model.User;

import java.io.IOException;
import java.util.Map;

public class PutPetController extends DefaultEntityController<Pet> implements SendEntityController<Pet> {
    private SendArbitraryRequestController controller;

    public PutPetController (SendArbitraryRequestController controller) {
        this.controller = controller;
    }

    // 200 + entity, 400(invalid id)|404(unknown)|405(invalid input) + ?
    public int send (Map<String,String> params, Pet entity) throws IOException {
        ResponseWrapper wrapper = controller.sendPut("pet", new Gson () .toJson(entity, Pet.class).getBytes());
        setBody(wrapper.getBody());
        return wrapper.getStatus();
    }
}
