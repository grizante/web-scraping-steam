package org.example.webscrapingback.config;

import org.example.webscrapingback.services.GameService;
import org.example.webscrapingback.services.ScrapService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public ScrapConfig scrapConfig(ScrapService scrapService) {
        return new ScrapConfig(scrapService);
    }

    @Bean
    public ScrapService scrapService(GameService gameService) {
        return new ScrapService(gameService);
    }
}
