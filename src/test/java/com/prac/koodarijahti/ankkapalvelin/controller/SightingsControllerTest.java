package com.prac.koodarijahti.ankkapalvelin.controller;

import com.prac.koodarijahti.ankkapalvelin.model.Sightings;
import com.prac.koodarijahti.ankkapalvelin.model.Species;
import com.prac.koodarijahti.ankkapalvelin.service.SightingService;
import com.prac.koodarijahti.ankkapalvelin.service.SpeciesService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.Date;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
@RunWith(SpringRunner.class)
public class SightingsControllerTest {
    private static final Species MALLARD = new Species("Mallard");
    private static final Sightings TESTSHIGHTING = new Sightings(MALLARD,"description",new Date(),2);
    private static final String exmapleSighting = "{\"species\": \"redhead\"," +
            "\"description\": \"I think this one is called Alfred J.\"," +
            "\"dateTime\": \"2016-11-29T10:00:01Z\",\"count\": 1}";

    @MockBean
    private SightingService sightingService;

    @MockBean
    private SpeciesService speciesService;

    @MockBean
    private Sightings sightings;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SightingsController sightingsController;

    @MockBean
    private Species species;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindAllSightingsAndExpectStatusOk() throws Exception {
        Mockito.when(this.sightingService.getAll())
                .thenReturn(Collections.singletonList(TESTSHIGHTING));
        this.mockMvc.perform(get("/sightings"))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk());
    }

    @Test
    public void whenNewSightingIsCreatedShouldReturnStatusCreated() throws Exception {

        this.mockMvc.perform(post("/sightings"))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

}