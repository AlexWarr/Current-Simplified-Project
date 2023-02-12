package com.Alex.Forest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.Alex.Forest.Entity.Plant_Species;

@Repository
public interface SpeciesRepository extends JpaRepository<Plant_Species, String> {

}
