Feature: New Order validation

  Scenario Outline: Validate new Order in WebOrder page
    Given the demoUser enters username "Tester"
    When the demoUser enters password "test"
    Then the demoUser clicks the login Button
    Then the user enters product info "<Product>" and "<quantity>"
    And the user enter address info "<name>", "<address>", "<city>", "<state>","<zipCode>"
    * the user enters payment info "<card>", "<cardNum>", "<expDate>"
    Then  the user validate success message
    Examples:
      | Product     | quantity | name  | address      | city           | state    | zipCode | card       | cardNum          | expDate |
      | FamilyAlbum | 10       | David | 2200 E Devon | Des Plaines    | Illinois | 60018   | Visa       | 4444333322221111 | 05/24   |
      | MyMoney     | 20       | Carl  | 2214 E Devan | Mount Prospect | Illinois | 60045   | MasterCard | 3333222211114444 | 08/27   |
      | ScreenSaver | 15       | Zach  | 2200 E Levon | Winterfall     | LA       | 67088   | Amex       | 1111333322224444 | 02/23   |
