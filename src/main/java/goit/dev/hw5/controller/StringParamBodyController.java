package goit.dev.hw5.controller;

import goit.dev.hw5.ResponseWrapper;

import java.io.IOException;

public interface StringParamBodyController {
    ResponseWrapper send(String param, String body) throws IOException;
}
