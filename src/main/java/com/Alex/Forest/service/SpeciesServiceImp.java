package com.Alex.Forest.service;

//import java.time.LocalDateTime;
import java.util.List;
import com.Alex.Forest.Entity.Plant_Species;
import com.Alex.Forest.exception.ResourceNotFoundException;
import com.Alex.Forest.repository.SpeciesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpeciesServiceImp implements SpeciesService{

  private SpeciesRepository speciesRepository;
  
  @Autowired
  public SpeciesServiceImp(SpeciesRepository speciesRepository) {
    super();
    this.speciesRepository = speciesRepository;
  }
  //This CREATES
  @Override
  public Plant_Species saveSpecies(Plant_Species species) {
    return speciesRepository.save(species);
  }
  //this READS All
  @Override
  public List<Plant_Species> getAllSpecies() {
    return speciesRepository.findAll();
  }
  
  //this READS individually
  @Override
  public Plant_Species getSpeciesByLatin(String Latin) {
    return speciesRepository.findById(Latin).orElseThrow(() -> 
    new ResourceNotFoundException("Species", "Latin Name", Latin));
  }
  //this UPDATES
  @Override
  public Plant_Species UpdateSpecies(Plant_Species species, String Latin) {
    Plant_Species existingSpecies = speciesRepository.findById(Latin).orElseThrow(() -> 
    new ResourceNotFoundException("Species", "Latin Name", Latin));
    existingSpecies.setPlant_Common_Name(species.getPlant_Common_Name());
        existingSpecies.setToxic(species.getToxic());
    existingSpecies.setEdible(species.getEdible());
    existingSpecies.setMedicinal(species.getMedicinal());
    existingSpecies.setPlant_Description(species.getPlant_Description());
    //The following needs a prepared statement that includes date, eventually user, and entry number
    /*
    existingSpecies.setPlant_Description( ""
        + existingSpecies.getPlant_Description() + "\n\n" 
        + LocalDateTime.now().toString() + " | "
        + species.getPlant_Description());
    */
    speciesRepository.save(existingSpecies);
    return existingSpecies;
  }
  //this DELETES
  @Override
  public void deleteSpecies(String Latin) {
    Plant_Species existingSpecies = speciesRepository.findById(Latin).orElseThrow(() -> 
    new ResourceNotFoundException("Species", "Latin Name", Latin));
    speciesRepository.deleteById(Latin);
  }
  
}
