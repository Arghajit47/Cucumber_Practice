Feature: feature to test login functionality of a demo website
  Scenario Outline: Validate Login Functionality
    Given Open the Browser
    And User is navigated to the Demo Website
    When User input the <FullName> and <Password>
    Then User is navigated to the home page
    Examples:
      | FullName | Password |
      | Arghajit | 12345 |
      | Aditya | 12345 |