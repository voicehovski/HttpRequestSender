package goit.dev.hw5.controller.store;

import goit.dev.hw5.ResponseWrapper;
import goit.dev.hw5.controller.BodyController;
import goit.dev.hw5.controller.SendArbitraryRequestController;

import java.io.IOException;

public class PostOrderController implements BodyController {
    private SendArbitraryRequestController controller;

    public PostOrderController(SendArbitraryRequestController controller) {
        this.controller = controller;
    }

    @Override
    public ResponseWrapper send(String body) throws IOException {
        return controller.sendPost("store/order", body);
    }
}
