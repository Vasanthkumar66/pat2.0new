package stepDefinitions;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.poi.ss.formula.atp.Switch;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.java.en.Then;
import pageObjects.LoginPage;
import pageObjects.ManageStudentPage;
import utilities.DataReader;
import utilities.DataWriter;
import utilities.FileUtils;

public class bulkInvite {

	WebDriver driver;
	LoginPage lp;
	ManageStudentPage macc;
	Properties p;
	List<HashMap<String, String>> datamap;

	@Then("Clicks the bulk upload button")
	public void clicks_the_bulk_upload_button() throws InterruptedException, IOException {
		macc = new ManageStudentPage(BaseClass.getDriver());
		Thread.sleep(2000);
		macc.clickBulkInviteArrow();
		macc.clickBulkInviteBtn();
		FileUtils.deleteFilesInFolder(System.getProperty("user.dir") + "\\testData\\downloadData");
	}

	@Then("Uploads the file")
	public void uploads_the_file() throws IOException, InterruptedException {
//		p = BaseClass.getProperties();
//		macc.clickFileUploadBtn();
		DataWriter.data(System.getProperty("user.dir") + "\\testData\\bulkInvite.xlsx");
//		macc.fileUploadBtn.sendKeys(System.getProperty("user.dir")+"\\testData\\bulkInvite.xlsx"); 
//		macc.clickBulkInvitePreviewSaveBtn();
		Thread.sleep(3000);
	}

	@Then("Clicks the upload button")
	public void clicks_the_upload_button() {
		macc.clickBulkUploadBtn();
	}

	@Then("Validates the successfully uploaded growl message")
	public void validates_the_successfully_uploaded_growl_message() {
		boolean result = macc.validateBulkInviteSuccessGrowl();
		if (result == true) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
		macc.closeGrowl();
	}

	@Then("Opens the notification column")
	public void opens_the_notification_column() throws InterruptedException {
		macc = new ManageStudentPage(BaseClass.getDriver());
		Thread.sleep(5000);
		macc.clicknotificationBell();
		macc.clickMarkAllAsReadbtn();
		BaseClass.getDriver().navigate().refresh();
		Thread.sleep(5000);
		macc.clicknotificationBell();
		Thread.sleep(2000);
	}

	@Then("Downloads the bulk invite status file")
	public void downloads_the_bulk_invite_status_file() throws InterruptedException, IOException {
		p = BaseClass.getProperties();
		String filename = p.getProperty("bulkInvite");
		macc.clickUnreadMsg();
		macc.downloadBulkInviteStatusFile(filename);
		Thread.sleep(5000);
		FileUtils.renamethefile("bulkstatus.xlsx", System.getProperty("user.dir") + "\\testData\\downloadData");
	}

	@Then("Validates the remarks column in the file {string}")
	public void validates_the_remarks_column_in_the_file(String rows) throws IOException {

		for (int i = 1; i < 5; i++) {
			datamap = DataReader.data(System.getProperty("user.dir") + "\\testData\\downloadData\\bulkstatus.xlsx",
					"Sheet1");
			String remarks = datamap.get(i).get("remarks");
			switch (i) {
			case 1:
				if (remarks.equalsIgnoreCase("Student invited successfully")) {
					BaseClass.getLogger().info("Student invited successfully");
					Assert.assertTrue(true);
				} else {
					BaseClass.getLogger().info("Student not invited");
					Assert.assertTrue(false);
				}
				break;
			case 2:
				if (remarks.equalsIgnoreCase("Empty Campus")) {
					BaseClass.getLogger().info("Campus field is empty");
					Assert.assertTrue(true);
				} else {
					BaseClass.getLogger().info("campus field empty is failed");
					Assert.assertTrue(false);
				}
				break;
			case 3:
				if (remarks.equalsIgnoreCase("Invalid Campus")) {
					BaseClass.getLogger().info("Campus field is Invalid");
					Assert.assertTrue(true);
				} else {
					BaseClass.getLogger().info("Campus field Invalid is Failed");
					Assert.assertTrue(false);
				}
				break;
			case 4:
				if (remarks.equalsIgnoreCase("Empty/Invalid Admission Year")) {
					BaseClass.getLogger().info("Admission Year field is Empty");
					Assert.assertTrue(true);
				} else {
					BaseClass.getLogger().info("Admission Year field Empty is field");
					Assert.assertTrue(false);
				}
				break;
			case 5:
				if (remarks.equalsIgnoreCase("Empty/Invalid Admission Year")) {
					BaseClass.getLogger().info("Admission Year field is Invalid");
					Assert.assertTrue(true);
				} else {
					BaseClass.getLogger().info("Admission Year field Invalid is field");
					Assert.assertTrue(false);
				}
				break;
			case 6:
				if (remarks.equalsIgnoreCase("Empty/Invalid Pass Out Year")) {
					BaseClass.getLogger().info("Passout Year field is Empty");
					Assert.assertTrue(true);
				} else {
					BaseClass.getLogger().info("Passout Year field Empty is field");
					Assert.assertTrue(false);
				}
				break;
			case 7:
				if (remarks.equalsIgnoreCase("Empty/Invalid Pass Out Year")) {
					BaseClass.getLogger().info("Passout Year field is Invalid");
					Assert.assertTrue(true);
				} else {
					BaseClass.getLogger().info("Passout Year field Invalid is field");
					Assert.assertTrue(false);
				}
				break;
			case 8:
				if (remarks.equalsIgnoreCase("No fields mapped for this campus and passout year")) {
					BaseClass.getLogger().info("Passout Year field is not mapped into the campus");
					Assert.assertTrue(true);
				} else {
					BaseClass.getLogger().info("FAILED: Passout Year field is not mapped into the campus");
					Assert.assertTrue(false);
				}
				break;
			case 9:
				if (remarks.equalsIgnoreCase("Invalid Passed Out Year")) {
					BaseClass.getLogger().info("Passout Year field is overlapped into the admission year");
					Assert.assertTrue(true);
				} else {
					BaseClass.getLogger().info("FAILED: Passout Year field is overlapped into the admission year");
					Assert.assertTrue(false);
				}
				break;
			case 10:
				if (remarks.equalsIgnoreCase("Empty Department")) {
					BaseClass.getLogger().info("Department field is EMPTY");
					Assert.assertTrue(true);
				} else {
					BaseClass.getLogger().info("FAILED: Department field is EMPTY");
					Assert.assertTrue(false);
				}
				break;
			case 11:
			case 12:
				if (remarks.equalsIgnoreCase("Invalid Department")) {
					BaseClass.getLogger().info("Department field is INVALID");
					Assert.assertTrue(true);
				} else {
					BaseClass.getLogger().info("FAILED: Department field is INVALID");
					Assert.assertTrue(false);
				}
				break;
			case 13:
				if (remarks.equalsIgnoreCase("Empty Degree and Specialization")) {
					BaseClass.getLogger().info("Degree and Specialization field is EMPTY");
					Assert.assertTrue(true);
				} else {
					BaseClass.getLogger().info("FAILED: Degree and Specialization field is EMPTY");
					Assert.assertTrue(false);
				}
				break;
			case 14:
			case 15:
				if (remarks.equalsIgnoreCase("Invalid Degree And Specialization")) {
					BaseClass.getLogger().info("Degree And Specialization field is INVALID");
					Assert.assertTrue(true);
				} else {
					BaseClass.getLogger().info("FAILED: Degree And Specialization field is INVALID");
					Assert.assertTrue(false);
				}
				break;
			case 16:
				if (remarks.equalsIgnoreCase("Empty/Invalid Student Type")) {
					BaseClass.getLogger().info("Student type field is EMPTY");
					Assert.assertTrue(true);
				} else {
					BaseClass.getLogger().info("FAILED: Student type field is EMPTY");
					Assert.assertTrue(false);
				}
				break;
			case 17:
				if (remarks.equalsIgnoreCase("Empty/Invalid Student Type")) {
					BaseClass.getLogger().info("Student type field is INVALID");
					Assert.assertTrue(true);
				} else {
					BaseClass.getLogger().info("FAILED: Student type field is INVALID");
					Assert.assertTrue(false);
				}
				break;
			case 18:
				if (remarks.equalsIgnoreCase("Empty/Invalid First Name")) {
					BaseClass.getLogger().info("First name field is EMPTY");
					Assert.assertTrue(true);
				} else {
					BaseClass.getLogger().info("FAILED: First name field is EMPTY");
					Assert.assertTrue(false);
				}
				break;
			case 19:
				if (remarks.equalsIgnoreCase("Empty/Invalid First Name")) {
					BaseClass.getLogger().info("First name field is INVALID");
					Assert.assertTrue(true);
				} else {
					BaseClass.getLogger().info("FAILED: First name field is INVALID");
					Assert.assertTrue(false);
				}
				break;
			case 20:
				if (remarks.equalsIgnoreCase("Empty/Invalid Last Name")) {
					BaseClass.getLogger().info("Last name field is EMPTY");
					Assert.assertTrue(true);
				} else {
					BaseClass.getLogger().info("FAILED: Last name field is EMPTY");
					Assert.assertTrue(false);
				}
				break;
			case 21:
				if (remarks.equalsIgnoreCase("Empty/Invalid Last Name")) {
					BaseClass.getLogger().info("Last name field is INVALID");
					Assert.assertTrue(true);
				} else {
					BaseClass.getLogger().info("FAILED: Last name field is INVALID");
					Assert.assertTrue(false);
				}
				break;
			case 22:
				if (remarks.equalsIgnoreCase("Empty Email Address")) {
					BaseClass.getLogger().info("Email field is EMPTY");
					Assert.assertTrue(true);
				} else {
					BaseClass.getLogger().info("FAILED: Email field is EMPTY");
					Assert.assertTrue(false);
				}
				break;
			case 23:
				if (remarks.equalsIgnoreCase("Invalid Email Address")) {
					BaseClass.getLogger().info("Email field is INVALID");
					Assert.assertTrue(true);
				} else {
					BaseClass.getLogger().info("FAILED: Email field is INVALID");
					Assert.assertTrue(false);
				}
				break;
			case 24:
				if (remarks.equalsIgnoreCase("User Already Exists")) {
					BaseClass.getLogger().info("Email ID is already Exsits");
					Assert.assertTrue(true);
				} else {
					BaseClass.getLogger().info("FAILED: Email ID is already Exsits");
					Assert.assertTrue(false);
				}
				break;
			case 25:
				if (remarks.equalsIgnoreCase("Empty Date of Birth")) {
					BaseClass.getLogger().info("DOB field is EMPTY");
					Assert.assertTrue(true);
				} else {
					BaseClass.getLogger().info("FAILED: DOB field is EMPTY");
					Assert.assertTrue(false);
				}
				break;
			case 26:
				if (remarks.equalsIgnoreCase("Invalid Date of Birth")) {
					BaseClass.getLogger().info("DOB field is INAVLID");
					Assert.assertTrue(true);
				} else {
					BaseClass.getLogger().info("FAILED: DOB field is INAVLID");
					Assert.assertTrue(false);
				}
				break;
			case 27:
				if (remarks.equalsIgnoreCase("Empty Country Code")) {
					BaseClass.getLogger().info("Country code field is EMPTY");
					Assert.assertTrue(true);
				} else {
					BaseClass.getLogger().info("FAILED: Country code field is EMPTY");
					Assert.assertTrue(false);
				}
				break;
			case 28:
				if (remarks.equalsIgnoreCase("Invalid Country Code")) {
					BaseClass.getLogger().info("Country code field is INAVLID");
					Assert.assertTrue(true);
				} else {
					BaseClass.getLogger().info("FAILED: Country code field is INAVLID");
					Assert.assertTrue(false);
				}
				break;
			case 29:
				if (remarks.equalsIgnoreCase("Empty Mobile Number")) {
					BaseClass.getLogger().info("Mobile Number field is EMPTY");
					Assert.assertTrue(true);
				} else {
					BaseClass.getLogger().info("FAILED: Mobile Number field is EMPTY");
					Assert.assertTrue(false);
				}
				break;
			case 30:
				if (remarks.equalsIgnoreCase("Invalid Mobile Number")) {
					BaseClass.getLogger().info("Mobile Number field is INVALID");
					Assert.assertTrue(true);
				} else {
					BaseClass.getLogger().info("FAILED: Mobile Number field is INVALID");
					Assert.assertTrue(false);
				}
				break;
			case 31:
				if (remarks.equalsIgnoreCase("Phone Number already exists")) {
					BaseClass.getLogger().info("Phone Number already exists");
					Assert.assertTrue(true);
				} else {
					BaseClass.getLogger().info("FAILED: Phone Number already exists");
					Assert.assertTrue(false);
				}
				break;
			case 32:
				if (remarks.equalsIgnoreCase("Empty Gender")) {
					BaseClass.getLogger().info("Empty Gender");
					Assert.assertTrue(true);
				} else {
					BaseClass.getLogger().info("FAILED: Empty Gender");
					Assert.assertTrue(false);
				}
				break;
			case 33:
				if (remarks.equalsIgnoreCase("Invalid Gender")) {
					BaseClass.getLogger().info("Invalid Gender");
					Assert.assertTrue(true);
				} else {
					BaseClass.getLogger().info("FAILED: Invalid Gender");
					Assert.assertTrue(false);
				}
				break;
			case 34:
				if (remarks.equalsIgnoreCase("Empty Registration Number")) {
					BaseClass.getLogger().info("Empty Registration Number");
					Assert.assertTrue(true);
				} else {
					BaseClass.getLogger().info("FAILED: Empty Registration Number");
					Assert.assertTrue(false);
				}
				break;
			case 35:
				if (remarks.equalsIgnoreCase("Invalid Registration Number")) {
					BaseClass.getLogger().info("Invalid Registration Number");
					Assert.assertTrue(true);
				} else {
					BaseClass.getLogger().info("FAILED: Invalid Registration Number");
					Assert.assertTrue(false);
				}
				break;
			case 36:
				if (remarks.equalsIgnoreCase("Registration Number Already Exists")) {
					BaseClass.getLogger().info("Registration Number Already Exists");
					Assert.assertTrue(true);
				} else {
					BaseClass.getLogger().info("FAILED: Registration Number Already Exists");
					Assert.assertTrue(false);
				}
				break;
			case 37:
				if (remarks.equalsIgnoreCase("Empty 10th Percentage/CGPA")) {
					BaseClass.getLogger().info("Empty 10th Percentage/CGPA");
					Assert.assertTrue(true);
				} else {
					BaseClass.getLogger().info("FAILED: Empty 10th Percentage/CGPA");
					Assert.assertTrue(false);
				}
				break;
			case 38:
				if (remarks.equalsIgnoreCase("Invalid 10th Percentage/CGPA")) {
					BaseClass.getLogger().info("Invalid 10th Percentage/CGPA");
					Assert.assertTrue(true);
				} else {
					BaseClass.getLogger().info("FAILED: Invalid 10th Percentage/CGPA");
					Assert.assertTrue(false);
				}
				break;
			case 39:
				if (remarks.equalsIgnoreCase("Empty 10th CGPA")) {
					BaseClass.getLogger().info("Empty 10th CGPA");
					Assert.assertTrue(true);
				} else {
					BaseClass.getLogger().info("FAILED: Empty 10th CGPA");
					Assert.assertTrue(false);
				}
				break;
			case 40:
				if (remarks.equalsIgnoreCase("Empty 10th Percentage")) {
					BaseClass.getLogger().info("Empty 10th Percentage");
					Assert.assertTrue(true);
				} else {
					BaseClass.getLogger().info("FAILED: Empty 10th Percentage");
					Assert.assertTrue(false);
				}
				break;
			case 41:
				if (remarks.equalsIgnoreCase("Invalid 10th CGPA")) {
					BaseClass.getLogger().info("Invalid 10th CGPA");
					Assert.assertTrue(true);
				} else {
					BaseClass.getLogger().info("FAILED: Invalid 10th CGPA");
					Assert.assertTrue(false);
				}
				break;
			case 42:
				if (remarks.equalsIgnoreCase("Invalid 10th Percentage")) {
					BaseClass.getLogger().info("Invalid 10th Percentage");
					Assert.assertTrue(true);
				} else {
					BaseClass.getLogger().info("FAILED: Invalid 10th Percentage");
					Assert.assertTrue(false);
				}
				break;
			case 43:
				if (remarks.equalsIgnoreCase("Empty 10th Mark")) {
					BaseClass.getLogger().info("Empty 10th Mark");
					Assert.assertTrue(true);
				} else {
					BaseClass.getLogger().info("FAILED: Empty 10th Mark");
					Assert.assertTrue(false);
				}
				break;
			case 44:
				if (remarks.equalsIgnoreCase("Empty 12th Percentage/CGPA")) {
					BaseClass.getLogger().info("Empty 12th Percentage/CGPA");
					Assert.assertTrue(true);
				} else {
					BaseClass.getLogger().info("FAILED: Empty 12th Percentage/CGPA");
					Assert.assertTrue(false);
				}
				break;
			case 45:
				if (remarks.equalsIgnoreCase("Invalid 12th Percentage/CGPA")) {
					BaseClass.getLogger().info("Invalid 12th Percentage/CGPA");
					Assert.assertTrue(true);
				} else {
					BaseClass.getLogger().info("FAILED: Invalid 12th Percentage/CGPA");
					Assert.assertTrue(false);
				}
				break;
			case 46:
				if (remarks.equalsIgnoreCase("Empty 12th CGPA")) {
					BaseClass.getLogger().info("Empty 12th CGPA");
					Assert.assertTrue(true);
				} else {
					BaseClass.getLogger().info("FAILED: Empty 12th CGPA");
					Assert.assertTrue(false);
				}
				break;
			case 47:
				if (remarks.equalsIgnoreCase("Empty 12th Percentage")) {
					BaseClass.getLogger().info("Empty 12th Percentage");
					Assert.assertTrue(true);
				} else {
					BaseClass.getLogger().info("FAILED: Empty 12th Percentage");
					Assert.assertTrue(false);
				}
				break;
			case 48:
				if (remarks.equalsIgnoreCase("Invalid 12th CGPA")) {
					BaseClass.getLogger().info("Invalid 12th CGPA");
					Assert.assertTrue(true);
				} else {
					BaseClass.getLogger().info("FAILED: Invalid 12th CGPA");
					Assert.assertTrue(false);
				}
				break;
			case 49:
				if (remarks.equalsIgnoreCase("Invalid 12th Percentage")) {
					BaseClass.getLogger().info("Invalid 12th Percentage");
					Assert.assertTrue(true);
				} else {
					BaseClass.getLogger().info("FAILED: Invalid 12th Percentage");
					Assert.assertTrue(false);
				}
				break;
			case 50:
				if (remarks.equalsIgnoreCase("Empty 12th Mark")) {
					BaseClass.getLogger().info("Empty 12th Mark");
					Assert.assertTrue(true);
				} else {
					BaseClass.getLogger().info("FAILED: Empty 12th Mark");
					Assert.assertTrue(false);
				}
				break;
			case 51:
				if (remarks.equalsIgnoreCase("Empty Diploma Percentage/CGPA")) {
					BaseClass.getLogger().info("Empty Diploma Percentage/CGPA");
					Assert.assertTrue(true);
				} else {
					BaseClass.getLogger().info("FAILED: Empty Diploma Percentage/CGPA");
					Assert.assertTrue(false);
				}
				break;
			case 52:
				if (remarks.equalsIgnoreCase("Invalid Diploma Percentage/CGPA")) {
					BaseClass.getLogger().info("Invalid Diploma Percentage/CGPA");
					Assert.assertTrue(true);
				} else {
					BaseClass.getLogger().info("FAILED: Invalid Diploma Percentage/CGPA");
					Assert.assertTrue(false);
				}
				break;
			case 53:
				if (remarks.equalsIgnoreCase("Empty Diploma CGPA")) {
					BaseClass.getLogger().info("Empty Diploma CGPA");
					Assert.assertTrue(true);
				} else {
					BaseClass.getLogger().info("FAILED: Empty Diploma CGPA");
					Assert.assertTrue(false);
				}
				break;
			case 54:
				if (remarks.equalsIgnoreCase("Empty Diploma Percentage")) {
					BaseClass.getLogger().info("Empty Diploma Percentage");
					Assert.assertTrue(true);
				} else {
					BaseClass.getLogger().info("FAILED: Empty Diploma Percentage");
					Assert.assertTrue(false);
				}
				break;
			case 55:
				if (remarks.equalsIgnoreCase("Invalid Diploma CGPA")) {
					BaseClass.getLogger().info("Invalid Diploma CGPA");
					Assert.assertTrue(true);
				} else {
					BaseClass.getLogger().info("FAILED: Invalid Diploma CGPA");
					Assert.assertTrue(false);
				}
				break;
			case 56:
				if (remarks.equalsIgnoreCase("Invalid Diploma Percentage")) {
					BaseClass.getLogger().info("Invalid Diploma Percentage");
					Assert.assertTrue(true);
				} else {
					BaseClass.getLogger().info("FAILED: Invalid Diploma Percentage");
					Assert.assertTrue(false);
				}
				break;
			case 57:
				if (remarks.equalsIgnoreCase("Empty Diploma Mark")) {
					BaseClass.getLogger().info("Empty Diploma Mark");
					Assert.assertTrue(true);
				} else {
					BaseClass.getLogger().info("FAILED: Empty Diploma Mark");
					Assert.assertTrue(false);
				}
				break;
			case 58:
				if (remarks.equalsIgnoreCase("Empty UG Percentage/CGPA")) {
					BaseClass.getLogger().info("Empty UG Percentage/CGPA");
					Assert.assertTrue(true);
				} else {
					BaseClass.getLogger().info("FAILED: Empty UG Percentage/CGPA");
					Assert.assertTrue(false);
				}
				break;
			case 59:
				if (remarks.equalsIgnoreCase("Invalid UG Percentage/CGPA")) {
					BaseClass.getLogger().info("Invalid UG Percentage/CGPA");
					Assert.assertTrue(true);
				} else {
					BaseClass.getLogger().info("FAILED: Invalid UG Percentage/CGPA");
					Assert.assertTrue(false);
				}
				break;
			case 60:
				if (remarks.equalsIgnoreCase("Empty UG CGPA")) {
					BaseClass.getLogger().info("Empty UG CGPA");
					Assert.assertTrue(true);
				} else {
					BaseClass.getLogger().info("FAILED: Empty UG CGPA");
					Assert.assertTrue(false);
				}
				break;
			case 61:
				if (remarks.equalsIgnoreCase("Empty UG Percentage")) {
					BaseClass.getLogger().info("Empty UG Percentage");
					Assert.assertTrue(true);
				} else {
					BaseClass.getLogger().info("FAILED: Empty UG Percentage");
					Assert.assertTrue(false);
				}
				break;
			case 62:
				if (remarks.equalsIgnoreCase("Invalid UG CGPA")) {
					BaseClass.getLogger().info("Invalid UG CGPA");
					Assert.assertTrue(true);
				} else {
					BaseClass.getLogger().info("FAILED: Invalid UG CGPA");
					Assert.assertTrue(false);
				}
				break;
			case 63:
				if (remarks.equalsIgnoreCase("Invalid UG Percentage")) {
					BaseClass.getLogger().info("Invalid UG Percentage");
					Assert.assertTrue(true);
				} else {
					BaseClass.getLogger().info("FAILED: Invalid UG Percentage");
					Assert.assertTrue(false);
				}
				break;
			case 64:
				if (remarks.equalsIgnoreCase("Empty UG Mark")) {
					BaseClass.getLogger().info("Empty UG Mark");
					Assert.assertTrue(true);
				} else {
					BaseClass.getLogger().info("FAILED: Empty UG Mark");
					Assert.assertTrue(false);
				}
				break;
			case 65:
				if (remarks.equalsIgnoreCase("Empty PG Percentage/CGPA")) {
					BaseClass.getLogger().info("Empty PG Percentage/CGPA");
					Assert.assertTrue(true);
				} else {
					BaseClass.getLogger().info("FAILED: Empty PG Percentage/CGPA");
					Assert.assertTrue(false);
				}
				break;
			case 66:
				if (remarks.equalsIgnoreCase("Invalid PG Percentage/CGPA")) {
					BaseClass.getLogger().info("Invalid PG Percentage/CGPA");
					Assert.assertTrue(true);
				} else {
					BaseClass.getLogger().info("FAILED: Invalid PG Percentage/CGPA");
					Assert.assertTrue(false);
				}
				break;
			case 67:
				if (remarks.equalsIgnoreCase("Empty PG CGPA")) {
					BaseClass.getLogger().info("Empty PG CGPA");
					Assert.assertTrue(true);
				} else {
					BaseClass.getLogger().info("FAILED: Empty PG CGPA");
					Assert.assertTrue(false);
				}
				break;
			case 68:
				if (remarks.equalsIgnoreCase("Empty PG Percentage")) {
					BaseClass.getLogger().info("Empty PG Percentage");
					Assert.assertTrue(true);
				} else {
					BaseClass.getLogger().info("FAILED: Empty PG Percentage");
					Assert.assertTrue(false);
				}
				break;
			case 69:
				if (remarks.equalsIgnoreCase("Invalid PG CGPA")) {
					BaseClass.getLogger().info("Invalid PG CGPA");
					Assert.assertTrue(true);
				} else {
					BaseClass.getLogger().info("FAILED: Invalid PG CGPA");
					Assert.assertTrue(false);
				}
				break;
			case 70:
				if (remarks.equalsIgnoreCase("Invalid PG Percentage")) {
					BaseClass.getLogger().info("Invalid PG Percentage");
					Assert.assertTrue(true);
				} else {
					BaseClass.getLogger().info("FAILED: Invalid PG Percentage");
					Assert.assertTrue(false);
				}
				break;
			case 71:
				if (remarks.equalsIgnoreCase("Empty PG Mark")) {
					BaseClass.getLogger().info("Empty PG Mark");
					Assert.assertTrue(true);
				} else {
					BaseClass.getLogger().info("FAILED: Empty PG Mark");
					Assert.assertTrue(false);
				}
				break;
			case 72:
				if (remarks.equalsIgnoreCase("Empty Backlog History")) {
					BaseClass.getLogger().info("Empty Backlog History");
					Assert.assertTrue(true);
				} else {
					BaseClass.getLogger().info("FAILED: Empty Backlog History");
					Assert.assertTrue(false);
				}
				break;
			case 73:
				if (remarks.equalsIgnoreCase("Invalid Backlog History")) {
					BaseClass.getLogger().info("Invalid Backlog History");
					Assert.assertTrue(true);
				} else {
					BaseClass.getLogger().info("FAILED: Invalid Backlog History");
					Assert.assertTrue(false);
				}
				break;
			case 74:
				if (remarks.equalsIgnoreCase("Empty Current Backlogs")) {
					BaseClass.getLogger().info("Empty Current Backlogs");
					Assert.assertTrue(true);
				} else {
					BaseClass.getLogger().info("FAILED: Empty Current Backlogs");
					Assert.assertTrue(false);
				}
				break;
			case 75:
				if (remarks.equalsIgnoreCase("Invalid Current Backlogs")) {
					BaseClass.getLogger().info("Invalid Current Backlogs");
					Assert.assertTrue(true);
				} else {
					BaseClass.getLogger().info("FAILED: Invalid Current Backlogs");
					Assert.assertTrue(false);
				}
				break;
			case 76:
				if (remarks.equalsIgnoreCase("Empty Placement Interest")) {
					BaseClass.getLogger().info("Empty Placement Interest");
					Assert.assertTrue(true);
				} else {
					BaseClass.getLogger().info("FAILED: Empty Placement Interest");
					Assert.assertTrue(false);
				}
				break;
			case 77:
				if (remarks.equalsIgnoreCase("Invalid Placement Interest")) {
					BaseClass.getLogger().info("Invalid Placement Interest");
					Assert.assertTrue(true);
				} else {
					BaseClass.getLogger().info("FAILED: Invalid Placement Interest");
					Assert.assertTrue(false);
				}
				break;
				
			default:
				System.out.println("Index not present");
				break;
			}
		}
	}
}
