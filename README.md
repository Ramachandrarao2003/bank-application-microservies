# Banking Application using Spring Boot Microservices

## Overview

The Banking Application is a production-style microservices-based backend system developed using Spring Boot and Spring Cloud. The application enables secure user authentication, bank account management, fund transfers, transaction tracking, email notifications, and administrative operations.

The system follows modern microservices architecture principles including Service Discovery, API Gateway, Event-Driven Communication, Fault Tolerance, Monitoring, and API Documentation.

## Architecture

Client
   |
   v
API Gateway
   |
---------------------------------------------------------
|            |              |            |              |
v            v              v            v              v
Auth     Account      Transaction   Notification    Admin
Service  Service      Service       Service         Service
   |
   v
Oracle Database

Supporting Components:
----------------------
Eureka Server
Kafka
Spring Boot Admin
Swagger/OpenAPI
Resilience4j

## Microservices

### 1. Auth Service

Responsibilities:

* User Registration
* User Login
* JWT Token Generation
* Role Management
* User Information APIs

Features:

* Spring Security
* JWT Authentication
* BCrypt Password Encryption
* User Management

Endpoints:

POST /auth/register
POST /auth/login
GET  /auth/users
GET  /auth/user/{id}
GET  /auth/email/{email}

### 2. Account Service

Responsibilities:

* Bank Account Creation
* Deposit Money
* Withdraw Money
* Account Status Management

Features:

* Account Number Generation
* Balance Management
* Account Validation

Endpoints:

POST /accounts
GET  /accounts/{accountNumber}
PUT  /accounts/deposit/{accountNumber}
PUT  /accounts/withdraw/{accountNumber}
GET  /accounts/all
PUT  /accounts/block/{accountNumber}
PUT  /accounts/activate/{accountNumber}
PUT  /accounts/close/{accountNumber}

### 3. Transaction Service

Responsibilities:

* Fund Transfer
* Transaction History
* Transfer Validation

Features:

* Feign Client Communication
* Transaction Tracking
* Kafka Event Publishing

Endpoints:

POST /transactions/transfer
GET  /transactions/{accountNumber}
GET  /transactions/all
GET  /transactions/{transactionId}

### 4. Notification Service

Responsibilities:

* Email Notifications
* Kafka Event Consumption

Features:

* Apache Kafka Consumer
* Spring Mail
* Transfer Success Notifications

Example Email:

Fund Transfer Success

Amount ₹1000 transferred successfully
from 123456789012 to 987654321098

### 5. Admin Service

Responsibilities:

* User Monitoring
* Account Monitoring
* Transaction Monitoring
* Dashboard Analytics

Features:

* Admin-Only Access
* System Statistics
* Account Control Operations

Endpoints:

GET /admin/users
GET /admin/accounts/all
GET /admin/transactions
GET /admin/dashboard

GET /admin/user/{userId}
GET /admin/account/{accountNumber}
GET /admin/transaction/{transactionId}

PUT /admin/block/{accountNumber}
PUT /admin/activate/{accountNumber}
PUT /admin/close/{accountNumber}

## Technology Stack

### Backend

* Java 17
* Spring Boot 3
* Spring Cloud

### Security

* Spring Security
* JWT Authentication
* BCrypt Password Encoder

### Communication

* OpenFeign
* Apache Kafka

### Service Discovery

* Eureka Server

### Gateway

* Spring Cloud Gateway

### Fault Tolerance

* Resilience4j Circuit Breaker

### Monitoring

* Spring Boot Actuator
* Spring Boot Admin

### API Documentation

* Swagger/OpenAPI

### Database

* Oracle Database

### Build Tool

* Maven

### Version Control

* Git
* GitHub

## Project Features

### Authentication

* Secure Login
* JWT Token Generation
* Role Based Access Control

### Account Management

* Create Account
* Deposit Funds
* Withdraw Funds
* Block Account
* Activate Account
* Close Account

### Fund Transfer

* Inter Account Transfer
* Balance Validation
* Transaction Recording

### Notifications

* Real-time Email Alerts
* Kafka Event Driven Messaging

### Monitoring

* Service Health Monitoring
* Application Metrics
* Dashboard Monitoring

### Fault Tolerance

* Circuit Breaker Support
* Service Failure Recovery

## Security

Implemented using:

* JWT Authentication
* Role-Based Access Control (RBAC)
* Spring Security
* Password Encryption

Roles:

ADMIN
CUSTOMER

## Kafka Flow

Transaction Service
       |
       v
Publish Notification Event
       |
       v
Kafka Topic
       |
       v
Notification Service
       |
       v
Email Sent

## Service Communication

Transaction Service
       |
       v
Account Service
       |
       v
Auth Service

Implemented using OpenFeign Clients.

## Swagger Documentation

Access Swagger UI:

http://localhost:9090/swagger-ui.html

Available APIs:

* Auth Service
* Account Service
* Transaction Service
* Admin Service

## Spring Boot Admin Dashboard

Access:

http://localhost:9099

Features:

* Service Monitoring
* Health Checks
* Metrics
* Environment Variables
* Logs

## Eureka Dashboard

Access:

http://localhost:8761

Features:

* Service Registration
* Service Discovery
* Instance Monitoring

## Future Enhancements

* Docker Containerization
* Kubernetes Deployment
* Redis Caching
* Distributed Tracing
* ELK Stack Logging
* CI/CD Pipeline using Jenkins
* Prometheus & Grafana Monitoring

## Resume Highlights

* Developed a Banking Application using Spring Boot Microservices Architecture.
* Implemented 30+ REST APIs for Authentication, Account Management, Fund Transfers, and Administration.
* Integrated Apache Kafka for asynchronous event-driven notifications.
* Implemented JWT Authentication and Role-Based Access Control (RBAC).
* Used Eureka Service Discovery, API Gateway, Resilience4j Circuit Breaker, Swagger/OpenAPI, and Spring Boot Admin.

## Author

P. Ramachandra Rao

Email: ramachandrarao24923@gmail.com

GitHub: https://github.com/Ramachandrarao2003
