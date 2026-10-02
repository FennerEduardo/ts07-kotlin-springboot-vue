package com.example.transactionalsystemkotlinvue.application.sagas;

import java.util.UUID;

/**
 * Saga Contract for OrquestacionDeSagaConCorrutinasEnKotlinSpringBoot domain process.
 * Contains all events and commands involved in the saga orchestration.
 */
public class OrquestacionDeSagaConCorrutinasEnKotlinSpringBootSagaContract {

    // === Events ===
    public record OrquestacionDeSagaConCorrutinasEnKotlinSpringBootInitiatedEvent(UUID correlationId, UUID orquestacionDeSagaConCorrutinasEnKotlinSpringBootId, java.util.Map<String, Object> metadata) {}
    public record OrquestacionDeSagaConCorrutinasEnKotlinSpringBootAuthorizedEvent(UUID correlationId) {}
    public record OrquestacionDeSagaConCorrutinasEnKotlinSpringBootCompletedEvent(UUID correlationId) {}
    public record OrquestacionDeSagaConCorrutinasEnKotlinSpringBootFailedEvent(UUID correlationId, String reason) {}

    // === Commands ===
    public record AuthorizeOrquestacionDeSagaConCorrutinasEnKotlinSpringBootCommand(UUID orquestacionDeSagaConCorrutinasEnKotlinSpringBootId, java.util.Map<String, Object> metadata) {}
    public record CompleteOrquestacionDeSagaConCorrutinasEnKotlinSpringBootCommand(UUID orquestacionDeSagaConCorrutinasEnKotlinSpringBootId) {}
    public record CompensateOrquestacionDeSagaConCorrutinasEnKotlinSpringBootCommand(UUID orquestacionDeSagaConCorrutinasEnKotlinSpringBootId, String reason) {}
}
