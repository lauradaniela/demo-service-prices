package com.demo.price.cucumber.stepDefs;

import com.demo.price.cucumber.CucumberSpringConfiguration;
import com.demo.price.infrastructure.input.rest.model.RequestQueryPrice;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;

@CucumberContextConfiguration
public class QueryTransactionsSteps extends CucumberSpringConfiguration {

    private RequestQueryPrice requestQueryPrice = new RequestQueryPrice();

    private ResponseEntity response;

    @Given("A request with application date {} with the product {} and brand {}")
    @Given("A request with values that not exists the prices with fields application date {} with the product {} and brand {}")
    @Given("A request without all mandatory fields application date {} with the product {} and brand {}")
    public void createRequest(final String applicationDate,
                              final String idProduct,
                              final String idBrand) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH.mm.ss");
        if (!applicationDate.equals("null") && !applicationDate.isEmpty()) {
            LocalDateTime dateTime = LocalDateTime.parse(applicationDate, formatter);
            requestQueryPrice.setApplicationDate(dateTime);
        }
        if (!idProduct.equals("null") && !idProduct.isBlank())
            requestQueryPrice.setProductId(Long.parseLong(idProduct));
        if (!idBrand.equals("null") && !idBrand.isBlank())
            requestQueryPrice.setBrandId(Integer.parseInt(idBrand));
    }

    @When("call the endpoint for check the prices")
    public void callEndpointPrices() {
        response = testRestTemplate.postForEntity("/prices", requestQueryPrice, String.class);
    }

    @Then("The system returns the status {int}")
    public void validateStatusResponse(final int codeResponse) {
        assertEquals(HttpStatus.valueOf(codeResponse), response.getStatusCode());
    }

    @And("the body response with the Price {} and application date between {} and {}")
    public void validateBodyResponseForSuccessfullyQuery(final String price,
                                                         final String startDate,
                                                         final String endDate) throws JSONException {


        String content = response.getBody().toString();
        JSONObject jsonResponse = new JSONObject(content);
        String amount = jsonResponse.getString("amount");
        assertEquals(StringUtils.left(price,5), StringUtils.left(amount,5));
        assertEquals(StringUtils.right(price,1), StringUtils.right(amount,1));
        assertEquals(startDate, jsonResponse.get("startDate"));
        assertEquals(endDate, jsonResponse.get("endDate"));
    }

}
