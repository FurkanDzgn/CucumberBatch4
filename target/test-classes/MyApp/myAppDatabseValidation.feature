@regressionTest @db @ui @smokeTest
Feature: My App Database Validation

  Scenario: Validating UI data with DB data
    # First step i create a customer UI, API Post, , Database
    # given User creates customer in UI/API/DB
    Given User goes to myApp homepage
    When User gets the data from UI
    Then User validates UI data with DB
    # Then User deletes the customer, UI, API Delete, Database Delete
