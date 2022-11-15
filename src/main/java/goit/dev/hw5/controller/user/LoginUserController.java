package goit.dev.hw5.controller.user;

import goit.dev.hw5.ResponseWrapper;
import goit.dev.hw5.controller.GetRawController;
import goit.dev.hw5.controller.SendArbitraryRequestController;
import goit.dev.hw5.controller.SendController;

import java.io.IOException;
import java.util.Map;

public class LoginUserController implements SendController, GetRawController {
    private SendArbitraryRequestController controller;
    private String body;


    public LoginUserController(SendArbitraryRequestController controller) {
        this.controller = controller;
    }

    // retun 200 or 400 if wrong credentials
    @Override
    public int send(Map<String,String> params) throws IOException {
        String username = params.get("username");
        String password = params.get("password");
        ResponseWrapper wrapper = controller.sendGet(String.format("user/login?username=%s&password=%s", username, password));
        body = wrapper.getBody();
        return wrapper.getStatus();
    }

    @Override
    public String getBody() {
        return body;
    }
}
