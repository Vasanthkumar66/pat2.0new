Feature: Student Single Invite

  Background: 
 		Given user enters emailID as "vasanth@iamneo.ai" and password as "patadmin"
    And  user clicks on the Login button
    Then user should be redirected to the manage student Page
    When I click on the invite button
   
	@Regression @sanity
  Scenario: Single invite with valid email id
    And I select the campus as "Vasanth" in the campus field
    And I select the Admission year as "2024" in the Admission year field
    And I select the Passout year as "2026" in the Passout year field
    And I select the Student type as "Regular" in the student type field
    And I select the Department as "Computer Science" in the Department field
    And I select the Degree and specialization as "B.Sc - CT" in the Degree and specialization field
    And I enter a valid email id in the email field
    And I click on the Send Invite button
    And Validate the success growl message
    Then Validate the emailID is created or not
    
 @Regression @sanity
 Scenario: Single invite with valid multiple email ID
 		And I select the campus as "Vasanth" in the campus field
    And I select the Admission year as "2024" in the Admission year field
    And I select the Passout year as "2026" in the Passout year field
    And I select the Student type as "Regular" in the student type field
    And I select the Department as "Computer Science" in the Department field
    And I select the Degree and specialization as "B.Sc - CT" in the Degree and specialization field
 		And Enter	multiple email ID in the email field
 		And click the send invite button
 		And Validate the success growl message
 		Then validate the multiple email id are created or not
 		
 @Regression	
 Scenario: Validate Error Occurs when Clicking Invite button Without Filling All Mandatory Fields
 		And click the send invite button
 		And Validate Error message should be display
 		
 @Regression	
 Scenario: Validate Error Occurs when Clicking Invite button Without Filling campus Fields
 		And I select the Admission year as "2024" in the Admission year field
    And I select the Passout year as "2026" in the Passout year field
    And I select the Student type as "Regular" in the student type field
 		And I enter a valid email id in the email field
 		And click the send invite button
 		And Validate Error message should be display
 		
 @Regression		
 Scenario: Validate Error Occurs when Clicking Invite button Without Filling Admission year Fields	
 		And I select the campus as "Vasanth" in the campus field
    And I select the Passout year as "2026" in the Passout year field
    And I select the Student type as "Regular" in the student type field
    And I select the Department as "Computer Science" in the Department field
    And I select the Degree and specialization as "B.Sc - CT" in the Degree and specialization field
    And I enter a valid email id in the email field
    And I click on the Send Invite button
    And Validate Error message should be display
    
 @Regression
 Scenario: Validate Error Occurs when Clicking Invite button Without Filling Passout year Fields
 		And I select the campus as "Vasanth" in the campus field
    And I select the Admission year as "2024" in the Admission year field
    And I select the Student type as "Regular" in the student type field
    And I select the Department as "Computer Science" in the Department field
    And I select the Degree and specialization as "B.Sc - CT" in the Degree and specialization field
    And I enter a valid email id in the email field
    And I click on the Send Invite button
    And Validate Error message should be display
    
 @Regression
 Scenario: Validate Error Occurs when Clicking Invite button Without Filling Department Fields		
 		And I select the campus as "Vasanth" in the campus field
    And I select the Admission year as "2024" in the Admission year field
    And I select the Passout year as "2026" in the Passout year field
    And I select the Student type as "Regular" in the student type field
    And I enter a valid email id in the email field
    And I click on the Send Invite button
    And Validate Error message should be display
    
 @Regression
 Scenario: Validate Error Occurs when Clicking Invite button Without Filling Degree and specialization Fields
		And I select the campus as "Vasanth" in the campus field
    And I select the Admission year as "2024" in the Admission year field
    And I select the Passout year as "2026" in the Passout year field
    And I select the Student type as "Regular" in the student type field
    And I select the Department as "Computer Science" in the Department field
    And I enter a valid email id in the email field
    And I click on the Send Invite button
    And Validate Error message should be display
    
  @Regression  
  Scenario: Validate Error Occurs when Clicking Invite button Without Filling Email-ID Fields  
  	And I select the campus as "Vasanth" in the campus field
    And I select the Admission year as "2024" in the Admission year field
    And I select the Passout year as "2026" in the Passout year field
    And I select the Student type as "Regular" in the student type field
    And I select the Department as "Computer Science" in the Department field
    And I select the Degree and specialization as "B.Sc - CT" in the Degree and specialization field
    And I click on the Send Invite button
    And Validate Error message should be display
    
 @Regression
 Scenario: Validate Error Occurs when Clicking Invite button With Invalid Email-ID Fields	
		And I select the campus as "Vasanth" in the campus field
    And I select the Admission year as "2024" in the Admission year field
    And I select the Passout year as "2026" in the Passout year field
    And I select the Student type as "Regular" in the student type field
    And I select the Department as "Computer Science" in the Department field
    And I select the Degree and specialization as "B.Sc - CT" in the Degree and specialization field
    And I enter Invalid email id in the email field
    And I click on the Send Invite button
    And Validate Invalid Email ID Error message should be display
 	 