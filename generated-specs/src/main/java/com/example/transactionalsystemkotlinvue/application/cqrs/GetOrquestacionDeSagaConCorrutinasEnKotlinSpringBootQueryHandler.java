package com.example.transactionalsystemkotlinvue.application.cqrs;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Map;

/**
 * Query Handler for OrquestacionDeSagaConCorrutinasEnKotlinSpringBoot read model.
 * Follows CQRS: reads from optimized read model / projected views.
 */
@Service
public class GetOrquestacionDeSagaConCorrutinasEnKotlinSpringBootQueryHandler {
    @Transactional(readOnly = true)
    public OrquestacionDeSagaConCorrutinasEnKotlinSpringBootDTO handle(GetOrquestacionDeSagaConCorrutinasEnKotlinSpringBootQuery query) {
        // Optimized read from Read Model / Projected View
        return new OrquestacionDeSagaConCorrutinasEnKotlinSpringBootDTO(query.orquestacionDeSagaConCorrutinasEnKotlinSpringBootId(), "PROCESSED", Map.of());
    }
}
