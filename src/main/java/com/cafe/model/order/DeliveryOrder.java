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
    public double calculateTotal() {
        double total = 0.0;
        for (MenuItem item : items) {
            total += item.getPrice();
        }
        // Giá trị tối thiểu phải lớn hơn 50K
        if (total < 50000) {
            throw new IllegalArgumentException();
        }
        return total + shippingFee;
    }

    @Override
    public void displayInfo() {
        System.out.println("\t\tĐƠN GIAO HÀNG");
        displayBill();
        System.out.println("Phí vận chuyển: " + String.format("%,.0f VNĐ", shippingFee));
        System.out.println("Địa chỉ: " + address);
    }
}
