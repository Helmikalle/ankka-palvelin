package com.prac.koodarijahti.ankkapalvelin.repository;

import com.prac.koodarijahti.ankkapalvelin.model.Species;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpeciesRepository extends CrudRepository<Species,Long> {
    boolean existsSpeciesByName(String name);
}
