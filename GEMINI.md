# Gemini Project Context

This file provides context for the DnDPlanner project to the Gemini CLI.

## Project Overview

DnDPlanner is a web application designed to help tabletop role-playing game (RPG) players create, browse, and join game sessions. It consists of a Java Spring Boot backend and a React frontend.

### Key Technologies

*   **Backend**: Java 24, Spring Boot, Maven, JPA/Hibernate, H2 (for development), PostgreSQL (for production), Flyway for database migrations.
*   **Frontend**: React, Vite, JavaScript, CSS.
*   **DevOps**: Docker, Docker Compose.

## Project Structure

*   `api/`: Contains the Java Spring Boot backend application.
    *   `api/pom.xml`: Maven build file for the backend.
    *   `api/src/main/java/se/karl/`: Main source code for the backend.
        *   `App.java`: Main application entry point.
        *   `plan/`: Feature module for managing plans.
            *   `PlanController.java`: REST controller for plan-related operations.
            *   `PlanService.java`: Business logic for plans.
            *   `PlanRepository.java`: Data access layer for plans.
            *   `PlanEntity.java`: JPA entity for plans.
    *   `api/src/main/resources/`: Configuration and database migration scripts.
        *   `application.properties`: Spring Boot configuration.
        *   `V1__Init_Setup.sql`: Initial database schema setup with Flyway.
*   `ui/`: Contains the React frontend application.
    *   `ui/package.json`: NPM package file for the frontend, containing dependencies and scripts.
    *   `ui/src/`: Main source code for the frontend.
        *   `main.jsx`: Entry point for the React application.
        *   `App.jsx`: Root component of the application.
*   `docker-compose.yml`: Docker Compose file for running the application stack.
*   `README.md`: Detailed project documentation.

## How to Run

### Backend

From the root directory:

```bash
# Run in development mode
mvn -f api spring-boot:run

# Build and run the JAR
mvn -f api clean package
java -jar api/target/dndplanner-1.0-SNAPSHOT.jar
```

### Frontend

From the `ui` directory:

```bash
# Install dependencies
npm install

# Run in development mode
npm run dev
```

### Docker Compose

From the root directory:

```bash
docker-compose up --build
```

## API Endpoints

The primary API endpoint is `/plans`, managed by `PlanController`.

*   `POST /plans`: Create a new game session plan.
*   `GET /plans/{id}`: Retrieve a plan by its ID.

## Development Notes

*   The backend uses an in-memory H2 database for development, but it's configured to use PostgreSQL.
*   The frontend is built with Vite, and the development server runs on `http://localhost:5173` by default.
*   API models are located in `api/src/main/java/se/karl/plan/controller/model`.
*   The `PlanRequest` object expects `name`, `description`, `time` (ISO-8601 format), and `location`.
