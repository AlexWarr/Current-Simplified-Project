package com.Alex.Forest.service;

//import java.time.LocalDateTime;
import java.util.List;
import com.Alex.Forest.Entity.Location;
import com.Alex.Forest.exception.ResourceNotFoundException;
import com.Alex.Forest.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationServiceImp implements LocationService{

  private LocationRepository locationRepository;
  
  @Autowired
  public LocationServiceImp(LocationRepository locationRepository) {
    super();
    this.locationRepository = locationRepository;
  }
  //This CREATES
  @Override
  public Location saveLocation(Location location) {
    return locationRepository.save(location);
  }
  //this READS All
  @Override
  public List<Location> getAllLocations() {
    return locationRepository.findAll();
  }
  
  //this READS individually
  @Override
  public Location getLocationByName(String name) {
    return locationRepository.findById(name).orElseThrow(() -> 
    new ResourceNotFoundException("Location", "Name: ", name));
  }
  //this UPDATES
  @Override
  public Location UpdateLocation(Location location, String name) {
    Location existingLocation = locationRepository.findById(name).orElseThrow(() -> 
    new ResourceNotFoundException("Location", "Name: ", name));
    existingLocation.setElevation(location.getElevation());
    existingLocation.setGeography(location.getGeography());
    existingLocation.setGrowing_Zone(location.getGrowing_Zone());
    existingLocation.setVegetative_Zone(location.getVegetative_Zone());
    existingLocation.setLocation_Notes(location.getLocation_Notes());
    locationRepository.save(existingLocation);
    return existingLocation;
  }
  //this DELETES
  @Override
  public void deleteLocation(String name) {
    Location existingLocation = locationRepository.findById(name).orElseThrow(() -> 
    new ResourceNotFoundException("Location", "Name: ", name));
    locationRepository.deleteById(name);
  }
  
}
