package com.example.desafiobackenditarc.service;

import com.example.desafiobackenditarc.dto.request.NotifyForecastRequestDTO;
import com.example.desafiobackenditarc.exception.CPTECException;
import com.example.desafiobackenditarc.exception.DesafioBackendItArcApiException;
import com.example.desafiobackenditarc.exception.EntityNotFoundException;

public interface NotifyForecastService {
    void process(NotifyForecastRequestDTO request)
            throws DesafioBackendItArcApiException, EntityNotFoundException, CPTECException;
}
