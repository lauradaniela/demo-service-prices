package com.demo.price.infrastructure.output.persistence.price;

import com.demo.price.application.ports.output.PriceOutput;
import com.demo.price.domain.model.Price;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class PricePersistence implements PriceOutput {

    private PriceRepository priceRepository;
    @Override
    public List<Price> getPrice(LocalDateTime applicationDate, Long productId, Integer brandId) {

        return priceRepository.findPrice(productId, brandId, applicationDate)
                .stream().map(PriceConverter::toPrice)
                .collect(Collectors.toList());
    }
}
