#  Description: To verify Rates API WebService for Foreign Exchange currency rates

@JobInterview
Feature: Rates API WebService with Foreign Exchange rates

  Scenario Outline: Verify Rates API WebService - check availability of latest Foreign Exchange rates functionality - GET Method
    Given I want to ask Rates API webservice for the Latest Foreign Exchange rates
    When I submit the GET request for a provided <valid_endpoint> endpoint
    Then I should get <success_status_code> Status Code

    Examples:
      | valid_endpoint | success_status_code |
      | latest         | 200                 |

  Scenario Outline: Verify Rates API WebService - check whether the response from the Latest Foreign Exchange has values - GET Method
    Given I want to ask Rates API webservice for the Latest Foreign Exchange rates
    When I submit the GET request for a provided <valid_endpoint> endpoint
    Then I should receive valid response with the exchange rates

    Examples:
      | valid_endpoint |
      | latest         |

  Scenario Outline: Verify Rates API WebService - check availability of Latest Foreign Exchange rates functionality with inappropriate endpoint provided - GET Method
    Given I want to ask Rates API webservice for the Latest Foreign Exchange rates
    When I submit the GET request for a provided <incomplete_endpoint> endpoint
    Then I should get <client_error_bad_request> Status Code
    When I submit the GET request for a provided <incorrect_endpoint> endpoint
    Then I should get <client_error_not_found> Status Code

    Examples:
      | incomplete_endpoint | client_error_bad_request | incorrect_endpoint | client_error_not_found |
      |                     | 400                      | latest/incorrect   | 404                    |

  Scenario Outline: Verify Rates API WebService - check availability of Foreign Exchange rates functionality with specific past date provided - GET Method
    Given I want to ask Rates API webservice for the Specific date Foreign Exchange rates
    When I submit the GET request for a provided <past_date_uri> endpoint
    Then I should get <success_status_code> Status Code

    Examples:
      | past_date_uri | success_status_code |
      | 2020-12-24    | 200                 |

  Scenario Outline: Verify Rates API WebService - check whether the response from the Foreign Exchange endpoint with specific past date provided has values - GET Method
    Given I want to ask Rates API webservice for the Specific date Foreign Exchange rates
    When I submit the GET request for a provided <past_date_uri> endpoint
    Then  I should receive valid response for request with the specific past date with the exchange rates

    Examples:
      | past_date_uri |
      | 2020-12-24    |

  Scenario Outline: Verify Rates API WebService - check availability of Foreign Exchange rates functionality with specific future date provided - GET Method
    Given I want to ask Rates API webservice for the Specific date Foreign Exchange rates
    When I submit the GET request for a provided <future_date_uri> endpoint
    Then I should get the response with values applicable to current date

    Examples:
      | future_date_uri |
      | 2021-12-24      |