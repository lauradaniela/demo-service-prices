package com.demo.price.infrastructure.output.persistence.price;

import com.demo.price.infrastructure.output.persistence.brand.BrandEntity;
import com.demo.price.infrastructure.output.persistence.product.ProductEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Builder(setterPrefix = "with")
@AllArgsConstructor
@Entity
@Table(name = "price")
public class PriceEntity {

    @Id
    @Column(name = "id", insertable = false, updatable = false, nullable = false)
    private long id;

    @Column(nullable = false)
    private LocalDateTime startDate;

    @Column(nullable = false)
    private LocalDateTime endDate;

    @Column(nullable = false)
    private int priority;

    @Column(nullable = false)
    private BigDecimal value;

    @Column(nullable = false)
    private String currency;

    @ManyToOne
    @JoinColumn(name="brand_id", referencedColumnName = "id", nullable = false)
    private BrandEntity brand;

    @ManyToOne
    @JoinColumn(name="product_id", referencedColumnName = "id", nullable = false)
    private ProductEntity product;
}
