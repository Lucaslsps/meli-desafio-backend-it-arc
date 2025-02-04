package com.example.desafiobackenditarc.job;

import brave.Span;
import brave.Tracer;
import com.example.desafiobackenditarc.service.NotifyForecastService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;

@Slf4j
@RequiredArgsConstructor
public class NotificationScheduler {
    private final Tracer tracer;
    private final NotifyForecastService notifyForecastService;

    @Scheduled(cron = "${scheduler.notification.cron}")
    public void process() {
        Span newSpan = tracer.newTrace().name("consumeConsignmentInvoice").start();
        tracer.withSpanInScope(newSpan);
        try {
            log.info("[NotificationScheduler] Starting processing!");
            notifyForecastService.process();
            log.info("[NotificationScheduler] Process success!");
        } catch (final Exception ex) {
            log.error("[NotificationScheduler] Process error!", ex);
        } finally {
            newSpan.finish();
        }
    }
}
