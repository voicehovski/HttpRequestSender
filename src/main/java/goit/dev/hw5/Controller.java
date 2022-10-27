package goit.dev.hw5;

import java.io.IOException;

public interface Controller {
    ResponseWrapper sendGet(String request) throws IOException;
    ResponseWrapper sendPost(String request, String filename) throws IOException;
}
