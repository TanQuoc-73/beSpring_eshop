package com.tanquoc73.be.service;

import com.tanquoc73.be.dto.BrandDto;
import com.tanquoc73.be.model.Brand;
import com.tanquoc73.be.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BrandService {
    @Autowired
    private BrandRepository brandRepository;

    public List<Brand> getAllBrands() {
        return brandRepository.findAll();
    }

    public Brand getBrandById(String id) {
        return brandRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Brand not found"));
    }

    public Brand createBrand(Brand brand) {
        return brandRepository.save(brand);
    }

    public Brand updateBrand(String id, BrandDto brandDto) {
        Brand brand = getBrandById(id);
        brand.setName(brandDto.getName());
        brand.setDescription(brandDto.getDescription());
        brand.setLogoUrl(brandDto.getLogoUrl());
        brand.setActive(brandDto.isActive());
        brand.setUpdatedAt(java.time.LocalDateTime.now());
        return brandRepository.save(brand);
    }

    public void deleteBrand(String id) {
        Brand brand = getBrandById(id);
        brandRepository.delete(brand);
    }
}
