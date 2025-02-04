package com.example.desafiobackenditarc.config;

import brave.Tracer;
import com.example.desafiobackenditarc.job.NotificationScheduler;
import com.example.desafiobackenditarc.service.NotifyForecastService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NotificationSchedulerConfig {

    private final NotifyForecastService notifyForecastService;
    private final Tracer tracer;

    public NotificationSchedulerConfig(NotifyForecastService notificationScheduler, Tracer tracer) {
        this.notifyForecastService = notificationScheduler;
        this.tracer = tracer;
    }

    @Bean
    @ConditionalOnProperty(name = "scheduler.notification.enabled", havingValue = "true")
    public NotificationScheduler notificationScheduler() {
        return new NotificationScheduler(tracer, notifyForecastService);
    }
}
