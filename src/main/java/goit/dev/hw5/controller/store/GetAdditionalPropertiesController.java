package goit.dev.hw5.controller.store;

import goit.dev.hw5.ResponseWrapper;
import goit.dev.hw5.controller.NoParametersController;
import goit.dev.hw5.controller.SendArbitraryRequestController;

import java.io.IOException;

public class GetAdditionalPropertiesController implements NoParametersController {
    private SendArbitraryRequestController controller;

    public GetAdditionalPropertiesController(SendArbitraryRequestController controller) {
        this.controller = controller;
    }

    @Override
    public ResponseWrapper send() throws IOException {
        return controller.sendGet("store/inventory");
    }
}
