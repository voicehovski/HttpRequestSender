package goit.dev.hw5.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface SendEntityListController<T> {
    int send (Map<String,String> params, List<T> entityList) throws IOException;
}
