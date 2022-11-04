package goit.dev.hw5.controller.user;

import goit.dev.hw5.ResponseWrapper;
import goit.dev.hw5.controller.SendArbitraryRequestController;
import goit.dev.hw5.controller.StringController;

import java.io.IOException;

public class DeleteUserController implements StringController {
    private SendArbitraryRequestController controller;

    public DeleteUserController(SendArbitraryRequestController controller) {
        this.controller = controller;
    }

    @Override
    public ResponseWrapper send(String username) throws IOException {
        return controller.sendDelete("user/" + username);
    }
}
