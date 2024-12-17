Feature: Login Functionality

  Scenario: Login with valid credentials
    Given Goto Url
    And Enter username
    And Enter password
    When Click login button

  Scenario: Login with invalid credentials
    Given Goto Url
    And Enter invalid email
    And Enter invalid password
    When Click login button
