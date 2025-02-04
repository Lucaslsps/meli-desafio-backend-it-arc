package com.example.desafiobackenditarc.controller;

import com.example.desafiobackenditarc.dto.request.NotifyForecastRequestDTO;
import com.example.desafiobackenditarc.dto.request.ScheduleForecastRequestDTO;
import com.example.desafiobackenditarc.exception.CPTECException;
import com.example.desafiobackenditarc.exception.DesafioBackendItArcApiException;
import com.example.desafiobackenditarc.exception.EntityNotFoundException;
import com.example.desafiobackenditarc.service.NotifyForecastService;
import com.example.desafiobackenditarc.service.ScheduleForecastService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/notify")
public class NotificationController {

    private final NotifyForecastService notifyForecastService;
    private final ScheduleForecastService scheduleForecastService;

    @PostMapping("/forecast")
    public ResponseEntity notifyForecast(@RequestBody final NotifyForecastRequestDTO request)
            throws DesafioBackendItArcApiException, EntityNotFoundException, CPTECException {
        notifyForecastService.process(request);
        return ResponseEntity.ok("OK");
    }

    @PostMapping("/forecast/schedule")
    public ResponseEntity scheduleForecast(@RequestBody final ScheduleForecastRequestDTO request)
            throws DesafioBackendItArcApiException {
        scheduleForecastService.process(request);
        return ResponseEntity.ok("OK");
    }
}
