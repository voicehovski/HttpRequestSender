package goit.dev.hw5.controller;

import goit.dev.hw5.ResponseWrapper;

import java.io.IOException;

public interface IdController {
    ResponseWrapper send (long id) throws IOException;
}