package com.Alex.Forest.Entity;

import java.time.LocalDateTime;
import javax.persistence.Id;
import org.springframework.data.relational.core.mapping.Column;
import javax.persistence.Table;
import javax.persistence.Entity;
import lombok.Data;

@Data
@Entity
@Table(name="Moment")
public class Moment {
  
  @Id
  private LocalDateTime DTG;
  
  @Column(value= "Season")
  private String Season;
  @Column(value= "Plant_Growth_Phase")
  private String Plant_Growth_Phase;
  @Column(value= "Weather")
  private String Weather;
}
