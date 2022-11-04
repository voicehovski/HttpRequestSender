package goit.dev.hw5.controller.user;

import goit.dev.hw5.ResponseWrapper;
import goit.dev.hw5.controller.SendArbitraryRequestController;
import goit.dev.hw5.controller.StringParamBodyController;

import java.io.IOException;

public class PutUserController implements StringParamBodyController {
    private SendArbitraryRequestController controller;

    public PutUserController(SendArbitraryRequestController controller) {
        this.controller = controller;
    }

    @Override
    public ResponseWrapper send(String username, String body) throws IOException {
        return controller.sendPut("user/" + username, body.getBytes());
    }
}
