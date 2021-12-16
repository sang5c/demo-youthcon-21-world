package com.example.worldapp.world;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WorldService {

    private static final Logger log = LoggerFactory.getLogger(WorldService.class);

    private final RestTemplate restTemplate;

    public WorldService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String callHi() {
        log.info("### call hi");
        return restTemplate.getForObject("http://localhost:8082/hi", String.class);
    }

}
