package com.demo.price.infrastructure.output.persistence.product;

import com.demo.price.infrastructure.output.persistence.price.PriceEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Getter
@AllArgsConstructor
@Table(name="product")
public class ProductEntity {

    @Id
    @Column(name = "id", updatable = false, nullable = false)
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "product")
    private List<PriceEntity> prices;
}
