package com.example.marketplaceapp.controller;

import com.example.marketplaceapp.dto.request.UserRequestDto;
import com.example.marketplaceapp.dto.response.UserResponseDto;
import com.example.marketplaceapp.mapper.UserMapper;
import com.example.marketplaceapp.model.User;
import com.example.marketplaceapp.service.UserService;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;

    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @PostMapping
    @ApiOperation(value = "Create new user")
    public UserResponseDto save(@RequestBody @Valid UserRequestDto userRequestDto) {
        return userMapper.mapToDto(userService.save(userMapper.mapToModel(userRequestDto)));
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get user by id")
    public UserResponseDto getById(@PathVariable Long id) {
        return userMapper.mapToDto(userService.getById(id));
    }

    @GetMapping
    @ApiOperation(value = "Get all users")
    public List<UserResponseDto> getAll() {
        return userService
                .getAll()
                .stream()
                .map(userMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Update user by id")
    public UserResponseDto update(@PathVariable Long id,
                                  @Valid @RequestBody UserRequestDto userRequestDto) {
        User user = userMapper.mapToModel(userRequestDto);
        user.setId(id);
        return userMapper.mapToDto(userService.save(user));
    }

    @PutMapping("/{id}/buy")
    @ApiOperation(value = "Update user after buying product")
    public String buyProduct(@PathVariable Long id, @RequestParam Long productId) {
        userService.buyProduct(id, productId);
        return "Successful purchase!";
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete user by id")
    public void delete(@PathVariable Long id) {
        userService.delete(id);
    }

    @GetMapping("/products/{id}")
    @ApiOperation(value = "Get all users by product id")
    public List<UserResponseDto> getAllUsersByProductId(@PathVariable Long id) {
        return userService
                .getAllUsersByProductId(id)
                .stream()
                .map(userMapper::mapToDto)
                .collect(Collectors.toList());
    }
}
