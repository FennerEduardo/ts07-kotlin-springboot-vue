# 🚀 AI AGENT MASTER IMPLEMENTATION PROMPT
## Feature: Orquestación de Saga con Corrutinas en Kotlin Spring Boot (Spec Hash: 3900f0e4)
## Architecture: MONOLITH | Stack: KOTLIN (spring-boot)
## Prompt Version / Audit Hash: prt_62e6f57f
## Author / Developer: Fenner Eduardo González C. <fennereduardo@gmail.com> (source: git)

### 📌 Context Files to Read & Follow:
- @.ghkgovernance.yaml
- @features/kotlin_saga_coroutines.feature
- @generated-specs/ADR-001-architecture-decisions.md
- @generated-specs/openapi.json
- @generated-specs/docker-compose.yml

### 🛠️ Technical Guardrails & Stack Specifications:
- **Language**: kotlin (spring-boot)
- **Persistence**: kotlin-orm + mysql
- **Validation**: kotlin-val
- **Testing Framework**: kotlin-test

### 🐳 Docker Execution Sandbox & Host Isolation Guardrails:
> **IMPORTANT**: If your host operating system lacks the native runtime SDK (KOTLIN), DO NOT install heavy packages directly on the host machine.
> Execute all compilation, migrations, and test runs inside the isolated Docker container:
> 
> ```bash
> # Start database and infrastructure services
> docker compose up -d
> 
> # Execute test suite inside Docker sandbox container:
> docker compose run --rm app npm test
> ```

### 🎯 Mandatory Step-by-Step Implementation Flow:

#### Phase 1: Pure Domain Layer
1. Read the feature specification in `features/kotlin_saga_coroutines.feature` and contract in `contracts.ts`.
2. Implement pure domain Entities, Value Objects, and Domain Events.
3. Ensure zero dependencies on external frameworks or database drivers in the domain core.

#### Phase 2: Application Use Cases & Infrastructure
1. Implement the Repository Port interface using KOTLIN-ORM (mysql).
2. Implement Controllers/Handlers to process HTTP requests and return appropriate status codes (e.g. 201 Created, 400 Bad Request).
3. Apply validation using kotlin-val.

#### Phase 3: Automated Unit & Feature Testing
1. Implement automated test cases in KOTLIN-TEST matching all scenarios in `features/kotlin_saga_coroutines.feature`.
2. Assert HTTP response status codes, payload structures, and event emissions.
3. If host environment lacks SDK, run verification inside Docker sandbox (`docker compose run --rm app npm test`).
4. Ensure 100% scenario pass rate.
