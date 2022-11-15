package goit.dev.hw5.controller.user;

import goit.dev.hw5.ResponseWrapper;
import goit.dev.hw5.controller.GetRawController;
import goit.dev.hw5.controller.SendArbitraryRequestController;
import goit.dev.hw5.controller.SendController;

import java.io.IOException;
import java.util.Map;

public class LogoutUserController implements SendController, GetRawController {
    private SendArbitraryRequestController controller;
    private String body;

    public LogoutUserController(SendArbitraryRequestController controller) {
        this.controller = controller;
    }

    // return 200
    @Override
    public int send(Map<String, String> params) throws IOException {
        ResponseWrapper wrapper = controller.sendGet("user/logout");
        body = wrapper.getBody();
        return wrapper.getStatus();
    }

    @Override
    public String getBody() {
        return body;
    }
}
