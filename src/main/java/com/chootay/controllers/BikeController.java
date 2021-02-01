package com.chootay.controllers;

import com.chootay.dtos.Bike_ReadDTO;
import com.chootay.dtos.Bike_WriteDTO;
import com.chootay.models.Bike;
import com.chootay.services.BikeService;
import com.chootay.services.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/bikes")
public class BikeController {
    @Autowired
    private BikeService bikeService;
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/")
    public List<Bike_ReadDTO> getBikes(){
        return bikeService.getBikes().stream()
                .map(n -> convertToReadDto(n))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public Bike_ReadDTO getBikeById(@PathVariable Integer id){
        return convertToReadDto(bikeService.getBikeById(id));
    }

    @PostMapping("/")
    public Bike_ReadDTO addBike(@RequestBody Bike_WriteDTO bike){
        return convertToReadDto(bikeService.addBike(bike));
    }

    @PutMapping("/{id}")
    public Bike_ReadDTO updateBike(@RequestBody Bike_WriteDTO bike, @PathVariable Integer id){
        return convertToReadDto(bikeService.updateBike(bike, id));
    }

    @DeleteMapping("/{id}")
    public String deleteBike(@PathVariable Integer id){
        return bikeService.deleteBike(id);
    }

    private Bike_ReadDTO convertToReadDto(Bike bike) {
        Bike_ReadDTO bikeDto = modelMapper.map(bike, Bike_ReadDTO.class);
        return bikeDto;
    }

}
