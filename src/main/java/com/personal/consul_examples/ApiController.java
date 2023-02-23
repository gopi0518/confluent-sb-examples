package com.personal.consul_examples;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

    @Value("${spring.application.name}")
    private String applicationName;

    @GetMapping("/info")
    public String getInfo() {
        return "{name: \"" + applicationName + "\" }";
    }
}