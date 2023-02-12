package com.Alex.Forest.service;

import java.time.LocalDateTime;
import java.util.List;
import com.Alex.Forest.Entity.Moment;

public interface MomentService {

  //post a species
  public Moment saveMoment(Moment moment);
  
  //get all species
  public List<Moment> getAllMoments();
  
  //get species by Latin Name
  public Moment getMomentById(LocalDateTime dtg);
  
  //update
  public Moment UpdateMoment(Moment moment, LocalDateTime dtg);
  
  public void deleteMoment(LocalDateTime dtg);
  
}
