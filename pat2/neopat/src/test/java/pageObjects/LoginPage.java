package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import factory.BaseClass;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@type='email']")
	WebElement txtEmailAddress;

	@FindBy(xpath = "//input[@type='password']")
	WebElement txtPassword;

	@FindBy(xpath = "//span[@type='submit']")
	WebElement btnLogin;

	@FindBy(xpath = "//label[@class='forgot-password']")
	WebElement forgotPassword;

	@FindBy(xpath = "//div[@class='success-msg-container ng-star-inserted']//span")
	WebElement forgotPasswordResponse;

	@FindBy(xpath = "//span[contains(text(),'Reset Password')]")
	WebElement resetPassword;

	public void setEmail(String email) {
		txtEmailAddress.sendKeys(email);
	}

	public void setPassword(String pwd) {
		txtPassword.sendKeys(pwd);
	}

	public void clickLogin() {
		btnLogin.click();
	}

	public void clickForgotPassword() {
		forgotPassword.click();
	}

	public String forgotPasswordResponse() {
		return forgotPasswordResponse.getText();
	}

	public void clickResetPasswordBtn() {
		resetPassword.click();
	}

	public boolean isValidateResetPasswordResponse() {
		try {
			String success = BaseClass.getProperties().getProperty("ResetPasswordSuccessResponse");
			String failure = BaseClass.getProperties().getProperty("ResetPasswordFailureResponse");
			//System.out.println("Main Response: "+forgotPasswordResponse());
			String response = forgotPasswordResponse();
			//System.out.println("succes: "+success);
			//System.out.println("failure: "+failure);
			return response.equalsIgnoreCase(success) || response.equalsIgnoreCase(failure);
		} catch (Exception e) {
			System.out.println("Exception occurred: " + e.getMessage());
			return false;
		}
	}

}
