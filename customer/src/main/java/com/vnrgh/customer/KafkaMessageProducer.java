package com.vnrgh.customer;

import com.vnrgh.clients.notification.NotificationRequest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaMessageProducer {

    private final KafkaTemplate<String, NotificationRequest> kafkaTemplate;

    public KafkaMessageProducer(KafkaTemplate<String, NotificationRequest> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendNotification(NotificationRequest notificationRequest) {
        kafkaTemplate.send("notification-topic", notificationRequest);
    }
}

