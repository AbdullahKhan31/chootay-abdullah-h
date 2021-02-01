package com.chootay.services;

import com.chootay.dtos.SalesReport_DTO;
import com.chootay.repositories.SalesReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SalesReportService {
    @Autowired
    private SalesReportRepository salesReportRepository;

    public List<SalesReport_DTO> dailySalesReport(){
        return salesReportRepository.calculateDailySalesReport();
    }

    public List<SalesReport_DTO> monthlySalesReport(){
        return salesReportRepository.calculateMonthlySalesReport();
    }
}
