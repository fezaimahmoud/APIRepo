Feature: Test APIs

  Scenario Outline: Test GET API response
    Given I have the endpoint from the Excel file with coordinate "<sheet>","<row>", and "<cell>"
    When I send a GET request to the endpoint
    Then I should receive a status code 200

    Examples: 
      | sheet | row | cell |
      |     0 |   1 |    1 |

  Scenario Outline: Test POST API response
    Given I have the endpoint from the Excel file with coordinate "<sheet>","<row>", and "<cell>"
    Given I have the body from the Excel file with coordinate "<bsheet>","<brow>", and "<bcell>"
    When I send a POST request to the endpoint
    Then I should receive a status code 201
    And verify response body with data from excel file with "<rsheet>","<rrow>", and "<rcell>"

    Examples: 
      | sheet | row | cell | bsheet | brow | bcell | rsheet | rrow | rcell |
      |     0 |   2 |    1 |      0 |    2 |     2 | 0 |    2 |   3 |
