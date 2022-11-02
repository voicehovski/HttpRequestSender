package goit.dev.hw5.controller;

import goit.dev.hw5.ResponseWrapper;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;

public class SendArbitraryRequestController implements Controller {
    private String serverUrl;

    public SendArbitraryRequestController(String serverUrl) {
        this.serverUrl = serverUrl;
    }

    // Add contentType argument ?
    public ResponseWrapper sendWithBody (String request, byte[] bodyData, String method) throws IOException {
        URL url = new URL(serverUrl + "/" + request);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod(method);
        connection.setDoOutput(true);
        connection.setRequestProperty("Content-Type", "application/json");

        OutputStream os = connection.getOutputStream();
        os.write(bodyData);
        os.flush();
        os.close();

        int responseCode = connection.getResponseCode();
        ResponseWrapper responseWrapper = new ResponseWrapper(responseCode);    // IOException

        responseWrapper.setBody(getResponseAsString(connection));
        /*if (responseCode == HttpURLConnection.HTTP_CREATED || responseCode == HttpURLConnection.HTTP_OK) {
            responseWrapper.setBody(getResponseAsString(connection));
        }*/

        return responseWrapper;
    }

    @Override
    public ResponseWrapper sendPost(String request, byte[] bodyData) throws IOException {
        return sendWithBody(request, bodyData, "POST");
    }
    public ResponseWrapper sendPost(String request, String bodyString) throws IOException {
        return sendPost(request, bodyString.getBytes());    // Encoding?
    }
    public ResponseWrapper sendPostFromJson (String request, File bodyFile) throws IOException {
        return sendPost(request, Files.readAllBytes(bodyFile.toPath()));
    }

    public ResponseWrapper sendPut (String request, byte[] bodyData) throws IOException {
        return sendWithBody(request, bodyData, "PUT");
    }

    public ResponseWrapper send (String request, String method) throws IOException {
        URL url = new URL(String .format("%1$s/%2$s", serverUrl, request)); // MalformedURLException
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();    // IOException
        connection.setRequestMethod(method); // ProtocolException
        int responseCode = connection.getResponseCode();
        ResponseWrapper responseWrapper = new ResponseWrapper(responseCode);    // IOException

        responseWrapper.setBody(getResponseAsString(connection));
        /*if (responseCode == HttpURLConnection.HTTP_OK) {
            responseWrapper.setBody(getResponseAsString(connection));
        }*/

        return responseWrapper;
    }

    @Override
    public ResponseWrapper sendGet(String request) throws IOException {
        return send(request, "GET");
    }

    public ResponseWrapper sendDelete(String request) throws IOException {
        URL url = new URL(String .format("%1$s/%2$s", serverUrl, request)); // MalformedURLException
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();    // IOException
        connection.setRequestMethod("DELETE"); // ProtocolException
        int responseCode = connection.getResponseCode();
        return new ResponseWrapper(responseCode);    // IOException
    }

    private String getResponseAsString(HttpURLConnection connection) throws IOException {
        BufferedReader in =
                new BufferedReader(
                        new InputStreamReader(connection.getInputStream()));    // IOException
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {   // IOException
            response.append(inputLine);
        }
        in.close(); // IOException
        return response.toString();
    }
}
