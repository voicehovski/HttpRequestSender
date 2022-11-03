package goit.dev.hw5.controller.store;

import goit.dev.hw5.ResponseWrapper;
import goit.dev.hw5.controller.IdController;
import goit.dev.hw5.controller.SendArbitraryRequestController;

import java.io.IOException;

public class GetOrderController implements IdController {
    private SendArbitraryRequestController controller;

    public GetOrderController(SendArbitraryRequestController controller) {
        this.controller = controller;
    }

    @Override
    public ResponseWrapper send(long id) throws IOException {
        return controller.sendGet("store/order/" + id);
    }
}
