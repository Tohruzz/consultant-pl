package com.example.plAutoConsultant.service;

import com.example.plAutoConsultant.model.Vehicle;
import com.example.plAutoConsultant.model.VehicleImage;
import com.example.plAutoConsultant.repository.VehicleImageRepo;
import com.example.plAutoConsultant.repository.VehicleRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class VehicleImageService {
    private final VehicleImageRepo vehicleImageRepo;
    private final VehicleRepository vehicleRepository;
    private final String uploadDir = "uploads/";
    public VehicleImageService(VehicleImageRepo vehicleImageRepo, VehicleRepository vehicleRepository){
        this.vehicleImageRepo = vehicleImageRepo;
        this.vehicleRepository = vehicleRepository;
    }
    public VehicleImage addImage(Long vehicleId, MultipartFile image) throws IOException {
        Vehicle vehicle = vehicleRepository.findById(vehicleId).orElse(null);

        if(vehicle == null){
            return null;
        }

        Files.createDirectories(Paths.get(uploadDir));

        Path path = Paths.get(uploadDir + image.getOriginalFilename());

        Files.write(path, image.getBytes());

        VehicleImage vehicleImage = new VehicleImage();

        vehicleImage.setVehicle(vehicle);
        vehicleImage.setImage(image.getOriginalFilename());

        return vehicleImageRepo.save(vehicleImage);
    }

    public List<VehicleImage> getImagesByVehicleId(Long vehicleId) {
        return vehicleImageRepo.findByVehicleId(vehicleId);
    }

    public VehicleImage getImageById(Long id) {
        return vehicleImageRepo.findById(id).orElse(null);
    }

    public VehicleImage updateImage(Long id, MultipartFile image) throws IOException {
        VehicleImage existingImage = vehicleImageRepo.findById(id).orElse(null);
        if(existingImage==null){
           return null;
        }
        Path oldPath = Paths.get(uploadDir + existingImage.getImage());
        Files.deleteIfExists(oldPath);
        Path newPath = Paths.get(uploadDir + image.getOriginalFilename());
        Files.write(newPath, image.getBytes());
        existingImage.setImage(image.getOriginalFilename());
        return vehicleImageRepo.save(existingImage);
    }

    public void deleteImage(Long id) throws IOException{
        VehicleImage vehicleImage = vehicleImageRepo.findById(id).orElse(null);
        if(vehicleImage!=null){
            Path path = Paths.get(uploadDir + vehicleImage.getImage());
            Files.deleteIfExists(path);
            vehicleImageRepo.deleteById(id);
        }
    }
}
