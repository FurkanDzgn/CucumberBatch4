Feature: Data Table Practice

  Scenario: Practice
    Then the user validate the product titles
      | Product:*         |
      | Quantity:*        |
      | Price per unit:   |
      | Discount:         |
      | Total:            |
    And the user login to the page
      | username | Tester |
      | password | test   |
    Then the user validate order details list of list
      |Paul Brown |ScreenSaver |  2   |03/12/2010 |5, Ringer Street |
      |Mark Smith |FamilyAlbum |  1   | 03/07/2010|9, Maple Valley  |
    Then the user validate order details list of map
      | Name      |Product     |  #   |Date       |   Street        |
      |Paul Brown |ScreenSaver |  2   |03/12/2010 |5, Ringer Street |
      |Mark Smith |FamilyAlbum |  1   | 03/07/2010|9, Maple Valley  |

    # cucumber report and rerun plugin