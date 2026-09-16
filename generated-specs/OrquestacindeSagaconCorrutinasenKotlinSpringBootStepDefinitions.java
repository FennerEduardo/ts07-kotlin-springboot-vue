// Cucumber-JVM Step Definition Generator for Spring Boot & GraphQL
package com.example.bdd.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import static org.assertj.core.api.Assertions.assertThat;

public class OrquestacindeSagaconCorrutinasenKotlinSpringBootStepDefinitions {

    @Autowired
    private TestRestTemplate restTemplate;

    @Container
    static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:15-alpine");

    
    // Scenario: Procesamiento Asíncrono de Pedidos con Kotlin Flow y Sealed Interfaces
    
    @Given("que se envía un comando `CreateOrderKtCommand` a la API de Kotlin Spring Boot")
    public void GivenqueseenvauncomandoCreateOrderKtCommandalaAPIdeKotlinSpringBoot() {
        throw new io.cucumber.java.PendingException();
    }

    @When("la función suspendible `executeSaga` procesa la orden mediante corrutinas")
    public void WhenlafuncinsuspendibleexecuteSagaprocesalaordenmediantecorrutinas() {
        throw new io.cucumber.java.PendingException();
    }

    @Then("se emite un `OrderCreatedEvent` de tipo Sealed Interface")
    public void ThenseemiteunOrderCreatedEventdetipoSealedInterface() {
        throw new io.cucumber.java.PendingException();
    }
    
}
