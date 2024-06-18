package org.example.webscrapingback.controller;

import lombok.AllArgsConstructor;
import org.example.webscrapingback.model.Game;
import org.example.webscrapingback.services.GameService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/games")
@AllArgsConstructor
public class GameController {

    GameService gameService;

    @GetMapping()
    public ResponseEntity<List<String>> getGenres() {
        return ResponseEntity.ok().body(gameService.getAllGenres());
    }

    @GetMapping("/{genres}")
    public ResponseEntity<List<Game>> getDataByGenres(@PathVariable List<String> genres) {
        return ResponseEntity.ok().body(gameService.getDataByGenre(genres));
    }

    @GetMapping("/lastmonth")
    public ResponseEntity<List<Game>> getLastMonthGames() {
        return ResponseEntity.ok().body(gameService.getDataByInterval(
                LocalDate.now().getYear(), LocalDate.now().getMonthValue() - 1,
                LocalDate.now().getYear(), LocalDate.now().getMonthValue()
        ));
    }

    @GetMapping("/lastyear")
    public ResponseEntity<List<Game>> getLastYearGames() {
        return ResponseEntity.ok().body(gameService.getDataByInterval(
                LocalDate.now().getYear() - 1, LocalDate.now().getMonthValue(),
                LocalDate.now().getYear(), LocalDate.now().getMonthValue()
        ));
    }

    @GetMapping("/twoyears")
    public ResponseEntity<List<Game>> getTwoYearGames() {
        return ResponseEntity.ok().body(gameService.getDataByInterval(
                LocalDate.now().getYear() - 2, LocalDate.now().getMonthValue(),
                LocalDate.now().getYear(), LocalDate.now().getMonthValue()
        ));
    }

    @GetMapping("/threeyears")
    public ResponseEntity<List<Game>> getThreeYearGames() {
        return ResponseEntity.ok().body(gameService.getDataByInterval(
                LocalDate.now().getYear() - 3, LocalDate.now().getMonthValue(),
                LocalDate.now().getYear(), LocalDate.now().getMonthValue()
        ));
    }

    @GetMapping("/fouryears")
    public ResponseEntity<List<Game>> getFourYearGames() {
        return ResponseEntity.ok().body(gameService.getDataByInterval(
                LocalDate.now().getYear() - 4, LocalDate.now().getMonthValue(),
                LocalDate.now().getYear(), LocalDate.now().getMonthValue()
        ));
    }

    @GetMapping("/fiveyears")
    public ResponseEntity<List<Game>> getFiveYearGames() {
        return ResponseEntity.ok().body(gameService.getDataByInterval(
                LocalDate.now().getYear() - 5, LocalDate.now().getMonthValue(),
                LocalDate.now().getYear(), LocalDate.now().getMonthValue()
        ));
    }
}
