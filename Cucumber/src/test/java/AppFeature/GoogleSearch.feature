Feature: feature to test google search functionality
  Scenario: Validate google search is working
    Given Browser is open
    And User is on Google search page
    When User enters text in Search box
    And Hits enter
    Then User is navigated to search results