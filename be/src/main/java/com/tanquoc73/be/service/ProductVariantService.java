package com.tanquoc73.be.service;

import com.tanquoc73.be.dto.ProductVariantDto;
import com.tanquoc73.be.model.Product;
import com.tanquoc73.be.model.ProductVariant;
import com.tanquoc73.be.repository.ProductRepository;
import com.tanquoc73.be.repository.ProductVariantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductVariantService {
    @Autowired
    private ProductVariantRepository productVariantRepository;
    @Autowired
    private ProductRepository productRepository;

    public List<ProductVariant> getAllVariants() {
        return productVariantRepository.findAll();
    }

    public ProductVariant getVariantById(String id) {
        return productVariantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product variant not found"));
    }

    public ProductVariant createVariant(ProductVariant variant) {
        return productVariantRepository.save(variant);
    }

    public ProductVariant updateVariant(String id, ProductVariantDto variantDto) {
        ProductVariant variant = getVariantById(id);
        Product product = productRepository.findById(String.valueOf(variantDto.getProductId()))
                .orElseThrow(() -> new RuntimeException("Product not found"));
        variant.setProduct(product);
        variant.setSku(variantDto.getSku());
        variant.setPrice(variantDto.getPrice());
        variant.setStock(variantDto.getStock());
        variant.setAttributes(variantDto.getAttributes());
        variant.setUpdatedAt(java.time.LocalDateTime.now());
        return productVariantRepository.save(variant);
    }

    public void deleteVariant(String id) {
        ProductVariant variant = getVariantById(id);
        productVariantRepository.delete(variant);
    }
}