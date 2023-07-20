package com.demo.price.infrastructure.input.rest.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
@JsonDeserialize(builder = ResponseQueryPrice.ResponseQueryPriceBuilder.class)
public class ResponseQueryPrice {

    private long idPrice;

    private String amount;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd-HH.mm.ss")
    private LocalDateTime startDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd-HH.mm.ss")
    private LocalDateTime endDate;

    private long idProduct;

    private int idBrand;
}
