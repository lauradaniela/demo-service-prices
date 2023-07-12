package com.demo.price.infrastructure.input.rest.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
@JsonDeserialize(builder = ResponseQueryPrice.ResponseQueryPriceBuilder.class)
public class ResponseQueryPrice {

    private int idProduct;

    private int idBrand;

    private String price;

    private LocalDate startDate;

    private LocalDate endDate;
}
