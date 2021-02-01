package com.chootay.controllers;

import com.chootay.dtos.SalesReport_DTO;
import com.chootay.services.SalesReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sales-report")
public class SalesReportController {
    @Autowired
    private SalesReportService salesReportService;

    @GetMapping("/daily")
    public List<SalesReport_DTO> getTodaysSalesReport(){
        return salesReportService.dailySalesReport();
    }

    @GetMapping("/monthly")
    public List<SalesReport_DTO> getThisMonthSalesReport(){
        return salesReportService.monthlySalesReport();
    }
}
