package com.blueshine.smartshop.SmartShop.service;

import com.blueshine.smartshop.SmartShop.dto.ProductNearbyDTO;
import com.blueshine.smartshop.SmartShop.repository.ProductRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductNearbyDTO> getProductsNearUser(double userLat, double userLon) {
        double radiusKm = 5.0; // 5 km
        return productRepository.findProductsNearLocation(userLat, userLon, radiusKm);
    }
}
