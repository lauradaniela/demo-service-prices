package com.demo.price.infrastructure.input.rest;

import com.demo.price.domain.exception.PriceException;
import com.demo.price.infrastructure.input.rest.model.ResponseErrorPrice;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static org.springframework.http.ResponseEntity.badRequest;

@Slf4j
@Controller
public class PriceExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ResponseErrorPrice> handleThrowable(PriceException priceException) {
        logThrowable(priceException);
        ResponseErrorPrice response = ResponseErrorPrice.builder()
                .error(priceException.getMessage())
                .build();
        return badRequest().body(response);
    }

    private void logThrowable(Throwable throwable){
        log.error("Server threw {} \nWith message: [{}], \nAnd stack trace:",
                throwable.getClass().getName(),
                throwable.getMessage(),
                throwable);
    }
}
