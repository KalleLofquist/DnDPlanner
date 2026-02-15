# DnDPlanner

A lightweight web service and React frontend to help tabletop role‑playing players create, browse and join game sessions.

This repository contains two main parts:

- Backend: a Java Spring Boot REST API in [api/pom.xml](api/pom.xml).
- Frontend: a React + Vite client in `ui/`.

Why this project
 - Kickstart for building a session-finding service for RPG players.
 - Small, focused codebase ideal for experimentation: add profiles, scheduling, chat, auth.

Features (current)
 - Create a game session (POST /plans)
 - Fetch a session by id (GET /plans/{id})

Tech stack
 - Java 21, Spring Boot, Maven
 - React + Vite for the frontend
 - H2 used for simple local persistence during development

Quick links
 - Backend entrypoint: [api/src/main/java/se/karl/appconfig/App.java](api/src/main/java/se/karl/appconfig/App.java)
 - Main controller: [api/src/main/java/se/karl/plan/controller/PlanController.java](api/src/main/java/se/karl/plan/controller/PlanController.java)
 - Frontend: `ui/`
 - Docker compose: [docker-compose.yml](docker-compose.yml)

Prerequisites
 - JDK 21 installed and on PATH
 - Maven 3.8+ (for the backend)
 - Node 18+ and npm/yarn/pnpm (for the frontend)
 - Docker (optional, if you prefer containers)

Quick Start — development (PowerShell)

1) Start the backend (dev)

```powershell
# From repo root: run via Maven (dev)
mvn -f .\api spring-boot:run

# Or build and run the jar
mvn -f .\api clean package
java --enable-preview -jar .\api\target\dndplanner-1.0-SNAPSHOT.jar
```

2) Start the frontend

```powershell
cd .\ui
npm install
npm run dev
```

Vite usually serves the client at http://localhost:5173. If the frontend and backend are on different ports, configure the client to point to the API base URL.

Run everything with Docker Compose

```powershell
# Build and start backend + frontend containers defined in docker-compose.yml
docker-compose up --build
```

API — quick examples

This project exposes a small Plans API implemented by `PlanController`.

- POST /plans — create a plan
- GET /plans/{id} — fetch a plan by id

Example: create a plan (JSON payload uses ISO-8601 datetime)

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

Example: get a plan

```bash
curl http://localhost:8080/plans/1
```

Response shape (example)

```json
{
	"id": 1,
	"name": "Evening Adventure",
	"description": "Level 3 heroes, short session",
	"time": "2026-02-15T19:00:00",
	"location": "Online (Discord)"
}
```

Build & test
 - Backend: `mvn -f api clean package` and `mvn -f api test`
 - Frontend: `cd ui && npm run build`

Development notes
 - The API models are in [api/src/main/java/se/karl/plan/controller/model](api/src/main/java/se/karl/plan/controller/model)
 - `PlanRequest` expects `name`, `description`, `time` (ISO‑8601) and `location`.
 - Use H2 for fast local iterations; swap to a production DB for deployments.

Contributing
 - Open issues, branch from `main`, add tests, and submit PRs.
 - Keep changes focused and include a descriptive PR message.

Where to look in the code
 - Controller: [api/src/main/java/se/karl/plan/controller/PlanController.java](api/src/main/java/se/karl/plan/controller/PlanController.java)
 - DTOs / requests: [api/src/main/java/se/karl/plan/controller/model/PlanDTO.java](api/src/main/java/se/karl/plan/controller/model/PlanDTO.java) and [api/src/main/java/se/karl/plan/controller/model/PlanRequest.java](api/src/main/java/se/karl/plan/controller/model/PlanRequest.java)

License
 - No license file included. Add a `LICENSE` (for example MIT) to clarify reuse terms.

Next steps I can help with
 - Add a minimal health endpoint and README badge
 - Add a simple Postman/Insomnia collection for the API
 - Wire the frontend to the running backend and demo a round-trip

If you'd like one of those, tell me which and I'll implement it.
