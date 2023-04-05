@login
Feature: Login Functionality


  Scenario: Login As Selim
    Given The user is on the login page
    When The user type in Selim's credentials
    Then The user should be able to login successfully

  Scenario:Login As Selim with parameter
    Given The user is on the login page
    When The user type in valid credentials: "sgezer@gmail.com" and "sg12345678"
    Then The user should be able to see userName: "Selim Gezer"


  Scenario:Login As ramanzi
    Given The user is on the login page
    When The user type in valid credentials: "Ramanzi@test.com" and "Test123456"
    Then The user should be able to see userName: "Mansimmo"


  Scenario:Login As ramanzi with map
    Given The user is on the login page
    Then The user type in valid credentials via map and verify success login
      | userMail | Ramanzi@test.com |
      | pass     | Test123456       |
      | name     | Mansimmo         |


  Scenario:Login As ramanzi with list
    Given The user is on the login page
    Then The user type in valid credentials via list and verify success login
      | Ramanzi@test.com |
      | Test123456       |
      | Mansimmo         |

  @wip
  Scenario Outline: Login with different user "<userName>" via scenario outline
    Given The user is on the login page
    When The user type in valid credentials: "<userEmail>" and "<password>"
    Then The user should be able to see userName: "<userName>"
    Examples:
      | userEmail        | password   | userName    |
      | sgezer@gmail.com | sg12345678 | Selim Gezer |
      | Ramanzi@test.com | Test123456 | Mansimmo    |

