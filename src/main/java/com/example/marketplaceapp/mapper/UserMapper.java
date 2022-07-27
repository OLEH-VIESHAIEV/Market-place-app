package com.example.marketplaceapp.mapper;

import com.example.marketplaceapp.dto.request.UserRequestDto;
import com.example.marketplaceapp.dto.response.UserResponseDto;
import com.example.marketplaceapp.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserResponseDto mapToDto(User user) {
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setId(user.getId());
        userResponseDto.setFirstName(user.getFirstName());
        userResponseDto.setLastName(user.getLastName());
        userResponseDto.setAmountOfMoney(user.getAmountOfMoney());
        if (user.getProducts() != null) {
            userResponseDto.setProducts(user.getProducts());
        }
        return userResponseDto;
    }

    public User mapToModel(UserRequestDto userRequestDto) {
        User user = new User();
        user.setFirstName(userRequestDto.getFirstName());
        user.setLastName(userRequestDto.getLastName());
        user.setAmountOfMoney(userRequestDto.getAmountOfMoney());
        return user;
    }
}
