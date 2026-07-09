# 🍽️ ABRMS - Akshaya Bhavan Restaurant Management System

## 👨‍💻 Author

**Balaji V.S.**

**Senior Java Solutions Architect & Full-Stack Engineering Lead**

---

# 📌 Project Overview

ABRMS (Akshaya Bhavan Restaurant Management System) is a production-oriented enterprise Spring Boot Microservices project developed using a Gradle Multi-Module architecture. The project demonstrates how modern distributed systems are built using Spring Cloud components, service discovery, API gateway, synchronous and asynchronous communication, and enterprise design patterns.

This project has been designed to provide hands-on implementation of real-world microservices architecture following industry best practices.

---

# 🎯 Project Objectives

* Build Enterprise Microservices using Spring Boot
* Implement Gradle Multi-Module Architecture
* Configure Service Discovery
* Build an API Gateway
* Enable Inter-Service Communication
* Implement Fault Tolerance
* Build Event-Driven Communication
* Generate Interactive API Documentation
* Follow Enterprise Layered Architecture

---

# 🏗️ Project Architecture

```text
                        Client
                           │
                           ▼
                     API Gateway
                           │
             ┌─────────────┴─────────────┐
             ▼                           ▼
      User Service              Restaurant Service
             │
             ▼
           MySQL
             │
             ▼
      Kafka Producer
             │
             ▼
      user-events Topic
             │
             ▼
      Kafka Consumer
```
## SCREEN SHOTS - All in One MicroService / Spring Cloud 
---
### MODULE 1 : EUREKA SERVER
<img width="1920" height="1080" alt="image" src="https://github.com/user-attachments/assets/b35ee6cb-d660-410d-923a-7a16b75cb22a" />

### MODULE 2 : API Gateway - Load Balancing / 2 Different MicroService masked by 8080 [UserService:8081 and RestaturantService:8082]
<img width="1920" height="1080" alt="image" src="https://github.com/user-attachments/assets/708f742f-067c-476b-9625-1cd497ce0a7c" />

### MODULE 3 : OpenFeign : MicroService to MicroService Communication
<img width="1920" height="1080" alt="image" src="https://github.com/user-attachments/assets/812e19eb-5852-4d80-ae5c-f35ea54b2354" />

### MODULE 4 : Resilience4j : Circuit-Breaker to call Callback methods if Microservice goes abnormal or Network fails.
<img width="1920" height="1080" alt="image" src="https://github.com/user-attachments/assets/3f02401d-e68e-429d-b024-7e4fc2737bad" />

### MODULE 5 : Kafka : Message Broker Event Creator / Producer / Topics-EventHolder / Consumer
<img width="904" height="510" alt="image" src="https://github.com/user-attachments/assets/a1a4b7e6-8057-4f0f-8d49-a5628f58d97c" />

### MODULE 6 : Swagger  
<img width="1920" height="1080" alt="image" src="https://github.com/user-attachments/assets/e79c0a26-da00-470a-b292-d0e37465fb53" />
---

# 📂 Gradle Multi-Module Structure

```
ABRMS
│
├── abrms-eureka-server
├── abrms-api-gateway
├── abrms-user-service
└── abrms-restaurant-service
```

---

# 🚀 Technologies Used

| Technology               | Description                                 |
| ------------------------ | ------------------------------------------- |
| Java 21                  | Modern Long-Term Support (LTS) Java version |
| Spring Boot 3            | Enterprise Application Framework            |
| Spring Data JPA          | Data Access Layer                           |
| Hibernate                | Object Relational Mapping (ORM)             |
| MySQL                    | Relational Database                         |
| Jakarta Bean Validation  | Request Validation                          |
| Lombok                   | Boilerplate Code Reduction                  |
| MapStruct                | DTO and Entity Mapping                      |
| Gradle                   | Build Automation Tool                       |
| Spring Cloud             | Microservices Framework                     |
| Netflix Eureka           | Service Discovery                           |
| Spring Cloud Gateway MVC | API Gateway                                 |
| OpenFeign                | Inter-Service REST Communication            |
| Resilience4J             | Circuit Breaker                             |
| Apache Kafka             | Event Streaming Platform                    |
| Spring Kafka             | Kafka Integration                           |
| Swagger / OpenAPI        | REST API Documentation                      |

---

# 📦 Modules

## 1. Eureka Server

### Responsibilities

* Service Registration
* Service Discovery
* Health Monitoring

### Dependencies

* Spring Boot
* Spring Cloud Netflix Eureka Server

---

## 2. API Gateway

### Responsibilities

* Centralized API Routing
* Request Forwarding
* Load Balancing
* Single Entry Point

### Dependencies

* Spring Boot
* Spring Cloud Gateway MVC
* Eureka Client

---

## 3. User Service

### Responsibilities

* User CRUD Operations
* REST API Development
* OpenFeign Client
* Circuit Breaker Integration
* Kafka Producer
* Kafka Consumer
* Swagger Documentation

### Dependencies

* Spring Boot Starter Web
* Spring Boot Starter Data JPA
* Spring Boot Starter Validation
* MySQL Connector
* Lombok
* MapStruct
* Eureka Client
* OpenFeign
* Resilience4J
* Spring Kafka
* Swagger OpenAPI

---

## 4. Restaurant Service

### Responsibilities

* Food CRUD Operations
* REST API Development
* OpenFeign Support
* Swagger Documentation

### Dependencies

* Spring Boot Starter Web
* Spring Boot Starter Data JPA
* Spring Boot Starter Validation
* MySQL Connector
* Lombok
* MapStruct
* Eureka Client
* Swagger OpenAPI

---

# ⚙️ Enterprise Features Implemented

* Gradle Multi-Module Architecture
* Layered Architecture
* RESTful API Design
* DTO Pattern
* Repository Pattern
* Service Layer Pattern
* Dependency Injection
* Bean Validation
* Entity Mapping using MapStruct
* Service Discovery using Eureka
* API Gateway
* OpenFeign Client
* Circuit Breaker using Resilience4J
* Event-Driven Architecture
* Kafka Producer
* Kafka Consumer
* JSON Event Serialization
* Swagger / OpenAPI Documentation

---

# 📡 Event-Driven Architecture

The User Service publishes business events whenever a new user is created.

### Flow

```
User Created
      │
      ▼
Kafka Producer
      │
      ▼
user-events Topic
      │
      ▼
Kafka Consumer
```

---

# 🔄 Application Flow

1. Client sends a request to the API Gateway.
2. API Gateway routes the request to the appropriate microservice.
3. User Service processes the request.
4. User information is stored in MySQL.
5. User Service publishes a **UserCreatedEvent** to Kafka.
6. Kafka Broker stores the event in the **user-events** topic.
7. Kafka Consumer receives and processes the event asynchronously.

---

# 📁 Package Structure

```
com.app.user
│
├── config
├── controller
├── service
├── repository
├── entity
├── dto
├── mapper
├── kafka
│   ├── producer
│   └── consumer
├── event
├── exception
└── util
```

---

# 📖 API Documentation

Swagger UI is enabled for REST API testing.

```
http://localhost:<service-port>/swagger-ui/index.html
```

Example:

```
http://localhost:8081/swagger-ui/index.html
```

---

# 🛠️ Development Tools

* IntelliJ IDEA
* Gradle
* Postman
* MySQL Workbench
* Apache Kafka
* Git
* GitHub

---

# 📚 Design Patterns & Concepts Covered

* Microservices Architecture
* Gradle Multi-Module Architecture
* Layered Architecture
* Repository Pattern
* DTO Pattern
* Dependency Injection
* API Gateway Pattern
* Service Discovery Pattern
* Circuit Breaker Pattern
* Event-Driven Architecture
* Asynchronous Messaging

---

# 🎓 Learning Outcomes

This project demonstrates practical implementation of:

* Enterprise Spring Boot Development
* Gradle Multi-Module Architecture
* Spring Cloud Microservices
* Eureka Service Discovery
* API Gateway
* OpenFeign Communication
* Resilience4J Circuit Breaker
* Apache Kafka Integration
* Event-Driven Architecture
* RESTful API Development
* Swagger/OpenAPI Documentation
* DTO and Entity Mapping
* Enterprise Project Structure

---

# ⭐ Project Status

* ✅ Gradle Multi-Module Architecture
* ✅ Spring Boot
* ✅ Spring Data JPA
* ✅ Hibernate
* ✅ MySQL
* ✅ Eureka Server
* ✅ API Gateway
* ✅ OpenFeign
* ✅ Resilience4J
* ✅ Apache Kafka
* ✅ Event-Driven Architecture
* ✅ Swagger / OpenAPI Documentation
