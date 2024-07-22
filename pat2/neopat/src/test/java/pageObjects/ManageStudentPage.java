package pageObjects;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import factory.BaseClass;

public class ManageStudentPage extends BasePage {

	public String email;
	public Set<String> emailSet = new HashSet<>();

	public ManageStudentPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//span[text()='Manage Students']") // MyAccount Page heading
	public WebElement manageStudentHeading;

	@FindBy(xpath = "//div[@class='list-group']//a[text()='Logout']")
	public WebElement lnkLogout;

	@FindBy(xpath = "//span[contains(text(),'Bulk Invite')]")
	public WebElement inviteBtn;

	@FindBy(xpath = "//div[@class='admission-department']//p-dropdown")
	public WebElement campus;

	@FindBy(xpath = "//ul[@role='listbox']//li")
	public List<WebElement> dataList;

	@FindBy(xpath = "(//div[@class='admission-passedout']//p-dropdown)[1]")
	public WebElement admissionYear;

	@FindBy(xpath = "(//div[@class='admission-passedout']//p-dropdown)[2]")
	public WebElement passOutYear;

	@FindBy(xpath = "(//div[@class='admission-passedout']//p-dropdown)[3]")
	public WebElement studentType;

	@FindBy(xpath = "(//div[@class='department-degreespec']//p-dropdown)[1]")
	public WebElement Department;

	@FindBy(xpath = "(//div[@class='department-degreespec']//p-dropdown)[2]")
	public WebElement degreeAndSpecialization;

	@FindBy(xpath = "//div[@class='p-chips p-component']//li/input")
	public WebElement emailID;

	@FindBy(xpath = "//button[contains(text(),'Invite')]")
	public WebElement sendInvite;

	@FindBy(xpath = "//input[@placeholder='Email or Registration Number']")
	public WebElement searchFilter;

	@FindBy(xpath = "//table/tbody/tr[1]/td[2]/span")
	public WebElement studentEmailID;

	@FindBy(xpath = "//span[contains(text(),'Clear All')]")
	public WebElement clearFilter;

	@FindBy(xpath = "//table/tbody/tr/td[2]/span")
	public List<WebElement> multipleIds;

	@FindBy(xpath = "//div[contains(text(),'Please fill in all required fields')]")
	public WebElement inviteErrorGrowlmsg;

	@FindBy(xpath = "//div[contains(text(),'Invite process initiated. Kindly check the notification after some time.')]")
	public WebElement inviteSuccessGrowlMsg;

	@FindBy(xpath = "//div[contains(text(),'Please enter a valid email address')]")
	public WebElement invalidEmailGrowl;

	@FindBy(xpath = "(//button[@type='button'])[3]")
	public WebElement bulkInviteArrow;

	@FindBy(xpath = "//span[contains(text(),'Bulk Upload')]")
	public WebElement bulkInviteBtn;

	@FindBy(xpath = "//input[@type='file']")
	public WebElement fileUploadBtn;

	@FindBy(xpath = "//span[contains(text(),'Save')]")
	public WebElement bulkInvitePreviewSaveBtn;

	@FindBy(xpath = "//button[contains(text(),' Upload ')]")
	public WebElement bulkUploadBtn;

	@FindBy(xpath = "//span[@class='bell-icon pi pi-bell']")
	public WebElement notificationBell;

	@FindBy(xpath = "//u[contains(text(),'Mark all as read')]")
	public WebElement markAllAsReadbtn;

	@FindBy(xpath = "//div[@class='notification-container']/div[1]/div[1]")
	public List<WebElement> bulkInviteStatusFileName;

	@FindBy(xpath = "//div[@class='notification-container']/div[1]/div[2]")
	public List<WebElement> newNotifications;

	@FindBy(xpath = "//span[@class='download-notification-data']")
	public List<WebElement> downloadNotification;

	@FindBy(xpath = "//div[contains(text(),'A background process has started. You will be notified when the download is complete.')]")
	public WebElement bulkInviteSuccessGrowl;

	@FindBy(xpath = "//button[@type='button']/timesicon")
	public WebElement closeGrowlBtn;

	@FindBy(xpath = "(//div[@class='p-hidden-accessible']/following-sibling::span)[2]")
	public WebElement unreadMsg;

	public boolean validateManageStudentPage() // validate the manage student page URL
	{
		try {
			String url = BaseClass.getProperties().getProperty("manageStudentPageURL");
			String expected = BaseClass.getDriver().getCurrentUrl();
			return url.equalsIgnoreCase(expected);
		} catch (Exception e) {
			System.out.println("Exception occurred: " + e.getMessage());
			return false;
		}
	}

	public void clickLogout() {
		lnkLogout.click();

	}

	public void clickInviteBtn() {
		BaseClass.elementToBeClickable(driver, inviteBtn);
		inviteBtn.click();
	}

	public void clickCampus() {
		BaseClass.elementToBeClickable(driver, campus);
		campus.click();
	}

	public void clickAdmissionYearField() {
		BaseClass.elementToBeClickable(driver, admissionYear);
		admissionYear.click();
	}

	public void selectData(String ele) {
		try {
			BaseClass.Dropdown_selection(dataList, ele);
		} catch (Exception e) {
			System.out.println("Exception occurred: " + e.getMessage());
		}
	}

	public List<WebElement> getDataList() {
		return dataList;
	}

	public void clickPassOutYearField() {
		BaseClass.elementToBeClickable(driver, passOutYear);
		passOutYear.click();
	}

	public void clickStudentTypeField() {
		BaseClass.elementToBeClickable(driver, studentType);
		studentType.click();
	}

	public void clickDepartmentField() {
		BaseClass.elementToBeClickable(driver, Department);
		Department.click();
	}

	public void clickDegreeAndSpecializationField() {
		BaseClass.elementToBeClickable(driver, degreeAndSpecialization);
		degreeAndSpecialization.click();
	}

	public void EnterEmailID() {
		email = BaseClass.randomeString() + "@examly.in";
		System.out.println(email);
		emailID.sendKeys(email);
		emailID.sendKeys(Keys.RETURN);
	}

	public void sendMultipleEmailID(int a) {
		int n = a;
		for (int i = 0; i < n; i++) {
			String id = BaseClass.randomeString() + "@examly.in";
			emailSet.add(id);
			emailID.sendKeys(id);
			emailID.sendKeys(Keys.RETURN);
		}
	}

	public void clickSendInviteBtn() {
		BaseClass.elementToBeClickable(driver, sendInvite);
		sendInvite.click();
	}

	// search student data
	public void singleSearch() {
		BaseClass.elementToBeClickable(driver, clearFilter);
		clearFilter.click();
		searchFilter.sendKeys(email);
		searchFilter.sendKeys(Keys.RETURN);
	}

	public void multiSearch() {
		StringBuilder concatenatedString = new StringBuilder();
		for (String email : emailSet) {
			concatenatedString.append(email).append(" ");
		}
		// Remove the trailing space
		if (concatenatedString.length() > 0) {
			concatenatedString.setLength(concatenatedString.length() - 1);
		}

		searchFilter.sendKeys(concatenatedString.toString());
		searchFilter.sendKeys(Keys.RETURN);
	}

	public boolean isvalidatemailID() {
		try {
			String createdEmail = studentEmailID.getText();
			return email.equalsIgnoreCase(createdEmail);
		} catch (Exception e) {
			System.out.println("Exception occurred: " + e.getMessage());
			return false;
		}
	}

	public boolean isvalidateMultipleID() {
		try {
			int count = 0;
			for (String i : emailSet) {
				for (WebElement j : multipleIds) {
					String k = j.getText();
					if (k.equalsIgnoreCase(i)) {
						count++;
					}
				}
			}
			return count == emailSet.size();
		} catch (Exception e) {
			System.out.println("Exception occurred: " + e.getMessage());
			return false;
		}

	}

	public boolean validateErrormessage() {
		// return inviteErrorGrowlmsg.isDisplayed();
		try {
			String exp = "Please fill in all required fields";
			String a = inviteErrorGrowlmsg.getText();
			System.out.println("Error essage: " + a);
			return exp.equalsIgnoreCase(a);
		} catch (Exception e) {
			System.out.println("Exception occurred: " + e.getMessage());
			return false;
		}
	}

	public boolean validateSuccessMessage() {
		try {
			String exp = "Invite process initiated. Kindly check the notification after some time.";
			String a = inviteSuccessGrowlMsg.getText();
			return exp.equalsIgnoreCase(a);
		} catch (Exception e) {
			System.out.println("Exception occurred: " + e.getMessage());
			return false;
		}
	}

	public boolean validateInvalidEmailgrowl() {
		try {
			String exp = "Please enter a valid email address";
			String a = invalidEmailGrowl.getText();
			return exp.equalsIgnoreCase(a);
		} catch (Exception e) {
			System.out.println("Exception occurred: " + e.getMessage());
			return false;
		}
	}

	public WebElement getEmailID() {
		return emailID;
	}

	public void clickBulkInviteArrow() {
		BaseClass.elementToBeClickable(driver, bulkInviteArrow);
		bulkInviteArrow.click();
	}

	public void clickBulkInviteBtn() {
		BaseClass.elementToBeClickable(driver, bulkInviteBtn);
		bulkInviteBtn.click();
	}

	public void clickFileUploadBtn() {
		BaseClass.elementToBeClickable(driver, fileUploadBtn);
		fileUploadBtn.click();

	}

	public WebElement getFileUploadBtn() {
		return fileUploadBtn;
	}

	public void clickBulkInvitePreviewSaveBtn() {
		BaseClass.elementToBeClickable(driver, bulkInvitePreviewSaveBtn);
		bulkInvitePreviewSaveBtn.click();
	}

	public void clickBulkUploadBtn() {
		BaseClass.elementToBeClickable(driver, bulkUploadBtn);
		bulkUploadBtn.click();
	}

	public void clicknotificationBell() {
		BaseClass.elementToBeClickable(driver, notificationBell);
		notificationBell.click();
	}

	public void clickMarkAllAsReadbtn() {
		BaseClass.elementToBeClickable(driver, markAllAsReadbtn);
		markAllAsReadbtn.click();
	}

	public void downloadBulkInviteStatusFile(String filename) {
		System.out.println("size: "+bulkInviteStatusFileName.size());
		for (int i = 0; i <= bulkInviteStatusFileName.size() - 1; i++) {
			
			//System.out.println("start...");
			String fn = bulkInviteStatusFileName.get(i).getText();
			System.out.println("Filename:" +fn);
			if (fn.equalsIgnoreCase(filename)) {
				BaseClass.moveToTwoElement(driver, bulkInviteStatusFileName.get(i), downloadNotification.get(i));
				System.out.println("file downloaded");
				break;
			}
		}
    }

	public boolean validateBulkInviteSuccessGrowl() {
		try {
			return bulkInviteSuccessGrowl.isDisplayed();

		} catch (Exception e) {
			System.out.println("Exception occurred: " + e.getMessage());
			return false;
		}
	}

	public void closeGrowl() {
		closeGrowlBtn.click();
	}

	public void clickUnreadMsg() {
		unreadMsg.click();
	}
}
