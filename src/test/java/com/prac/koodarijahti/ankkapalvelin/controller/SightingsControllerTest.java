package com.prac.koodarijahti.ankkapalvelin.controller;

import com.prac.koodarijahti.ankkapalvelin.model.Sightings;
import com.prac.koodarijahti.ankkapalvelin.service.SightingService;
import com.prac.koodarijahti.ankkapalvelin.service.SpeciesService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Date;

@WebMvcTest
@RunWith(SpringRunner.class)
public class SightingsControllerTest {

    private static final Sightings TESTSHIGHTING = new Sightings("mallard","description",new Date(),2);

    @MockBean
    private SightingService sightingService;

    @MockBean
    private SpeciesService speciesService;

    @Autowired
    private MockMvc mockMvc;


    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void whenNewSightingIsCreatedShouldReturnStatusCreated() throws Exception {
        //TODO kun keksin miten
    }

}