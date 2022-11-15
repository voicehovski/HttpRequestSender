package goit.dev.hw5.controller.user;

import com.google.gson.Gson;
import goit.dev.hw5.ResponseWrapper;
import goit.dev.hw5.controller.GetRawController;
import goit.dev.hw5.controller.SendArbitraryRequestController;
import goit.dev.hw5.controller.SendEntityController;
import goit.dev.hw5.model.User;

import java.io.IOException;
import java.util.Map;

public class PutUserController implements SendEntityController<User>, GetRawController {
    private SendArbitraryRequestController controller;
    private String body;

    public PutUserController(SendArbitraryRequestController controller) {
        this.controller = controller;
    }

    // 200|400|404 + json message
    @Override
    public int send(Map<String,String> params, User entity) throws IOException {
        String username = params.get("username");
        ResponseWrapper wrapper = controller.sendPut(
                "user/" + username,
                new Gson() .toJson(entity, User.class) .getBytes()
        );
        body = wrapper.getBody();
        return wrapper.getStatus();
    }

    @Override
    public String getBody() {
        return body;
    }
}
