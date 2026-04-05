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

    public abstract boolean isValid();

    public abstract double calculateTotal();

    public abstract void displayInfo();

    public void addItem(MenuItem item) {
        if (item != null && item.getName() != null && item.getPrice() >= 0) {
            items.add(item);
        } else {
            System.out.println("Lỗi thêm sản phẩm!");
        }
    }

    public void displayBill() {
        System.out.println("-------------- Hóa đơn --------------");
        int i = 1;
        for (MenuItem item : items) {
            System.out.println(" " + i + ". Tên món: " + item.getName());
            System.out.print("\tThành tiền: " + String.format("%,.0f VNĐ", item.getPrice()) + "\n");
            i++;
        }
        System.out.println("-------------------------------------");
        System.out.println("Tổng tiền: " + String.format("%,.0f VNĐ", calculateTotal()));
    }
}