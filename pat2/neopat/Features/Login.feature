Feature: Login with Valid Credentials

  
  Scenario: Successful Login with Valid Credentials
    When user enters email as "vasanth@iamneo.ai" and password as "patadmin"
    And the user clicks on the Login button
    Then the user should be redirected to the Manage Student Page
    
	
  Scenario Outline: Login Data Driven
    When user enters email as "<email>" and password as "<password>"
    And the user clicks on the Login button
    Then the user should be redirected to the Manage Student Page

    Examples: 
      | email                	    | password |
      | vasanth@iamneo.ai         | patadmin  |
      | pavanoltraining@gmail.com | test@123 |
