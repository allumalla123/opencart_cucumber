Feature: User should search the product and add it to cart

  Scenario: Successful product add to cart
    Given I should login with vaild email as "pavanoltraining@gmail.com"  and password as "test@123"  first
    When I need to search as "HTC Touch HD" in searchbox and click
    And should add product to cart
    And I should click on shopping cart
    Then I should able to see product added to cart
