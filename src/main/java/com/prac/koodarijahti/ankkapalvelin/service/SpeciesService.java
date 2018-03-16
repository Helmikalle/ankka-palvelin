package com.prac.koodarijahti.ankkapalvelin.service;

import com.prac.koodarijahti.ankkapalvelin.model.Species;
import com.prac.koodarijahti.ankkapalvelin.repository.SpeciesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class SpeciesService {
    @Autowired
    SpeciesRepository speciesRepository;

    public Iterable<Species> getAll() {
        return speciesRepository.findAll();
    }

    public boolean checkForExistingSpecies(String name) {
        return speciesRepository.existsSpeciesByName(name);
    }
}
