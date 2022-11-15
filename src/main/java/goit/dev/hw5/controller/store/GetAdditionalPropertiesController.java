package goit.dev.hw5.controller.store;

import goit.dev.hw5.ResponseWrapper;
import goit.dev.hw5.controller.DefaultGetRawController;
import goit.dev.hw5.controller.SendArbitraryRequestController;
import goit.dev.hw5.controller.SendController;

import java.io.IOException;
import java.util.Map;

public class GetAdditionalPropertiesController extends DefaultGetRawController implements SendController {
    private SendArbitraryRequestController controller;

    public GetAdditionalPropertiesController(SendArbitraryRequestController controller) {
        this.controller = controller;
    }

    // 200 + json
    @Override
    public int send(Map<String, String> params) throws IOException {
        ResponseWrapper wrapper = controller.sendGet("store/inventory");
        setBody(wrapper.getBody());
        return wrapper.getStatus();
    }
}
