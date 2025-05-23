#Feature: Login Functionality
#
  #Scenario: User logs in with valid inputs
    #Given User is on the login page
    #When User enters valid email or mobile number
    #And User enters valid password
    #And User clicks on the login button
    #Then User should be logged in successfully
#
  #Scenario: User tries to login with invalid email or mobile number
    #Given User is on the login page
    #When User enters invalid email or mobile number
    #And User enters valid password
    #And User clicks on the login button
    #Then An error message should be displayed
#
  #Scenario: User tries to login with null inputs
    #Given User is on the login page
    #When User leaves email or mobile number and password blank
    #And User clicks on the login button
    #Then Validation messages should be displayed
#
  #Scenario: User logs in with correct OTP
    #Given User is on the OTP verification page
    #When User enters correct OTP
    #Then User should be logged in successfully
#
  #Scenario: User logs in with incorrect OTP
    #Given User is on the OTP verification page
    #When User enters incorrect OTP
    #Then An error message should be displayed
    
    
    
    Feature: Login Feature

  Scenario: Login with valid credentials
    Given User is on the BooksWagon homepage
    When User clicks on Login
    And User enters email "7905176351"
    And User enters password "9450@Rudra"
    And User clicks on Login button
    Then User should be logged in successfully

  Scenario: Login with invalid email
    Given User is on the BooksWagon homepage
    When User clicks on Login
    And User enters email "invalid@example.com"
    And User enters password "Password123"
    And User clicks on Login button
    Then User should see error message "Invalid credentials"
    
