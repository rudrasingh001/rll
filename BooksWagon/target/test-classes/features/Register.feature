#Feature: User Registration Functionality
#
  #Scenario: User can signup with valid inputs
    #Given User is on the BooksWagon registration page
    #When User enters valid name, email, mobile number, and password
    #And User selects the captcha
    #And User enters correct OTP
    #And User clicks on Signup button
    #Then User should be registered successfully
#
  #Scenario: User tries to signup with invalid name input
    #Given User is on the BooksWagon registration page
    #When User enters an invalid name
    #And User clicks on Signup button
    #Then User should see an error message "invalid_name_msg"
#
  #Scenario: User tries to signup with invalid mobile number
    #Given User is on the BooksWagon registration page
    #When User enters an invalid mobile number
    #And User clicks on Signup button
    #Then User should see an error message "invalid_mobile_msg"
#
  #Scenario: User tries to signup without selecting captcha
    #Given User is on the BooksWagon registration page
    #When User enters valid details but skips captcha
    #And User clicks on Signup button
    #Then User should see an error message "captcha_required_msg"
#
  #Scenario: User tries to signup with invalid OTP
    #Given User is on the BooksWagon registration page
    #When User enters invalid OTP
    #And User clicks on Signup button
    #Then User should see an error message "invalid_otp_msg"
#
  #Scenario: User tries to signup with invalid password
    #Given User is on the BooksWagon registration page
    #When User enters an invalid password
    #And User clicks on Signup button
    #Then User should see an error message "invalid_password_msg"
#
  #Scenario: User tries to signup with different confirm password
    #Given User is on the BooksWagon registration page
    #When User enters password "valid_password"
    #And User enters confirm password "mismatch_password"
    #And User clicks on Signup button
    #Then User should see an error message "password_mismatch_msg"
#
  #Scenario: User tries to signup with null inputs
    #Given User is on the BooksWagon registration page
    #When User leaves all required fields empty
    #And User clicks on Signup button
    #Then User should see an error message "empty_fields_msg"
#
  #Scenario: User tries to signup with mobile number exceeding 10 digits
    #Given User is on the BooksWagon registration page
    #When User enters a mobile number with more than 10 digits
    #And User clicks on Signup button
    #Then User should see an error message "invalid_mobile_length_msg"
    
    
    
    
    
    
 @Signup
Feature: User Registration Functionality

  @ValidSignup
  Scenario: User can signup with valid inputs
    Given User is on the BooksWagon registration page
    When User enters valid name "valid_name", mobile number "valid_mobile", and signup password "valid_password"
    And User selects the captcha manually
    And User clicks on Continue button
    And User enters OTP "valid_otp"
    And User enters signup password "valid_password"
    And User enters confirm password "valid_password"
    And User clicks on Signup button
    Then User should be registered successfully

  @InvalidName
  Scenario: User tries to signup with invalid name input
    Given User is on the BooksWagon registration page
    When User enters an invalid name "invalid_name", mobile number "valid_mobile", and signup password "valid_password"
    And User selects the captcha manually
    And User clicks on Continue button
    Then User should see an error message "invalid_name_msg"

  @InvalidMobile
  Scenario: User tries to signup with invalid mobile number
    Given User is on the BooksWagon registration page
    When User enters valid name "valid_name", invalid mobile number "invalid_mobile", and signup password "valid_password"
    And User selects the captcha manually
    And User clicks on Continue button
    Then User should see an error message "invalid_mobile_msg"

  @CaptchaRequired
  Scenario: User tries to signup without selecting captcha
    Given User is on the BooksWagon registration page
    When User enters valid name "valid_name", mobile number "valid_mobile", and signup password "valid_password"
    And User skips captcha selection
    And User clicks on Continue button
    Then User should see an error message "captcha_required_msg"

  @InvalidOTP
  Scenario: User tries to signup with invalid OTP
    Given User is on the BooksWagon registration page
    When User enters valid name "valid_name", mobile number "valid_mobile", and signup password "valid_password"
    And User selects the captcha manually
    And User clicks on Continue button
    And User enters OTP "invalid_otp"
    And User enters signup password "valid_password"
    And User enters confirm password "valid_password"
    And User clicks on Signup button
    Then User should see an error message "invalid_otp_msg"

  @InvalidPassword
  Scenario: User tries to signup with invalid signup password
    Given User is on the BooksWagon registration page
    When User enters valid name "valid_name", mobile number "valid_mobile", and signup password "invalid_password"
    And User selects the captcha manually
    And User clicks on Continue button
    And User enters OTP "valid_otp"
    And User enters signup password "valid_password"
    And User enters confirm password "valid_password"
    And User clicks on Signup button
    Then User should see an error message "invalid_password_msg"

  @PasswordMismatch
  Scenario: User tries to signup with different confirm password
    Given User is on the BooksWagon registration page
    When User enters valid name "valid_name", mobile number "valid_mobile", and signup password "valid_password"
    And User selects the captcha manually
    And User clicks on Continue button
    And User enters OTP "valid_otp"
    And User enters signup password "valid_password"
    And User enters confirm password "mismatch_password"
    And User clicks on Signup button
    Then User should see an error message "password_mismatch_msg"

  @EmptyFields
  Scenario: User tries to signup with null inputs
    Given User is on the BooksWagon registration page
    When User leaves all required fields empty
    And User clicks on Continue button
    Then User should see an error message "empty_fields_msg"

  @MobileLengthError
  Scenario: User tries to signup with mobile number exceeding 10 digits
    Given User is on the BooksWagon registration page
    When User enters valid name "valid_name", mobile number "invalid_mobile_length", and signup password "valid_password"
    And User selects the captcha manually
    And User clicks on Continue button
    Then User should see an error message "invalid_mobile_length_msg"
