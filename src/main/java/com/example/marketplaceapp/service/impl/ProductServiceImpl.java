package com.example.marketplaceapp.service.impl;

import com.example.marketplaceapp.model.Product;
import com.example.marketplaceapp.model.User;
import com.example.marketplaceapp.repository.ProductRepository;
import com.example.marketplaceapp.repository.UserRepository;
import com.example.marketplaceapp.service.ProductService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    public ProductServiceImpl(ProductRepository productRepository,
                              UserRepository userRepository) {
        this.productRepository = productRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product getById(Long id) {
        return productRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Couldn't get product by id " + id));
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<Product> getAllProductsByUserId(Long id) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Couldn't get user by id " + id));
        return user.getProducts();
    }
}
