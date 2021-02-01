package com.chootay.controllers;

import com.chootay.dtos.Transaction_ReadDTO;
import com.chootay.dtos.Transaction_WriteDTO;
import com.chootay.models.Transaction;
import com.chootay.services.TransactionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/")
    public List<Transaction_ReadDTO> getTransactions(){
        return transactionService.getTransactions().stream()
                .map(n -> convertToReadDto(n))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public Transaction_ReadDTO getTransactionById(@PathVariable Integer id){
        return convertToReadDto(transactionService.getTransactionById(id));
    }

    @PostMapping("/")
    public Transaction_ReadDTO addTransaction(@RequestBody Transaction_WriteDTO transaction_writeDTO){
        return convertToReadDto(transactionService.addTransaction(transaction_writeDTO));
    }

    @PutMapping("/{id}")
    public Transaction_ReadDTO updateTransaction(@RequestBody Transaction_WriteDTO transaction_writeDTO, @PathVariable Integer id){
        return convertToReadDto(transactionService.updateTransaction(transaction_writeDTO, id));
    }

    @DeleteMapping("/{id}")
    public String deleteTransaction(@PathVariable Integer id){
        return transactionService.deleteTransaction(id);
    }

    private Transaction_ReadDTO convertToReadDto(Transaction transaction) {
        Transaction_ReadDTO transactionDto = modelMapper.map(transaction, Transaction_ReadDTO.class);
        return transactionDto;
    }
}
