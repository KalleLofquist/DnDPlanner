# DnDPlanner

DnDPlanner is a web application designed to help tabletop role-playing game (RPG) players create, browse, and join game sessions. It consists of a Java Spring Boot backend and a React frontend.

## Why this project

- Kickstart for building a session-finding service for RPG players.
- Small, focused codebase ideal for experimentation: add profiles, scheduling, chat, auth.

## Features

- Create a game session (`POST /plans`)
- Fetch a session by id (`GET /plans/{id}`)

## Key Technologies

*   **Backend**: Java 24, Spring Boot, Maven, JPA/Hibernate, H2 (for development), PostgreSQL (for production), Flyway for database migrations.
*   **Frontend**: React, Vite, JavaScript, CSS.
*   **DevOps**: Docker, Docker Compose.

## Project Structure

*   `api/`: Contains the Java Spring Boot backend application.
*   `ui/`: Contains the React frontend application.
*   `docker-compose.yml`: Docker Compose file for running the application stack.

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

The primary API endpoints are managed by `PlanController`.

*   `POST /plans`: Create a new game session plan.
*   `GET /plans`: Retrieve all plans.
*   `GET /plans/{id}`: Retrieve a plan by its ID.
*   `DELETE /plans/{id}`: Delete a plan by its ID.

### Examples

Create a plan:
```bash
curl -X POST http://localhost:8080/plans \
	-H "Content-Type: application/json" \
	-d '{
		"name":"Evening Adventure",
		"description":"Level 3 heroes, short session",
		"time":"2026-02-15T19:00:00",
		"location":"Online (Discord)"
	}'
```

Get a plan:
```bash
curl http://localhost:8080/plans/1
```

Response:
```json
{
	"id": 1,
	"name": "Evening Adventure",
	"description": "Level 3 heroes, short session",
	"time": "2026-02-15T19:00:00",
	"location": "Online (Discord)"
}
```
