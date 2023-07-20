package com.demo.price.domain.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Product {

    private Long id;

    private String name;
}
