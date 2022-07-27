package com.example.marketplaceapp.dto.request;

import java.math.BigDecimal;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import lombok.Data;

@Data
public class UserRequestDto {
    @NotNull
    @NotEmpty
    @Size(max = 45)
    private String firstName;
    @NotNull
    @NotEmpty
    @Size(max = 45)
    private String lastName;
    @NotNull
    @Positive
    @Digits(integer = 10, fraction = 2)
    private BigDecimal amountOfMoney;
}
