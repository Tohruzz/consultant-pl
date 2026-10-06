package com.example.plAutoConsultant.service;

import com.example.plAutoConsultant.model.Enquire;
import com.example.plAutoConsultant.model.Vehicle;
import com.example.plAutoConsultant.model.VehicleImage;
import com.example.plAutoConsultant.repository.EnquireRepo;
import com.example.plAutoConsultant.repository.VehicleImageRepo;
import com.example.plAutoConsultant.repository.VehicleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleService {
    private final VehicleRepository vehicleRepository;
    private final VehicleImageRepo vehicleImageRepo;
    private final EnquireRepo enquireRepo;
    public VehicleService(VehicleRepository vehicleRepository, VehicleImageRepo vehicleImageRepo, EnquireRepo enquireRepo){

        this.vehicleRepository = vehicleRepository;
        this.vehicleImageRepo = vehicleImageRepo;
        this.enquireRepo = enquireRepo;
    }
    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    public Vehicle addVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    public Optional<Vehicle> getVehicleById(Long id) {
        return vehicleRepository.findById(id);
    }

    public void deleteVehicle(Long id) {
        List<Enquire> enquiries = enquireRepo.findByVehicleId(id);
        enquireRepo.deleteAll(enquiries);
        List<VehicleImage> images = vehicleImageRepo.findByVehicleId(id);
        vehicleImageRepo.deleteAll(images);
        vehicleRepository.deleteById(id);
    }

    public Vehicle updateVehicle(Long id, Vehicle vehicle) {
        Vehicle existingVehicle = vehicleRepository.findById(id).orElse(null);
        if(existingVehicle!=null){
            existingVehicle.setBrand(vehicle.getBrand());
            existingVehicle.setModel(vehicle.getModel());
            existingVehicle.setPrice(vehicle.getPrice());
            existingVehicle.setYear(vehicle.getYear());
            existingVehicle.setKmDriven(vehicle.getKmDriven());
            existingVehicle.setDescription(vehicle.getDescription());
            existingVehicle.setCategory(vehicle.getCategory());
            return vehicleRepository.save(existingVehicle);
        }
        return null;
    }

    public List<Vehicle> getVehiclesByCategory(String category) {
        return vehicleRepository.findByCategory(category);
    }
}
