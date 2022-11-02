package goit.dev.hw5.controller;

import goit.dev.hw5.ResponseWrapper;

import java.io.File;
import java.io.IOException;

public interface Controller {
    ResponseWrapper sendGet(String request) throws IOException;
    ResponseWrapper sendPostFromJson(String request, File bodyFilename) throws IOException;
    ResponseWrapper sendPost(String request, byte[] bodyData) throws IOException;
}
