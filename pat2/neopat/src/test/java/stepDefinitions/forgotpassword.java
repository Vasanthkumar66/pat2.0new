package stepDefinitions;

import java.util.HashMap;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pageObjects.LoginPage;
import pageObjects.ManageStudentPage;
import utilities.DataReader;

public class forgotpassword {

	WebDriver driver;
	LoginPage lp;
	ManageStudentPage macc;

	List<HashMap<String, String>> datamap; // Data driven

	@Given("User should be redirected to forgot passowrd page by clicking forgot password button")
	public void user_should_be_redirected_to_forgot_passowrd_page_by_clicking_forgot_password_button() {
		lp = new LoginPage(BaseClass.getDriver());
		lp.clickForgotPassword();
	}

	@Then("the forgot password response should be display in the top of the screen by passing email with excel row {string}")
	public void the_forgot_password_response_should_be_display_in_the_top_of_the_screen_by_passing_email_with_excel_row(
			String rows) throws InterruptedException {
		datamap = DataReader.data(System.getProperty("user.dir") + "\\testData\\neopat.xlsx", "Sheet2");

		int index = Integer.parseInt(rows) - 1;
		String email = datamap.get(index).get("username");
		String Exp_res = datamap.get(index).get("res");

		lp.setEmail(email);
		lp.clickResetPasswordBtn();
		Thread.sleep(4000);

		try {
			boolean result = lp.isValidateResetPasswordResponse();
			System.out.println("Result: " + result);
			if (Exp_res.equalsIgnoreCase("Valid")) {

				if (result == true) {
					Assert.assertTrue(true);
				} else {
						Assert.assertTrue(false);
				}

			} else if (Exp_res.equalsIgnoreCase("Invalid")) {
				if (result == true) {
					Assert.assertTrue(true);
				} else {
					Assert.assertTrue(false);
				}

			}
		} catch (Exception e) {
			Assert.fail("Exception occurred: " + e.getMessage());
		}

	}

}
