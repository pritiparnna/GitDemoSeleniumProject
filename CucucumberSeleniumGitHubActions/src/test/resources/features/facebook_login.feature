Feature: Facebook Login
  As a Facebook user
  I want to log in to my Facebook account
  So that I can access my news feed

  @fbLogin
  Scenario Outline: Successful Facebook login with valid credentials
    Given I am on the Facebook login page
    When I enter Facebook username "<email>"
    And I enter Facebook password "<password>"
    And I click on the Facebook Login button
    Then I should be logged in to Facebook successfully

    Examples:
      | email                        | password    |
      | pritiparnnagiri96@gmail.com  | Priti@96 |
