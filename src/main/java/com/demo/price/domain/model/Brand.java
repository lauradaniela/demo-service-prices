package com.demo.price.domain.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Brand {

    private int id;

    private String name;
}
