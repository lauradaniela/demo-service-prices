package com.demo.price.application.ports.output;

import com.demo.price.domain.model.Price;

import java.time.LocalDateTime;
import java.util.List;

public interface PriceOutput {

    List<Price> getPrice(LocalDateTime applicationDate, Long productId, Integer brandId);

}
