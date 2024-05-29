package org.example.webscrapingback.model.response;

import lombok.Data;

import java.util.List;

@Data
public class GameJsonModel {
    private String nome;
    private int appid;
    private List<String> tags;
    private List<StatsApiModel> players;
}
