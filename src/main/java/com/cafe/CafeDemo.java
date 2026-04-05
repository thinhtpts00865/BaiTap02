package com.cafe;

import com.cafe.model.MenuItem;
import com.cafe.model.order.*;

public class CafeDemo {
    static void main() {
        CafeSystem system = new CafeSystem();

        MenuItem coffee = new MenuItem("Cà phê sữa", 25000);
        MenuItem bread = new MenuItem("Bánh mì", 15000);
        MenuItem juice = new MenuItem("Nước ép cam", 25000);
        MenuItem boba = new MenuItem("Trà sữa", 35000);

        DineInOrder dineInOrder = new DineInOrder(1);
        dineInOrder.addItem(coffee);
        dineInOrder.addItem(bread);
        dineInOrder.addItem(boba);
        system.addOrder(dineInOrder);

        TakeawayOrder takeawayOrder = new TakeawayOrder("Anh Tuấn");
        takeawayOrder.addItem(juice);
        system.addOrder(takeawayOrder);

        DeliveryOrder deliveryOrder = new DeliveryOrder("123 Cách Mạng Tháng 8", 15000);
        deliveryOrder.addItem(coffee);
        deliveryOrder.addItem(boba);
        system.addOrder(deliveryOrder);

        system.printAllOrders();
        System.out.println("\nTỔNG DOANH THU HỆ THỐNG: " +
                String.format("%,.0f VNĐ", system.calculateTotalRevenue()));
    }
}