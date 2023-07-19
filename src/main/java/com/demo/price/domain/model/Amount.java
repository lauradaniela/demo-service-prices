package com.demo.price.domain.model;

import lombok.Builder;
import lombok.Getter;

import java.util.Currency;

@Getter
@Builder
public class Amount {

    private Long value;

    private Currency currency;
}
