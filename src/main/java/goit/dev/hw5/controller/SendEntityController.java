package goit.dev.hw5.controller;

import java.io.IOException;
import java.util.Map;

public interface SendEntityController<T> {
    int send (Map<String,String> params, T entity) throws IOException;
}
