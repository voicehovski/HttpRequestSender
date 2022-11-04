package goit.dev.hw5.controller.user;

import goit.dev.hw5.ResponseWrapper;
import goit.dev.hw5.controller.BodyController;
import goit.dev.hw5.controller.SendArbitraryRequestController;

import java.io.IOException;

public class PostUserController implements BodyController {
    private SendArbitraryRequestController controller;

    public PostUserController(SendArbitraryRequestController controller) {
        this.controller = controller;
    }

    @Override
    public ResponseWrapper send(String body) throws IOException {
        return controller.sendPost("user", body);
    }
}
