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
public class TakeawayOrder extends Order {
    // Phí đóng gói
    private final double PACKAGING_FEE = 1.05;
    private String customerName;

    @Override
    public double calculateTotal() {
        double total = 0.0;
        for (MenuItem item : items) {
            total += item.getPrice();
        }
        return total * PACKAGING_FEE;
    }

    @Override
    public void displayInfo() {
        System.out.println("\t\t\tĐƠN MANG ĐI");
        System.out.println("Tên khách hàng: " + customerName);
        displayBill();
    }
}
