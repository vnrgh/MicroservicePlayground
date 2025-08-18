package com.vnrgh.clients.notification;

public record NotificationRequest(
        Integer toCustomerId,
        String toCustomerName,
        String toCustomerEmail,
        String message) {}