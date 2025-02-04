package com.example.desafiobackenditarc.clients;

import com.example.desafiobackenditarc.dto.NotifyForecastDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@FeignClient(name = DesafioBackendItArcApiConfig.NAME, url = DesafioBackendItArcApiConfig.URL,
        path = DesafioBackendItArcApiConfig.PATH,
        configuration = DesafioBackendItArcApiConfig.class)
public interface DesafioBackendItArcApiFeignClientConfig {

    @PostMapping(DesafioBackendItArcApiConfig.NOTIFY_FORECAST)
    void notifyForecast(@RequestBody NotifyForecastDTO request);
}