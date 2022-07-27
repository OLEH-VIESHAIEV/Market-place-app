package com.example.marketplaceapp.config;

import com.example.marketplaceapp.model.Product;
import com.example.marketplaceapp.model.User;
import com.example.marketplaceapp.service.ProductService;
import com.example.marketplaceapp.service.UserService;
import java.math.BigDecimal;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {
    private final ProductService productService;
    private final UserService userService;

    public DataInitializer(ProductService productService, UserService userService) {
        this.productService = productService;
        this.userService = userService;
    }

    @PostConstruct
    public void inject() {
        Product phone = new Product();
        phone.setName("iPhone 11 Pro");
        phone.setPrice(BigDecimal.valueOf(1399));
        productService.save(phone);

        Product tv = new Product();
        tv.setName("Apple TV 4K");
        tv.setPrice(BigDecimal.valueOf(1999));
        productService.save(tv);

        Product macintosh = new Product();
        macintosh.setName("Mac Book Pro 16");
        macintosh.setPrice(BigDecimal.valueOf(2599));
        productService.save(macintosh);

        User bob = new User();
        bob.setFirstName("Bob");
        bob.setLastName("Dylan");
        bob.setAmountOfMoney(BigDecimal.valueOf(2500));
        userService.save(bob);

        User richie = new User();
        richie.setFirstName("Richie");
        richie.setLastName("Sambora");
        richie.setAmountOfMoney(BigDecimal.valueOf(15000));
        userService.save(richie);

        User robert = new User();
        robert.setFirstName("Robert");
        robert.setLastName("Plant");
        robert.setAmountOfMoney(BigDecimal.valueOf(9000));
        userService.save(robert);
    }
}
