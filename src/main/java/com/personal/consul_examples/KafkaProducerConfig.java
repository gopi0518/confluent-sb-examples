package com.personal.consul_examples;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.kafka.support.serializer.JsonSerializer;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaProducerConfig {

    @Bean
    public ProducerFactory<?, ?> ProducerFactory(KafkaProperties kafkaProperties) {
    	IPLookupModel im;

    	Map<String, Object> props = kafkaProperties.buildProducerProperties();
        /*configProps.put(
                ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,
                "pkc-2396y.us-east-1.aws.confluent.cloud:9092");*/
        props.put("security.protocol","SASL_SSL");
        /*configProps.put("sasl.jaas.config","org.apache.kafka.common.security.plain.PlainLoginModule required username='5JW4B4S7CPI65WMI' password='fLcw0MM8I/gp4e8hboYDZy3mwWeNZyiawOda7ek3Dr3OZT5j3m17AZbzLWKb8wUs';");*/
        props.put("sasl.mechanism","PLAIN");
        props.put("client.dns.lookup","use_all_dns_ips");
        props.put("session.timeout.ms",45000);
        props.put("retries",10);
        props.put(
                ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
                StringSerializer.class);
        /*configProps.put(
                ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
                StringSerializer.class);*/
        props.put(
                ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
                JsonSerializer.class);
        return new DefaultKafkaProducerFactory<>(props);
    }
   
}
