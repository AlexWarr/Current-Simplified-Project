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
import com.Alex.Forest.Entity.Location;
import com.Alex.Forest.service.LocationService;


@RestController
@RequestMapping("/4est/Location")
public class LocationController {
  @Autowired
  private LocationService locationService;
  
  private LocationController(LocationService locationService) {
    super();
    this.locationService = locationService;
  }
  
  //create a Location API
  @PostMapping()
  public ResponseEntity<Location> saveLocation(@RequestBody Location location){
    return new ResponseEntity<Location>(locationService.saveLocation(location),HttpStatus.CREATED); 
  }
  
  //Read all Locations API
  @GetMapping
  public List<Location> getAllLocations(){
    return locationService.getAllLocations();
  }
  
  //Get Species by Id
  @GetMapping("{Location_Name}")
  public ResponseEntity<Location> getLocationByName(@PathVariable("Location_Name") String name){
    return new ResponseEntity<Location>(locationService.getLocationByName(name), HttpStatus.OK);
  }
  
  //updating or putting plant instance by id
  @PutMapping("{Location_Name}")
  public ResponseEntity<Location> updateLocation(@PathVariable("Location_Name") String name, @RequestBody Location location){
    return new ResponseEntity<Location>(locationService.UpdateLocation(location, name), HttpStatus.OK);
  }
  
  //Deleting plant instance by id
  @DeleteMapping("{Location_Name}")
  public ResponseEntity<String> deleteLocation(@PathVariable("Location_Name") String name){
    locationService.deleteLocation(name);
    return new ResponseEntity<String>("Plant Instance Deleted", HttpStatus.OK);
  }
}
