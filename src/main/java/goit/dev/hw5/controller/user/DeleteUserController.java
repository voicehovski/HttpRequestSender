package goit.dev.hw5.controller.user;

import goit.dev.hw5.ResponseWrapper;
import goit.dev.hw5.controller.SendArbitraryRequestController;
import goit.dev.hw5.controller.SendController;

import java.io.IOException;
import java.util.Map;

public class DeleteUserController implements SendController {
    private SendArbitraryRequestController controller;

    public DeleteUserController(SendArbitraryRequestController controller) {
        this.controller = controller;
    }

    // 200 + json message, 404
    @Override
    public int send(Map<String, String> params) throws IOException {
        String username = params.get("username");
        ResponseWrapper wrapper = controller.sendDelete("user/" + username);
        return wrapper.getStatus();
    }
}
