package com.demo.price.domain.usecase;

import com.demo.price.application.ports.output.PriceOutput;
import com.demo.price.domain.model.Amount;
import com.demo.price.domain.model.Brand;
import com.demo.price.domain.model.Price;
import com.demo.price.domain.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class QueryPriceUseCaseImplTest {

    private PriceOutput priceOutput;

    private QueryPriceUseCaseImpl queryPriceUseCase;

    @BeforeEach
    void init(){
        priceOutput = mock(PriceOutput.class);
        queryPriceUseCase = new QueryPriceUseCaseImpl(priceOutput);
    }

    @Test
    void givenExistingParametersWithUniqueValueInDBWhenQueryProductPriceThenReturnPrice(){

        //Given
        LocalDateTime applicationDate = LocalDateTime.now();
        Long productId = 1111L;
        Integer brandId = 1;

        List<Price> priceList = new ArrayList<>();
        Price price = Price.builder()
                .endDate(LocalDateTime.now().plusDays(30))
                .startDate(LocalDateTime.now().minusDays(30))
                .id(1L)
                .priority(0)
                .amount(Amount.builder()
                        .value(new BigDecimal("30.50"))
                        .currency(Currency.getInstance("EUR"))
                        .build())
                .product(Product.builder()
                        .id(productId)
                        .build())
                .brand(Brand.builder()
                        .id(brandId)
                        .build())
                .build();

        priceList.add(price);

        when(priceOutput.getPrice(applicationDate, productId, brandId)).thenReturn(priceList);

        //When
        Optional<Price> priceResponse = queryPriceUseCase.queryProductPrice(applicationDate, productId, brandId);

        //Then
        assertNotEquals(Optional.empty(), priceResponse);
        assertEquals(price.getStartDate(), priceResponse.get().getStartDate());
        assertEquals(price.getAmount(), priceResponse.get().getAmount());
        assertEquals(price.getEndDate(), priceResponse.get().getEndDate());
        assertEquals(price.getAmount(), priceResponse.get().getAmount());
    }

    @Test
    void givenNotExistingParametersInDBWhenQueryProductPriceThenReturnOptionalEmpty(){

        //Given
        LocalDateTime applicationDate = LocalDateTime.now();
        Long productId = 1111L;
        Integer brandId = 1;

        List<Price> priceList = new ArrayList<>();

        when(priceOutput.getPrice(applicationDate, productId, brandId)).thenReturn(priceList);

        //When
        Optional<Price> priceResponse = queryPriceUseCase.queryProductPrice(applicationDate, productId, brandId);

        //Then
        assertEquals(Optional.empty(), priceResponse);
    }

    @Test
    void givenExistingParametersWithMultipleValueInDBWhenQueryProductPriceThenReturnPriceWithHighestPriority(){

        //Given
        LocalDateTime applicationDate = LocalDateTime.now();
        Long productId = 1111L;
        Integer brandId = 1;

        List<Price> priceList = new ArrayList<>();
        Price price1 = Price.builder()
                .endDate(LocalDateTime.now().plusDays(30))
                .startDate(LocalDateTime.now().minusDays(30))
                .id(1L)
                .priority(0)
                .amount(Amount.builder()
                        .value(new BigDecimal("30.50"))
                        .currency(Currency.getInstance("EUR"))
                        .build())
                .product(Product.builder()
                        .id(productId)
                        .build())
                .brand(Brand.builder()
                        .id(brandId)
                        .build())
                .build();
        Price price2 = Price.builder()
                .endDate(LocalDateTime.now().plusDays(30))
                .startDate(LocalDateTime.now().minusDays(30))
                .id(1L)
                .priority(1)
                .amount(Amount.builder()
                        .value(new BigDecimal("30.50"))
                        .currency(Currency.getInstance("EUR"))
                        .build())
                .product(Product.builder()
                        .id(productId)
                        .build())
                .brand(Brand.builder()
                        .id(brandId)
                        .build())
                .build();

        priceList.add(price1);
        priceList.add(price2);

        when(priceOutput.getPrice(applicationDate, productId, brandId)).thenReturn(priceList);

        //When
        Optional<Price> priceResponse = queryPriceUseCase.queryProductPrice(applicationDate, productId, brandId);

        //Then
        assertNotEquals(Optional.empty(), priceResponse);
        assertEquals(price2.getStartDate(), priceResponse.get().getStartDate());
        assertEquals(price2.getAmount(), priceResponse.get().getAmount());
        assertEquals(price2.getEndDate(), priceResponse.get().getEndDate());
        assertEquals(price2.getAmount(), priceResponse.get().getAmount());
    }

}
