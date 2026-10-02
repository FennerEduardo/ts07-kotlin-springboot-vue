<script setup lang="ts">
import { ref } from 'vue';
import { COMMANDS } from '../api/orquestacion-de-saga-con-corrutinas-en-kotlin-spring-boot-client';
import { useOrquestacionDeSagaConCorrutinasEnKotlinSpringBootStore } from '../stores/orquestacion-de-saga-con-corrutinas-en-kotlin-spring-boot.store';

const store = useOrquestacionDeSagaConCorrutinasEnKotlinSpringBootStore();
const aggregateId = ref('');
</script>

<template>
  <section aria-label="Orquestación de Saga con Corrutinas en Kotlin Spring Boot">
    <h1>Orquestación de Saga con Corrutinas en Kotlin Spring Boot</h1>
    <label>
      Aggregate id
      <input v-model="aggregateId" data-test="aggregate-id" />
    </label>
    <button
      v-for="command in COMMANDS"
      :key="command"
      :data-test="command"
      :disabled="!aggregateId || store.loading"
      @click="store.execute(aggregateId, command)"
    >
      {{ command }}
    </button>
    <p v-if="store.error" role="alert">{{ store.error }}</p>
    <ul aria-label="events">
      <li v-for="e in store.events" :key="e.aggregateId + '-' + e.version">{{ e.type }} v{{ e.version }}</li>
    </ul>
  </section>
</template>
