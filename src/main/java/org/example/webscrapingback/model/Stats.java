package org.example.webscrapingback.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@Setter
public class Stats {
    private Integer year;
    private Integer month;
    private Integer players;
}
