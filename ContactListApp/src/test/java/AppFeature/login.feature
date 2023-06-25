@test
Feature: Checking Login functionalities in Contact List App
  Scenario: Login with Valid Credentials
    Given user is on the WebPage
    When user enters email and password
    Then click on Submit Button
    And sees Login confirmation
  Scenario: Login with Invalid Credentials
    Given user is on the WebPage
    When user enters Invalid email and password
    Then click on Submit Button
    And sees Incorrect username or password error message