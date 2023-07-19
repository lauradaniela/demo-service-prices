package com.demo.price.domain.model;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class Price {

    private long id;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private Brand brand;

    private long productId;

    private int priority;

    private Amount amount;
}
