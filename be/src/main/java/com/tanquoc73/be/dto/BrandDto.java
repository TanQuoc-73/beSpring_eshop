package com.tanquoc73.be.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class BrandDto {
    private String id;
    private String name;
    private String description;
    private String logoUrl;
    private boolean isActive;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
