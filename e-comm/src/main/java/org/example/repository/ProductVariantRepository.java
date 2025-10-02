package org.example.repository;

import org.example.entity.ProductVariantEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductVariantRepository extends JpaRepository<ProductVariantEntity,Integer> {
}
