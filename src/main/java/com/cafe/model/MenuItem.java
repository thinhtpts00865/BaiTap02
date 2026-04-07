package com.cafe.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MenuItem {
    private String name;
    private double price;

    public MenuItem(String name, double price) {
        this.name = name;
        if (price < 0) {
            throw new IllegalArgumentException("Price can't be negative");
        }
        this.price = price;
    }
}
