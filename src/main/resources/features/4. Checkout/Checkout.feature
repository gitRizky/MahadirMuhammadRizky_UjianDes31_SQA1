Feature: Checkout

  Scenario: Checkout the cart
  When User go to the cart page
  And Click proceed to checkout
  And fill all form data and agree terms and order
  Then Get confirmation