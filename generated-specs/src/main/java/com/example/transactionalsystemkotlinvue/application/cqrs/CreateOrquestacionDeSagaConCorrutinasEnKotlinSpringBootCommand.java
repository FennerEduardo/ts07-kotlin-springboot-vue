package com.example.transactionalsystemkotlinvue.application.cqrs;

import java.util.UUID;

/**
 * CQRS Commands for OrquestacionDeSagaConCorrutinasEnKotlinSpringBoot domain.
 * Commands are immutable records (Java 21) that represent intent.
 */
public record CreateOrquestacionDeSagaConCorrutinasEnKotlinSpringBootCommand(UUID tenantId, java.util.Map<String, Object> payload) {}
