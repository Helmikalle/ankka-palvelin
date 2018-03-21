package com.prac.koodarijahti.ankkapalvelin.service;

import com.prac.koodarijahti.ankkapalvelin.exception.CustomNotFoundException;
import com.prac.koodarijahti.ankkapalvelin.model.Sightings;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SightingServiceTest {
    @MockBean
    SpeciesService speciesService;
    @Autowired
    SightingService sightingService;

    @Test(expected = CustomNotFoundException.class)
    public void whenCreatingNewSightingWithSpeciesThatsNotInDatabaseThenShouldThrowException() {
        Mockito.when(speciesService.checkForExistingSpecies("duck")).thenReturn(false);
        sightingService.addNewSighting(new Sightings("duck","test",new Date(),2));
    }

    @Test
    public void whenTimestampIsMissingShouldGiveNewDate() {
        Sightings sightings = new Sightings("mallard","test",null,2);
        Mockito.when(speciesService.checkForExistingSpecies("mallard")).thenReturn(true);
        sightingService.addNewSighting(sightings);
        assertThat(sightings.getDateTime()).isCloseTo(new Date(), 1000);
    }
}