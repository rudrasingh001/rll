   #
#Feature: Login Functionality
#
  #Scenario: User logs in with valid inputs
    #Given User is on the BooksWagon homepage
    #When User clicks on Login
    #And User enters email "valid_email"
    #And User enters password "valid_password"
    #And User clicks on Login button
    #Then User should be logged in successfully
#
  #Scenario: User tries to login with invalid email or mobile number
    #Given User is on the BooksWagon homepage
    #When User clicks on Login
    #And User enters email "invalid_email"
    #And User enters password "valid_password"
    #And User clicks on Login button
    #Then User should see error message "invalid_credentials_msg"
#
  #Scenario: User tries to login with null inputs
    #Given User is on the BooksWagon homepage
    #When User clicks on Login
    #And User enters email "empty_email"
    #And User enters password "empty_password"
    #And User clicks on Login button
    #Then User should see error message "empty_fields_msg"
#
  #Scenario: User logs in with correct OTP
    #Given User is on the OTP verification page
    #When User enters email "valid_email"
    #And User enters password "valid_password"
    #And User clicks on Login button
    #And User enters correct OTP
    #Then User should be logged in successfully
#
  #Scenario: User logs in with incorrect OTP
    #Given User is on the OTP verification page
    #When User enters email "valid_email"
    #And User enters password "valid_password"
    #And User clicks on Login button
    #And User enters incorrect OTP
    #Then User should see error message "invalid_otp_msg"
    
    
    
    
    
    @Login
Feature: Login Functionality

  @ValidLogin
  Scenario: User logs in with valid inputs
    Given User is on the BooksWagon homepage
    When User clicks on Login
    And User enters email "valid_email"
    And User enters password "valid_password"
    And User clicks on Login button
    Then User should be logged in successfully

  @InvalidLogin
  Scenario: User tries to login with invalid email or mobile number
    Given User is on the BooksWagon homepage
    When User clicks on Login
    And User enters email "invalid_email"
    And User enters password "valid_password"
    And User clicks on Login button
    Then User should see error message "invalid_credentials_msg"

  @NullLogin
  Scenario: User tries to login with null inputs
    Given User is on the BooksWagon homepage
    When User clicks on Login
    And User enters email "empty_email"
    And User enters password "empty_password"
    And User clicks on Login button
    Then User should see error message "empty_fields_msg"

  @OTPLogin
  Scenario: User logs in with correct OTP
    Given User is on the OTP verification page
    When User enters email "valid_email"
    And User enters password "valid_password"
    And User clicks on Login button
    And User enters OTP "valid_otp"
    Then User should be logged in successfully

  @InvalidOTPLogin
  Scenario: User logs in with incorrect OTP
    Given User is on the OTP verification page
    When User enters email "valid_email"
    And User enters password "valid_password"
    And User clicks on Login button
    And User enters OTP "invalid_otp"
    Then User should see error message "invalid_otp_msg"
    