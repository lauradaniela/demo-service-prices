package com.demo.price.infrastructure.output.persistence.price;

import com.demo.price.domain.model.Amount;
import com.demo.price.domain.model.Price;
import com.demo.price.infrastructure.output.persistence.brand.BrandCoverter;
import com.demo.price.infrastructure.output.persistence.product.ProductConverter;

import java.math.BigDecimal;
import java.util.Currency;

public class PriceConverter {

    public static Price toPrice(final PriceEntity priceEntity) {
        return Price.builder()
                .id(priceEntity.getId())
                .amount(getAmount(priceEntity.getValue(), priceEntity.getCurrency()))
                .priority(priceEntity.getPriority())
                .startDate(priceEntity.getStartDate())
                .endDate(priceEntity.getEndDate())
                .brand(BrandCoverter.toBrand(priceEntity.getBrand()))
                .product(ProductConverter.toProduct(priceEntity.getProduct()))
                .build();
    }

    private static Amount getAmount(final BigDecimal value,
                                    final String codeCurrency) {
        return Amount.builder()
                .currency(Currency.getInstance(codeCurrency))
                .value(value)
                .build();
    }
}
