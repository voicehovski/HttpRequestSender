package goit.dev.hw5.controller.store;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import goit.dev.hw5.ResponseWrapper;
import goit.dev.hw5.controller.GetEntityController;
import goit.dev.hw5.controller.SendArbitraryRequestController;
import goit.dev.hw5.controller.SendEntityController;
import goit.dev.hw5.model.Order;

import java.io.IOException;
import java.util.Map;

public class PostOrderController implements SendEntityController<Order>, GetEntityController<Order> {
    private SendArbitraryRequestController controller;
    private String entityString;

    public PostOrderController(SendArbitraryRequestController controller) {
        this.controller = controller;
    }

    // 200 + entity, 400 + ?
    @Override
    public int send(Map<String, String> params, Order entity) throws IOException {
        ResponseWrapper wrapper = controller.sendPost("store/order", new Gson ().toJson(entity, Order.class));
        entityString = wrapper.getBody();
        return wrapper.getStatus();
    }

    @Override
    public Order getEntity() {

        if (entityString == null) {
            return null;
        }

        try {
            return new Gson().fromJson(entityString, Order.class);
        } catch (JsonSyntaxException jse) {
            return null;
        }
    }
}
