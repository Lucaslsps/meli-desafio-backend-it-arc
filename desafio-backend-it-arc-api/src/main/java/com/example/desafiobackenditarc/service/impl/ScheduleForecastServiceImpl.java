package com.example.desafiobackenditarc.service.impl;

import com.example.desafiobackenditarc.clients.CPTECApiService;
import com.example.desafiobackenditarc.dto.cptec.CityForecastDTO;
import com.example.desafiobackenditarc.dto.cptec.CityListDTO;
import com.example.desafiobackenditarc.dto.cptec.WaveForecastDTO;
import com.example.desafiobackenditarc.dto.notification.Period;
import com.example.desafiobackenditarc.dto.notification.UserNotificationDTO;
import com.example.desafiobackenditarc.dto.notification.WaveForecast;
import com.example.desafiobackenditarc.dto.notification.WeatherForecast;
import com.example.desafiobackenditarc.dto.request.NotifyForecastRequestDTO;
import com.example.desafiobackenditarc.dto.request.ScheduleForecastRequestDTO;
import com.example.desafiobackenditarc.enums.NotificationStatusEnum;
import com.example.desafiobackenditarc.exception.CPTECException;
import com.example.desafiobackenditarc.exception.DesafioBackendItArcApiException;
import com.example.desafiobackenditarc.exception.EntityNotFoundException;
import com.example.desafiobackenditarc.model.Notification;
import com.example.desafiobackenditarc.model.User;
import com.example.desafiobackenditarc.repository.NotificationRepository;
import com.example.desafiobackenditarc.repository.UserRepository;
import com.example.desafiobackenditarc.service.NotifyForecastService;
import com.example.desafiobackenditarc.service.NotifyUsersService;
import com.example.desafiobackenditarc.service.ScheduleForecastService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class ScheduleForecastServiceImpl implements ScheduleForecastService {
    final NotificationRepository notificationRepository;

    @Override
    public void process(ScheduleForecastRequestDTO requestDTO) {
        final Notification notification =
                Notification.builder().city(requestDTO.getCityName()).notificationDate(requestDTO.getNotificationDate())
                        .status(NotificationStatusEnum.PENDING.getDescription()).build();
        notificationRepository.save(notification);
        log.info("[NotifyForecastService] Notification scheduled with success: {}", notification);
    }
}
