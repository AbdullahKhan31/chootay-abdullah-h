package com.chootay.services;

import com.chootay.dtos.Customer_WriteDTO;
import com.chootay.models.Customer;
import com.chootay.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public Customer addCustomer(Customer_WriteDTO customer_writeDTO) {
        Customer customer = new Customer();
        customer.setName(customer_writeDTO.getName());
        customer.setEmail(customer_writeDTO.getEmail());
        return customerRepository.save(customer);
    }

    public Customer getCustomerById(Integer id) {
        return customerRepository.findById(id).orElse(null);
    }

    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    public Customer updateCustomer(Customer_WriteDTO customer_writeDTO, Integer id) {
        Customer existingCustomer = customerRepository.findById(id).orElse(null);
        existingCustomer.setName(customer_writeDTO.getName());
        existingCustomer.setEmail(customer_writeDTO.getEmail());

        return customerRepository.save(existingCustomer);
    }

    public String deleteCustomer(Integer id) {
        customerRepository.deleteById(id);
        return "Customer " + id + " deleted successfully!";
    }
}
