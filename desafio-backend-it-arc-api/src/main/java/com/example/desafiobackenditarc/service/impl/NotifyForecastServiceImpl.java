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
import com.example.desafiobackenditarc.enums.NotificationStatusEnum;
import com.example.desafiobackenditarc.exception.CPTECException;
import com.example.desafiobackenditarc.exception.DesafioBackendItArcApiException;
import com.example.desafiobackenditarc.exception.EntityNotFoundException;
import com.example.desafiobackenditarc.model.Notification;
import com.example.desafiobackenditarc.model.User;
import com.example.desafiobackenditarc.repository.NotificationRepository;
import com.example.desafiobackenditarc.repository.UserRepository;
import com.example.desafiobackenditarc.service.NotifyForecastService;
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
public class NotifyForecastServiceImpl implements NotifyForecastService {
    final NotificationRepository notificationRepository;
    final UserRepository userRepository;
    final CPTECApiService cptecApiService;

    @Override
    public void process(NotifyForecastRequestDTO requestDTO) throws DesafioBackendItArcApiException {
        final Notification notification = Notification.builder().city(requestDTO.getCityName()).build();
        notification.setStatus(NotificationStatusEnum.PENDING.getDescription());

        log.info("[NotifyForecastService] Notifying: {}", notification);

        if (Objects.isNull(requestDTO.getNotificationDate())) {
            try {
                log.info("[NotifyForecastService] Notification is not scheduled");
                notifyUsers(requestDTO.getCityName());
                notification.setNotificationDate(new Date());
                notification.setStatus(NotificationStatusEnum.PROCESSED.getDescription());
                notificationRepository.save(notification);
                return;
            } catch (Exception e) {
                log.error("[NotifyForecastService] Error on notificating with error: {}", e.getMessage());
                notification.setStatus(NotificationStatusEnum.ERROR.getDescription());
                notification.setErrorMessage(e.getMessage());
                notificationRepository.save(notification);
                throw new DesafioBackendItArcApiException(
                        "[NotifyForecastService] Error on saving notification, error: " + e.getMessage());
            }
        }

        log.info("[NotifyForecastService] Notification is scheduled");
        notificationRepository.save(notification);
    }

    private void notifyUsers(final String cityName) throws EntityNotFoundException, CPTECException {
        final List<User> usersToBeNotified = userRepository.findByCityName(cityName);

        if (usersToBeNotified.isEmpty()) {
            log.error("[NotifyForecastService] No users from this city to be notified");
            throw new EntityNotFoundException("No users from this city to be notified");
        }

        final CityListDTO cityList = cptecApiService.getCityList(cityName);

        if (Objects.isNull(cityList.getCities().get(0)) || !cityList.getCities().get(0).getName().equals(cityName)) {
            log.error("[NotifyForecastService] Error getting city details on CPTEC. City: {}", cityName);
            throw new CPTECException("Error getting city details on CPTEC");
        }

        final CityListDTO.CityDTO city = cityList.getCities().get(0);

        final CityForecastDTO cityForecast = cptecApiService.getCityForecast(city.getId());
        final WaveForecastDTO waveForecast = cptecApiService.getWaveForecast(city.getId(), 0);

        final UserNotificationDTO notificationDTO = UserNotificationDTO.builder()
                .weatherForecast(
                        cityForecast.getForecasts().stream()
                                .map(forecast -> WeatherForecast.builder().day(forecast.getDay()).weather(forecast.getWeather())
                                        .maxTemperature(forecast.getMaxTemperature())
                                        .minTemperature(forecast.getMinTemperature()).uvIndex(forecast.getUvIndex()).build())
                                .collect(Collectors.toList()))
                .waveForecast("undefined".equals(waveForecast.getName()) ? null :
                        WaveForecast.builder().name(city.getName()).state(city.getState()).morning(
                                        Period.builder().day(waveForecast.getMorning().getDay())
                                                .agitation(waveForecast.getMorning().getAgitation())
                                                .height(waveForecast.getMorning().getHeight())
                                                .direction(waveForecast.getMorning().getDirection())
                                                .wind(waveForecast.getMorning().getWind())
                                                .windDirection(waveForecast.getMorning().getWindDirection()).build()).afternoon(
                                        Period.builder().day(waveForecast.getAfternoon().getDay())
                                                .agitation(waveForecast.getAfternoon().getAgitation())
                                                .height(waveForecast.getAfternoon().getHeight())
                                                .direction(waveForecast.getAfternoon().getDirection())
                                                .wind(waveForecast.getAfternoon().getWind())
                                                .windDirection(waveForecast.getAfternoon().getWindDirection()).build())
                                .night(Period.builder().day(waveForecast.getNight().getDay())
                                        .agitation(waveForecast.getNight().getAgitation())
                                        .height(waveForecast.getNight().getHeight())
                                        .direction(waveForecast.getNight().getDirection())
                                        .wind(waveForecast.getNight().getWind())
                                        .windDirection(waveForecast.getNight().getWindDirection()).build())
                                .build()).build();

        log.info("Notification sent to city: {}, notification: {}", cityName, notificationDTO);
    }
}
