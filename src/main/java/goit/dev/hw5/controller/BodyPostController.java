package goit.dev.hw5.controller;

import goit.dev.hw5.ResponseWrapper;

import java.io.IOException;

public interface BodyPostController {
    ResponseWrapper post (String body) throws IOException;
}
