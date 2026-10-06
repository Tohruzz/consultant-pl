package com.example.plAutoConsultant.repository;

import com.example.plAutoConsultant.model.Sell;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellRepo extends JpaRepository<Sell,Long> {
}
