package com.blueshine.smartshop.SmartShop.controller;

import com.blueshine.smartshop.SmartShop.model.Product;
import com.blueshine.smartshop.SmartShop.model.Shop;
import com.blueshine.smartshop.SmartShop.repository.ShopRepository;
import com.blueshine.smartshop.SmartShop.service.ShopService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/shops")
public class ShopController {

    private final ShopService shopService;
    private final ShopRepository shopRepository;

    public ShopController(ShopService shopService, ShopRepository shopRepository) {
        this.shopService = shopService;
        this.shopRepository = shopRepository;
    }

    @PostMapping("/{shopId}/products")
    public Product addProduct(@PathVariable Long shopId, @RequestBody Product product) {
        return shopService.addProductToShop(shopId, product);
    }

    @GetMapping("/{shopId}")
    public Shop getShopById(@PathVariable Long shopId) {
        return shopRepository.findById(String.valueOf(shopId))
                .orElseThrow(() -> new RuntimeException("Shop not found"));
    }
    @GetMapping
    public Shop getShopByName(@RequestParam String name) {
        return (Shop) shopRepository.findByname(name)
                .orElseThrow(() -> new RuntimeException("Shop not found with name: " + name));
    }
}
