package goit.dev.hw5.controller.store;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import goit.dev.hw5.ResponseWrapper;
import goit.dev.hw5.controller.DefaultEntityController;
import goit.dev.hw5.controller.GetEntityController;
import goit.dev.hw5.controller.SendArbitraryRequestController;
import goit.dev.hw5.controller.SendController;
import goit.dev.hw5.model.Order;

import java.io.IOException;
import java.util.Map;

public class GetOrderController extends DefaultEntityController<Order> implements SendController {
    private SendArbitraryRequestController controller;

    public GetOrderController(SendArbitraryRequestController controller) {
        this.controller = controller;
    }

    // 200 + entity, 400 + msg, 404 + msg
    @Override
    public int send(Map<String, String> params) throws IOException {
        String orderId = params.get("id");
        ResponseWrapper wrapper = controller.sendGet("store/order/" + orderId);
        setBody(wrapper.getBody());
        return wrapper.getStatus();
    }
}
