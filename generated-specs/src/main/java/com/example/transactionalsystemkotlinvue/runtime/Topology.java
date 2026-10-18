package com.example.transactionalsystemkotlinvue.runtime;

/**
 * Event bus destinations: events are published to {@code exchange} (RabbitMQ topic exchange / Pub/Sub topic)
 * and consumed from {@code queue} (queue / pull subscription); dead-lettered messages go to {@code dlx}
 * and can be read from {@code dlq}.
 */
public record Topology(String exchange, String queue, String dlx, String dlq) {
    public static final Topology DEFAULT = new Topology("transactional-system-kotlin-vue.events", "transactional-system-kotlin-vue.consumer", "transactional-system-kotlin-vue.dlx", "transactional-system-kotlin-vue.dlq");

    public static Topology forPrefix(String prefix) {
        return new Topology(prefix + ".events", prefix + ".consumer", prefix + ".dlx", prefix + ".dlq");
    }
}
