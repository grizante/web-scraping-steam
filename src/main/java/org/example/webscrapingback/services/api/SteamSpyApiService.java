package org.example.webscrapingback.services.api;

import org.example.webscrapingback.model.response.GameApiModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class SteamSpyApiService {
    GameApiModel game = new GameApiModel();

    public GameApiModel getInfo(int numApp) throws Exception{
        String siteApi = "https://steamspy.com/api.php?request=appdetails&appid="+ numApp;

        HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(siteApi)).GET().build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        ObjectMapper objectMapper = new ObjectMapper();

        game = objectMapper.readValue(response.body(), GameApiModel.class);

        client.close();

        return game;
    }
}
