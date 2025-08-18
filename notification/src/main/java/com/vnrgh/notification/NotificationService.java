package com.vnrgh.notification;

import com.vnrgh.clients.notification.NotificationRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class NotificationService {
    private final NotificationRepository repository;

    public void send(NotificationRequest request) {
        repository.save(
                Notification.builder()
                        .toCustomerId(request.toCustomerId())
                        .toCustomerEmail(request.toCustomerEmail())
                        .sender("VNRGH")
                        .message(request.message())
                        .sendAt(LocalDateTime.now())
                        .build()
        );
    }
}
