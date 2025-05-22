Feature: Registration Functionality

  Scenario: User signs up with valid inputs
    Given User is on the registration page
    When User enters valid name, mobile number, password, and confirm password
    And User enters OTP and selects captcha
    And User clicks on the register button
    Then User should be registered successfully

  Scenario: User signs up with invalid name input
    Given User is on the registration page
    When User enters invalid name and other valid inputs
    And User clicks on the register button
    Then An error message should be shown

  Scenario: User signs up with invalid mobile number
    Given User is on the registration page
    When User enters invalid mobile number
    Then An error message should be shown

  Scenario: User signs up without selecting captcha
    Given User is on the registration page
    When User fills all fields but skips captcha
    Then A captcha validation message should be shown

  Scenario: User enters invalid OTP during registration
    Given User is on the OTP verification page
    When User enters invalid OTP
    Then An error message should be shown

  Scenario: User signs up with invalid password
    Given User is on the registration page
    When User enters invalid password
    Then A password validation message should be displayed

  Scenario: User signs up with mismatched confirm password
    Given User is on the registration page
    When User enters different values in password and confirm password fields
    Then A mismatch error should be shown

  Scenario: User signs up with null inputs
    Given User is on the registration page
    When User leaves all fields empty
    Then Validation messages should be shown

  Scenario: User signs up with mobile number longer than 10 digits
    Given User is on the registration page
    When User enters mobile number with more than 10 digits
    Then A validation error should be shown