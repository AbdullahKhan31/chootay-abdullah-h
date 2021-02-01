package com.chootay.repositories;

import com.chootay.dtos.SalesReport_DTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class SalesReportRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    private static final String SQL_DailySalesReport = "(SELECT t.transaction_id as TransactionId, c.name as Customer,IFNULL(CONCAT('Bike: ', b.model), CONCAT('Sparepart: ', s.item)) as Item, IFNULL(b.price, s.price) as UnitPrice, t.quantity as Quantity, IFNULL(b.price * t.quantity, s.price* t.quantity) as TotalPrice, t.transaction_date as TransactionDate FROM transaction t LEFT JOIN customer c on t.customer_id = c.customer_id LEFT JOIN bike b on t.bike_id = b.bike_id LEFT JOIN sparepart s on t.sparepart_id = s.sparepart_id WHERE t.transaction_date = CURRENT_DATE) UNION (SELECT 0 as TransactionId, 'All' as Customer, 'All' as Item, IFNULL(SUM(IFNULL(b.price, s.price)), 0) as UnitPrice, IFNULL(SUM(t.quantity),0) as Quantity, IFNULL(SUM(IFNULL(b.price * t.quantity, s.price* t.quantity)),0) as TotalPrice, null as TransactionDate FROM transaction t LEFT JOIN customer c on t.customer_id = c.customer_id LEFT JOIN bike b on t.bike_id = b.bike_id LEFT JOIN sparepart s on t.sparepart_id = s.sparepart_id WHERE t.transaction_date = CURRENT_DATE)";

    private static final String SQL_MonthlySalesReport = "(SELECT t.transaction_id as Id, c.name as Customer, IFNULL(CONCAT('Bike: ', b.model), CONCAT('Sparepart: ', s.item)) as Item, IFNULL(b.price, s.price) as UnitPrice, t.quantity as Quantity, IFNULL(b.price * t.quantity, s.price* t.quantity) as TotalPrice, t.transaction_date as Date FROM transaction t LEFT JOIN customer c on t.customer_id = c.customer_id LEFT JOIN bike b on t.bike_id = b.bike_id LEFT JOIN sparepart s on t.sparepart_id = s.sparepart_id WHERE MONTH(t.transaction_date) = MONTH(CURRENT_DATE()) AND YEAR(t.transaction_date) = YEAR(CURRENT_DATE())) UNION (SELECT 0 as Id, 'All' as Customer, 'All' as Item, IFNULL(SUM(IFNULL(b.price, s.price)),0) as UnitPrice, IFNULL(SUM(t.quantity),0) as Quantity, IFNULL(SUM(IFNULL(b.price * t.quantity, s.price* t.quantity)),0) as TotalPrice, null as Date FROM transaction t LEFT JOIN customer c on t.customer_id = c.customer_id LEFT JOIN bike b on t.bike_id = b.bike_id LEFT JOIN sparepart s on t.sparepart_id = s.sparepart_id WHERE MONTH(t.transaction_date) = MONTH(CURRENT_DATE()) AND YEAR(t.transaction_date) = YEAR(CURRENT_DATE()))";


    public List<SalesReport_DTO> calculateDailySalesReport(){
        List<SalesReport_DTO> data = jdbcTemplate.query(SQL_DailySalesReport,
                new BeanPropertyRowMapper<SalesReport_DTO>(SalesReport_DTO.class));
        return data;
    }

    public List<SalesReport_DTO> calculateMonthlySalesReport(){
        List<SalesReport_DTO> data = jdbcTemplate.query(SQL_MonthlySalesReport,
                new BeanPropertyRowMapper<SalesReport_DTO>(SalesReport_DTO.class));
        return data;
    }

}
