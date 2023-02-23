package com.personal.consul_examples;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.health.DiscoveryClientHealthIndicator;
import org.springframework.cloud.context.restart.RestartEndpoint;
import org.springframework.core.env.AbstractEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

@RestController
public class ClientFailOverController {
    
   
    @Autowired
    
    private KafkaTemplate<String, Object> secondaryKafkaTemplate;
    @Autowired
	private Environment environment;
    RestTemplate restTemplate = new RestTemplate();
	String restart_url
	  = "http://localhost:8081/kafka/restart";
	
	
    @GetMapping("/produce")
    public String get() {
    	
        ServiceInstance service1 = null;
        SplunkEventGen SG = new SplunkEventGen();
        String profileName1 = null;
        for (String profileNames : environment.getActiveProfiles()) {
    		profileName1=profileNames;
    		System.out.println("active profile:"+profileName1);
    	    }
       	
       	System.out.println("Sending to "+profileName1+ " kafka cluster");
       	
       	for (long i = 0L; i < 5; i++) {
    		long millis = System.currentTimeMillis();
    		String event= "Event published on:"+profileName1;
    		String source="udp:514";
    		String host="boundary-fw-1";
    		String sourceType="cisco:asa";
    		String index="main";
    		String k=sourceType+millis;
            SG.setTime(millis);
            SG.setEvent(event);
            SG.setSource(source);
            SG.setSourcetype(sourceType);
            SG.setHost(host);
            SG.setIndex(index);
            secondaryKafkaTemplate.send("splunk-s2s-events",k,SG);
    		
    	}
       	
       	return "Sending to "+profileName1+ " kafka cluster";
        
        
    }
    
    @GetMapping("/restart")
    public String restart() {
    	
    	Service2Application.restart();
		
    	return "restarted";
    }
    @GetMapping("/publish")
    public String pub() {
    	
    	System.out.println();
    	return "stoped";
    	
    }
    
    @PostMapping("/healthcheck/notify")
    public String hcNotify(@RequestBody HealthCheck hc) {
    	System.out.println("received health check"+hc.active_cluster);
    	String profileName = null;
        for (String profileNames : environment.getActiveProfiles()) {
    		profileName=profileNames;
    		System.out.println("active profile:"+profileName);
    	    }
    	if (profileName.toUpperCase()!=hc.active_cluster.toUpperCase()) {
    		System.setProperty(AbstractEnvironment.ACTIVE_PROFILES_PROPERTY_NAME, 
    				hc.active_cluster.toLowerCase());
    		ResponseEntity<String> response=restTemplate.getForEntity(restart_url,String.class);
    		
			/*String response = builder.build()
					.postForObject("http://localhost:8081/kafka/restart", entity, String.class);*/
			System.out.println("i am in restart loop");
			System.out.println(response);
			/*System.out.println("response"+response);*/
    	}
    	
    	return "stoped";
    	
    }
}