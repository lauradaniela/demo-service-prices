package com.demo.price.domain.model;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class Price {

    private Long id;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private Brand brand;

    private Product product;

    private Integer priority;

    private Amount amount;

}
