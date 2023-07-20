package com.demo.price.infrastructure.input.rest;

import com.demo.price.application.ports.input.QueryPriceUseCase;
import com.demo.price.domain.model.Price;
import com.demo.price.infrastructure.input.rest.model.RequestQueryPrice;
import com.demo.price.infrastructure.input.rest.model.ResponseQueryPrice;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Optional;

import static com.demo.price.infrastructure.input.rest.model.QueryPriceConverter.toResponseQueryPrice;

@AllArgsConstructor
@RestController
@CrossOrigin("*")
@RequestMapping("/prices")
public class PriceController {

    private QueryPriceUseCase queryPriceUseCase;

    @PostMapping
    public ResponseEntity<ResponseQueryPrice> queryPrices(@Valid @RequestBody RequestQueryPrice requestQueryPrice){

        Optional<Price> price = queryPriceUseCase.queryProductPrice(requestQueryPrice.getApplicationDate(),
                                            requestQueryPrice.getProductId(),
                                            requestQueryPrice.getBrandId());
        return price.map(value -> ResponseEntity.ok(toResponseQueryPrice(value))).orElseGet(() -> ResponseEntity.notFound().build());
    }

}
