package com.vnrgh.notification;

import com.vnrgh.clients.notification.NotificationRequest;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/notification")
@AllArgsConstructor
public class NotificationController {
    private final NotificationService notificationService;

    @PostMapping
    public void setNotification(@RequestBody NotificationRequest request) {
        notificationService.send(request);
    }
}
