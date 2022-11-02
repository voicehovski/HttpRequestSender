package goit.dev.hw5.controller;

import goit.dev.hw5.ResponseWrapper;

import java.io.IOException;

public interface StringController {
    ResponseWrapper send(String param) throws IOException;
}
