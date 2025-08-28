package com.vnrgh.notification.kafka;

import com.vnrgh.clients.notification.NotificationRequest;
import com.vnrgh.notification.NotificationService;
import lombok.AllArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class NotificationConsumer {
    private final NotificationService notificationService;

    @KafkaListener(
            topics = "notification-topic",
            groupId = "notification-group")
    void consume(NotificationRequest request) {
        notificationService.send(request);
    }
}
