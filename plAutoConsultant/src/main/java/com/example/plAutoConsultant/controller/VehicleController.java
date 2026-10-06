package com.example.plAutoConsultant.controller;

import com.example.plAutoConsultant.model.Vehicle;
import com.example.plAutoConsultant.service.VehicleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {
   private final VehicleService vehicleService;
   public VehicleController(VehicleService vehicleService){
       this.vehicleService = vehicleService;
   }
   @GetMapping
    public List<Vehicle> getAllVehicles(){
       return vehicleService.getAllVehicles();
   }
   @PostMapping
    public Vehicle addVehicle(@RequestBody Vehicle vehicle){
       return vehicleService.addVehicle(vehicle);
   }
   @GetMapping("/{id}")
    public Optional<Vehicle> getVehicleById(@PathVariable Long id){
       return vehicleService.getVehicleById(id);
   }
   @DeleteMapping("/{id}")
    public String deleteVehicle(@PathVariable Long id){
       vehicleService.deleteVehicle(id);
       return "Vehicle deleted successfully";
   }
   @PutMapping("/{id}")
    public Vehicle updateVehicle(@PathVariable Long id, @RequestBody Vehicle vehicle){
       return vehicleService.updateVehicle(id,vehicle);
   }
   @GetMapping("/category/{category}")
    public List<Vehicle> getVehiclesByCategory(@PathVariable String category){
       return vehicleService.getVehiclesByCategory(category);
   }
}
