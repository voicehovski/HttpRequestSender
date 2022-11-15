package goit.dev.hw5.controller.store;

import goit.dev.hw5.ResponseWrapper;
import goit.dev.hw5.controller.SendArbitraryRequestController;
import goit.dev.hw5.controller.SendController;

import java.io.IOException;
import java.util.Map;

public class DeleteOrderController implements SendController {
    private SendArbitraryRequestController controller;

    public DeleteOrderController(SendArbitraryRequestController controller) {
        this.controller = controller;
    }

    // 200|400|404 + json message
    @Override
    public int send(Map<String, String> params) throws IOException {
        String id = params.get("id");
        ResponseWrapper wrapper = controller.sendDelete("store/order/" + id);
        return wrapper.getStatus();
    }
}
