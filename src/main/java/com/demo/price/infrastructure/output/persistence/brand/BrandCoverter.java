package com.demo.price.infrastructure.output.persistence.brand;

import com.demo.price.domain.model.Brand;

public class BrandCoverter {

    public static Brand toBrand(final BrandEntity brandEntity) {
        return Brand.builder()
                .id(brandEntity.getId())
                .name(brandEntity.getName())
                .build();
    }
}
