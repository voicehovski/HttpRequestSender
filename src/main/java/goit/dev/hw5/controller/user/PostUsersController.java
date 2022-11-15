package goit.dev.hw5.controller.user;

import com.google.gson.Gson;
import goit.dev.hw5.ResponseWrapper;
import goit.dev.hw5.controller.DefaultGetRawController;
import goit.dev.hw5.controller.SendArbitraryRequestController;
import goit.dev.hw5.controller.SendEntityListController;
import goit.dev.hw5.model.User;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class PostUsersController extends DefaultGetRawController implements SendEntityListController<User> {
    private SendArbitraryRequestController controller;

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
        setBody(wrapper.getBody());
        return wrapper.getStatus();
    }
}
