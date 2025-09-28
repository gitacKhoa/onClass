package org.example.model;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.example.model.Product.chargeMoney;

public class chargeOrder extends Order{
    private Product product = chargeMoney;

    public chargeOrder(long totalMoney, LocalDate orderDate, LocalTime orderTime) {
        super(totalMoney, orderDate, orderTime);
    }


}
