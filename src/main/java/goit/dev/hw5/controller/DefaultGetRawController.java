package goit.dev.hw5.controller;

public class DefaultGetRawController implements GetRawController {
    private String body;

    @Override
    public String getBody() {
        return body;
    }

    @Override
    public void setBody(String body) {
        this.body = body;
    }
}
