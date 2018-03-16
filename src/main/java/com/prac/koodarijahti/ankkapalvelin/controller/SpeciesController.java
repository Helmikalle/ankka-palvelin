package com.prac.koodarijahti.ankkapalvelin.controller;

import com.prac.koodarijahti.ankkapalvelin.model.Species;
import com.prac.koodarijahti.ankkapalvelin.service.SpeciesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpeciesController {
    @Autowired
    private SpeciesService speciesService;

    @GetMapping("/species")
    public Iterable<Species> findAllSpecies() {
        return speciesService.getAll();
    }

}
