@test
Feature: Visit Contact List Page and check for all functionalities
  Background:
    Given user starting the WebDriver
  Scenario: Check for all Expected elements
    Given Login to the webPage
    When sees contactList Url for login confirmation
    Then sees the Contact List Page
  Scenario: Add a new Contact
    Given Login to the webPage
    And click on Add button
    When fill the required fields
    And click on confirm button
    Then sees contact in the table
  Scenario: Edit the contact
    Given Login to the webPage
    And click on the contact to see Contact Details page
    When click on Edit Contact to see Edit Contact page
    And change phone number
    And click on confirm button
    Then checks the number is updated
  Scenario: Delete the contact
    Given Login to the webPage
    And click on the contact to see Contact Details page
    When click on Delete button
    Then confirm the Delete
    And Log out from Account to see Login page
