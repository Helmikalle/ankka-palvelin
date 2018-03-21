package com.prac.koodarijahti.ankkapalvelin.service;

import com.prac.koodarijahti.ankkapalvelin.exception.CustomNotFoundException;
import com.prac.koodarijahti.ankkapalvelin.model.Sightings;
import com.prac.koodarijahti.ankkapalvelin.repository.SightingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class SightingService {
    @Autowired
    SightingsRepository sightingsRepository;
    @Autowired
    SpeciesService speciesService;

    public Iterable<Sightings> getAll() {
        return sightingsRepository.findAll();
    }

    public Sightings addNewSighting(Sightings sightings) {
        if (speciesService.checkForExistingSpecies(sightings.getSpecies().getName().toLowerCase())){
            if (sightings.getDateTime() == null || sightings.getDateTime().equals(""))
            sightings.setDateTime(new Date());
            sightings.setId(sightingsRepository.count() + 1);
            return sightingsRepository.save(sightings);
        } else throw new CustomNotFoundException("No such bird in the database - " + sightings.getSpecies().getName());
      }
}
