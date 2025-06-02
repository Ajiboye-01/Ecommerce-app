# 🛒 E-Commerce Microservices Application

## 📝 Overview

This is a modern e-commerce platform built using a **microservices architecture**. The system is designed for **scalability**, **reliability**, and **maintainability**, leveraging cutting-edge technologies across the stack.

---

## 🏗️ Architecture

The application follows a distributed microservices pattern:

- **Frontend**: React-based single-page application
- **API Gateway**: Spring Cloud Gateway
- **Core Services**: Independently deployable backend services
- **Infrastructure**: Containerized using Docker, orchestrated for deployment

---

## 🛠️ Technology Stack

### 🔧 Backend Services

- **Language**: Java 17 (Spring Boot 3.x) {upgraded to java 23 due to ide not supportting the core features such as auto completion}
- **Service Discovery**: Spring Cloud Netflix Eureka
- **API Gateway**: Spring Cloud Gateway
- **Configuration Management**: Spring Cloud Config Server
- **Build Tool**: Maven

### 🗃️ Data Layer

- **Relational Database**: PostgreSQL (orders, products, payment)
- **NoSQL Database**: MongoDB (users)
- **Caching**: Redis (optional)

### 🔄 Event Streaming

- **Message Broker**: Apache Kafka
- **Event Sourcing**: Used for asynchronous order processing

### 📈 Monitoring & Observability

- **Distributed Tracing**: OpenZipkin
- **Metrics**: Prometheus + Grafana
- **Error Tracking**: Sentry

### 💻 Frontend

- **Framework**: React 18
- **State Management**: Redux Toolkit
- **Styling**: Tailwind CSS, CSS Modules

### ⚙️ Development & Deployment

- **Containerization**: Docker
- **Local Email Testing**: MailDev
- **CI/CD**: GitHub Actions (sample workflow files included)

---

## 🚀 Getting Started

### ✅ Prerequisites

- Java 23 JDK
- Docker & Docker Compose
- Node.js 16+
- Maven 3.8+
- Kafka (bundled with Docker Compose)

### 📦 Installation

1. **Clone the repository**

```bash
git clone https://github.com/your-repo/ecommerce-microservices.git
cd ecommerce-microservices
