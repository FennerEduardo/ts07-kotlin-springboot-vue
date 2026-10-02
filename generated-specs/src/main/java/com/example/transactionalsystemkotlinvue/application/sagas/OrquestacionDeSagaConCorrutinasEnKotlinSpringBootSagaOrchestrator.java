package com.example.transactionalsystemkotlinvue.application.sagas;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * OrquestacionDeSagaConCorrutinasEnKotlinSpringBoot Saga Orchestrator.
 * Manages the lifecycle of the OrquestacionDeSagaConCorrutinasEnKotlinSpringBoot saga through state transitions.
 * Each handler is transactional and idempotent.
 */
@Service
public class OrquestacionDeSagaConCorrutinasEnKotlinSpringBootSagaOrchestrator {
    private static final Logger log = LoggerFactory.getLogger(OrquestacionDeSagaConCorrutinasEnKotlinSpringBootSagaOrchestrator.class);
    private final OrquestacionDeSagaConCorrutinasEnKotlinSpringBootSagaInstanceRepository sagaRepository;
    private final ApplicationEventPublisher commandBus;

    public OrquestacionDeSagaConCorrutinasEnKotlinSpringBootSagaOrchestrator(OrquestacionDeSagaConCorrutinasEnKotlinSpringBootSagaInstanceRepository sagaRepository, ApplicationEventPublisher commandBus) {
        this.sagaRepository = sagaRepository;
        this.commandBus = commandBus;
    }

    @Transactional
    public void handle(OrquestacionDeSagaConCorrutinasEnKotlinSpringBootSagaContract.OrquestacionDeSagaConCorrutinasEnKotlinSpringBootInitiatedEvent event) {
        log.info("Saga initiated: correlationId={}", event.correlationId());
        var metadata = event.metadata() != null ? event.metadata().toString() : "{}";
        var saga = new OrquestacionDeSagaConCorrutinasEnKotlinSpringBootSagaInstance(event.correlationId(), event.orquestacionDeSagaConCorrutinasEnKotlinSpringBootId(), metadata);
        sagaRepository.save(saga);

        // Commands are dispatched in-process; bridge them to your broker (e.g. via the outbox) as needed.
        commandBus.publishEvent(new OrquestacionDeSagaConCorrutinasEnKotlinSpringBootSagaContract.AuthorizeOrquestacionDeSagaConCorrutinasEnKotlinSpringBootCommand(event.orquestacionDeSagaConCorrutinasEnKotlinSpringBootId(), event.metadata()));
    }

    @Transactional
    public void handle(OrquestacionDeSagaConCorrutinasEnKotlinSpringBootSagaContract.OrquestacionDeSagaConCorrutinasEnKotlinSpringBootAuthorizedEvent event) {
        log.info("Saga authorized: correlationId={}", event.correlationId());
        var saga = sagaRepository.findById(event.correlationId())
                .orElseThrow(() -> new IllegalArgumentException("Saga not found: " + event.correlationId()));

        saga.transitionTo(OrquestacionDeSagaConCorrutinasEnKotlinSpringBootSagaInstance.SagaState.AUTHORIZED);
        saga.transitionTo(OrquestacionDeSagaConCorrutinasEnKotlinSpringBootSagaInstance.SagaState.COMPLETING);
        sagaRepository.save(saga);

        commandBus.publishEvent(new OrquestacionDeSagaConCorrutinasEnKotlinSpringBootSagaContract.CompleteOrquestacionDeSagaConCorrutinasEnKotlinSpringBootCommand(saga.getOrquestacionDeSagaConCorrutinasEnKotlinSpringBootId()));
    }

    @Transactional
    public void handle(OrquestacionDeSagaConCorrutinasEnKotlinSpringBootSagaContract.OrquestacionDeSagaConCorrutinasEnKotlinSpringBootCompletedEvent event) {
        log.info("Saga completed: correlationId={}", event.correlationId());
        var saga = sagaRepository.findById(event.correlationId())
                .orElseThrow(() -> new IllegalArgumentException("Saga not found: " + event.correlationId()));

        saga.transitionTo(OrquestacionDeSagaConCorrutinasEnKotlinSpringBootSagaInstance.SagaState.COMPLETED);
        sagaRepository.save(saga);
    }

    @Transactional
    public void handle(OrquestacionDeSagaConCorrutinasEnKotlinSpringBootSagaContract.OrquestacionDeSagaConCorrutinasEnKotlinSpringBootFailedEvent event) {
        log.info("Saga failed: correlationId={}, reason={}", event.correlationId(), event.reason());
        var saga = sagaRepository.findById(event.correlationId())
                .orElseThrow(() -> new IllegalArgumentException("Saga not found: " + event.correlationId()));

        saga.transitionTo(OrquestacionDeSagaConCorrutinasEnKotlinSpringBootSagaInstance.SagaState.COMPENSATING);
        saga.setFailureReason(event.reason());

        commandBus.publishEvent(new OrquestacionDeSagaConCorrutinasEnKotlinSpringBootSagaContract.CompensateOrquestacionDeSagaConCorrutinasEnKotlinSpringBootCommand(saga.getOrquestacionDeSagaConCorrutinasEnKotlinSpringBootId(), event.reason()));

        saga.transitionTo(OrquestacionDeSagaConCorrutinasEnKotlinSpringBootSagaInstance.SagaState.FAILED);
        sagaRepository.save(saga);
    }
}
