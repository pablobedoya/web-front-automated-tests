Feature: Login website

  Scenario: Login successful
    Given I successfully registered on the website
    And I want to login in website
    And I enter valid credentials
    When I submit the login
    Then should return that the login was successful

  Scenario Outline: Login unsuccessful
    Given I want to login in website
    And I enter <emailType> email
    And I enter <passwordType> password
    When I submit the login
    Then should return that the login was unsuccessful with an error "<message>"
    
    Examples:
    | emailType | passwordType | message                    |
    | VALID     | VALID        | Authentication failed.     |
    | BLANK     | VALID        | An email address required. |
    | VALID     | BLANK        | Password is required.      |
    | BLANK     | BLANK        | An email address required. |
    | INVALID   | VALID        | Invalid email address.     |
    | VALID     | INVALID      | Invalid password.          |
    | INVALID   | INVALID      | Invalid email address.     |
