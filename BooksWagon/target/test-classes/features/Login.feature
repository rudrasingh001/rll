Feature: Login Functionality

  Scenario: User logs in with valid inputs
    Given User is on the login page
    When User enters valid email or mobile number
    And User enters valid password
    And User clicks on the login button
    Then User should be logged in successfully

  Scenario: User tries to login with invalid email or mobile number
    Given User is on the login page
    When User enters invalid email or mobile number
    And User enters valid password
    And User clicks on the login button
    Then An error message should be displayed

  Scenario: User tries to login with null inputs
    Given User is on the login page
    When User leaves email or mobile number and password blank
    And User clicks on the login button
    Then Validation messages should be displayed

  Scenario: User logs in with correct OTP
    Given User is on the OTP verification page
    When User enters correct OTP
    Then User should be logged in successfully

  Scenario: User logs in with incorrect OTP
    Given User is on the OTP verification page
    When User enters incorrect OTP
    Then An error message should be displayed
