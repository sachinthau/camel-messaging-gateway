# 📨 Camel Messaging Gateway

A Spring Boot application using **Apache Camel** to route messages between HTTP, JMS (ActiveMQ), RabbitMQ, SFTP, and SMTP (MailHog). Ideal for messaging integration, protocol bridging, and lightweight service orchestration.

---

## 🚀 Features

- HTTP to RabbitMQ
- HTTP to JMS (ActiveMQ)
- JMS to RabbitMQ
- RabbitMQ to SMTP (MailHog)
- SFTP file to RabbitMQ

---

## 🛠 Tech Stack

| Tool/Tech         | Purpose                         |
|-------------------|---------------------------------|
| Spring Boot       | Application framework           |
| Apache Camel      | Integration routing engine      |
| RabbitMQ          | AMQP message broker             |
| ActiveMQ          | JMS message broker              |
| MailHog           | Dummy SMTP mail server          |
| Atmoz SFTP        | Lightweight SFTP server         |
| Maven             | Build & dependency management   |
| Docker Compose    | Container orchestration         |

---

## 📁 Project Structure

```
camel-messaging-gateway/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── sachintha/
│   │   │           └── camel/
│   │   │               └── camel_messaging_gateway/
│   │   │                   ├── CamelMessagingGatewayApplication.java
│   │   │                   └── route/
│   │   │                       ├── HttpToJmsRoute.java
│   │   │                       ├── HttpToRabbitRoute.java
│   │   │                       ├── JmsToRabbitRoute.java
│   │   │                       ├── RabbitToSmtpRoute.java
│   │   │                       └── SftpToRabbitRoute.java
│   │   └── resources/
│   │       ├── application.properties
│   │       └── logback-spring.xml (if any)
├── docker-compose.yml
├── pom.xml
└── README.md
```

--- 

## ⚙️ Setup Instructions

## 🐳 Docker Compose Setup

Ensure Docker is installed, then run:

1. Start RabbitMQ, ActiveMQ, Mailhog, and SFTP services:
```
docker-compose up -d
```

2. Visit:
   - RabbitMQ: http://localhost:15672 (guest/guest)
   - ActiveMQ: http://localhost:8161 (admin/admin)
   - Mailhog: http://localhost:8025

---

## 🛠️ Build & Run Instructions

1. Ensure Java 17 and Maven are installed.

2. To clean and build the project:
```
mvn clean install
```

3. To run the application:
```
mvn spring-boot:run

OR

java -jar target/camel-messaging-gateway-0.0.1-SNAPSHOT.jar
```

---

### Start Supporting Services

Use Docker Compose to bring up RabbitMQ, ActiveMQ, SFTP server, and MailHog.

Access:
- RabbitMQ UI: http://localhost:15672 (guest / guest)
- ActiveMQ UI: http://localhost:8161 (admin / admin)
- MailHog UI: http://localhost:8025

### Build the App

Use Maven to build the Spring Boot application.

### Run the App

Use `spring-boot:run` goal to start the application.

---

## 🌐 Available Endpoints & Routes

### ✅ HTTP to RabbitMQ

- **Endpoint:** `http://localhost:8085/api/send`
- **Function:** Forwards HTTP POST message to RabbitMQ (`email-exchange` with routing key `email-queue`)

### ✅ HTTP to JMS

- **Endpoint:** `http://localhost:8085/api/send-jms`
- **Function:** Forwards HTTP POST message to ActiveMQ queue `external-jms-queue`

### ✅ JMS to RabbitMQ

- **Source:** JMS queue `external-jms-queue`
- **Target:** RabbitMQ `email-exchange` with routing key `email-queue`

### ✅ RabbitMQ to SMTP

- **Source:** RabbitMQ `email-exchange` with routing key `email-queue`
- **Target:** MailHog SMTP (sends email to `test@example.com`)

### ✅ SFTP to RabbitMQ

- **Source:** Drop files into `sftp-upload` directory
- **Target:** File contents are forwarded to RabbitMQ (`email-exchange` with routing key `email-queue`)
- **Note:** Files are auto-deleted after processing

---

## 📌 Notes

- MailHog helps visualize the final email output from RabbitMQ.
- SFTP files are auto-deleted once processed.
- All routing logic is defined using Camel `RouteBuilder`.

---

## ✨ Author

**K.G. Sachintha Udara**