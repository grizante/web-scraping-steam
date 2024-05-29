package org.example.webscrapingback.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Stats {
    private Integer year;
    private Integer month;
    private Integer players;
}
