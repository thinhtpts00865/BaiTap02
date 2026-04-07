package com.cafe;

import com.cafe.model.order.Order;

import java.util.ArrayList;
import java.util.List;

public class CafeSystem {
    private final List<Order> orders = new ArrayList<>();

    public void addOrder(Order order) {
        orders.add(order);
    }

    public void printAllOrders() {
        for (Order order : orders) {
            System.out.println("\n=====================================");
            order.displayInfo();
            System.out.println("=====================================");
        }
    }

    public double calculateTotalRevenue() {
        double totalRevenue = 0;
        for (Order order : orders) {
            totalRevenue += order.calculateTotal();
        }
        return totalRevenue;
    }
}