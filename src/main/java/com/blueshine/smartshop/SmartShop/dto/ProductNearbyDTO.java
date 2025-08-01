package com.blueshine.smartshop.SmartShop.dto;

public class ProductNearbyDTO {
    private String shopName;
    private double shopLatitude;
    private double shopLongitude;
    private String shopPhone;
    private String productName;
    private String productImage;
    private double productPrice;

    public ProductNearbyDTO(String shopName, double shopLatitude, double shopLongitude,
                            String shopPhone, String productName, String productImage, double productPrice) {
        this.shopName = shopName;
        this.shopLatitude = shopLatitude;
        this.shopLongitude = shopLongitude;
        this.shopPhone = shopPhone;
        this.productName = productName;
        this.productImage = productImage;
        this.productPrice = productPrice;
    }

    // getters
}

