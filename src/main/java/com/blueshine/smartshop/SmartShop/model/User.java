package com.blueshine.smartshop.SmartShop.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    @Setter
    @Getter
    private String email;

    @OneToOne(mappedBy = "owner", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Shop shop;

    // getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }


    public Shop getShop() { return shop; }

    public void setShop(Shop shop) {
        this.shop = shop;
        if (shop != null) {
            shop.setOwner(this); // keep bidirectional sync
        }
    }

}
