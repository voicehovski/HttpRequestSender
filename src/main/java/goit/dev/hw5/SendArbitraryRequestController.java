package goit.dev.hw5;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;

public class SendArbitraryRequestController implements Controller {
    private String serverUrl;

    public SendArbitraryRequestController(String serverUrl) {
        this.serverUrl = serverUrl;
    }

    public ResponseWrapper sendPost(String request, String filename) throws IOException {
        URL url = new URL(serverUrl + "/" + request);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setDoOutput(true);

        OutputStream os = connection.getOutputStream();
        os.write(Files.readAllBytes(new File("src/main/resources/" + filename).toPath()));
        os.flush();
        os.close();

        int responseCode = connection.getResponseCode();
        ResponseWrapper responseWrapper = new ResponseWrapper(responseCode);    // IOException

        if (responseCode == HttpURLConnection.HTTP_CREATED) {
            responseWrapper.setBody(getResponseAsString(connection));
        }

        return responseWrapper;
    }

    @Override
    public ResponseWrapper sendGet(String request) throws IOException {
        URL url = new URL(String .format("%1$s/%2$s", serverUrl, request)); // MalformedURLException
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();    // IOException
        connection.setRequestMethod("GET"); // ProtocolException
        int responseCode = connection.getResponseCode();
        ResponseWrapper responseWrapper = new ResponseWrapper(responseCode);    // IOException

        if (responseCode == HttpURLConnection.HTTP_OK) {
            responseWrapper.setBody(getResponseAsString(connection));
        }

        return responseWrapper;
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
