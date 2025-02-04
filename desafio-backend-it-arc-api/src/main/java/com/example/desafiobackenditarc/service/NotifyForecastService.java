package com.example.desafiobackenditarc.service;

import com.example.desafiobackenditarc.dto.request.NotifyForecastRequestDTO;
import com.example.desafiobackenditarc.exception.DesafioBackendItArcApiException;

public interface NotifyForecastService {
    void process(NotifyForecastRequestDTO request) throws DesafioBackendItArcApiException;
}
