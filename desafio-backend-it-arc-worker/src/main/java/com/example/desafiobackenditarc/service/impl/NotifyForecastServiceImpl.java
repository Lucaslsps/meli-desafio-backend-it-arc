package com.example.desafiobackenditarc.service.impl;


import com.example.desafiobackenditarc.clients.DesafioBackendItArcApiService;
import com.example.desafiobackenditarc.dto.NotifyForecastDTO;
import com.example.desafiobackenditarc.enums.NotificationStatusEnum;
import com.example.desafiobackenditarc.exception.DesafioBackendItArcApiException;
import com.example.desafiobackenditarc.model.Notification;
import com.example.desafiobackenditarc.repository.NotificationRepository;
import com.example.desafiobackenditarc.service.NotifyForecastService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class NotifyForecastServiceImpl implements NotifyForecastService {
    final NotificationRepository notificationRepository;
    final DesafioBackendItArcApiService desafioBackendItArcApiService;

    @Override
    public void process() {
        final List<Notification> notificationsToBeSent = notificationRepository.getScheduledNotificationsToBeSent();

        if(notificationsToBeSent.isEmpty()) {
            log.info("[NotifyForecastService] No notifications pending");
            return;
        }

        log.info("[NotifyForecastService] Processing notifications: {}", notificationsToBeSent);
        notificationsToBeSent.forEach((notification -> {
            final NotifyForecastDTO request = NotifyForecastDTO.builder()
                    .cityName(notification.getCity())
                    .notificationId(notification.getId())
                    .build();
            try {
                desafioBackendItArcApiService.notifyForecast(request);
                notification.setStatus(NotificationStatusEnum.PROCESSED.getDescription());
                notificationRepository.save(notification);
                log.info("[NotifyForecastService] Success processing notification id: {}", notification.getId());
            } catch (DesafioBackendItArcApiException e) {
                log.error("[NotifyForecastService] Error on sending notification id: {} with error: {}",
                        notification.getId(), e.getMessage());
                notification.setStatus(NotificationStatusEnum.ERROR.getDescription());
                notification.setErrorMessage(e.getMessage());
                notificationRepository.save(notification);
            }
        }));
    }
}
