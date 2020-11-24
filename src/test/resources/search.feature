@search
Feature: Search
  As a customer
  I want to search for an info
  So that I can find the information I am looking for

  @positive
  Scenario: Search for information
    Given I am on homepage
    When I search for information "test"
    Then I should be able to find appropriate information

  @negative
  Scenario: Search for non existing information
    Given I am on homepage
    When I search for information "random data"
    Then I should see "No results found." in information

  @negative
  Scenario: Search without search term
    Given I am on homepage
    When I perform search
    Then I should see error message as "The following errors were encountered"