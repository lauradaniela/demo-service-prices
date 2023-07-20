package com.demo.price.infrastructure.output.persistence.product;

import com.demo.price.domain.model.Product;

public class ProductConverter {

    public static Product toProduct(final ProductEntity productEntity) {
        return Product.builder()
                .id(productEntity.getId())
                .name(productEntity.getName())
                .build();
    }
}
