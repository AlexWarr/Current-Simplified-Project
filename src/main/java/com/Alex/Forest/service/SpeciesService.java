package com.Alex.Forest.service;

import java.util.List;
import com.Alex.Forest.Entity.Plant_Species;

public interface SpeciesService {

  //post a species
  public Plant_Species saveSpecies(Plant_Species species);
  
  //get all species
  public List<Plant_Species> getAllSpecies();
  
  //get species by Latin Name
  public Plant_Species getSpeciesByLatin(String Latin);
  
  //update
  public Plant_Species UpdateSpecies(Plant_Species species, String Latin);
  
  //Delete (Just here for troubleshooting, species will not have a delete option readily available to user. They can delete only entries and plant instances
  public void deleteSpecies(String Latin);
  
}
