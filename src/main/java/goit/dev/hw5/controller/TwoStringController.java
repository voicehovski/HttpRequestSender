package goit.dev.hw5.controller;

import goit.dev.hw5.ResponseWrapper;

import java.io.IOException;

public interface TwoStringController {
    ResponseWrapper send(String param1, String param2) throws IOException;
}
