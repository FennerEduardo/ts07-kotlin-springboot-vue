package com.example.transactionalsystemkotlinvue.application.cqrs;

import java.util.UUID;

/**
 * Domain Events for OrquestacionDeSagaConCorrutinasEnKotlinSpringBoot.
 */
public record OrquestacionDeSagaConCorrutinasEnKotlinSpringBootCreatedEvent(UUID orquestacionDeSagaConCorrutinasEnKotlinSpringBootId, UUID tenantId) {}
