package com.chootay.controllers;

import com.chootay.dtos.Sparepart_ReadDTO;
import com.chootay.dtos.Sparepart_WriteDTO;
import com.chootay.models.Sparepart;
import com.chootay.services.SparepartService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/spareparts")
public class SparepartController {
    @Autowired
    private SparepartService sparepartService;
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/")
    public List<Sparepart_ReadDTO> getSpareparts(){
        return sparepartService.getSpareparts().stream()
                .map(n -> convertToReadDto(n))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public Sparepart_ReadDTO getSparepartById(@PathVariable Integer id){
        return convertToReadDto(sparepartService.getSparepartById(id));
    }

    @PostMapping("/")
    public Sparepart_ReadDTO addSparepart(@RequestBody Sparepart_WriteDTO sparepart){
        return convertToReadDto(sparepartService.addSparepart(sparepart));
    }

    @PutMapping("/{id}")
    public Sparepart_ReadDTO updateSparepart(@RequestBody Sparepart_WriteDTO sparepart, @PathVariable Integer id){
        return convertToReadDto(sparepartService.updateSparepart(sparepart, id));
    }

    @DeleteMapping("/{id}")
    public String deleteSparepart(@PathVariable Integer id){
        return sparepartService.deleteSparepart(id);
    }

    private Sparepart_ReadDTO convertToReadDto(Sparepart sparepart) {
        Sparepart_ReadDTO sparepartDto = modelMapper.map(sparepart, Sparepart_ReadDTO.class);
        return sparepartDto;
    }
}
