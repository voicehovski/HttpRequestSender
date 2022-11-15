package goit.dev.hw5.controller.pet;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import goit.dev.hw5.ResponseWrapper;
import goit.dev.hw5.controller.*;
import goit.dev.hw5.model.Pet;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

public class GetPetByStatusController implements SendController, GetEntityListController<Pet> {
    private SendArbitraryRequestController controller;
    private String body;

    public GetPetByStatusController(SendArbitraryRequestController controller) {
        this.controller = controller;
    }

    // 200 + entity list, 400 + ?
    @Override
    public int send(Map<String,String> params) throws IOException {
        String status = params.get("status");
        ResponseWrapper wrapper = controller.sendGet("pet/findByStatus?status=" + status);
        body = wrapper.getBody();
        return wrapper.getStatus();
    }

    @Override
    public List<Pet> getEntityList() {
        if (body == null) {
            return null;
        }
        Type listElementType = new TypeToken<List<Pet>>(){} .getType (  );
        try {
            return new Gson().fromJson(body, listElementType);
        } catch (JsonSyntaxException jse) {
            return null;
        }
    }
}
