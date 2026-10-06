package com.example.plAutoConsultant.repository;

import com.example.plAutoConsultant.model.Enquire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnquireRepo extends JpaRepository<Enquire, Long> {
    List<Enquire> findByVehicleId(Long id);
}
