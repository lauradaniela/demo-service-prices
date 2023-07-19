package com.demo.price.infrastructure.output.persistence.brand;

import com.demo.price.infrastructure.output.persistence.price.PriceEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Getter
@Builder(setterPrefix = "with")
@AllArgsConstructor
@Table(name="brand")
public class BrandEntity {

    @Id
    @Column(name = "id", updatable = false, nullable = false)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "brand")
    private List<PriceEntity> prices;
}
