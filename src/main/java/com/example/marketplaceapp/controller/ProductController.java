package com.example.marketplaceapp.controller;

import com.example.marketplaceapp.dto.request.ProductRequestDto;
import com.example.marketplaceapp.dto.response.ProductResponseDto;
import com.example.marketplaceapp.mapper.ProductMapper;
import com.example.marketplaceapp.model.Product;
import com.example.marketplaceapp.service.ProductService;
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
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;
    private final ProductMapper productMapper;

    public ProductController(ProductService productService,
                             ProductMapper productMapper) {
        this.productService = productService;
        this.productMapper = productMapper;
    }

    @PostMapping
    @ApiOperation(value = "Create new product")
    public ProductResponseDto save(@RequestBody @Valid ProductRequestDto productRequestDto) {
        return productMapper.mapToDto(productService.save(
                productMapper.mapToModel(productRequestDto)));
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get product by id")
    public ProductResponseDto getById(@PathVariable Long id) {
        return productMapper.mapToDto(productService.getById(id));
    }

    @GetMapping
    @ApiOperation(value = "Get all products")
    public List<ProductResponseDto> getAll() {
        return productService
                .getAll()
                .stream()
                .map(productMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Update product by id")
    public ProductResponseDto update(@PathVariable Long id,
                                     @Valid @RequestBody ProductRequestDto productRequestDto) {
        Product product = productMapper.mapToModel(productRequestDto);
        product.setId(id);
        return productMapper.mapToDto(productService.save(product));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete product by id")
    public void delete(@PathVariable Long id) {
        productService.delete(id);
    }

    @GetMapping("/users/{id}")
    @ApiOperation(value = "Get all products by user id")
    public List<ProductResponseDto> getAllProductsByUserId(@PathVariable Long id) {
        return productService
                .getAllProductsByUserId(id)
                .stream()
                .map(productMapper::mapToDto)
                .collect(Collectors.toList());
    }
}
