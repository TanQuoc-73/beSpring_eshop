package com.tanquoc73.be.dto;

import lombok.Data;
import java.time.LocalDateTime;
import java.util.Map;

@Data
public class ProductVariantDto {
    private String id;
    private String productId;
    private String sku;
    private double price;
    private int stock;
    private Map<String, String> attributes;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
