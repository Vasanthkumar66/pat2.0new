Feature: Valiade Error growl message



Scenario: Error growl message should be displayed when clicking invite button without filling mandatory fields
		Given user enters emailID as "patadmin@iamneo.ai" and password as "patadmin"
    And  user clicks on the Login button
    Then user should be redirected to the manage student Page
    When I click on the invite button
    When I click on the Send invite button by passing excel data "<rows>"
		And Validate Error message should be display
			
		Examples:
		|rows|
		|   1|
#		|   2|
#		|   3|
#		|   4|
#		|   5|
#		|   6|
#		|   7|
#		|   8|
		
		