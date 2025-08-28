# Project MicroservicePlayground

## Overview

This is a personal project designed to explore and learn microservices architecture using Spring Boot, Kafka, and PostgreSQL. The project simulates a basic order management system with multiple independent services communicating through REST APIs and Kafka messaging.

## Services

* **Customer Service**: Manages customer information.
* **Fraud Service**: Checks if a customer is a potential fraudster.
* **Notification Service**: Sends notifications to customers.
* **API Gateway**: Routes requests to appropriate services.
* **Eureka Server**: Service registry for service discovery.
* **Kafka**: Message broker for asynchronous communication.
* **PostgreSQL**: Database for persisting service data.
* **PgAdmin**: Web interface for managing PostgreSQL.
* **Zipkin**: Distributed tracing system for monitoring requests.

## Getting Started

### Prerequisites

* Docker & Docker Compose
* Java 21+
* Maven or Gradle
* IDE (IntelliJ IDEA, VS Code, etc.)

### Running with Docker Compose

1. Clone the repository.
2. Run `docker-compose up --build` to start all services.
3. Services will be available at the following ports:

    * Customer: 8080
    * Fraud: 8081
    * Notification: 8082
    * API Gateway: 8083
    * Eureka: 8761
    * PgAdmin: 5050
    * Zipkin: 9411

### Running Locally

1. Ensure you have PostgreSQL and Kafka running (either in Docker or locally).
2. Start the microservices from your IDE as Spring Applications.

To test the system, send a **POST** request to: [localhost:8083/api/v1/customers](localhost:8083/api/v1/customers) with a JSON body like:

```json
{
    "firstName": "First name",
    "lastName": "Last name",
    "email": "example@mail.com"
} 
```
This will create a new customer, trigger fraud check, and produce a Kafka notification (currently stored in the DB).

## Architecture

* Microservices communicate via REST and Kafka.
* Eureka Server enables dynamic service discovery.
* API Gateway handles request routing and load balancing.
* PostgreSQL stores persistent data for each service.
* Kafka ensures asynchronous messaging between services.
* Zipkin provides distributed tracing for monitoring inter-service calls.

## Technologies Used

* Java 21, Spring Boot 3.5.3, Spring Kafka, Spring Data JPA
* PostgreSQL, Apache Kafka, Docker, Docker Compose
* Eureka, Zipkin, PgAdmin

## Notes

* All services are dockerized for easy deployment.
* Kafka configuration uses KRaft mode with a single broker for development.
* JSON serialization is used for Kafka message communication.
* Database schema is auto-created on service startup for development purposes.

---

This project serves as a learning tool for understanding microservices, asynchronous messaging, and distributed system patterns.
