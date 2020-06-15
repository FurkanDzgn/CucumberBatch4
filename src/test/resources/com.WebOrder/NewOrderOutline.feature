Feature: Validation of New Order using Scenario Outline

  Scenario Outline: New Order Validation
    Given the demoUser enters username "Tester"
    When the demoUser enters password "test"
    Then the demoUser clicks the login Button
    Then the user enters product info "<ProductName>" and "<quantity>"
    And the user enter address info "<name>", "<address>", "<city>", "<state>","<zipCode>"
    * the user enters payment info "<CardType>", "<carNumber>", "<expDate>"
    Then  the user validate success message
    And the user validate new order details "<ProductName>", "<quantity>", "<name>",  "<address>", "<city>", "<state>","<zipCode>", "<CardType>", "<carNumber>", "<expDate>"
    # Scenarios:
    Examples:
      | ProductName | quantity | name     | address      | city        | state    | zipCode | CardType         | carNumber        | expDate |
      | MyMoney     | 10       | Franklin | 2200 E Devon | Des Plaines | Illinois | 60018   | Visa             | 4444333322221111 | 05/24   |
      | FamilyAlbum | 5        | Kallin   | 2222 E Devon | Chicago     | Arizona  | 50456   | MasterCard       | 3333222211114444 | 05/27   |
      | ScreenSaver | 3        | Jessica  | 3445 E Levon | Winterfall  | LA       | 67088   | American Express | 1111333322224444 | 02/23   |