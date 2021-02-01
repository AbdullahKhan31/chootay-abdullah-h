package com.chootay.services;

import com.chootay.dtos.Sparepart_WriteDTO;
import com.chootay.models.Sparepart;
import com.chootay.repositories.SparepartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SparepartService {
    @Autowired
    private SparepartRepository sparepartRepository;

    public Sparepart addSparepart(Sparepart_WriteDTO sparepart_writeDTO) {
        Sparepart sparepart = new Sparepart();
        sparepart.setItem(sparepart_writeDTO.getItem());
        sparepart.setPrice(sparepart_writeDTO.getPrice());
        sparepart.setQuantity(sparepart_writeDTO.getQuantity());
        return sparepartRepository.save(sparepart);
    }

    public Sparepart getSparepartById(Integer id) {
        return sparepartRepository.findById(id).orElse(null);
    }

    public List<Sparepart> getSpareparts() {
        return sparepartRepository.findAll();
    }

    public Sparepart updateSparepart(Sparepart_WriteDTO sparepart_writeDTO, Integer id) {
        Sparepart existingSparepart = sparepartRepository.findById(id).orElse(null);
        existingSparepart.setItem(sparepart_writeDTO.getItem());
        existingSparepart.setPrice(sparepart_writeDTO.getPrice());
        existingSparepart.setQuantity(sparepart_writeDTO.getQuantity());

        return sparepartRepository.save(existingSparepart);
    }

    public String deleteSparepart(Integer id) {
        sparepartRepository.deleteById(id);
        return "Sparepart " + id + " deleted successfully!";
    }
}
