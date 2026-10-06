package com.example.plAutoConsultant.controller;

import com.example.plAutoConsultant.model.Sell;
import com.example.plAutoConsultant.service.SellService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/sellReq")
public class SellController {
    private final SellService sellService;
    public SellController(SellService sellService){
        this.sellService = sellService;
    }
    @GetMapping
    public List<Sell> getAllSellReq(){
        return sellService.getAllSellReq();
    }
    @GetMapping("/{id}")
    public Sell getSellReqById(@PathVariable Long id){
        return sellService.getSellReqById(id);
    }
    @PostMapping
    public Sell addSellReq(@RequestBody Sell sell){
        return sellService.addSellReq(sell);
    }
    @DeleteMapping("/{id}")
    public String deleteSell(@PathVariable Long id){
         sellService.deleteSell(id);
         return "Deleted successfullyy";
    }

}
