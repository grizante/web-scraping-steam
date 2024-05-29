package org.example.webscrapingback.config;

import org.example.webscrapingback.services.ScrapService;
import org.example.webscrapingback.services.api.SteamApiService;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class ScrapConfig {
    SteamApiService steamApiService;
    ScrapService scrap;
    private int app;

    public ScrapConfig(ScrapService scrapService) {
        this.scrap = scrapService;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void onAppReady() {
        this.steamApiService = new SteamApiService();
        steamApiService.consultApi();

        for (int appId : steamApiService.gameId.id()){
            app = appId;

            try {
                executar();
            } catch (Exception e) {
                System.out.println("Falha ao buscar dados para o ID: " + app);
            }
        }

    }

    private void executar(){
        String linkDb = "https://steamcharts.com/app/" + app;
        scrap.buscarDb(linkDb, app);
    }
}
