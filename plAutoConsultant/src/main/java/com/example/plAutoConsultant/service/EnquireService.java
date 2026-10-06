package com.example.plAutoConsultant.service;

import com.example.plAutoConsultant.model.Enquire;
import com.example.plAutoConsultant.repository.EnquireRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnquireService {
    private final EnquireRepo enquireRepo;
    public EnquireService(EnquireRepo enquireRepo){
        this.enquireRepo = enquireRepo;
    }
    public List<Enquire> getAllEnquiries() {
        return enquireRepo.findAll();
    }

    public Enquire getEnquiryById(Long id) {
        return enquireRepo.findById(id).orElse(null);
    }

    public Enquire addEnquiry(Enquire enquire) {
        return enquireRepo.save(enquire);
    }

    public void deleteEnquiry(Long id) {
        enquireRepo.deleteById(id);
    }
}
