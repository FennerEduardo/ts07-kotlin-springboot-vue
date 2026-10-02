package com.example.transactionalsystemkotlinvue.application.sagas;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.UUID;

@Repository
public interface OrquestacionDeSagaConCorrutinasEnKotlinSpringBootSagaInstanceRepository extends JpaRepository<OrquestacionDeSagaConCorrutinasEnKotlinSpringBootSagaInstance, UUID> {

    List<OrquestacionDeSagaConCorrutinasEnKotlinSpringBootSagaInstance> findByCurrentState(OrquestacionDeSagaConCorrutinasEnKotlinSpringBootSagaInstance.SagaState state);

    @Query("SELECT s FROM OrquestacionDeSagaConCorrutinasEnKotlinSpringBootSagaInstance s WHERE s.currentState IN ('COMPENSATING', 'STARTED') AND s.retryCount < :maxRetries")
    List<OrquestacionDeSagaConCorrutinasEnKotlinSpringBootSagaInstance> findRetryableSagas(int maxRetries);
}
