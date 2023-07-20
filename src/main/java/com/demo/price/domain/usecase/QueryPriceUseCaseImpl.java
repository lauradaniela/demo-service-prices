package com.demo.price.domain.usecase;

import com.demo.price.application.ports.input.QueryPriceUseCase;
import com.demo.price.application.ports.output.PriceOutput;
import com.demo.price.domain.model.Price;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.Optional;

@Service
@AllArgsConstructor
public class QueryPriceUseCaseImpl implements QueryPriceUseCase {

    private PriceOutput priceOutput;

    @Override
    public Optional<Price> queryProductPrice(LocalDateTime applicationDate, Long productId, Integer brandId) {
        return priceOutput.getPrice(applicationDate, productId, brandId).stream()
                .max(Comparator.comparing(Price::getPriority));
    }
}
