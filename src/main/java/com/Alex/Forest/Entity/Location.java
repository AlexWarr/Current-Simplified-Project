package com.Alex.Forest.Entity;

import javax.persistence.Id;
import org.springframework.data.relational.core.mapping.Column;
import javax.persistence.Table;
import javax.persistence.Entity;
import lombok.Data;

@Data
@Entity
@Table(name="Location")
public class Location {
  
  @Id
  private String Location_Name;
  
  @Column(value = "Geography")
  private String Geography;
  
  @Column(value = "Vegetative_Zone")
  private String Vegetative_Zone;
  
  @Column(value = "Growing_Zone")
  private String Growing_Zone;
  
  @Column(value = "Elevation")
  private int Elevation;
  
  @Column(value = "Location_Notes")
  private String Location_Notes;


 /* public String getLocation_Name() {
    return Location_Name;
  }

  public void setLocation_Name(String location_Name) {
    Location_Name = location_Name;
  }

  public String getGeography() {
    return Geography;
  }

  public void setGeography(String geography) {
    Geography = geography;
  }

  public String getVegetative_Zone() {
    return Vegetative_Zone;
  }

  public void setVegetative_Zone(String vegetative_Zone) {
    Vegetative_Zone = vegetative_Zone;
  }

  public String getGrowing_Zone() {
    return Growing_Zone;
  }

  public void setGrowing_Zone(String growing_Zone) {
    Growing_Zone = growing_Zone;
  }

  public int getElevation() {
    return Elevation;
  }

  public void setElevation(int elevation) {
    Elevation = elevation;
  }

  public String getLocation_Notes() {
    return Location_Notes;
  }

  public void setLocation_Notes(String location_Notes) {
    Location_Notes = location_Notes;
  }
  
*/

  

}
