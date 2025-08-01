package com.blueshine.smartshop.SmartShop.repository;

import com.blueshine.smartshop.SmartShop.model.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ShopRepository extends JpaRepository <Shop, String> {
    Optional<Object> findByname(String name);
    // Additional query methods can be defined here if needed
}
