package com.Alex.Forest.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.Alex.Forest.Entity.Plant_Species;
import com.Alex.Forest.service.SpeciesService;


@RestController
@RequestMapping("/4est/Plant_Species")
public class SpeciesController {
  @Autowired
  private SpeciesService speciesService;
  
  private SpeciesController(SpeciesService speciesService) {
    super();
    this.speciesService = speciesService;
  }
  
  //create a species API
  @PostMapping()
  public ResponseEntity<Plant_Species> saveSpecies(@RequestBody Plant_Species species){
    return new ResponseEntity<Plant_Species>(speciesService.saveSpecies(species),HttpStatus.CREATED); 
  }
  
  //Read all species API
  @GetMapping
  public List<Plant_Species> getAllSpecies(){
    return speciesService.getAllSpecies();
  }
  
  //Get Species by Id
  @GetMapping("{Plant_Latin_Name}")
  public ResponseEntity<Plant_Species> getSpeciesByLatin(@PathVariable("Plant_Latin_Name") String Latin){
    return new ResponseEntity<Plant_Species>(speciesService.getSpeciesByLatin(Latin), HttpStatus.OK);
  }
  
  //updating or putting plant instance by id
  @PutMapping("{Plant_Latin_Name}")
  public ResponseEntity<Plant_Species> updateSpecies(@PathVariable("Plant_Latin_Name") String Latin, @RequestBody Plant_Species species){
    return new ResponseEntity<Plant_Species>(speciesService.UpdateSpecies(species, Latin), HttpStatus.OK);
  }
  
  //Deleting plant instance by id
  @DeleteMapping("{Plant_Latin_Name}")
  public ResponseEntity<String> deletePlant(@PathVariable("Plant_Latin_Name") String Latin){
    speciesService.deleteSpecies(Latin);
    return new ResponseEntity<String>("Plant Instance Deleted", HttpStatus.OK);
  }
}
