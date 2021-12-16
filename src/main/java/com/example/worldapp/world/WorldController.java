package com.example.worldapp.world;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WorldController {

    private static final Logger log = LoggerFactory.getLogger(WorldController.class);

    private final WorldService worldService;

    public WorldController(WorldService worldService) {
        this.worldService = worldService;
    }

    @GetMapping("/world")
    public String world() {
        log.info("### world");
        return worldService.callHi();
    }

    @GetMapping("/fail")
    public ResponseEntity<String> fail() {
        log.info("### fail!");
        return new ResponseEntity<>("ERROR", HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
