package goit.dev.hw5.controller.pet;

import goit.dev.hw5.ResponseWrapper;
import goit.dev.hw5.controller.helper.MimeMultipartData;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

public class PostFilePetController {
    private String url;

    public PostFilePetController(String url) {
        this.url = url;
    }

    public ResponseWrapper send (long id, String param, File file) throws IOException, InterruptedException {

        var mimeMultipartData = MimeMultipartData.newBuilder()
                .withCharset(StandardCharsets.UTF_8)
                .addText("additionalMetadata", param)
                .addFile("file", file.toPath(), Files.probeContentType(file.toPath()))
                .build();

        var request = HttpRequest.newBuilder()
                .header("Content-Type", mimeMultipartData.getContentType())
                .POST(mimeMultipartData.getBodyPublisher())
                .uri(URI.create(String.format("%s/pet/%d/uploadImage", url, id)))
                .build();

        var httpClient = HttpClient.newBuilder().build();
        var response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        ResponseWrapper responseWrapper = new ResponseWrapper(response.statusCode());
        responseWrapper.setBody(response.body());
        return responseWrapper;
    }
}
