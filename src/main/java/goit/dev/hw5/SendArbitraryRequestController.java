package goit.dev.hw5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class SendArbitraryRequestController implements Controller {
    private String serverUrl;

    public SendArbitraryRequestController(String serverUrl) {
        this.serverUrl = serverUrl;
    }

    @Override
    public String sendRequest(String request) throws IOException {
        URL url = new URL(String .format("%1$s/%2$s", serverUrl, request)); // MalformedURLException
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();    // IOException
        connection.setRequestMethod("GET"); // ProtocolException
        int responseCode = connection.getResponseCode();    // IOException
        System.out.println("GET response code: " + responseCode);
        if (responseCode == HttpURLConnection.HTTP_OK) {
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
        } else {
            return "Response status: " + responseCode;
        }
    }
}
