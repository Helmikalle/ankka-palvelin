package com.prac.koodarijahti.ankkapalvelin.repository;

import com.prac.koodarijahti.ankkapalvelin.model.Sightings;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SightingsRepository extends CrudRepository<Sightings,Long> {
}
