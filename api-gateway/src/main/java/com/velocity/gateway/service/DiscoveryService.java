package com.velocity.gateway.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;

@Service
public class DiscoveryService {
	
	private DiscoveryClient discoveryClient;
	
	@Autowired
	public DiscoveryService(DiscoveryClient discoveryClient) {
		this.discoveryClient = discoveryClient;
	}

    public List<String> getAllServiceUrls() {
        List<String> services = discoveryClient.getServices();
        List<String> serviceUrls = new ArrayList<>();
        String swagerui = "/swagger-ui.html";
        for (String service : services) {
            List<ServiceInstance> instances = discoveryClient.getInstances(service);
            for (ServiceInstance instance : instances) {
                serviceUrls.add(instance.getUri().toString()+swagerui);
            }
        }

        return serviceUrls;
    }
}
