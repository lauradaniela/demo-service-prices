package com.demo.price.domain.model;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@Builder
public class Price {

    public static final DateTimeFormatter FORMAT_TIME_PRICE = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private Long id;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private Brand brand;

    private Product product;

    private Integer priority;

    private Amount amount;

}
