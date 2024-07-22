Feature: Forgot password with valid and invalid email ID
@Regression @sanity
Scenario Outline: Valiadte the forgot password functionlaity by using excel data
	Given User should be redirected to forgot passowrd page by clicking forgot password button
	Then the forgot password response should be display in the top of the screen by passing email with excel row "<rows>"
	
	Examples: 
	| rows |
	| 	 1 |
	|    2 |