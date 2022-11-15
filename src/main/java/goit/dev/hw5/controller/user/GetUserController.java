package goit.dev.hw5.controller.user;

import goit.dev.hw5.ResponseWrapper;
import goit.dev.hw5.controller.*;
import goit.dev.hw5.model.User;

import java.io.IOException;
import java.util.Map;

public class GetUserController extends DefaultEntityController<User> implements SendController {
    private SendArbitraryRequestController controller;

    public GetUserController(SendArbitraryRequestController controller) {
        this.controller = controller;
    }

    // 200 + entity, 400 (invalid name) + json message, 404 (user not found) + json message
    @Override
    public int send(Map<String, String> params) throws IOException {
        String username = params.get("username");
        ResponseWrapper wrapper = controller.sendGet("user/" + username);
        setBody(wrapper.getBody());
        return wrapper.getStatus();
    }
}
