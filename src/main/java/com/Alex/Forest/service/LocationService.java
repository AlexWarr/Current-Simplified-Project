package com.Alex.Forest.service;

import java.util.List;
import com.Alex.Forest.Entity.Location;

public interface LocationService {

  //post a species
  public Location saveLocation(Location location);
  
  //get all species
  public List<Location> getAllLocations();
  
  //get species by Latin Name
  public Location getLocationByName(String name);
  
  //update
  public Location UpdateLocation(Location location, String name);
  
  //Delete (Just here for troubleshooting, species will not have a delete option readily available to user. They can delete only entries and plant instances
  public void deleteLocation(String Latin);
  
}
