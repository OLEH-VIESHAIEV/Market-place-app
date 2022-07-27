package com.example.marketplaceapp.dto.response;

import com.example.marketplaceapp.model.Product;
import java.math.BigDecimal;
import java.util.List;
import lombok.Data;

@Data
public class UserResponseDto {
    private Long id;
    private String firstName;
    private String lastName;
    private BigDecimal amountOfMoney;
    private List<Product> products;
}
