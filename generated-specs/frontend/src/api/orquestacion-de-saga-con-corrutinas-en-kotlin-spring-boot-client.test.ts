import { describe, expect, it, vi } from 'vitest';
import { ApiError, COMMANDS, createOrquestacionDeSagaConCorrutinasEnKotlinSpringBootClient } from './orquestacion-de-saga-con-corrutinas-en-kotlin-spring-boot-client';

function fakeFetch(status: number, body: unknown) {
  return vi.fn(async (_url: RequestInfo | URL, _init?: RequestInit) => new Response(JSON.stringify(body), { status, headers: { 'Content-Type': 'application/json' } }));
}

describe('OrquestacionDeSagaConCorrutinasEnKotlinSpringBoot API client', () => {
  it('exposes one method per domain command', () => {
    expect(COMMANDS).toEqual(['process_orquestacion_de_saga_con_corrutinas_en_kotlin_spring_boot']);
  });

  it('posts the command with tenant and idempotency headers', async () => {
    const fetch = fakeFetch(201, { type: 'OrderCreated', aggregateId: 'agg-1', version: 1 });
    const client = createOrquestacionDeSagaConCorrutinasEnKotlinSpringBootClient({ baseUrl: 'https://api.test/', tenantId: 'acme', fetch });

    const result = await client.processOrquestacionDeSagaConCorrutinasEnKotlinSpringBoot('agg-1', { amount: 100 }, { idempotencyKey: 'key-1' });

    expect(result).toEqual({ type: 'OrderCreated', aggregateId: 'agg-1', version: 1 });
    const [url, init] = fetch.mock.calls[0];
    expect(url).toBe('https://api.test/api/v1/orquestacion-de-saga-con-corrutinas-en-kotlin-spring-boot/agg-1/process_orquestacion_de_saga_con_corrutinas_en_kotlin_spring_boot');
    expect(init?.method).toBe('POST');
    expect((init?.headers as Record<string, string>)['X-Tenant-Id']).toBe('acme');
    expect((init?.headers as Record<string, string>)['X-Idempotency-Key']).toBe('key-1');
    expect(JSON.parse(String(init?.body))).toEqual({ amount: 100 });
  });

  it('raises ApiError with the server detail on failure', async () => {
    const client = createOrquestacionDeSagaConCorrutinasEnKotlinSpringBootClient({ fetch: fakeFetch(422, { detail: 'Command id is required' }) });
    await expect(client.execute('agg-1', 'process_orquestacion_de_saga_con_corrutinas_en_kotlin_spring_boot')).rejects.toEqual(new ApiError(422, 'Command id is required'));
  });
});
