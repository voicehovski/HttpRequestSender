package goit.dev.hw5.controller.user;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import goit.dev.hw5.ResponseWrapper;
import goit.dev.hw5.controller.*;
import goit.dev.hw5.model.User;

import java.io.IOException;
import java.util.Map;

public class GetUserController implements SendController, GetEntityController<User> {
    private SendArbitraryRequestController controller;
    private String entityString;

    public GetUserController(SendArbitraryRequestController controller) {
        this.controller = controller;
    }

    // 200 + entity, 400 (invalid name) + json message, 404 (user not found) + json message
    @Override
    public int send(Map<String, String> params) throws IOException {
        String username = params.get("username");
        ResponseWrapper wrapper = controller.sendGet("user/" + username);
        entityString = wrapper.getBody();
        return wrapper.getStatus();
    }

    @Override
    public User getEntity() {
        if (entityString == null) {
            return null;
        }

        try {
            return new Gson().fromJson(entityString, User.class);
        } catch (JsonSyntaxException jse) {
            return null;
        }
    }
}
