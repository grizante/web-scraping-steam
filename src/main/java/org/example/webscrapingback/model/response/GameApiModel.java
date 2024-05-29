package org.example.webscrapingback.model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class GameApiModel {

    private int appid;
    private String name;
    private String genre;
    private Map<String, Integer> tags;

    public List<String> getTagsList() {
        if (tags == null || tags.isEmpty()) {
            return Collections.emptyList();
        }

        return new ArrayList<>(tags.keySet());
    }
}
