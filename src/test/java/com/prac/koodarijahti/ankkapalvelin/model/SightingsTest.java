package com.prac.koodarijahti.ankkapalvelin.model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.ConstraintViolationException;
import java.util.Date;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@RunWith(SpringRunner.class)
@DataJpaTest
public class SightingsTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    public void autoGeneratedId() {
        Sightings sightings = this.testEntityManager.persistFlushFind(new Sightings("mallard","test content", new Date(),2));
        assertThat(sightings.getId()).isGreaterThan(0);
        assertThat(sightings.getId()).isNotEqualTo(null);
    }

    @Test
    public void saveShouldPersistData() {
        Sightings sightings = this.testEntityManager.persistFlushFind(new Sightings("mallard","test content", new Date(),2));
        assertThat(sightings.getSpecies()).isEqualTo("mallard");
        assertThat(sightings.getCount()).isGreaterThan(0);
        assertThat(sightings.getCount()).isEqualTo(2);

    }

    @Test(expected = ConstraintViolationException.class)
    public void shouldNotAllowToSaveIfCountIsZeroExceptionExpected() {
        Sightings sightings = this.testEntityManager.persistFlushFind(new Sightings("mallard","test",new Date(),0));
        assertThat(sightings.getCount()).isEqualTo(0);
    }
}