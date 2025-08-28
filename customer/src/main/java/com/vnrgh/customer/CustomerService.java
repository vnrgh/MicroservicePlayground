package com.vnrgh.customer;

import com.vnrgh.clients.fraud.FraudCheckResponse;
import com.vnrgh.clients.fraud.FraudClient;
import com.vnrgh.clients.notification.NotificationRequest;
import com.vnrgh.customer.kafka.KafkaMessageProducer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerService {
    private final CustomerRepository repository;
    private final KafkaMessageProducer kafkaMessageProducer;
    private final FraudClient fraudClient;

    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();
        repository.saveAndFlush(customer);

        FraudCheckResponse fraudCheckResponse = fraudClient.isFraudster(customer.getId());

        if (fraudCheckResponse.isFraudster()) {
            throw new IllegalStateException("fraudster");
        }

        NotificationRequest notificationRequest = new NotificationRequest(
                customer.getId(),
                customer.getFirstName(),
                customer.getEmail(),
                String.format("Hi %s, welcome to OrderService Project!",
                        customer.getFirstName()));

        kafkaMessageProducer.sendNotification(notificationRequest);
    }
}
