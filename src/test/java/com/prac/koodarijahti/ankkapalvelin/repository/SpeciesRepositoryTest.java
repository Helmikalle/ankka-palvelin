package com.prac.koodarijahti.ankkapalvelin.repository;

import com.prac.koodarijahti.ankkapalvelin.model.Species;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

@DataJpaTest
@RunWith(SpringRunner.class)
public class SpeciesRepositoryTest {

    @Autowired
    private SpeciesRepository repository;

    @Test
    public void existsSpeciesByNameTest() {
        this.repository.save(new Species("mallard"));

        boolean exists = this.repository.existsSpeciesByName("mallard");
        boolean doesntExist = this.repository.existsSpeciesByName("duck");
        assertTrue(exists);
        assertFalse(doesntExist);
    }
}