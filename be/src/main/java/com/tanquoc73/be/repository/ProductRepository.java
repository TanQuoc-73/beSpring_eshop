package com.tanquoc73.be.repository;

import com.tanquoc73.be.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {
}
