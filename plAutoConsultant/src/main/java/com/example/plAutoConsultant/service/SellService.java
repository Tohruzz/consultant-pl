package com.example.plAutoConsultant.service;

import com.example.plAutoConsultant.model.Sell;
import com.example.plAutoConsultant.repository.SellRepo;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SellService {
    private final SellRepo sellRepo;
    public SellService(SellRepo sellRepo){
        this.sellRepo = sellRepo;
    }
    public List<Sell> getAllSellReq() {
        return sellRepo.findAll();
    }

    public Sell getSellReqById(Long id) {
        return sellRepo.findById(id).orElse(null);
    }

    public Sell addSellReq(Sell sell) {
        return sellRepo.save(sell);
    }

    public void deleteSell(Long id) {
        sellRepo.deleteById(id);
    }
}
