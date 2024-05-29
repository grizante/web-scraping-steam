package org.example.webscrapingback.services;

import org.example.webscrapingback.model.Game;
import org.example.webscrapingback.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Optional<Game> getDataById(String id) {
        return gameRepository.findById(id);
    }

    public List<Game> save (List<Game> gameList) {
        return gameRepository.insert(gameList);
    }

    public void save (Game gameArgs) {
        gameRepository.insert(gameArgs);
    }
}
