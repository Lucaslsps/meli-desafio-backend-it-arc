package com.example.desafiobackenditarc.clients;

import com.example.desafiobackenditarc.dto.NotifyForecastDTO;
import com.example.desafiobackenditarc.exception.DesafioBackendItArcApiException;

import feign.FeignException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;


@Service
@Slf4j
@RequiredArgsConstructor
public class DesafioBackendItArcApiServiceImpl implements DesafioBackendItArcApiService {

    private final DesafioBackendItArcApiFeignClientConfig desafioBackendItArcApiFeignClientConfig;

    @Override
    public void notifyForecast(NotifyForecastDTO notifyForecastDTO) throws DesafioBackendItArcApiException {
        try {
            desafioBackendItArcApiFeignClientConfig.notifyForecast(notifyForecastDTO);
        } catch (final FeignException feignException) {
            log.error("[DesafioBackendItArcApiService] Error on sending schedulement to API with error: {}",
                    feignException.getMessage());
            throw new DesafioBackendItArcApiException(feignException.getMessage());
        }
    }
}