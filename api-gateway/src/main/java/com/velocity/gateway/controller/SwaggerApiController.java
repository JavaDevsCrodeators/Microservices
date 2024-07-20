package com.velocity.gateway.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.velocity.gateway.service.DiscoveryService;

@Controller()
public class SwaggerApiController {
	
	private final DiscoveryService discoveryService;
	
	@Autowired
    public SwaggerApiController(DiscoveryService discoveryService) {
        this.discoveryService = discoveryService;
    }
	
	@GetMapping("/")
    public String getServices(Model model) {
        // Fetch the list of services from Eureka Server
        List<String> services = discoveryService.getAllServiceUrls();
        
        // Add the list of services to the model
        model.addAttribute("services", services);
        
        // Return the name of the Thymeleaf template to render
        return "services";
    }

}
