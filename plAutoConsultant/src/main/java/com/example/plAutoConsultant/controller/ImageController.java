package com.example.plAutoConsultant.controller;

import com.example.plAutoConsultant.model.VehicleImage;
import com.example.plAutoConsultant.service.VehicleImageService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/images")
public class ImageController {
   private final VehicleImageService vehicleImageService;
   public ImageController(VehicleImageService vehicleImageService){
      this.vehicleImageService = vehicleImageService;
   }
   @PostMapping("/upload/{vehicleId}")
   public VehicleImage addImage(@PathVariable Long vehicleId, @RequestParam("image") MultipartFile image) throws IOException{
      return vehicleImageService.addImage(vehicleId, image);
   }
   @GetMapping("/vehicle/{vehicleId}")
   public List<VehicleImage> getImagesByVehicleId(@PathVariable Long vehicleId){
      return vehicleImageService.getImagesByVehicleId(vehicleId);
   }
   @GetMapping("/{id}")
   public VehicleImage getImageById(@PathVariable Long id) throws IOException {
      return vehicleImageService.getImageById(id);
   }
   @PutMapping("/{id}")
   public VehicleImage updateImage(@PathVariable Long id, @RequestParam("image") MultipartFile image) throws IOException{
      return vehicleImageService.updateImage(id, image);
   }
   @DeleteMapping("/{id}")
   public String deleteImage(@PathVariable Long id) throws IOException{
      vehicleImageService.deleteImage(id);
      return "Image deleted successfully";
   }
}
