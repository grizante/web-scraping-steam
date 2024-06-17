package org.example.webscrapingback.services;

import lombok.AllArgsConstructor;
import org.example.webscrapingback.model.Game;
import org.example.webscrapingback.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GameService {

    MongoTemplate mongoTemplate;
    GameRepository gameRepository;

    public List<Game> getAllData() {
        return gameRepository.findAll();
    }

    public List<Game> getDataByGenre(String genre) {
        return gameRepository.findGamesByGenreContainsIgnoreCase(genre);
    }

    public List<Game> getDataByTimeStamp(Integer initMonth, Integer initYear, Integer finalMonth, Integer finalYear) {
        return List.of();
    }

    public void save (Game gameArgs) {
        List<Game> game = gameRepository.findGamesByName(gameArgs.getName());
        if (!game.isEmpty()) {
            mongoTemplate.updateFirst(
                    Query.query(Criteria.where("id").is(game.getFirst().getId())),
                    new Update().push("stats", gameArgs.getStats()),
                    Game.class
            );
        } else {
            gameRepository.insert(gameArgs);
        }
    }
}
