Feature: Register

  Scenario: Register new account
    Given User go to website
    When User click my account
    And User fill register form and click register
    Then New account already created