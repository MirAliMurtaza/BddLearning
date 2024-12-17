Feature: Shopping for Apparel and Accessories

  Scenario: Purchase low to high rated T-shirts and a high-value shoe
    Given I am logged in and on the homepage
    When I navigate to the APPAREL & ACCESSORIES section and select Tshirts
    And I sort items by Rating Lowest and add top 3 low rated T-shirts to the cart ensuring size is Medium
    And I navigate back to APPAREL & ACCESSORIES and select Shoes
    And I add the highest value shoe to the cart with quantity 2
    Then I verify the items in the cart
