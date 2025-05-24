#Feature: User Login functionality
#
  #Scenario Outline: Validate user login with different inputs
    #Given User is on the BooksWagon homepage
    #When User clicks on Login
    #When User enters email or mobile as "<mobile>"
    #And User enters password as "<password>"
    #And User attempts login or requests OTP
    #And User enters OTP manually if required "<otp>"
    #Then Login should be "<expectedResult>"
#
  #Examples:
    #| mobile       | password   | otp        | expectedResult |
    #| 7905176351 | 9450@Rudra |            | success        |
    #| user@mail.com | invalid   |            | failure        |
    #|              | validPass |            | failure        |
    #| 7905176351   |            | correctOTP | success        |
    #| 7905176351   |            | wrongOTP   | failure        |

@Test    
Feature: User Login Functionality

  Scenario Outline: Validate user login with different inputs from Excel
    Given User is on the BooksWagon homepage
    When User clicks on Login
    When User enters email or mobile as "<mobile>"
    And User enters password as "<password>"
    And User attempts login or requests OTP
    And User enters OTP manually if required "<otp>"
    Then Login should be "<expectedResult>"

  Examples:
    | mobile       | password   | otp        | expectedResult |
    