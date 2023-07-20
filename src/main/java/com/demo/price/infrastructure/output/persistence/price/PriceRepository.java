package com.demo.price.infrastructure.output.persistence.price;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface PriceRepository extends JpaRepository<PriceEntity, Long> {

    @Query( nativeQuery = true,
            value = "SELECT * FROM price p where p.product_id = ?1 and p.brand_id = ?2 and p.end_date >= ?3 and p.start_date <= ?3")
    List<PriceEntity> findPrice(Long productId, Integer brandId, LocalDateTime applicationDate);
}
