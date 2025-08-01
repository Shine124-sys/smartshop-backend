package com.blueshine.smartshop.SmartShop.service;



import com.blueshine.smartshop.SmartShop.model.User;
import com.blueshine.smartshop.SmartShop.model.Shop;
import com.blueshine.smartshop.SmartShop.repository.UserRepository;
import com.blueshine.smartshop.SmartShop.repository.ShopRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final ShopRepository shopRepository;

    public UserService(UserRepository userRepository, ShopRepository shopRepository) {
        this.userRepository = userRepository;
        this.shopRepository = shopRepository;
    }

    // Create a new user
    public User createUser(User user) {
        return userRepository.save(user);
    }

    // Get a user by ID
    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }

    // Get all users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Assign a shop to a user
    public Shop assignShopToUser(Long userId, Shop shop) {
        User user = getUserById(userId);

        if (user.getShop() != null) {
            throw new RuntimeException("User already owns a shop");
        }

        shop.setOwner(user);
        user.setShop(shop);

        shopRepository.save(shop);
        return shop;
    }

    // Delete user
    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new RuntimeException("User not found with id: " + id);
        }
        userRepository.deleteById(id);
    }
}

