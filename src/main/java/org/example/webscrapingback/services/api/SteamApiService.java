package org.example.webscrapingback.services.api;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.example.webscrapingback.model.response.GameId;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;


@Service
public class SteamApiService {
    public GameId gameId = new GameId(new ArrayList<>());
    ObjectMapper objectMapper = new ObjectMapper();

    @EventListener(ApplicationReadyEvent.class)
    public void consultApi() {
        try {
            JsonNode apps = getJsonNode();

            ArrayNode gameArray = objectMapper.createArrayNode();

            for (JsonNode app : apps) {

                int appId = app.get("appid").intValue();
                String name = app.get("name").asText();

                if (!cleanAppId(name)) {
                    ObjectNode gameNode = objectMapper.createObjectNode();

                    gameNode.put("name", name);
                    gameNode.put("appid", appId);

                    gameArray.add(gameNode);

                    ArrayList<Integer> appIds = (ArrayList<Integer>) gameId.id();

                    appIds.add(appId);

                    System.out.println("OBJETO APP ID = " + appId);

                    gameId.id().add(appId);
                }
            }

            File jsonFile = new File("games.json");

            ObjectNode objectNode = objectMapper.createObjectNode();
            objectNode.putArray("games").add(gameArray);

            objectMapper.writeValue(jsonFile, objectNode);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    private JsonNode getJsonNode() throws URISyntaxException, IOException {
        URL url = new URI("https://api.steampowered.com/ISteamApps/GetAppList/v2/").toURL();
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;

        while ((line = reader.readLine()) != null) {
            response.append(line);
        }

        reader.close();

        JsonNode jsonResponse = objectMapper.readTree(response.toString());

        JsonNode appList = jsonResponse.get("applist");

        return appList.get("apps");
    }

    private static boolean cleanAppId(String name) {
        return name.contains("Soundtrack") || name.contains("soundtrack");
    }
}
