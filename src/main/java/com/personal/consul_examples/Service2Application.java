package com.personal.consul_examples;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.core.env.AbstractEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient


public class Service2Application {
	private static ConfigurableApplicationContext context;
	HealthCheck hc = new HealthCheck();
	static RestTemplate restTemplate = new RestTemplate();
	static String hcurl
	  = "http://localhost:8080/kafka/activecluster";
	static String active_profile;
    public static void main(String[] args) {
    	
    	
    	ResponseEntity<HealthCheck> responseEntity_init=restTemplate.getForEntity(hcurl, HealthCheck.class);
    	active_profile=responseEntity_init.getBody().active_cluster;
    	/*String response
    	  = restTemplate.getForObject(hcurl, String.class);*/
    	
    	System.out.println("response received "+active_profile);
        //String PROFILE_NAME=response.active_cluster;
        //System.out.println(PROFILE_NAME);
        System.setProperty(AbstractEnvironment.ACTIVE_PROFILES_PROPERTY_NAME, 
        		active_profile.toLowerCase());
        //SpringApplication.run(Service2Application.class, args);
        context=SpringApplication.run(Service2Application.class, args);
    }
    
    public static void restart() {
    	ResponseEntity<HealthCheck> responseEntity=restTemplate.getForEntity(hcurl, HealthCheck.class);
    	active_profile=responseEntity.getBody().active_cluster;
        //ApplicationArguments args = context.getBean(ApplicationArguments.class);
        
        Thread thread = new Thread(() -> {
            context.close();
            context = SpringApplication.run(Service2Application.class, "--spring.profiles.active="+active_profile);
        });

        thread.setDaemon(false);
        thread.start();
    }
    
}