Feature: : All Products

  Scenario: Validation of All products
    Given the demoUser enters username "Tester"
    When the demoUser enters password "test"
    Then the demoUser clicks the login Button
    Then the user clicks the allProducs button
    And the user calidate the product details
      | Product name | Price | Discount |
      | MyMoney      | $100  | 8%       |
      | FamilyAlbum  | $80   | 15%      |
      | ScreenSaver  | $20   | 10%      |
