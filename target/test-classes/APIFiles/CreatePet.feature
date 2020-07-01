@Api
Feature: Api First scenario

  Scenario Outline: Api POST scenario
    When user creates a pet with "<id>", "<name>", "<status>"
    Then the status code is 200
    And pet with "<id>", "<name>", "<status>" is created
    Examples:
      | id       | name    | status       |
      | 123456   | Kumar   | available    |
      | 234335   | Patel   | do not touch |
      | 23424    | Jack    | busy         |
      | 24253235 | Pikachu | messy        |
      | 225235   | Frank   | busy         |
