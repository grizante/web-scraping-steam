package org.example.webscrapingback.services;

import org.example.webscrapingback.model.Game;
import org.example.webscrapingback.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    GameRepository gameRepository;

    @Autowired
    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

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
        gameRepository.insert(gameArgs);
    }
}
