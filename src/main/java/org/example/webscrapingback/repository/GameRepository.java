package org.example.webscrapingback.repository;


import org.example.webscrapingback.model.Game;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameRepository extends MongoRepository<Game, String> {
    List<Game> findGamesByGenreContainsIgnoreCase(String genre);
}