package com.tanquoc73.be.controller;

import com.tanquoc73.be.dto.BrandDto;
import com.tanquoc73.be.model.Brand;
import com.tanquoc73.be.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/brands")
public class BrandController {
    @Autowired
    private BrandService brandService;

    @GetMapping
    public List<Brand> getAllBrands() {
        return brandService.getAllBrands();
    }

    @GetMapping("/{id}")
    public Brand getBrandById(@PathVariable String id) {
        return brandService.getBrandById(id);
    }

    @PostMapping
    public Brand createBrand(@RequestBody BrandDto brandDto) {
        Brand brand = new Brand();
        brand.setName(brandDto.getName());
        brand.setDescription(brandDto.getDescription());
        brand.setLogoUrl(brandDto.getLogoUrl());
        brand.setActive(brandDto.isActive());
        brand.setCreatedAt(java.time.LocalDateTime.now());
        brand.setUpdatedAt(java.time.LocalDateTime.now());
        return brandService.createBrand(brand);
    }

    @PutMapping("/{id}")
    public Brand updateBrand(@PathVariable String id, @RequestBody BrandDto brandDto) {
        return brandService.updateBrand(id, brandDto);
    }

    @DeleteMapping("/{id}")
    public void deleteBrand(@PathVariable String id) {
        brandService.deleteBrand(id);
    }
}