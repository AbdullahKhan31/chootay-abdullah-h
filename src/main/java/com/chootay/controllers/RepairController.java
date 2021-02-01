package com.chootay.controllers;

import com.chootay.dtos.Repair_ReadDTO;
import com.chootay.dtos.Repair_WriteDTO;
import com.chootay.models.Repair;
import com.chootay.services.RepairService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/repairs")
public class RepairController {
    @Autowired
    private RepairService repairService;
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/")
    public List<Repair_ReadDTO> getRepairs(){
        return repairService.getRepairs().stream()
                .map(n -> convertToReadDto(n))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public Repair_ReadDTO getRepairById(@PathVariable Integer id){
        return convertToReadDto(repairService.getRepairById(id));
    }

    @PostMapping("/")
    public Repair_ReadDTO addRepair(@RequestBody Repair_WriteDTO repair){
        return convertToReadDto(repairService.addRepair(repair));
    }

    @PutMapping("/{id}")
    public Repair_ReadDTO updateRepair(@RequestBody Repair_WriteDTO repair, @PathVariable Integer id){
        return convertToReadDto(repairService.updateRepair(repair, id));
    }

    @DeleteMapping("/{id}")
    public String deleteRepair(@PathVariable Integer id){
        return repairService.deleteRepair(id);
    }

    private Repair_ReadDTO convertToReadDto(Repair repair) {
        Repair_ReadDTO repairDto = modelMapper.map(repair, Repair_ReadDTO.class);
        return repairDto;
    }
}
