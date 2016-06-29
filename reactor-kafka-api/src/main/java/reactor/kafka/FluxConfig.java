package reactor.kafka;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import reactor.kafka.internals.ConsumerFactory;

/**
 * Configuration properties for Kafka consumer flux.
 */
public class FluxConfig<K, V> {

    private final Map<String, Object> properties = new HashMap<>();

    private Duration pollTimeout = Duration.ofMillis(100);
    private Duration closeTimeout = Duration.ofMillis(Long.MAX_VALUE);
    private Duration commitInterval = ConsumerFactory.INSTANCE.defaultAutoCommitInterval();
    private int commitBatchSize = Integer.MAX_VALUE;
    private int maxAutoCommitAttempts = Integer.MAX_VALUE;

    public FluxConfig() {
    }

    public FluxConfig(Map<String, Object> configProperties) {
        this.properties.putAll(configProperties);
    }

    public FluxConfig(Properties configProperties) {
        configProperties.forEach((name, value) -> this.properties.put((String) name, value));
    }

    public Map<String, Object> consumerProperties() {
        return properties;
    }

    public FluxConfig<K, V> consumerProperty(String name, Object newValue) {
        this.properties.put(name, newValue);
        return this;
    }

    public Duration pollTimeout() {
        return pollTimeout;
    }

    public FluxConfig<K, V> pollTimeout(Duration timeout) {
        this.pollTimeout = timeout;
        return this;
    }

    public Duration closeTimeout() {
        return closeTimeout;
    }

    public FluxConfig<K, V> closeTimeout(Duration timeout) {
        this.closeTimeout = timeout;
        return this;
    }

    public String groupId() {
        return ConsumerFactory.INSTANCE.groupId(this);
    }

    public Duration heartbeatInterval() {
        return ConsumerFactory.INSTANCE.heartbeatInterval(this);
    }

    public Duration commitInterval() {
        return commitInterval;
    }

    public FluxConfig<K, V> commitInterval(Duration interval) {
        this.commitInterval = interval;
        return this;
    }

    public int commitBatchSize() {
        return commitBatchSize;
    }

    public FluxConfig<K, V> commitBatchSize(int commitBatchSize) {
        this.commitBatchSize = commitBatchSize;
        return this;
    }

    public int maxAutoCommitAttempts() {
        return maxAutoCommitAttempts;
    }

    public FluxConfig<K, V> maxAutoCommitAttempts(int maxRetries) {
        this.maxAutoCommitAttempts = maxRetries;
        return this;
    }
}