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
import com.Alex.Forest.Entity.Entry;
import com.Alex.Forest.service.EntryService;


@RestController
@RequestMapping("/4est/Entry")
public class EntryController {
  @Autowired
  private EntryService entryService;
  
  private EntryController(EntryService entryService) {
    super();
    this.entryService = entryService;
  }
  
  //create a entry instance API
  @PostMapping()
  public ResponseEntity<Entry> saveEntry(@RequestBody Entry entry){
    return new ResponseEntity<Entry>(entryService.saveEntry(entry),HttpStatus.CREATED); 
  }
  
  //Read all entry instances API
  @GetMapping
  public List<Entry> getAllEntryss(){
    return entryService.getAllEntries();
  }
  
  //Get entry instance by Id
  @GetMapping("{Entry_ID}")
  public ResponseEntity<Entry> getEntryById(@PathVariable("Entry_ID") int id){
    return new ResponseEntity<Entry>(entryService.getEntryById(id), HttpStatus.OK);
  }
  
  //updating or putting entry instance by id
  @PutMapping("{Entry_ID}")
  public ResponseEntity<Entry> updateEntry(@PathVariable("Entry_ID") int id, @RequestBody Entry entry){
    return new ResponseEntity<Entry>(entryService.UpdateEntry(entry, id), HttpStatus.OK);
  }
  
  //Deleting entry instance by id
  @DeleteMapping("{Entry_ID}")
  public ResponseEntity<String> deleteEntry(@PathVariable("Entry_ID") int id){
    entryService.deleteEntry(id);
    return new ResponseEntity<String>("Entry Instance Deleted", HttpStatus.OK);
  }
}
