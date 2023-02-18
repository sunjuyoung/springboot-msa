package com.example.product.service;

import com.example.product.dto.ProductRequest;
import com.example.product.dto.ProductResponse;
import com.example.product.model.Product;
import com.example.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public void createProduct(ProductRequest request){
        Product product = Product.builder()
                .description(request.getDescription())
                .name(request.getName())
                .price(request.getPrice())
                .build();

        productRepository.save(product);
    }

    public List<ProductResponse> getAllProducts() {
        List<Product> products = productRepository.findAll();
        List<ProductResponse> productResponseList = products.stream()
                .map(product -> mapToProductResponse(product))
                .collect(Collectors.toList());
        return productResponseList;
    }

    private ProductResponse mapToProductResponse(Product product) {
        return ProductResponse.builder()
                .description(product.getDescription())
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .build();
    }
}
