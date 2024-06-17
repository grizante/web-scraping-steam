package org.example.webscrapingback.model.response;


import lombok.Data;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


@Data
public class StatsApiModel {
    private final Integer MES;
    private final Integer ANO;
    private final String PLAYERS;

    public StatsApiModel(String Data, String players) {
        this.PLAYERS = players;

        if (Objects.equals(Data, "Last 30 Days")) {
            Calendar calendar = Calendar.getInstance();
            ANO = calendar.get(Calendar.YEAR);
            MES = calendar.get(Calendar.MONTH) + 1;
        } else {
            String[] dataSplit = Data.split(" ");

            Map<String, Integer> monthMap = getStringIntegerMap();

            ANO = Integer.valueOf(dataSplit[1]);
            MES = monthMap.get(dataSplit[0]);
        }
    }

    private static Map<String, Integer> getStringIntegerMap() {
        Map<String, Integer> monthMap = new HashMap<>();

        monthMap.put("January", 1);
        monthMap.put("February", 2);
        monthMap.put("March", 3);
        monthMap.put("April", 4);
        monthMap.put("May", 5);
        monthMap.put("June", 6);
        monthMap.put("July", 7);
        monthMap.put("August", 8);
        monthMap.put("September", 9);
        monthMap.put("October", 10);
        monthMap.put("November", 11);
        monthMap.put("December", 12);
        return monthMap;
    }

}
