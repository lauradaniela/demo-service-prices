Feature: Endpoint for query prices accord with different parameters
  This feature contains the possible scenarios when is realized a query for validate the status for a transaction

  Scenario Outline: Client wants to know the prices that apply for the product
    Given A request with aplication date <aplicationDate> with the product <idProduct> and brand <idBrand>
    When call the enpoint for check the prices
    Then The system returns the status <responseCode>
    And the body response with the Price <price> and application date between <startDate> and <endDate>
    Examples:
      | aplicationDate      | idProduct | idBrand | responseCode | price     | startDate           | endDate             |
      | 2020-06-14-10.00.00 | 35455     | 1       | 200          | 35.50 EUR | 2020-06-14-00.00.00 | 2020-12-31-23.59.59 |
      | 2020-06-14-10.00.00 | 35455     | 1       | 200          | 25.45 EUR | 2020-06-14-15.00.00 | 2020-06-14-18.30.00 |
      | 2020-06-14-21.00.00 | 35455     | 1       | 200          | 35.50 EUR | 2020-06-14-00.00.00 | 2020-12-31-23.59.59 |
      | 2020-06-15-10.00.00 | 35455     | 1       | 200          | 30.50 EUR | 2020-06-15-00.00.00 | 2020-06-15-11.00.00 |
      | 2020-06-15-21.00.00 | 35455     | 1       | 200          | 38.95 EUR | 2020-06-15-16.00.00 | 2020-12-31-23.59.59 |

  Scenario Outline:
    Given A request without all mandatory fields aplication date <aplicationDate> with the product <idProduct> and brand <idBrand>
    When call the enpoint for check the prices
    Then The system returns the status <responseCode>
    Examples:
      | aplicationDate      | idProduct | idBrand | responseCode |
      | 2020-06-15-21.00.00 |           |         | 400          |
      | 2020-06-15-21.00.00 | 00        |         | 400          |
      |                     | 00        | 9       | 400          |

    Scenario Outline:
      Given A request without values that not exists the prices with fields aplication date <aplicationDate> with the product <idProduct> and brand <idBrand>
      When call the endpoint for check the prices
      Then The system returns the status <responseCode>
      Examples:
        | aplicationDate      | idProduct | idBrand | responseCode |
        | 2020-06-15-21.00.00 | 35455     | 2       | 404          |
        | 2020-06-14-21.00.00 | 35453     | 1       | 404          |
        | 2020-06-16-21.00.00 | 35455     | 1       | 404          |
