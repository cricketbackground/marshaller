# Spring Boot App

This is a Spring Boot application that provides two endpoints for testing. 

## Prerequisites

This app requires:

- Java 17
- Spring Boot 3.0.6
- Spring Cloud 2022.0.2

## Endpoints

The following endpoints are available:

- `http://localhost:8383/marshaller/mvc`
- `http://localhost:8383/marshaller/message`

## How to Use

After starting the application, you can import the following curl commands into postman to test the endpoints.

### Testing the `/mvc` endpoint

```sh
curl --location 'http://localhost:8383/marshaller/mvc' \
--header 'Content-Type: application/json' \
--data '{
    "numbers": "6469344427; 2017586291"
}'
```

### Testing the `/message` endpoint

```sh
curl --location 'http://localhost:8383/marshaller/message' \
--header 'Content-Type: application/json' \
--data '{
    "numbers": "6469344427; 2017586291"
}'
```

## Set the kafka servers

In `application.yml` set the kafka servers

```yaml
spring.cloud.stream.kafka.binder.brokers: ${secret.binder.brokers}
spring.cloud.stream.kafka.binder.zkNodes: ${secret.zk.nodes}
```
