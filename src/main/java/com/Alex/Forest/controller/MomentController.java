package com.Alex.Forest.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.Alex.Forest.Entity.Moment;
import com.Alex.Forest.service.MomentService;


@RestController
@RequestMapping("/4est/Moment")
public class MomentController {
  @Autowired
  private MomentService momentService;
  
  private MomentController(MomentService momentService) {
    super();
    this.momentService = momentService;
  }
  
  //create a moment instance API
  @PostMapping()
  public ResponseEntity<Moment> saveMoment(@RequestBody Moment moment){
    return new ResponseEntity<Moment>(momentService.saveMoment(moment), HttpStatus.CREATED); 
  }
  
  //Read all moment instances API
  @GetMapping
  public List<Moment> getAllMoments(){
    return momentService.getAllMoments();
  }
  
  //Get moment instance by Id
  @GetMapping("{DTG}")
  public ResponseEntity<Moment> getMomentById(@RequestParam(required = true)
  String dtg){
      DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
      LocalDateTime dateTime = LocalDateTime.parse(dtg, format);
    return new ResponseEntity<Moment>(momentService.getMomentById(dateTime), HttpStatus.OK);
  }
  
  //updating or putting moment instance by id
  @PutMapping("{DTG}")
  public ResponseEntity<Moment> updateMoment(@RequestParam(required = true)
  String dtg, @RequestBody Moment moment){
    DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    LocalDateTime dateTime = LocalDateTime.parse(dtg, format);
    return new ResponseEntity<Moment>(momentService.UpdateMoment(moment, dateTime), HttpStatus.OK);
  }
  
  //Deleting moment instance by id
  @DeleteMapping("{DTG}")
  public ResponseEntity<String> deleteMoment(@RequestParam(required = true)
  String dtg){
    DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    LocalDateTime dateTime = LocalDateTime.parse(dtg, format);
    momentService.deleteMoment(dateTime);
    return new ResponseEntity<String>("Moment Instance Deleted", HttpStatus.OK);
  }
}
