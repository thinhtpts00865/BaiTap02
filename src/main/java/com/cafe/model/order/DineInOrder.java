package com.cafe.model.order;

import com.cafe.model.MenuItem;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
public class DineInOrder extends Order {
    private int tableNumber;

    public DineInOrder(int tableNumber) {
        if (tableNumber <= 0) {
            throw new IllegalArgumentException();
        }
        this.tableNumber = tableNumber;
    }

    public void setTableNumber(int tableNumber) {
        if (tableNumber <= 0) {
            throw new IllegalArgumentException();
        }
        this.tableNumber = tableNumber;
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
        System.out.println("Số bàn: " + tableNumber);
        displayBill();
    }
}