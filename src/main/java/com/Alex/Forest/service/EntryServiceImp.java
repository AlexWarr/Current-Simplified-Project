package com.Alex.Forest.service;

//import java.time.LocalDateTime;
import java.util.List;
import com.Alex.Forest.Entity.Entry;
import com.Alex.Forest.exception.ResourceNotFoundException;
import com.Alex.Forest.repository.EntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EntryServiceImp implements EntryService{

  private EntryRepository entryRepository;
  
  @Autowired
  public EntryServiceImp(EntryRepository entryRepository) {
    super();
    this.entryRepository = entryRepository;
  }
  //This CREATES
  @Override
  public Entry saveEntry(Entry entry) {
    return entryRepository.save(entry);
  }
  //this READS All
  @Override
  public List<Entry> getAllEntries() {
    return entryRepository.findAll();
  }
  
  //this READS individually
  @Override
  public Entry getEntryById(int id) {
    return entryRepository.findById(id).orElseThrow(() -> 
    new ResourceNotFoundException("Entry", "Id:", id));
  }
  //this UPDATES
  @Override
  public Entry UpdateEntry(Entry entry, int id) {
    Entry existingEntry = entryRepository.findById(id).orElseThrow(() -> 
    new ResourceNotFoundException("Entry", "Id:", id));
    existingEntry.setBody_Trunk_Stem_Description(
        entry.getBody_Trunk_Stem_Description());
    existingEntry.setBranch_Leaf_Pattern_Description(
        entry.getBranch_Leaf_Pattern_Description());
    existingEntry.setFlower_Fruit_Description(
        entry.getFlower_Fruit_Description());
    existingEntry.setPlant_Latin_Name(entry.getPlant_Latin_Name());
    existingEntry.setLocation_Name(entry.getLocation_Name());
    existingEntry.setDTG(entry.getDTG());
    entryRepository.save(existingEntry);
    return existingEntry;
  }
  //this DELETES
  @Override
  public void deleteEntry(int id) {
    Entry existingEntry = entryRepository.findById(id).orElseThrow(() -> 
    new ResourceNotFoundException("Entry", "Id:", id));
    
    entryRepository.deleteById(id);

  }
}
