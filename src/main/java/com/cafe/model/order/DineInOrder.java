package com.cafe.model.order;

import com.cafe.model.MenuItem;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class DineInOrder extends Order {
    private int tableNumber;

    @Override
    public boolean isValid() {
        return tableNumber > 0;
    }

    @Override
    public double calculateTotal() {
        double total = 0.0;
        for (MenuItem item : items) {
            total += item.getPrice();
        }
        return total;
    }

    @Override
    public void displayInfo() {
        System.out.println("\t\tĐƠN DÙNG TẠI CHỖ");
        if (tableNumber > 0) {
            System.out.println("Số bàn: " + tableNumber);
            displayBill();
        } else {
            System.out.println("Số bàn không hợp lệ!");
        }
    }
}