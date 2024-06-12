package org.example.webscrapingback.controller;

import org.example.webscrapingback.model.Game;
import org.example.webscrapingback.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/games")
public class GameController {

    GameService gameService;

    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping
    public ResponseEntity<List<Game>> getAllData() {
        return ResponseEntity.ok().body(gameService.getAllData());
    }

    @GetMapping("/{genre}")
    public ResponseEntity<List<Game>> getDataByGenre(@PathVariable String genre) {
        return ResponseEntity.ok().body(gameService.getDataByGender(genre));
    }

    @GetMapping("/{initMonth}/{initYear}/{finalMonth}/{finalYear}")
    public ResponseEntity<List<Game>> getDataByTimeStamp(@PathVariable Integer initMonth, @PathVariable Integer initYear,
                                                         @PathVariable Integer finalMonth, @PathVariable Integer finalYear) {
        return ResponseEntity.ok().body(gameService.getDataByTimeStamp(initMonth, initYear, finalMonth, finalYear));
    }
}
