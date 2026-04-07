package com.cafe.model.order;

import com.cafe.model.MenuItem;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
public abstract class Order {
    protected List<MenuItem> items = new ArrayList<>();

    /**
     * Tính tổng giá trị hóa đơn (Order)
     */
    public abstract double calculateTotal();

    /**
     * Hiển thị thông tin toàn bộ hóa đơn (Order)
     */
    public abstract void displayInfo();

    /**
     * Thêm sản phẩm vào hóa đơn (Order)
     */
    public void addItem(MenuItem item) {
        if (item != null && item.getName() != null && item.getPrice() >= 0) {
            items.add(item);
        } else {
            System.out.println("Lỗi thêm sản phẩm!");
        }
    }

    /**
     * Hiển thị thông tin chung hóa đơn (Order)
     */
    public void displayBill() {
        System.out.println("-------------- Hóa đơn --------------");
        for (int i = 0; i < items.size(); i++) {
            System.out.println(" " + (i + 1) + ". Tên món: " + items.get(i).getName());
            System.out.print("\tThành tiền: " + String.format("%,.0f VNĐ", items.get(i).getPrice()) + "\n");
        }
        System.out.println("-------------------------------------");
        System.out.println("Tổng tiền: " + String.format("%,.0f VNĐ", calculateTotal()));
    }
}