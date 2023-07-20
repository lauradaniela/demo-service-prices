Feature: Endpoint for query prices accord with different parameters
  This feature contains the possible scenarios when is realized a query for validate the status for a transaction

  Scenario Outline: Client wants to know the prices that apply for the product
    Given A request with application date <applicationDate> with the product <idProduct> and brand <idBrand>
    When call the endpoint for check the prices
    Then The system returns the status <responseCode>
    And the body response with the Price <price> and application date between <startDate> and <endDate>
    Examples:
      | applicationDate     | idProduct | idBrand | responseCode | price   | startDate           | endDate             |
      | 2020-06-14-10.00.00 | 35455     | 1       | 200          | 35,50 € | 2020-06-14-00.00.00 | 2020-12-31-23.59.59 |
      | 2020-06-14-16.00.00 | 35455     | 1       | 200          | 25,45 € | 2020-06-14-15.00.00 | 2020-06-14-18.30.00 |
      | 2020-06-14-21.00.00 | 35455     | 1       | 200          | 35,50 € | 2020-06-14-00.00.00 | 2020-12-31-23.59.59 |
      | 2020-06-15-10.00.00 | 35455     | 1       | 200          | 30,50 € | 2020-06-15-00.00.00 | 2020-06-15-11.00.00 |
      | 2020-06-15-21.00.00 | 35455     | 1       | 200          | 38,95 € | 2020-06-15-16.00.00 | 2020-12-31-23.59.59 |

  Scenario Outline:
    Given A request with values that not exists the prices with fields application date <applicationDate> with the product <idProduct> and brand <idBrand>
    When call the endpoint for check the prices
    Then The system returns the status <responseCode>
    Examples:
      | applicationDate     | idProduct | idBrand | responseCode |
      | 2020-06-15-21.00.00 | 35455     | 2       | 404          |
      | 2020-06-14-21.00.00 | 35453     | 1       | 404          |
      | 2023-06-16-21.00.00 | 35455     | 1       | 404          |

  Scenario Outline:
    Given A request without all mandatory fields application date <applicationDate> with the product <idProduct> and brand <idBrand>
    When call the endpoint for check the prices
    Then The system returns the status <responseCode>
    Examples:
      | applicationDate     | idProduct | idBrand | responseCode |
      | 2020-06-15-21.00.00 | null      | null    | 400          |
      | 2020-06-15-21.00.00 | 00        | null    | 400          |
      | null                | 00        | 9       | 400          |
