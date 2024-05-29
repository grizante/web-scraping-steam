package org.example.webscrapingback.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document
public class Game {
    @Id
    private String id;
    private String name;
    private List<String> gender;
    private List<Stats> stats;
    
}
