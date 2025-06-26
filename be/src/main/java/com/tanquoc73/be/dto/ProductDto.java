package com.tanquoc73.be.dto;

import lombok.Data;
import java.time.LocalDateTime;
import java.util.Set;

@Data
public class ProductDto {
    private String id;
    private String name;
    private String description;
    private double price;
    private String brandId;
    private Set<ProductVariantDto> variants;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
