package com.prac.koodarijahti.ankkapalvelin;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.prac.koodarijahti.ankkapalvelin.model.Sightings;
import com.prac.koodarijahti.ankkapalvelin.model.Species;
import com.prac.koodarijahti.ankkapalvelin.repository.SightingsRepository;
import com.prac.koodarijahti.ankkapalvelin.repository.SpeciesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Component
public class ComponentToReadJsonAndPopulateDB implements CommandLineRunner {
    final
    SpeciesRepository speciesRepository;
    final
    SightingsRepository sightingsRepository;
    private static final String SIGHTINGS_FILE_NAME = "SightingsData.json";
    private static final String SPECIES_FILE_NAME = "SpeciesData.json";

    @Autowired
    public ComponentToReadJsonAndPopulateDB(SpeciesRepository speciesRepository, SightingsRepository sightingsRepository) {
        this.speciesRepository = speciesRepository;
        this.sightingsRepository = sightingsRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        ObjectMapper mapper = new ObjectMapper();
        TypeReference<List<Sightings>> typeReference = new TypeReference<List<Sightings>>(){};
        File inputStream = new File(SIGHTINGS_FILE_NAME);
        TypeReference<List<Species>> speciesTypeRef = new TypeReference<List<Species>>() {};
        File speciesInputStream = new File(SPECIES_FILE_NAME);
        try {
            List<Species> species = mapper.readValue(speciesInputStream,speciesTypeRef);
            speciesRepository.saveAll(species);
            System.out.println("SpeciesData saved");
        } catch (IOException e) {
            System.out.println("Something went wrong when mapping species. " + e.getMessage());
        }
        try {
            List<Sightings> sighting = mapper.readValue(inputStream,typeReference);
            sightingsRepository.saveAll(sighting);
            System.out.println("SightingsData saved");
        }catch (IOException e) {
            System.out.println("Something went wrong when mapping sightings. " + e.getMessage());
        }
    }
}
