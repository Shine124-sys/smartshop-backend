package com.blueshine.smartshop.SmartShop.repository;

import com.blueshine.smartshop.SmartShop.dto.ProductNearbyDTO;
import com.blueshine.smartshop.SmartShop.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT new com.blueshine.smartshop.SmartShop.dto.ProductNearbyDTO(" +
            "s.name, s.latitude, s.longitude, s.phone, p.name, p.imageUrl, p.price) " +
            "FROM Product p JOIN p.shop s " +
            "WHERE (6371 * acos(cos(radians(:userLat)) * cos(radians(s.latitude)) " +
            "* cos(radians(s.longitude) - radians(:userLon)) + sin(radians(:userLat)) * sin(radians(s.latitude)))) <= :radius")
    List<ProductNearbyDTO> findProductsNearLocation(
            @Param("userLat") double userLat,
            @Param("userLon") double userLon,
            @Param("radius") double radius);
}
