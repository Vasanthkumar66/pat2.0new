package stepDefinitions;

import java.util.HashMap;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LoginPage;
import pageObjects.ManageStudentPage;
import utilities.DataReader;

public class SingleInvite {

	WebDriver driver;
	LoginPage lp;
	ManageStudentPage macc;

	List<HashMap<String, String>> datamap; // Data driven

	@Given("user enters emailID as {string} and password as {string}")
	public void user_enters_email_id_as_and_password_as(String email, String pwd) {
		BaseClass.getLogger().info("Entering email and password.. ");

		lp = new LoginPage(BaseClass.getDriver());
		lp.setEmail(email);
		lp.setPassword(pwd);
	}

	@Given("user clicks on the Login button")
	public void user_clicks_on_the_login_button() throws InterruptedException {
		lp.clickLogin();
		BaseClass.getLogger().info("clicked on login button...");
		Thread.sleep(5000);
	}

	@Then("user should be redirected to the manage student Page")
	public void user_should_be_redirected_to_the_manage_student_page() {
		macc = new ManageStudentPage(BaseClass.getDriver());
		boolean targetpage = macc.validateManageStudentPage();

		if (targetpage == true) {
			BaseClass.getLogger().info("logged in successfully");
			Assert.assertTrue(true);
		} else {
			BaseClass.getLogger().info("login Failure");
			Assert.assertTrue(false);
		}
	}

	@When("I click on the invite button")
	public void i_click_on_the_invite_button() throws InterruptedException {
		macc.clickInviteBtn();
		Thread.sleep(1000);
	}

	@When("I select the campus as {string} in the campus field")
	public void i_select_the_campus_as_in_the_campus_field(String campus) throws InterruptedException {
		macc.clickCampus();
		macc.selectData(campus);
		Thread.sleep(1000);
	}

	@When("I select the Admission year as {string} in the Admission year field")
	public void i_select_the_admission_year_as_in_the_admission_year_field(String adminssionYear)
			throws InterruptedException {
		macc.clickAdmissionYearField();
		macc.selectData(adminssionYear);
		Thread.sleep(1000);
	}

	@When("I select the Passout year as {string} in the Passout year field")
	public void i_select_the_passout_year_as_in_the_passout_year_field(String passoutYear) throws InterruptedException {
		macc.clickPassOutYearField();
		macc.selectData(passoutYear);
		Thread.sleep(1000);
	}

	@When("I select the Student type as {string} in the student type field")
	public void i_select_the_student_type_as_in_the_student_type_field(String studentType) throws InterruptedException {
		macc.clickStudentTypeField();
		macc.selectData(studentType);
		Thread.sleep(1000);
	}

	@When("I select the Department as {string} in the Department field")
	public void i_select_the_department_as_in_the_department_field(String Department) throws InterruptedException {
		macc.clickDepartmentField();
		macc.selectData(Department);
		Thread.sleep(1000);
	}

	@When("I select the Degree and specialization as {string} in the Degree and specialization field")
	public void i_select_the_degree_and_specialization_as_in_the_degree_and_specialization_field(String degree)
			throws InterruptedException {
		macc.clickDegreeAndSpecializationField();
		macc.selectData(degree);
		Thread.sleep(1000);
	}

	@When("I enter a valid email id in the email field")
	public void i_enter_a_valid_email_id_in_the_email_field() throws InterruptedException {
		macc.EnterEmailID();
		Thread.sleep(1000);
	}

	@When("I click on the Send Invite button")
	public void i_click_on_the_send_invite_button() throws InterruptedException {
		macc.clickSendInviteBtn();
		Thread.sleep(1000);
	}
	
	@When("Validate the success growl message")
	public void validate_the_success_growl_message() {
	   boolean result = macc.validateSuccessMessage();
	   if (result == true) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}

	@Then("Validate the emailID is created or not")
	public void validate_the_email_id_is_created_or_not() throws InterruptedException {
		macc.singleSearch();
		Thread.sleep(2000);
		boolean result = macc.isvalidatemailID();
		if (result == true) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}

	}

	@When("Enter	multiple email ID in the email field")
	public void enter_multiple_email_id_in_the_email_field() {
		macc.sendMultipleEmailID(3);

	}

	@When("click the send invite button")
	public void click_the_send_invite_button() throws InterruptedException {
		macc.clickSendInviteBtn();
		Thread.sleep(3000);
	}

	@Then("validate the multiple email id are created or not")
	public void validate_the_multiple_email_id_are_created_or_not() throws InterruptedException {
		macc.multiSearch();
		boolean res = macc.isvalidateMultipleID();
		if (res == true) {
			Assert.assertTrue(true);
			System.out.println("Validated successfully");
		} else {
			Assert.assertTrue(false);
			System.out.println("Email IDs are not matched");
		}
		Thread.sleep(4000);
	}

	@When("Validate Error message should be display")
	public void validate_error_message_should_be_display() {
		//macc.clickSendInviteBtn();
		boolean res = macc.validateErrormessage();
		if (res == true) {
			Assert.assertTrue(true);
			System.out.println("Error message occurred");
		} else {
			Assert.assertTrue(false);
			System.out.println("Error message not occurred");
		}

	}
	
	@When("I enter Invalid email id in the email field")
	public void i_enter_invalid_email_id_in_the_email_field() {
	    macc.getEmailID().sendKeys("dummy");
	    macc.getEmailID().sendKeys(Keys.RETURN);
	}
	
	@When("Validate Invalid Email ID Error message should be display")
	public void validate_invalid_email_id_error_message_should_be_display() {
	   boolean result = macc.validateInvalidEmailgrowl();
	   if (result == true) {
			Assert.assertTrue(true);
			System.out.println("invalid email id growl message");
		} else {
			Assert.assertTrue(false);
			System.out.println("Growl not presented");
		}
		
	}


	@When("I click on the Send invite button by passing excel data {string}")
	public void i_click_on_the_send_invite_button_by_passing_excel_data(String rows) throws InterruptedException {
		datamap = DataReader.data(System.getProperty("user.dir") + "\\testData\\neopat.xlsx", "Sheet3");
		int index = Integer.parseInt(rows) - 1;
		String campus = datamap.get(index).get("Campus");
		String AdmissionYear = datamap.get(index).get("Admissionyear");
		String PassoutYear = datamap.get(index).get("Passoutyear");
		String StudentType = datamap.get(index).get("Studenttype");
		String Department = datamap.get(index).get("Department");
		String DegreeSpecialization = datamap.get(index).get("Degreeandspecialization");
		//String res = datamap.get(index).get("res");
		String no = datamap.get(index).get("case");
		int a = Integer.parseInt(no);
		
		/*
		 * macc.clickCampus(); macc.selectData(campus); Thread.sleep(1000);
		 */
		switch (a) {
		case 1:
			macc.clickAdmissionYearField();
			macc.selectData(AdmissionYear); 
			Thread.sleep(1000);

			macc.clickPassOutYearField();
			macc.selectData(PassoutYear);
			Thread.sleep(1000);

			macc.clickStudentTypeField();
			macc.selectData(StudentType);
			Thread.sleep(1000);
			
			macc.EnterEmailID();
			Thread.sleep(1000);
			
			break;
			
		case 2:
			macc.clickCampus(); 
			macc.selectData(campus); 
			Thread.sleep(1000);

		default:
			break;
		}
		macc.clickAdmissionYearField();
		macc.selectData(AdmissionYear);
		Thread.sleep(1000);

		macc.clickPassOutYearField();
		macc.selectData(PassoutYear);
		Thread.sleep(1000);

		macc.clickStudentTypeField();
		macc.selectData(StudentType);
		Thread.sleep(1000);

		/*
		 * macc.clickDepartmentField(); macc.selectData(Department); Thread.sleep(1000);
		 * 
		 * macc.clickDegreeAndSpecializationField();
		 * macc.selectData(DegreeSpecialization); Thread.sleep(1000);
		 */

		macc.EnterEmailID();
		Thread.sleep(1000);

		// macc.clickSendInviteBtn();

	}
}
