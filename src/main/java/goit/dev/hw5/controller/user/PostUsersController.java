package goit.dev.hw5.controller.user;

import com.google.gson.Gson;
import goit.dev.hw5.ResponseWrapper;
import goit.dev.hw5.controller.GetRawController;
import goit.dev.hw5.controller.SendArbitraryRequestController;
import goit.dev.hw5.controller.SendEntityListController;
import goit.dev.hw5.model.User;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class PostUsersController implements SendEntityListController<User>, GetRawController {
    private SendArbitraryRequestController controller;
    private String body;

    public PostUsersController(SendArbitraryRequestController controller) {
        this.controller = controller;
    }

    // 200 + json message
    @Override
    public int send(Map<String, String> params, List<User> entityList) throws IOException {
        ResponseWrapper wrapper = controller.sendPost(
                "user/createWithArray",
                new Gson().toJson(entityList)
        );
        body = wrapper.getBody();
        return wrapper.getStatus();
    }

    @Override
    public String getBody() {
        return body;
    }
}
