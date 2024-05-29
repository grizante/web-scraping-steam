package org.example.webscrapingback.repository;


import org.example.webscrapingback.model.Game;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GameRepository extends MongoRepository<Game, String> {

    }
