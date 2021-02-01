package com.chootay.services;

import com.chootay.dtos.Bike_ReadDTO;
import com.chootay.dtos.Bike_WriteDTO;
import com.chootay.models.Bike;
import com.chootay.repositories.BikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BikeService {
    @Autowired
    private BikeRepository bikeRepository;

    public Bike addBike(Bike_WriteDTO bike_writeDTO) {
        Bike bike = new Bike();
        bike.setModel(bike_writeDTO.getModel());
        bike.setPrice(bike_writeDTO.getQuantity());
        bike.setQuantity(bike_writeDTO.getQuantity());
        return bikeRepository.save(bike);
    }

    public Bike getBikeById(Integer id) {
        return bikeRepository.findById(id).orElse(null);
    }

    public List<Bike> getBikes() {
        return bikeRepository.findAll();
    }

    public Bike updateBike(Bike_WriteDTO bike_writeDTO, Integer id) {
        Bike existingBike = bikeRepository.findById(id).orElse(null);
        existingBike.setModel(bike_writeDTO.getModel());
        existingBike.setPrice(bike_writeDTO.getPrice());
        existingBike.setQuantity(bike_writeDTO.getQuantity());

        return bikeRepository.save(existingBike);
    }

    public String deleteBike(Integer id) {
        bikeRepository.deleteById(id);
        return "Bike " + id + " deleted successfully!";
    }

}