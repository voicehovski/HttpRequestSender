package goit.dev.hw5.controller.store;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import goit.dev.hw5.ResponseWrapper;
import goit.dev.hw5.controller.DefaultEntityController;
import goit.dev.hw5.controller.GetEntityController;
import goit.dev.hw5.controller.SendArbitraryRequestController;
import goit.dev.hw5.controller.SendEntityController;
import goit.dev.hw5.model.Order;

import java.io.IOException;
import java.util.Map;

public class PostOrderController extends DefaultEntityController<Order> implements SendEntityController<Order> {
    private SendArbitraryRequestController controller;

    public PostOrderController(SendArbitraryRequestController controller) {
        this.controller = controller;
    }

    // 200 + entity, 400 + ?
    @Override
    public int send(Map<String, String> params, Order entity) throws IOException {
        ResponseWrapper wrapper = controller.sendPost("store/order", new Gson ().toJson(entity, Order.class));
        setBody(wrapper.getBody());
        return wrapper.getStatus();
    }
}
