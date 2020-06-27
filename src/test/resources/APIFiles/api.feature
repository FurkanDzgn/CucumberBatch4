Feature: Api exercise

  Scenario Outline: Give different values
    Given the user enter id headers "Content-Type" ,"Accept" and "application/json" "<id>" name name "<name>" status "<status>"
    Examples:
      | id   | name  | status       |
      | 7788 | Kumar | waiting      |
      | 7799 | Patel | do not touch |
      | 8899 | Hazer | available    |
      | 4455 | Jason | busy         |
      | 5566 | Tyler | waiting      |
      | 4466 | Katil | do not touch |
      | 6633 | Hayle | busy         |
      | 8855 | Frank | waiting      |
      | 2255 | Jack  | do not touch |
      | 8822 | Files | available    |


