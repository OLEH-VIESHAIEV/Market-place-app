package com.example.marketplaceapp.service;

import com.example.marketplaceapp.model.Product;
import java.util.List;

public interface ProductService {
    Product save(Product product);

    Product getById(Long id);

    List<Product> getAll();

    void delete(Long id);

    List<Product> getAllProductsByUserId(Long id);
}
