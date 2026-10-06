package com.example.plAutoConsultant.controller;

import com.example.plAutoConsultant.model.Enquire;
import com.example.plAutoConsultant.service.EnquireService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/enquiries")
public class EnquireController {
    private final EnquireService enquireService;
    public EnquireController(EnquireService enquireService){
        this.enquireService = enquireService;
    }
    @GetMapping
    public List<Enquire> getAllEnquiries(){
        return enquireService.getAllEnquiries();
    }
    @GetMapping("/{id}")
    public Enquire getEnquiryById(@PathVariable Long id){
        return enquireService.getEnquiryById(id);
    }
    @PostMapping
    public Enquire addEnquiry(@RequestBody Enquire enquire){
        return enquireService.addEnquiry(enquire);
    }
    @DeleteMapping("/{id}")
    public String deleteEnquiry(@PathVariable Long id){
        enquireService.deleteEnquiry(id);
        return "Deleted successfully";
    }
}
