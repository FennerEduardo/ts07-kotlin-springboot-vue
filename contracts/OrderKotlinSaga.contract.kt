package com.transactional.kotlin.contract

import java.math.BigDecimal
import java.time.Instant
import java.util.UUID

sealed interface OrderSagaEvent {
    val eventId: UUID
    val occurredAt: Instant
}

data class OrderCreatedEvent(
    override val eventId: UUID = UUID.randomUUID(),
    override val occurredAt: Instant = Instant.now(),
    val orderId: UUID,
    val customerId: UUID,
    val totalAmount: BigDecimal,
    val correlationId: String
) : OrderSagaEvent

data class CreateOrderKtCommand(
    val orderId: UUID,
    val customerId: UUID,
    val totalAmount: BigDecimal,
    val currency: String,
    val idempotencyKey: String
)

interface OrderKotlinSagaContract {
    suspend fun executeSaga(command: CreateOrderKtCommand): OrderCreatedEvent
    suspend fun validateIdempotency(key: String): Boolean
}
