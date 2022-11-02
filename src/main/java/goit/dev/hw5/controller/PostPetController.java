package goit.dev.hw5.controller;

import goit.dev.hw5.ResponseWrapper;

import java.io.IOException;

public class PostPetController implements BodyPostController {
    private SendArbitraryRequestController controller;

    public PostPetController (SendArbitraryRequestController controller) {
        this.controller = controller;
    }

    public ResponseWrapper post (String json) throws IOException {
        return controller .sendPost("pet", json);
    }
}
