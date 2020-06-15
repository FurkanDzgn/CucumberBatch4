Feature: Validate search in Etsy

  Background: It will run before each scenario
    Given the user goes to the Etsy
    # it will run 3 times before each scenarios

  # We need to run b3 scenario
  # before every scenario I want to navigate to etsy except second scenario

  @etsy @tt
  Scenario: Validation of search in Etsy 1
    When the user search in etsy with "winter hat"
    Then the user validate the title "Winter hat | Etsy" and url "winter"

  @etsy
  Scenario: Validation of search in Etsy 2
    When the user search in etsy with "hat"
    Then the user validate the title "Hat | Etsy" and url "hat"

  @etsy @tt
  Scenario: Validation of search in Etsy 3
    When the user search in etsy with "winter soldier"
    Then the user validate the title "Winter soldier | Etsy" and url "soldier"
