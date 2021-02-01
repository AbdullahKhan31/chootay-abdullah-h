package com.chootay.controllers;

import com.chootay.dtos.Customer_ReadDTO;
import com.chootay.dtos.Customer_WriteDTO;
import com.chootay.models.Customer;
import com.chootay.services.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/")
    public List<Customer_ReadDTO> getCustomers(){
        return customerService.getCustomers().stream()
                .map(n -> convertToReadDto(n))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public Customer_ReadDTO getCustomerById(@PathVariable Integer id){
        return convertToReadDto(customerService.getCustomerById(id));
    }

    @PostMapping("/")
    public Customer_ReadDTO addCustomer(@RequestBody Customer_WriteDTO customer){
        return convertToReadDto(customerService.addCustomer(customer));
    }

    @PutMapping("/{id}")
    public Customer_ReadDTO updateCustomer(@RequestBody Customer_WriteDTO customer, @PathVariable Integer id){
        return convertToReadDto(customerService.updateCustomer(customer, id));
    }

    @DeleteMapping("/{id}")
    public String deleteCustomer(@PathVariable Integer id){
        return customerService.deleteCustomer(id);
    }

    private Customer_ReadDTO convertToReadDto(Customer customer) {
        Customer_ReadDTO customerDto = modelMapper.map(customer, Customer_ReadDTO.class);
        return customerDto;
    }
}
