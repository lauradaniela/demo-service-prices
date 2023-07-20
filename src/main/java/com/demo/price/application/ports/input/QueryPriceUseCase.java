package com.demo.price.application.ports.input;

import com.demo.price.domain.model.Price;

import java.time.LocalDateTime;
import java.util.Optional;

public interface QueryPriceUseCase {

    Optional<Price> queryProductPrice(LocalDateTime applicationDate, Long productId, Integer brandId);

}
