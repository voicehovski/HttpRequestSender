package goit.dev.hw5.controller.store;

import goit.dev.hw5.ResponseWrapper;
import goit.dev.hw5.controller.GetRawController;
import goit.dev.hw5.controller.SendArbitraryRequestController;
import goit.dev.hw5.controller.SendController;

import java.io.IOException;
import java.util.Map;

// todo Какой тут лучше тип контроллера и что он должен возвращать?
public class GetAdditionalPropertiesController implements SendController, GetRawController {
    private SendArbitraryRequestController controller;
    private String entityString;

    public GetAdditionalPropertiesController(SendArbitraryRequestController controller) {
        this.controller = controller;
    }

    // 200 + json
    @Override
    public int send(Map<String, String> params) throws IOException {
        ResponseWrapper wrapper = controller.sendGet("store/inventory");
        entityString = wrapper.getBody();
        return wrapper.getStatus();
    }

    @Override
    public String getBody() {
        return entityString == null ? "" : entityString;
    }
}
