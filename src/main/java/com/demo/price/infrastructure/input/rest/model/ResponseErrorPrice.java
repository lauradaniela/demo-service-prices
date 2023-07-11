package com.demo.price.infrastructure.input.rest.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ResponseErrorPrice {

    private final String error;
}
