package com.prac.koodarijahti.ankkapalvelin.controller;

import com.prac.koodarijahti.ankkapalvelin.model.Sightings;
import com.prac.koodarijahti.ankkapalvelin.service.SightingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
public class SightingsController {
    @Autowired
    private SightingService sightingService;

    @GetMapping("/sightings")
    public Iterable<Sightings> findAllSightings() {
        return sightingService.getAll();
    }

    @PostMapping("/sightings")
    public ResponseEntity<Sightings> newSighting(@Valid @RequestBody Sightings sightings) {
        sightingService.addNewSighting(sightings);
        URI location = UriComponentsBuilder.newInstance()
                .scheme("http")
                .host("localhost")
                .port(8081)
                .path("/sightings/{id}")
                .buildAndExpand(sightings.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }
}
