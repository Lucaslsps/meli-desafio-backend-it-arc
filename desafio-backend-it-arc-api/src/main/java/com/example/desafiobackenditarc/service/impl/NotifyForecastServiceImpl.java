package com.example.desafiobackenditarc.service.impl;

import com.example.desafiobackenditarc.clients.CPTECApiService;
import com.example.desafiobackenditarc.dto.request.NotifyForecastRequestDTO;
import com.example.desafiobackenditarc.enums.NotificationStatusEnum;
import com.example.desafiobackenditarc.exception.CPTECException;
import com.example.desafiobackenditarc.exception.DesafioBackendItArcApiException;
import com.example.desafiobackenditarc.exception.EntityNotFoundException;
import com.example.desafiobackenditarc.model.Notification;
import com.example.desafiobackenditarc.repository.NotificationRepository;
import com.example.desafiobackenditarc.repository.UserRepository;
import com.example.desafiobackenditarc.service.NotifyUsersService;
import com.example.desafiobackenditarc.service.NotifyForecastService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Objects;

@Service
@Slf4j
@RequiredArgsConstructor
public class NotifyForecastServiceImpl implements NotifyForecastService {
    final NotificationRepository notificationRepository;
    final NotifyUsersService notifyUsersService;

    @Override
    public void process(NotifyForecastRequestDTO requestDTO)
            throws DesafioBackendItArcApiException, EntityNotFoundException, CPTECException {
        if (Objects.isNull(requestDTO.getNotificationId())) {
            final Notification notification = Notification.builder().city(requestDTO.getCityName()).build();
            notification.setStatus(NotificationStatusEnum.PENDING.getDescription());
            log.info("[NotifyForecastService] Notification is not scheduled: {}", notification);
            try {
                notifyUsersService.notifyUsers(requestDTO.getCityName());
                notification.setNotificationDate(new Date());
                notification.setStatus(NotificationStatusEnum.PROCESSED.getDescription());
                notificationRepository.save(notification);
            } catch (Exception e) {
                log.error("[NotifyForecastService] Error on notificating with error: {}", e.getMessage());
                notification.setStatus(NotificationStatusEnum.ERROR.getDescription());
                notification.setErrorMessage(e.getMessage());
                notificationRepository.save(notification);
                throw new DesafioBackendItArcApiException(
                        "[NotifyForecastService] Error on saving notification, error: " + e.getMessage());
            }
        } else {
            notifyUsersService.notifyUsers(requestDTO.getCityName());
        }
    }
}
