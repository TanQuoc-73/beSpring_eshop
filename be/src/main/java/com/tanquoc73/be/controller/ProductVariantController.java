package com.tanquoc73.be.controller;

import com.tanquoc73.be.dto.ProductVariantDto;
import com.tanquoc73.be.model.Product;
import com.tanquoc73.be.model.ProductVariant;
import com.tanquoc73.be.repository.ProductRepository;
import com.tanquoc73.be.service.ProductVariantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/product-variants")
public class ProductVariantController {
    @Autowired
    private ProductVariantService productVariantService;
    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public List<ProductVariant> getAllVariants() {
        return productVariantService.getAllVariants();
    }

    @GetMapping("/{id}")
    public ProductVariant getVariantById(@PathVariable String id) {
        return productVariantService.getVariantById(id);
    }

    @PostMapping
    public ProductVariant createVariant(@RequestBody ProductVariantDto variantDto) {
        ProductVariant variant = new ProductVariant();
        Product product = productRepository.findById(String.valueOf(variantDto.getProductId()))
                .orElseThrow(() -> new RuntimeException("Product not found"));
        variant.setProduct(product);
        variant.setSku(variantDto.getSku());
        variant.setPrice(variantDto.getPrice());
        variant.setStock(variantDto.getStock());
        variant.setAttributes(variantDto.getAttributes());
        return productVariantService.createVariant(variant);
    }

    @PutMapping("/{id}")
    public ProductVariant updateVariant(@PathVariable String id, @RequestBody ProductVariantDto variantDto) {
        return productVariantService.updateVariant(id, variantDto);
    }

    @DeleteMapping("/{id}")
    public void deleteVariant(@PathVariable String id) {
        productVariantService.deleteVariant(id);
    }
}