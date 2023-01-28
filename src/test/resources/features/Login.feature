@Login
Feature: Testing Login Feature

  @TC01 @LoginPageTC
  Scenario: Login with valid credentials
    Given User is on the login page of cxe "https://10.12.49.77/user"
#    When User enters username "4620" security code "0000" server "AjitVm006"
#    Then User is logged in successfully

  @TC02 @LoginPageTC
  Scenario Outline: Login with invalid credentials
    Given User is on the login page of cxe "https://10.12.49.77/user"
    When User enters username "<username>" security code "<securityCode>" server "<serverName>"
    Then Error message is thrown

    Examples:
      | username | securityCode | serverName |
      | 896541   | 454654       | AjitVm006  |
      | 687987   |              | AjitVm006  |

#  @TC03 @LoginPageTC
#  Scenario: Login with invalid credentials gh
#    Given User is on the login page
#    When User enters username security code server
#      | username | securityCode | serverName |
#      | 896541   | 454654       | AjitVm006  |
#      | 687987   |              | AjitVm006  |
#    #Then Error message is thrown






