Feature: Student Bulk Invite

  Background:
    When user enters email as "vasanth@iamneo.ai" and password as "patadmin"
    And the user clicks on the Login button
    Then the user should be redirected to the Manage Student Page

  Scenario: Student Bulk Invite with Valid Data
    #And Clicks the bulk upload button
    And Uploads the file
    #And Clicks the upload button
    #Then Validates the successfully uploaded growl message
    #And Opens the notification column
    #And Downloads the bulk invite status file
    #Then Validates the remarks column in the file "rows"
    
    Examples:
		|rows|
		|   1|
		
