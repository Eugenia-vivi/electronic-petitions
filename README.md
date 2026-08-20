# Electronic Petitions Platform

A full-stack web application designed for creating, browsing, and supporting community-driven petitions. Built with Java and the Spring Boot framework, the application utilizes Thymeleaf for server-side rendering, Spring Data JPA for persistence, and an in-memory H2 database. The user interface implements a responsive Neo-Brutalist design system.

---

## Features

- **Petition Catalog:** View all registered public petitions with real-time signature counters.
- **Petition Submission:** Create new community initiatives via a validated submission form.
- **Signature Collection:** Support active petitions with full name and email verification.
- **Detailed View:** Access the comprehensive description and current progress of individual initiatives.
- **Responsive UI:** Custom-built layout styled with Neo-Brutalist visual principles, accessible across mobile and desktop devices.

---

## Tech Stack

- **Backend:** Java 17+, Spring Boot, Spring Data JPA, Hibernate, Apache Tomcat
- **Frontend:** Thymeleaf, HTML5, CSS3
- **Database:** H2 Database Engine (In-Memory)
- **Build Automation:** Apache Maven

---

## Architecture and Project Structure

The project follows the standard Model-View-Controller (MVC) architectural pattern:
```text
petition-app/
├── src/
│   ├── main/
│   │   ├── java/com/petitions/
│   │   │   ├── controller/
│   │   │   ├── model/
│   │   │   ├── repository/
│   │   │   ├── service/
│   │   │   └── PetitionApplication.java
│   │   └── resources/
│   │       ├── static/
│   │       ├── templates/
│   │       └── application.properties
├── pom.xml
└── README.md
```
---

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 17 or higher
- Git

### Installation and Execution

1. Clone the repository:
   git clone https://github.com/vinedyss/petition-app.git
   cd petition-app

2. Build and run the application using the Maven Wrapper:
   - macOS / Linux:
     ./mvnw spring-boot:run
   - Windows:
     .\mvnw.cmd spring-boot:run

3. Access the web interface:
   http://localhost:8080/petitions

---

## Author

- **vinedyss** — Architecture, backend implementation, and UI design
