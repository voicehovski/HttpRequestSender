package goit.dev.hw5.controller.user;

import goit.dev.hw5.ResponseWrapper;
import goit.dev.hw5.controller.SendArbitraryRequestController;
import goit.dev.hw5.controller.TwoStringController;

import java.io.IOException;

public class LoginUserController implements TwoStringController {
    private SendArbitraryRequestController controller;

    public LoginUserController(SendArbitraryRequestController controller) {
        this.controller = controller;
    }

    @Override
    public ResponseWrapper send(String username, String password) throws IOException {
        return controller.sendGet(String.format("user/login?username=%s&password=%s", username, password));
    }
}
