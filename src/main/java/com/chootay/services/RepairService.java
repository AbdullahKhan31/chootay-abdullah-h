package com.chootay.services;

import com.chootay.dtos.Repair_WriteDTO;
import com.chootay.models.Customer;
import com.chootay.models.Repair;
import com.chootay.repositories.CustomerRepository;
import com.chootay.repositories.RepairRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.List;

@Service
@Transactional
public class RepairService {
    @Autowired
    private RepairRepository repairRepository;
    @Autowired
    private CustomerRepository customerRepository;

    public Repair addRepair(Repair_WriteDTO repair_writeDTO) {
        Repair repair = new Repair();
        repair.setCost(repair_writeDTO.getCost());
        repair.setDescription(repair_writeDTO.getDescription());
        repair.setRepairDate(repair_writeDTO.getRepairDate());
        Customer customer = customerRepository.findById(repair_writeDTO.getCustomer().getCustomer_id()).orElse(null);
        if( customer != null) {
            repair.setCustomer(customer);
        }else {
            Customer newCustomer = new Customer();
            newCustomer.setName(repair_writeDTO.getCustomer().getName());
            newCustomer.setEmail(repair_writeDTO.getCustomer().getEmail());
            repair.setCustomer(customerRepository.save(newCustomer));
        }
        return repairRepository.save(repair);
    }

    public Repair getRepairById(Integer id) {
        return repairRepository.findById(id).orElse(null);
    }

    public List<Repair> getRepairs() {
        return repairRepository.findAll();
    }

    public Repair updateRepair(Repair_WriteDTO repair_writeDTO, Integer id) {
        Repair existingRepair = repairRepository.findById(id).orElse(null);
        existingRepair.setCost(repair_writeDTO.getCost());
        existingRepair.setDescription(repair_writeDTO.getDescription());
        existingRepair.setRepairDate(repair_writeDTO.getRepairDate());
        Customer customer = customerRepository.findById(repair_writeDTO.getCustomer().getCustomer_id()).orElse(null);
        if( customer != null) {
            existingRepair.setCustomer(customer);
        }else {
            Customer newCustomer = new Customer();
            newCustomer.setName(repair_writeDTO.getCustomer().getName());
            newCustomer.setEmail(repair_writeDTO.getCustomer().getEmail());
            existingRepair.setCustomer(customerRepository.save(newCustomer));
        }
        return repairRepository.save(existingRepair);
    }

    public String deleteRepair(Integer id) {
        repairRepository.deleteById(id);
        return "Repair " + id + " deleted successfully!";
    }

}
