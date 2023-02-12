package com.Alex.Forest.repository;

import java.time.LocalDateTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.Alex.Forest.Entity.Moment;

@Repository
public interface MomentRepository extends JpaRepository<Moment, LocalDateTime> {

}
