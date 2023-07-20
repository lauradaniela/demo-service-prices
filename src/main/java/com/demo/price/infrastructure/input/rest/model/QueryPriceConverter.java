package com.demo.price.infrastructure.input.rest.model;

import com.demo.price.domain.model.Amount;
import com.demo.price.domain.model.Price;

import java.text.NumberFormat;

public class QueryPriceConverter {

    public static ResponseQueryPrice toResponseQueryPrice(final Price price) {

        return ResponseQueryPrice.builder()
                .idProduct(price.getProduct().getId())
                .idBrand(price.getBrand().getId())
                .idPrice(price.getId())
                .startDate(price.getStartDate())
                .endDate(price.getEndDate())
                .amount(formatResponseAmount(price.getAmount()))
                .build();
    }

    private static String formatResponseAmount(Amount amount) {
        NumberFormat formatterAmount = NumberFormat.getCurrencyInstance();
        formatterAmount.setCurrency(amount.getCurrency());
        formatterAmount.setMaximumFractionDigits(2);
        formatterAmount.setMinimumFractionDigits(2);
        return formatterAmount.format(amount.getValue());
    }
}
