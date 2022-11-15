package goit.dev.hw5.controller.user;

import com.google.gson.Gson;
import goit.dev.hw5.ResponseWrapper;
import goit.dev.hw5.controller.GetRawController;
import goit.dev.hw5.controller.SendArbitraryRequestController;
import goit.dev.hw5.controller.SendEntityController;
import goit.dev.hw5.model.User;

import java.io.IOException;
import java.util.Map;

public class PostUserController implements SendEntityController<User>, GetRawController {
    private SendArbitraryRequestController controller;
    private String body;

    public PostUserController(SendArbitraryRequestController controller) {
        this.controller = controller;
    }

    // return 200 + json message
    @Override
    public int send(Map<String, String> params, User entity) throws IOException {
        ResponseWrapper wrapper = controller.sendPost("user", new Gson() .toJson(entity, User.class));
        body = wrapper.getBody();
        return wrapper.getStatus();
    }

    @Override
    public String getBody() {
        return body;
    }
}
