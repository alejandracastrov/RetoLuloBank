Feature: dummy API consumption
  I want to interact with the dummy api through the common verbs

  Background:
     Given Maria wants to be able to test common API verbs

  @GetAllEemployeeData
  Scenario: Get all employee data
    When he consults the information required to obtain the data of the employees
    Then he must obtain the data of all employees

