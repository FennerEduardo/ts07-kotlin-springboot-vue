// ==========================================================================
// Generated Kotlin Domain Contracts & DTOs
// Feature: Orquestación de Saga con Corrutinas en Kotlin Spring Boot
// Architecture: monolith
// ==========================================================================
package transactionalsystemkotlinvue.orquestaciondesagaconcorrutinasenkotlinspringboot

import java.util.UUID
import java.time.Instant

// 1. Domain Events
interface DomainEvent {
    val eventId: UUID
    val occurredOn: Instant
    val eventType: String
}

data class OrderCreatedEventEvent(
    override val eventId: UUID = UUID.randomUUID(),
    override val occurredOn: Instant = Instant.now(),
    val payload: OrderCreatedEventPayload
) : DomainEvent {
    override val eventType: String = "OrderCreatedEvent"
}

data class OrderCreatedEventPayload(
)

// 2. Command DTOs
data class OrquestacionDeSagaConCorrutinasEnKotlinSpringBootCommand(
    val requestId: UUID,
    val timestamp: Instant,
    val payload: OrquestacionDeSagaConCorrutinasEnKotlinSpringBootCommandPayload
)

data class OrquestacionDeSagaConCorrutinasEnKotlinSpringBootCommandPayload(
)

// 3. Domain Repository Port
interface OrquestacionDeSagaConCorrutinasEnKotlinSpringBootRepository {
    fun findById(id: UUID): Any?
    fun save(entity: Any)
    fun delete(id: UUID)
}

// 4. Event Publisher Port
interface EventPublisher {
    fun publish(event: DomainEvent)
}
