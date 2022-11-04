package goit.dev.hw5.controller.user;

import goit.dev.hw5.ResponseWrapper;
import goit.dev.hw5.controller.NoParametersController;
import goit.dev.hw5.controller.SendArbitraryRequestController;

import java.io.IOException;

public class LogoutUserController implements NoParametersController {
    private SendArbitraryRequestController controller;

    public LogoutUserController(SendArbitraryRequestController controller) {
        this.controller = controller;
    }

    @Override
    public ResponseWrapper send() throws IOException {
        return controller.sendGet("user/logout");
    }
}
