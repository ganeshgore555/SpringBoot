package com.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class ConfigCheckService {
	
    @Value("${app:default}")
    private String app;
	
    @Value("${threshold:1}")
    private Integer threshold;
    
    @Value("${maxCount:10}")
    private Integer maxCount;
    
	@GetMapping("/api/config")
    public String displayConfig(){
        return "App Name is : "  + app + " with threshold " + threshold + " and maxCount " + maxCount;
    }
}
