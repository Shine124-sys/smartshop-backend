package com.blueshine.smartshop.SmartShop.controller;

import com.blueshine.smartshop.SmartShop.dto.ProductNearbyDTO;
import com.blueshine.smartshop.SmartShop.service.ProductService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/nearby")
    public List<ProductNearbyDTO> getNearbyProducts(
            @RequestParam double lat,
            @RequestParam double lon) {
        return productService.getProductsNearUser(lat, lon);
    }
}
