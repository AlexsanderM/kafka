package ru.kafka.kafkatest.config;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;

import java.util.HashMap;
import java.util.Map;

@EnableKafka
@Configuration
public class KafkaConsumerConfig {
    @Value("${kafka.address}")
    private String bootstrapServers;

    @Bean
    public Map<String, Object> consumerProperties() {
    Map<String, Object> properties = new HashMap<>();
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, this.bootstrapServers);
        return properties;
    }

//    @Bean
//    public ConsumerFactory<Long, EventProto.EVENT> consumerFactory() {
//        return new DefaultKafkaConsumerFactory<>(consumerProperties());
//    }

//    @Bean
//    public ConcurrentKafkaListenerContainerFactory<Long, EventProto.EVENT> kafkaListenerContainerFactory() {
//        ConcurrentKafkaListenerContainerFactory<Long, EventProto.EVENT> factory = new ConcurrentKafkaListenerContainerFactory<>();
//        factory.setConsumerFactory(consumerFactory());
//        factory.setConcurrency(1);
//        factory.getContainerProperties().setPollTimeout(30000);
//        factory.setErrorHandler(new SeekToCurrentErrorHandler());
//        factory.getContainerProperties().setAckOnError(false);
//        factory.getContainerProperties().setAckMode(ContainerProperties.AckMode.MANUAL_IMMEDIATE);
//        factory.setAutoStartup(true);
//        return factory;
//    }
}
