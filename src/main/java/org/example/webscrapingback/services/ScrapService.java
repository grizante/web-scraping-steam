package org.example.webscrapingback.services;

import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import org.example.webscrapingback.model.Game;
import org.example.webscrapingback.model.Stats;
import org.example.webscrapingback.model.response.GameApiModel;
import org.example.webscrapingback.model.response.StatsApiModel;
import org.example.webscrapingback.services.api.SteamSpyApiService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ScrapService {
    SteamSpyApiService apiSteamSpy;
    GameService gameService;

    public ScrapService(GameService gameService) {
        this.apiSteamSpy = new SteamSpyApiService();
        this.gameService = gameService;
    }

    public void buscarDb(String link, int app) {
        Document doc;

        try {
            doc = Jsoup.connect(link).get();

            List<StatsApiModel> games = new ArrayList<>();

            Elements tables = doc.getElementsByClass("common-table");

            for (Element table : tables) {
                Element tbody = table.selectFirst("tbody");
                if (tbody != null) {
                    Elements rows = tbody.select("tr");
                    for (Element row : rows) {
                        Elements tds = row.select("td");
                        if (tds.size() >= 3) {
                            String Data = tds.get(0).text();
                            String Players = tds.get(1).text();
                            games.add(new StatsApiModel(Data, Players));
                        }
                    }
                }
            }

            try {
                GameApiModel gameApiModel = apiSteamSpy.getInfo(app);
                Game game = getGame(games, gameApiModel);

                gameService.save(game);

            } catch (MismatchedInputException e) {
                System.out.println("Erro de desserialização, API incompleta. URL: https://steamspy.com/api.php?request=appdetails&appid=" + app);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            System.out.println("O site não foi encontrado: " + link);
        }
    }

    private static Game getGame(List<StatsApiModel> games, GameApiModel gameApiModel) {
        List<Stats> statsList = new ArrayList<>();


        for (StatsApiModel gameStats : games) {
            Stats stats = new Stats();

            stats.setYear(gameStats.getANO());
            stats.setMonth(gameStats.getMES());
            stats.setPlayers((int) Double.parseDouble(gameStats.getPLAYERS()));

            statsList.add(stats);
        }

        Game game = new Game();
        game.setName(gameApiModel.getName());
        game.setGenre(gameApiModel.getTagsList());
        game.setStats(statsList);
        return game;
    }
}