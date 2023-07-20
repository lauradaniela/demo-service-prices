package com.demo.price.domain.model;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.Currency;

@Getter
@Builder
public class Amount {

    private BigDecimal value;

    private Currency currency;
}
