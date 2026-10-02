import { beforeEach, describe, expect, it, vi } from 'vitest';
import { createPinia, setActivePinia } from 'pinia';
import { setOrquestacionDeSagaConCorrutinasEnKotlinSpringBootClient, useOrquestacionDeSagaConCorrutinasEnKotlinSpringBootStore } from './orquestacion-de-saga-con-corrutinas-en-kotlin-spring-boot.store';
import type { OrquestacionDeSagaConCorrutinasEnKotlinSpringBootClient } from '../api/orquestacion-de-saga-con-corrutinas-en-kotlin-spring-boot-client';

describe('orquestacionDeSagaConCorrutinasEnKotlinSpringBoot store', () => {
  beforeEach(() => setActivePinia(createPinia()));

  it('records the event returned by the backend', async () => {
    const result = { type: 'OrderCreated', aggregateId: 'agg-1', version: 1 };
    setOrquestacionDeSagaConCorrutinasEnKotlinSpringBootClient({ execute: vi.fn().mockResolvedValue(result) } as unknown as OrquestacionDeSagaConCorrutinasEnKotlinSpringBootClient);
    const store = useOrquestacionDeSagaConCorrutinasEnKotlinSpringBootStore();

    await store.execute('agg-1', 'process_orquestacion_de_saga_con_corrutinas_en_kotlin_spring_boot');

    expect(store.events).toEqual([result]);
    expect(store.error).toBeNull();
  });

  it('keeps the error message when the command fails', async () => {
    setOrquestacionDeSagaConCorrutinasEnKotlinSpringBootClient({ execute: vi.fn().mockRejectedValue(new Error('Command id is required')) } as unknown as OrquestacionDeSagaConCorrutinasEnKotlinSpringBootClient);
    const store = useOrquestacionDeSagaConCorrutinasEnKotlinSpringBootStore();

    await store.execute('agg-1', 'process_orquestacion_de_saga_con_corrutinas_en_kotlin_spring_boot');

    expect(store.error).toBe('Command id is required');
  });
});
