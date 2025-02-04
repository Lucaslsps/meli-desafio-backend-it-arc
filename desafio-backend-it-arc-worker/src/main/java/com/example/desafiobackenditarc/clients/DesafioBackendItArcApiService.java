package com.example.desafiobackenditarc.clients;

import com.example.desafiobackenditarc.dto.NotifyForecastDTO;
import com.example.desafiobackenditarc.exception.DesafioBackendItArcApiException;


public interface DesafioBackendItArcApiService {
    void notifyForecast(NotifyForecastDTO notifyForecastDTO) throws DesafioBackendItArcApiException;
}