@regression @techtorial
Feature: DuckDuckGo search testing

  Scenario: Validation of Search in DuckDuckGo
    Given the user goes to the duckduckgo
    When the user send the selenium keyword
    Then the user click search button
    And the user validate title contains the selenium keyword
    And the user validate url contains the selenium keyword
    * the user validate all results contain the selenium keyword

    # Create new scenario to test the the search function with different value
    # Use the Parameter in steps
    # Create steps to implement the implemented steps

  @smoke @techtorial1 @tech
  Scenario: Validation of Search with TestNG
    Given the user goes to the duckduckgo
    When the user search with "TestNG"
    Then the user click search button
    And the user validate title contains "TestNG"
    And the user validate all results contains "Test"
    And the user validate number of result is 10

  @smoke @techtorial2 @test
  Scenario: Validation of Search with Java
    Given the user goes to the duckduckgo
    When the user search with "Java"
    Then the user click search button
    And the user validate title contains "Java"
    And the user validate all results contains "Java"
    And the user validate number of result is 10
