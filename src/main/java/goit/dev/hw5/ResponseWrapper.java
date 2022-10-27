package goit.dev.hw5;

public class ResponseWrapper {
    private int status;
    private String body;

    public ResponseWrapper(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public String getBody() {
        return body == null ? "" : body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
