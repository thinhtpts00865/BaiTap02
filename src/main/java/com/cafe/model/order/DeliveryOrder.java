package com.cafe.model.order;

import com.cafe.model.MenuItem;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class DeliveryOrder extends Order {
    private String address;
    private double shippingFee;

    @Override
    public boolean isValid() {
        return calculateTotal() > 50000 && address != null;
    }

    @Override
    public double calculateTotal() {
        double total = 0.0;
        for (MenuItem item : items) {
            total += item.getPrice();
        }
        if (total < 50000) {
            return total;
        }
        return total + shippingFee;
    }

    @Override
    public void displayInfo() {
        System.out.println("\t\tĐƠN GIAO HÀNG");
        if (isValid()) {
            displayBill();
            System.out.println("Phí vận chuyển: " + String.format("%,.0f VNĐ", shippingFee));
            System.out.println("Địa chỉ: " + address);
        } else {
            System.out.println("Không đủ giá trị tối thiểu!");
        }
    }
}
