package com.personal.consul_examples;

import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.config.SaslConfigs;
import org.apache.kafka.common.security.plain.PlainLoginModule;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.CommonContainerStoppingErrorHandler;
import org.springframework.kafka.listener.CommonErrorHandler;

import org.springframework.kafka.listener.DefaultErrorHandler;
import org.springframework.kafka.listener.MessageListenerContainer;


@Configuration

public class KafkaPrimaryConsumerConfig {
	Logger logger = LoggerFactory.getLogger(KafkaPrimaryConsumerConfig.class);

	@SuppressWarnings("unused")
	@Bean(name="consumerFactory")
	    public ConsumerFactory<String, String> consumerFactory() {
		    
	        Map<String, Object> props = new HashMap<>();
	        
	        
	      	        props.put(
	      	          ConsumerConfig.GROUP_ID_CONFIG, 
	      	          "test");
	      	        props.put("security.protocol","SASL_SSL");
	      	        
	      	      /*props.put(SaslConfigs.SASL_JAAS_CONFIG, String.format(
	      	            "%s required username=\"%s\" " + "password=\"%s\";", PlainLoginModule.class.getName(), "username", "password"
	      	        ));*/
	      	       

	      	        props.put("sasl.mechanism","PLAIN");
	      	        props.put("client.dns.lookup","use_all_dns_ips");
	      	        props.put("session.timeout.ms",45000);
	      	        /*props.put(
	      	                ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
	      	                StringSerializer.class);
	      	        props.put(
	      	                ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
	      	                StringSerializer.class);*/
	      	        props.put(
	      	          ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, 
	      	          StringDeserializer.class);
	      	        props.put(
	      	          ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, 
	      	          StringDeserializer.class);
	      	      props.put("retries",30);
	        
	        return new DefaultKafkaConsumerFactory<>(props);
	    }

	    
	    @Bean
	    public ConcurrentKafkaListenerContainerFactory<String, String> 
	    kafkaPrimaryListenerContainerFactory(final ConsumerFactory<String, String> kafkaListenerContainerFactory) {
	   
	        ConcurrentKafkaListenerContainerFactory<String, String> factory =
	          new ConcurrentKafkaListenerContainerFactory<>();
	        factory.setConsumerFactory(consumerFactory());
	        factory.setCommonErrorHandler((CommonErrorHandler) new CommonContainerStoppingErrorHandler() {
	            final DefaultErrorHandler defaultErrorHandler = new DefaultErrorHandler();

	            @Override
	            public void handleRemaining(
	                final Exception thrownException,
	                
	                final List<ConsumerRecord<?, ?>> records,
	                final Consumer<?, ?> consumer,
	                final MessageListenerContainer container
	            ) {
	                if (thrownException.getCause() instanceof UnknownHostException) {
	                    logger.error("UnknownHostException has occurred and will stop the container to prevent log flooding.");
	                    super.handleOtherException(thrownException, consumer, container, false);
	                }
	                else {
	                    this.defaultErrorHandler.handleOtherException(thrownException, consumer, container, false);
	                }
	            }
	        });
	        return factory;
	    }
	
}
