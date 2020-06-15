Feature: WebOrder Login page Test

  @smoke
  Scenario: Login Functionality Positive Test
    Given the demoUser enters username "Tester"
    When the demoUser enters password "test"
    Then the demoUser clicks the login Button
    And the demoUser validate the home page

    Scenario: Login Functionality Negative Test
      Given the demoUser enters username "techtorial"
      When the demoUser enters password "test"
      Then the demoUser clicks the login Button
      Then the demoUser validate the text "Invalid Login or Password."

  @smoke @negative @conditional
  Scenario: Login Functionality Negative Test 1
    Given the demoUser enters username "Tester"
    When the demoUser enters password "tttt"
    Then the demoUser clicks the login Button
    Then the demoUser validate the text "Invalid Login or Password."

  @smoke @negative
  Scenario: Login Functionality Negative Test 2
    Given the demoUser enters username "Techtorial"
    When the demoUser enters password "tttt"
    Then the demoUser clicks the login Button
    Then the demoUser validate the text "Invalid Login or Password"
    # There is a problem
