package com.example.marketplaceapp.service;

import com.example.marketplaceapp.model.User;
import java.util.List;

public interface UserService {
    User save(User user);

    User getById(Long id);

    List<User> getAll();

    void delete(Long id);

    User buyProduct(Long userId, Long productId);

    List<User> getAllUsersByProductId(Long id);
}
