package goit.dev.hw5.controller;

import java.io.IOException;
import java.util.Map;

public interface SendController {
    int send (Map<String,String> params) throws IOException;
}
