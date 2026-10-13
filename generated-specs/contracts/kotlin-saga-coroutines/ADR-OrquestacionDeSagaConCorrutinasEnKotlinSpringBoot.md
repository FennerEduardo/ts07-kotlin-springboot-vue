# ADR 001: Architecture Decisions for Orquestación de Saga con Corrutinas en Kotlin Spring Boot

## Status
Accepted

## Context
Project requiring structured implementation matching Gherkin specification.

## Decisions
- **Architecture Style**: Monolith Architecture (MVC / Monolithic) (monolith)
- **Primary Backend Language**: kotlin
- **Backend Framework**: spring-boot (^10.3.0)
- **ORM / Persistence**: kotlin-orm (@prisma/client@^5.10.0)
- **Validation**: kotlin-val (zod@^3.22.4)
- **Authentication**: jwt-bcrypt (bcrypt cost factor 12, JWT TTL 3600s)
- **Backend Testing Framework**: kotlin-test (jest@^29.7.0, supertest@^6.3.4)
- **Frontend Framework**: vue
- **Frontend Language**: javascript
- **Frontend Bundler**: vite
- **Frontend Unit Testing**: vitest
- **Frontend E2E Testing**: cypress

## Prohibited Layer Dependencies
Domain core must NOT import:
- `direct SQL string interpolation`
- `global state mutation`
