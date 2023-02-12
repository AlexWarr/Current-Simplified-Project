package com.Alex.Forest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.Alex.Forest.Entity.Entry;

@Repository
public interface EntryRepository extends JpaRepository<Entry, Integer> {

}
