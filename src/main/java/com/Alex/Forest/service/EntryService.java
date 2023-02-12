package com.Alex.Forest.service;

import java.util.List;
import com.Alex.Forest.Entity.Entry; 

public interface EntryService {

  //post an Entry
  public Entry saveEntry(Entry entry);
  
  //get all Entries
  public List<Entry> getAllEntries();
  
  //get Entry by ID
  public Entry getEntryById(int id);
  
  //update Entry
  public Entry UpdateEntry(Entry entry, int id);
  
  //Delete Entry
  public void deleteEntry(int id);
  
}
