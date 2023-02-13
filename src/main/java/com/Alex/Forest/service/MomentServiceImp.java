package com.Alex.Forest.service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import com.Alex.Forest.Entity.Moment;
import com.Alex.Forest.exception.ResourceNotFoundException;
import com.Alex.Forest.repository.MomentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MomentServiceImp implements MomentService{

  private MomentRepository momentRepository;
  
  @Autowired
  public MomentServiceImp(MomentRepository momentRepository) {
    super();
    this.momentRepository = momentRepository;
  }
  //This CREATES
  @Override
  public Moment saveMoment(Moment moment) {
    LocalDateTime dtg = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);
    moment.setDTG(dtg);
    return momentRepository.save(moment);
  }
  //this READS All
  @Override
  public List<Moment> getAllMoments() {
    return momentRepository.findAll();
  }
  
  //this READS individually
  @Override
  public Moment getMomentById(LocalDateTime dtg) {
    return momentRepository.findById(dtg).orElseThrow(() -> 
    new ResourceNotFoundException("Moment", "Date Time Group:", dtg));
  }
  //this UPDATES
  @Override
  public Moment UpdateMoment(Moment moment, LocalDateTime dtg) {
    Moment existingMoment = momentRepository.findById(dtg).orElseThrow(() -> 
    new ResourceNotFoundException("Moment", "Date Time Group:", dtg));
    
    existingMoment.setDTG(dtg);
    existingMoment.setSeason(moment.getSeason());
    existingMoment.setPlant_Growth_Phase(moment.getPlant_Growth_Phase());
    existingMoment.setWeather(moment.getWeather());
    
    momentRepository.save(existingMoment);
    return existingMoment;
  }
  //this DELETES
  @Override
  public void deleteMoment(LocalDateTime dtg) {
    Moment existingMoment = momentRepository.findById(dtg).orElseThrow(() -> 
    new ResourceNotFoundException("Moment", "Date Time Group:", dtg));
    
    momentRepository.deleteById(dtg);

  }
}
