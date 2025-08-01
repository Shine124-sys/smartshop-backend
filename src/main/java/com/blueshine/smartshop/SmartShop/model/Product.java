package com.blueshine.smartshop.SmartShop.model;

import jakarta.persistence.*;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    String id;
    String name;
    int quantity;
    double price;
    String description;
    String category;
    String imageUrl;



    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shop_id", nullable = false)
    private Shop shop;

    public Product(String id, String name, int quantity, double price, String description, String category, String imageUrl) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.description = description;
        this.category = category;
        this.imageUrl = imageUrl;

    }


    public Shop getShop() { return shop; }
    public void setShop(Shop shop) { this.shop = shop; }
}
