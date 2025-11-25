package org.example.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import static org.example.model.Product.pdArr;


public class ChargeOrder extends Order{
    private Product product = pdArr.get(0);

    public ChargeOrder(int userId,long totalMoney, LocalDateTime dateTime, LocalDate orderDate, LocalTime orderTime, boolean isPaid) {
        super(userId, totalMoney, dateTime, orderDate, orderTime, isPaid);
    }
}
