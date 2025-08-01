package com.blueshine.smartshop.SmartShop.service;

import com.blueshine.smartshop.SmartShop.model.Product;
import com.blueshine.smartshop.SmartShop.model.Shop;
import com.blueshine.smartshop.SmartShop.repository.ProductRepository;
import com.blueshine.smartshop.SmartShop.repository.ShopRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

@Service
public class ShopService {

    private final ShopRepository shopRepository;
    private final ProductRepository productRepository;

    public ShopService(ShopRepository shopRepository, ProductRepository productRepository) {
        this.shopRepository = shopRepository;
        this.productRepository = productRepository;
    }

    @Transactional
    public Product addProductToShop(Long shopId, Product product) {
        Shop shop = shopRepository.findById(String.valueOf(shopId))
                .orElseThrow(() -> new RuntimeException("Shop not found"));
        product.setShop(shop);
        return productRepository.save(product);
    }
    @Transactional(readOnly = true)
    public Optional<Shop> getShopById(Long shopId) {
        return shopRepository.findById(String.valueOf(shopId));
    }
    @Transactional(readOnly = true)
    public Optional<Object> getShopByName(String name) {
        return shopRepository.findByname(name);
    }

}

