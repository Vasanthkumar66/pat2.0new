Feature: Login Data Driven with Excel
	@Regression @sanity
  Scenario Outline: Login Data Driven Excel
    #Given the user navigates to login page
    Then the user should be redirected to the Manage student Page by passing email and password with excel row "<row_index>"

    Examples: 
      | row_index |
      |         1 |
      |         2 |
      |         3 |
      |					4	|
