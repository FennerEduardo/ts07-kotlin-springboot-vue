package com.example.transactionalsystemkotlinvue.application.cqrs;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.UUID;

/**
 * Command Handler for CreateOrquestacionDeSagaConCorrutinasEnKotlinSpringBoot.
 * Follows CQRS: writes to the write model and publishes domain events.
 */
@Service
public class CreateOrquestacionDeSagaConCorrutinasEnKotlinSpringBootCommandHandler {
    private final ApplicationEventPublisher eventPublisher;

    public CreateOrquestacionDeSagaConCorrutinasEnKotlinSpringBootCommandHandler(ApplicationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    @Transactional
    public UUID handle(CreateOrquestacionDeSagaConCorrutinasEnKotlinSpringBootCommand command) {
        UUID orquestacionDeSagaConCorrutinasEnKotlinSpringBootId = UUID.randomUUID();

        // 1. Save to Write Model (Domain DB)
        // repository.save(new OrquestacionDeSagaConCorrutinasEnKotlinSpringBoot(orquestacionDeSagaConCorrutinasEnKotlinSpringBootId, command.tenantId(), command.payload()));

        // 2. Publish Domain Event
        eventPublisher.publishEvent(new OrquestacionDeSagaConCorrutinasEnKotlinSpringBootCreatedEvent(orquestacionDeSagaConCorrutinasEnKotlinSpringBootId, command.tenantId()));
        return orquestacionDeSagaConCorrutinasEnKotlinSpringBootId;
    }
}
