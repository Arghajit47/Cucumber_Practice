Feature:
  Scenario: Checking filter option
    Given SignIn is Done
    And press the filter button
    When User selects the filtrate options and apply
    Then Jobs will be shown as per the filtration
  Scenario: Checking save option
    Given User is in the main page
    And click the first job card
    When clicking the save option in the job
    Then the job will be shown in Saved Jobs section
  Scenario: Checking unsaved option
    Given After login main page
    And Click on the Saved Jobs tab panel
    When Clicked on the present job card and click on Unsaved option
    Then There will no jobs in the saved jobs section
  Scenario: Checking green commute routes
    Given Inside the main page after logging in
    And Click on a job card
    When clicked on the Green Commute Routes
    Then Common cabs and bus routes will be shown




