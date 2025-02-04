package com.example.desafiobackenditarc.repository;

import com.example.desafiobackenditarc.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface NotificationRepository extends JpaRepository<Notification, Integer> {

    @Query(value = "SELECT * " +
            "FROM notifications n " +
            "WHERE n.notification_date <= now() " +
            "AND n.status = 'PENDING' " +
            "ORDER BY n.notification_date ASC " +
            "LIMIT 10", nativeQuery = true)
    public List<Notification> getScheduledNotificationsToBeSent();
}
