package com.example.marketplaceapp.service.impl;

import com.example.marketplaceapp.model.Product;
import com.example.marketplaceapp.model.User;
import com.example.marketplaceapp.repository.ProductRepository;
import com.example.marketplaceapp.repository.UserRepository;
import com.example.marketplaceapp.service.UserService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    public UserServiceImpl(UserRepository userRepository,
                           ProductRepository productRepository) {
        this.userRepository = userRepository;
        this.productRepository = productRepository;
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getById(Long id) {
        return userRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Couldn't get user by user id " + id));
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User buyProduct(Long userId, Long productId) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new RuntimeException("Couldn't get user by user id " + userId));
        Product product = productRepository.findById(productId).orElseThrow(
                () -> new RuntimeException("Couldn't get product by product id " + productId));
        if (product.getPrice().compareTo(user.getAmountOfMoney()) > 0) {
            throw new RuntimeException("You have no enough money for buying this product");
        } else {
            user.setAmountOfMoney(user.getAmountOfMoney().subtract(product.getPrice()));
            List<Product> products = user.getProducts();
            products.add(product);
            user.setProducts(products);
            userRepository.save(user);
        }
        return user;
    }

    @Override
    public List<User> getAllUsersByProductId(Long id) {
        Product product = productRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Couldn't get product by product id " + id));
        List<User> users = userRepository
                .findAll()
                .stream()
                .filter(u -> u.getProducts().contains(product))
                .collect(Collectors.toList());
        return users;
    }
}
