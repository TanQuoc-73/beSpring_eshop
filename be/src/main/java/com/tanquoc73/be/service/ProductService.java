package com.tanquoc73.be.service;

import com.tanquoc73.be.dto.ProductDto;
import com.tanquoc73.be.model.Brand;
import com.tanquoc73.be.model.Product;
import com.tanquoc73.be.repository.BrandRepository;
import com.tanquoc73.be.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private BrandRepository brandRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(String id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(String id, ProductDto productDto) {
        Product product = getProductById(id);
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        Brand brand = brandRepository.findById(productDto.getBrandId())
                .orElseThrow(() -> new RuntimeException("Brand not found"));
        product.setBrand(brand);
        product.setUpdatedAt(java.time.LocalDateTime.now());
        return productRepository.save(product);
    }

    public void deleteProduct(String id) {
        Product product = getProductById(id);
        productRepository.delete(product);
    }
}