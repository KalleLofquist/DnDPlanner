# DnDPlanner

A small web service and frontend to help tabletop role-playing players find others and join up for adventures.

This repository contains two main parts:

- `api/` — Java Spring Boot backend (REST API). Built with Maven and targets Java 21.
- `ui/` — React + Vite frontend (client) for interacting with the service.

## What it does

DnDPlanner aims to make it easy for players to post, search and join game sessions. The current codebase contains the minimal backend and a React front-end starter. Use this project as a foundation for adding features like user profiles, game listings, chat and scheduling.

Key ideas:

- Allow hosts to create adventure sessions and list needed player roles.
- Let players browse and join sessions near their interests.
- Provide a lightweight REST API consumed by the React frontend.

## Tech stack

- Backend: Spring Boot (spring-boot-starter-web), H2 for embedded data during development. Java 21.
- Build: Maven
- Frontend: React 19 + Vite

## Quick project map

- `api/src/main/java/se/karl/appconfig/App.java` — Spring Boot entry point.
- `api/src/main/java/se/karl/controller/PlanController.java` — Example controller (exposes `/hello`).
- `api/pom.xml` — Maven configuration (Java 21, Spring Boot parent).
- `ui/` — React client (Vite + npm).

## Prerequisites

- JDK 21 installed and available on PATH (recommended). The backend is compiled for Java 21 and the pom uses `--enable-preview` for compilation; running may require `--enable-preview` depending on features used.
- Maven 3.8+ for building the Java backend.
- Node 18+ and npm (or pnpm/yarn) for the frontend.

## Running the application (development)

Open two terminals (backend and frontend). The examples below are PowerShell-friendly.


1) Start the backend

PowerShell:

```powershell
# Run directly using the Spring Boot Maven plugin
mvn -f .\api spring-boot:run

# Or: build and run the produced jar (if you need to run the packaged artifact)
mvn -f .\api clean package
java --enable-preview -jar .\api\target\dndplanner-1.0-SNAPSHOT.jar
```

By default the backend runs on port 8080. A quick API check:

```powershell
# Example: call the sample endpoint
Invoke-RestMethod -Uri http://localhost:8080/hello
```

2) Start the frontend

```powershell
cd .\ui
npm install
npm run dev
```

Vite will run a dev server (typically on http://localhost:5173). The front-end expects the backend API at the server root — update the client code if you run the API on a different host or port.

## Build for production

Backend (package):

```powershell
mvn -f .\api clean package
```

Frontend (build static files):

```powershell
cd .\ui
npm run build
```

Serve the built frontend with any static host and point it to the backend API.

## Tests

Run backend tests with Maven:

```powershell
mvn -f .\api test
```

Add frontend tests as you add components and logic.

## API examples

This repository includes a tiny example controller exposing `/hello` that returns a JSON-like string for quick verification. Expand controllers under `se.karl.controller` to add real endpoints for sessions, users and joins.

Example (PowerShell):

```powershell
Invoke-RestMethod -Uri http://localhost:8080/hello
# Expected response: "Hello World!"
```

## Development tips

- Run backend and frontend concurrently in two terminals while developing.
- Keep API contract stable (document endpoints) — update the frontend when you change routes or payloads.
- Use H2 for quick local data but switch to a proper DB for production.

## Contribution

Contributions are welcome. Small suggestions:

1. Open an issue describing the feature or bug.
2. Create a feature branch, add tests, and open a pull request.

Please include short, focused commits and a descriptive PR message.

## License

This project does not include a license file yet. Add a license to clarify reuse terms (e.g., MIT) if you want others to reuse the code.
