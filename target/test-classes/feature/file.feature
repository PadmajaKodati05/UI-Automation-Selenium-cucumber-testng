Feature: Yahoo Finance Automation
  Verify navigation and table data in Yahoo Finance

  Scenario: Navigate to Top Mutual Funds and verify table
    Given I launch the Yahoo homepage
    When I click on Finance
    And I hover over Markets
    And I click on Top Mutual Funds
    Then I should see the mutual funds table
    And I print the number of rows and columns
    And I print the first cell data
    And I print the full table data