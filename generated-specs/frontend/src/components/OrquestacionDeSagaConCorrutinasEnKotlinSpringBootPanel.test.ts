import { beforeEach, describe, expect, it, vi } from 'vitest';
import { flushPromises, mount } from '@vue/test-utils';
import { createPinia, setActivePinia } from 'pinia';
import OrquestacionDeSagaConCorrutinasEnKotlinSpringBootPanel from './OrquestacionDeSagaConCorrutinasEnKotlinSpringBootPanel.vue';
import { setOrquestacionDeSagaConCorrutinasEnKotlinSpringBootClient } from '../stores/orquestacion-de-saga-con-corrutinas-en-kotlin-spring-boot.store';
import type { OrquestacionDeSagaConCorrutinasEnKotlinSpringBootClient } from '../api/orquestacion-de-saga-con-corrutinas-en-kotlin-spring-boot-client';

describe('OrquestacionDeSagaConCorrutinasEnKotlinSpringBootPanel', () => {
  beforeEach(() => setActivePinia(createPinia()));

  it('executes a command and lists the resulting event', async () => {
    const execute = vi.fn().mockResolvedValue({ type: 'OrderCreated', aggregateId: 'agg-1', version: 1 });
    setOrquestacionDeSagaConCorrutinasEnKotlinSpringBootClient({ execute } as unknown as OrquestacionDeSagaConCorrutinasEnKotlinSpringBootClient);
    const wrapper = mount(OrquestacionDeSagaConCorrutinasEnKotlinSpringBootPanel);

    await wrapper.get('[data-test="aggregate-id"]').setValue('agg-1');
    await wrapper.get('[data-test="process_orquestacion_de_saga_con_corrutinas_en_kotlin_spring_boot"]').trigger('click');
    await flushPromises();

    expect(wrapper.text()).toContain('OrderCreated v1');
    expect(execute).toHaveBeenCalledWith('agg-1', 'process_orquestacion_de_saga_con_corrutinas_en_kotlin_spring_boot', undefined, expect.objectContaining({ idempotencyKey: expect.any(String) }));
  });

  it('disables commands until an aggregate id is entered', () => {
    const wrapper = mount(OrquestacionDeSagaConCorrutinasEnKotlinSpringBootPanel);
    expect(wrapper.get('[data-test="process_orquestacion_de_saga_con_corrutinas_en_kotlin_spring_boot"]').attributes('disabled')).toBeDefined();
  });
});
