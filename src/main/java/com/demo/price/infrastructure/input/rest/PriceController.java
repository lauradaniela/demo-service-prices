package com.demo.price.infrastructure.input.rest;

import com.demo.price.infrastructure.input.rest.model.RequestQueryPrice;
import com.demo.price.infrastructure.input.rest.model.ResponseQueryPrice;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@CrossOrigin("*")
@RequestMapping("/prices")
public class PriceController {

    @PostMapping
    public ResponseEntity<ResponseQueryPrice> queryPrices(@Valid @RequestBody RequestQueryPrice requestQueryPrice){
        return ResponseEntity.ok(new ResponseQueryPrice());
    }

}
