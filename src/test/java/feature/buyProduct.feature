Feature: Buy the product and verify

  Scenario Outline: Generate data and register user
    Given User generator to generate an user
    When Hit the user generator "<api>" to get the user
    Then use those user details to register on the "<url>"
    And Purchase the product
    Then Verify the purchase

    Examples:
      |url                                       |api                       |
      | https://magento.softwaretestingboard.com/|https://randomuser.me/api/|

