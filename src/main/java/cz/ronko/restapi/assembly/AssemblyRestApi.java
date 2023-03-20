package cz.ronko.restapi.assembly;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Properties;

public class AssemblyRestApi {

    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
        InputStream input = AssemblyRestApi.class.getClassLoader().getResourceAsStream("config.properties");
        Properties properties = new Properties();
        properties.load(input);

        HttpClient client = HttpClient.newHttpClient();
        Gson gson = new Gson();
        Transcript transcript = new Transcript();
        transcript.setAudio_url(properties.getProperty("assembly.api.audioUrl"));

        String body = gson.toJson(transcript);
        HttpRequest httpRequest = preparePostRequest(properties, body);
        HttpResponse<String> response = client.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        transcript = gson.fromJson(response.body(), Transcript.class);
        httpRequest = prepareGetRequest(properties, transcript);

        while (true) {
            response = client.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            transcript = gson.fromJson(response.body(), Transcript.class);
            System.out.println(transcript.getStatus());
            Thread.sleep(1000);
            if (("error".equals(transcript.getStatus()))) {
                System.out.println("Translation wasn't successful...");
                break;
            } else if ("completed".equals(transcript.getStatus())) {
                System.out.println("Translated text: " + transcript.getText());
                break;
            }
        }

    }

    private static HttpRequest preparePostRequest(Properties properties, String body) throws URISyntaxException {
        System.out.println("Sending request...");
        return HttpRequest.newBuilder()
                .uri(new URI(properties.getProperty("assembly.api.uri")))
                .POST(HttpRequest.BodyPublishers.ofString(body))
                .header(properties.getProperty("assembly.api.authorization"), properties.getProperty("assembly.api.token"))
                .build();
    }

    private static HttpRequest prepareGetRequest(Properties properties, Transcript transcript) throws URISyntaxException {
        return HttpRequest.newBuilder()
                .uri(new URI(properties.getProperty("assembly.api.uri") + "/" + transcript.getId()))
                .GET().header(properties.getProperty("assembly.api.authorization"), properties.getProperty("assembly.api.token"))
                .build();
    }

}
