Feature: dummy API consumption
  I want to interact with the dummy api through the common verbs


  @CreateNewRecord
  Scenario Outline: Create new record in database
    Given Maria wants to be able to test common API verbs
    When you create the employee information with "<lastName>" and "<firstName>" and "<email>"
    Then you need to validate the created data of the employee
    Examples:
      | lastName | firstName | email                 |
      | castro   | maria     | mariacastro01@gmail.com |

  Scenario Outline: Create new record in database
    Given Maria wants to be able to test common API verbs
    When you create the employee information with "<lastName>" and "<firstName>" and "<email>"
    Then you need to validate employee already exists
    Examples:
      | lastName | firstName | email                 |
      | castro   | maria     | mariacastro21@gmail.com |