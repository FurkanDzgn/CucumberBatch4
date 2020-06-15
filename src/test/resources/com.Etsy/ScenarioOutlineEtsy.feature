Feature: scenario outline Test

  Background: Etsy navigation
    Given the user goes to the Etsy

    # Scenario Outline:  and Scenario Template: are same
    # Examples and Scenarios are the same
  @etsyOutline
  Scenario Outline: Etsy Search Validation with outline
    When the user search in etsy with "<searchValue>"
    Then the user validate the title "<title>" and url "<etsyUrl>"
    Examples:
      | searchValue    | title                  | etsyUrl |
      | winter hat     | Winter hat \| Etsy     | winter  |
      | hat            | Hat \| Etsy            | hat     |
      | winter soldier | Winter soldier \| Etsy | soldier |

    # to organize your code in intellij you need to use option+command+l  --> mac
                                                    #   ctrl+alt+l  --> windows

  # @DataProvider
  # public Object[][] getData(){

   # return new Object{
   #   {"first"},
   #   {"second"}
   #  }