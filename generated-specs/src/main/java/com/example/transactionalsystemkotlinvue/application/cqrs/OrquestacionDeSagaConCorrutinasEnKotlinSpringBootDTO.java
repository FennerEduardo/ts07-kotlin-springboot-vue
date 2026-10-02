package com.example.transactionalsystemkotlinvue.application.cqrs;

import java.util.UUID;

/**
 * Data Transfer Object for OrquestacionDeSagaConCorrutinasEnKotlinSpringBoot read model.
 */
public record OrquestacionDeSagaConCorrutinasEnKotlinSpringBootDTO(UUID orquestacionDeSagaConCorrutinasEnKotlinSpringBootId, String status, java.util.Map<String, Object> data) {}
