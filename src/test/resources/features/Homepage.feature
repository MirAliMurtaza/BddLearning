Feature: Managing Dove Items in Shopping Cart

  Scenario: Add the newest Dove item to the cart and verify its details
    Given I am on the login page
    When I log in with valid credentials
    And I navigate to the homepage
    And I scroll to and select the newest Dove item
    And I add the item to the cart
    Then I should see the correct item and details in the cart