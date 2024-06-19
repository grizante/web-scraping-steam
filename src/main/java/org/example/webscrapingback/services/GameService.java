package org.example.webscrapingback.services;

import lombok.AllArgsConstructor;
import org.example.webscrapingback.model.Game;
import org.example.webscrapingback.repository.GameRepository;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class GameService {

    MongoTemplate mongoTemplate;
    GameRepository gameRepository;

    public List<Game> getAllData() {
        return mongoTemplate.findAll(Game.class);
    }

    public List<Game> getDataByGenre(List<String> genre) {
        return gameRepository.findGamesByGenreContains(genre);
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

    public List<String> getAllGenres() {
        List<Game> games = mongoTemplate.findAll(Game.class);
        List<String> genres = new ArrayList<>();

        for (Game game : games) {
            genres.addAll(game.getGenre());
        }

        return genres;
    }

    public List<Game> getDataByInterval(int startYear, int startMonth, int endYear, int endMonth) {
        Query query = new Query();

        List<Criteria> criteriaList = new ArrayList<>();

        Criteria startYearCriteria = Criteria.where("stats.year").is(startYear).and("stats.month").gte(startMonth);
        criteriaList.add(startYearCriteria);

        Criteria endYearCriteria = Criteria.where("stats.year").is(endYear).and("stats.month").lte(endMonth);
        criteriaList.add(endYearCriteria);

        if (startYear < endYear - 1) {
            Criteria middleYearsCriteria = Criteria.where("stats.year").gt(startYear).lt(endYear);
            criteriaList.add(middleYearsCriteria);
        }

        query.addCriteria(new Criteria().orOperator(criteriaList.toArray(new Criteria[0])));

        return mongoTemplate.find(query, Game.class);

    }
}
