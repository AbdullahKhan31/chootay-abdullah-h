package com.chootay.services;

import com.chootay.dtos.Repair_WriteDTO;
import com.chootay.dtos.Transaction_WriteDTO;
import com.chootay.models.*;
import com.chootay.repositories.BikeRepository;
import com.chootay.repositories.CustomerRepository;
import com.chootay.repositories.SparepartRepository;
import com.chootay.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private BikeRepository bikeRepository;
    @Autowired
    private SparepartRepository sparepartRepository;

    public Transaction getTransactionById(Integer id) {
        return transactionRepository.findById(id).orElse(null);
    }

    public List<Transaction> getTransactions() {
        return transactionRepository.findAll();
    }

    public String deleteTransaction(Integer id) {
        transactionRepository.deleteById(id);
        return "Transaction " + id + " deleted successfully!";
    }

    public Transaction addTransaction(Transaction_WriteDTO transaction_writeDTO){
        Transaction transaction = new Transaction();
        transaction.setQuantity(transaction_writeDTO.getQuantity());
        transaction.setTransactionDate(transaction_writeDTO.getTransactionDate());
        Bike bike = bikeRepository.findById(transaction_writeDTO.getBike_id()).orElse(null);
        Sparepart sparepart = sparepartRepository.findById(transaction_writeDTO.getSparepart_id()).orElse(null);
        Customer customer = customerRepository.findById(transaction_writeDTO.getCustomer().getCustomer_id()).orElse(null);
        if(bike != null)
            transaction.setBike(bike);
        if(sparepart != null)
            transaction.setSparepart(sparepart);
        if( customer != null) {
            transaction.setCustomer(customer);
        }else {
            Customer newCustomer = new Customer();
            newCustomer.setName(transaction_writeDTO.getCustomer().getName());
            newCustomer.setEmail(transaction_writeDTO.getCustomer().getEmail());
            transaction.setCustomer(customerRepository.save(newCustomer));
        }
        return transactionRepository.save(transaction);
    }

    public Transaction updateTransaction(Transaction_WriteDTO transaction_writeDTO, Integer id){
        Transaction existingTransaction = transactionRepository.findById(id).orElse(null);
        existingTransaction.setQuantity(transaction_writeDTO.getQuantity());
        existingTransaction.setTransactionDate(transaction_writeDTO.getTransactionDate());
        Bike bike = bikeRepository.findById(transaction_writeDTO.getBike_id()).orElse(null);
        Sparepart sparepart = sparepartRepository.findById(transaction_writeDTO.getSparepart_id()).orElse(null);
        Customer customer = customerRepository.findById(transaction_writeDTO.getCustomer().getCustomer_id()).orElse(null);
        if(bike != null)
            existingTransaction.setBike(bike);
        if(sparepart != null)
            existingTransaction.setSparepart(sparepart);
        if( customer != null) {
            existingTransaction.setCustomer(customer);
        }else {
            Customer newCustomer = new Customer();
            newCustomer.setName(transaction_writeDTO.getCustomer().getName());
            newCustomer.setEmail(transaction_writeDTO.getCustomer().getEmail());
            existingTransaction.setCustomer(customerRepository.save(newCustomer));
        }
        return transactionRepository.save(existingTransaction);
    }


}
