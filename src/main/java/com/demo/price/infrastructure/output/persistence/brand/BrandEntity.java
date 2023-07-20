package com.demo.price.infrastructure.output.persistence.brand;

import com.demo.price.infrastructure.output.persistence.price.PriceEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="brand")
public class BrandEntity {

    @Id
    @Column(name = "id", updatable = false, nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "brand")
    private List<PriceEntity> prices;
}
