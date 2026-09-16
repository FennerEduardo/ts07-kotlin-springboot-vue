# language: es
Característica: Orquestación de Saga con Corrutinas en Kotlin Spring Boot

  Escenario: Procesamiento Asíncrono de Pedidos con Kotlin Flow y Sealed Interfaces
    Dado que se envía un comando `CreateOrderKtCommand` a la API de Kotlin Spring Boot
    Cuando la función suspendible `executeSaga` procesa la orden mediante corrutinas
    Entonces se emite un `OrderCreatedEvent` de tipo Sealed Interface
    Y el registro Outbox se persiste utilizando R2DBC de forma no bloqueante
    Y la suite de pruebas `./gradlew test` en Kotlin compila y aprueba la verificación
