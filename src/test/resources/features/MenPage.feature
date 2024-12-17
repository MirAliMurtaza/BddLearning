Feature: Men Section Shopping

  Scenario: Add products ending with M and check the cart
    Given I am on the men's section of the store
    When I add products ending with M to the cart
    Then I should see that all items in the cart end with M
