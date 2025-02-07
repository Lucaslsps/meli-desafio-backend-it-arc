package com.example.desafiobackenditarc.integration;

import com.example.desafiobackenditarc.config.IntegrationTest;
import com.example.desafiobackenditarc.enums.NotificationStatusEnum;
import com.example.desafiobackenditarc.job.NotificationScheduler;
import com.example.desafiobackenditarc.model.Notification;
import com.example.desafiobackenditarc.repository.NotificationRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@IntegrationTest
public class NotificationSchedulerTest {
    @Autowired
    private NotificationScheduler scheduler;

    @Autowired
    private NotificationRepository notificationRepository;

    @Test
    @Sql({"classpath:sql/cleanup_script.sql"})
    void successWhenNoNotificationsToBeSent() {
        Assertions.assertDoesNotThrow(() -> scheduler.process());

        final List<Notification> notification = notificationRepository.findAll();
        Assertions.assertEquals(0, notification.size());
    }

    @Test
    @Sql({"classpath:sql/cleanup_script.sql", "classpath:sql/success-sending-notification-test.sql"})
    void successSendingNotification() {
        Assertions.assertDoesNotThrow(() -> scheduler.process());

        final Notification notification = notificationRepository.findById(1).get();
        Assertions.assertEquals(NotificationStatusEnum.PROCESSED.getDescription(), notification.getStatus());
    }

    @Test
    @Sql({"classpath:sql/cleanup_script.sql", "classpath:sql/error-sending-notification-test.sql"})
    void errorSendingNotification() {
        Assertions.assertDoesNotThrow(() -> scheduler.process());

        final Notification notification = notificationRepository.findById(2).get();
        Assertions.assertEquals(NotificationStatusEnum.ERROR.getDescription(), notification.getStatus());
    }
}
