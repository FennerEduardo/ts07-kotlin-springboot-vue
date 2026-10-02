package com.example.transactionalsystemkotlinvue.domain

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertTrue

class OrquestacionDeSagaConCorrutinasEnKotlinSpringBootAggregateTest {

    @Test
    fun `starts in the initial state with no events`() {
        val aggregate = OrquestacionDeSagaConCorrutinasEnKotlinSpringBootAggregate("agg-1")
        assertEquals(OrquestacionDeSagaConCorrutinasEnKotlinSpringBootState.PENDING, aggregate.state)
        assertEquals(0, aggregate.version)
        assertTrue(aggregate.pendingEvents.isEmpty())
    }

    @Test
    fun `rejects an aggregate without id`() {
        assertFailsWith<DomainValidationException> { OrquestacionDeSagaConCorrutinasEnKotlinSpringBootAggregate("") }
    }

    @Test
    fun `processOrquestacionDeSagaConCorrutinasEnKotlinSpringBoot records OrderCreated and bumps the version`() {
        val aggregate = OrquestacionDeSagaConCorrutinasEnKotlinSpringBootAggregate("agg-1")
        val event = aggregate.processOrquestacionDeSagaConCorrutinasEnKotlinSpringBoot(OrquestacionDeSagaConCorrutinasEnKotlinSpringBootCommand("agg-1"))
        assertEquals(OrquestacionDeSagaConCorrutinasEnKotlinSpringBootEventType.OrderCreated, event.type)
        assertEquals(1, event.version)
        assertEquals(1, aggregate.version)
        assertEquals(1, aggregate.pendingEvents.size)
    }

    @Test
    fun `processOrquestacionDeSagaConCorrutinasEnKotlinSpringBoot rejects a command without id`() {
        val aggregate = OrquestacionDeSagaConCorrutinasEnKotlinSpringBootAggregate("agg-1")
        assertFailsWith<DomainValidationException> { aggregate.processOrquestacionDeSagaConCorrutinasEnKotlinSpringBoot(OrquestacionDeSagaConCorrutinasEnKotlinSpringBootCommand("")) }
        assertTrue(aggregate.pendingEvents.isEmpty())
    }
}
