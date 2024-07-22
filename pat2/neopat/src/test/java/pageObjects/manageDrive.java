package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import factory.BaseClass;

public class manageDrive extends BasePage {

	public List<String> loc = new ArrayList<String>();

	// constructor
	public manageDrive(WebDriver driver) {
		super(driver);
	}

	// Find elements
	@FindBy(xpath = "(//button[@tooltipposition='left'])[2]")
	public WebElement driveMenu;

	@FindBy(xpath = "//span[contains(text(),'Single Profile Drive')]")
	public WebElement singleProfileDriveBtn;

	@FindBy(xpath = "(//input[@id='inputtext'])[1]")
	public WebElement driveName;

	@FindBy(xpath = "//div[contains(text(),'Select Drive Type')]")
	public WebElement driveTypeDropdown;

	@FindBy(xpath = "//ul[@role='listbox']//li//span")
	public List<WebElement> dropdownOptions;

	@FindBy(xpath = "//div[@data-placeholder=\"Drive Description\"]")
	public WebElement driveDescription;

	@FindBy(xpath = "//span[contains(text(),\"upload files\")]")
	public WebElement uploadFile;

	@FindBy(xpath = "//label[contains(text(),'Drive SPOC')]/preceding-sibling::input")
	public WebElement driveSpoc;

	@FindBy(xpath = "//div[@class='create-background']/div[2]/span")
	public WebElement companyInfo;

	@FindBy(xpath = "//p-dropdown[@optionlabel='company_name']")
	public WebElement selectCompany;

	@FindBy(xpath = "//p-dropdown[@optionlabel='company_category']")
	public WebElement selectCompanycategory;

	@FindBy(xpath = "(//div[@class='p-chips p-component'])[1]//li/input")
	public WebElement enterLocation;

	@FindBy(xpath = "//div[@class='create-background']/div[3]/span")
	public WebElement profileSalartInfo;

	@FindBy(xpath = "(//div[@class='p-chips p-component'])[2]//li/input")
	public WebElement designation;

	@FindBy(xpath = "//div[@class='flex gap-10']//p-checkbox")
	public List<WebElement> salaryStipendType;

	@FindBy(xpath = "(//div[@aria-haspopup='listbox']//preceding-sibling::span)[3]")
	public WebElement salaryDropdown;

	@FindBy(xpath = "//div[@class='radio-btns ng-star-inserted']/div/div")
	public List<WebElement> salaryType;

	@FindBy(xpath = "//input[@formcontrolname='fixedSalary']")
	public WebElement fixedSalary;

	@FindBy(xpath = "//p-checkbox[@formcontrolname='salaryBreak']/div")
	public WebElement enableSalaryBreakup;

	@FindBy(xpath = "//input[@formcontrolname='salaryFixed']")
	public WebElement breakupFixedsalary;

	@FindBy(xpath = "//input[@formcontrolname='salaryVariable']")
	public WebElement breakupVariableSalary;

	@FindBy(xpath = "(//div[@aria-haspopup='listbox']//preceding-sibling::span)[4]")
	public WebElement stippedType;

	@FindBy(xpath = "//input[@formcontrolname='fixedStipend']")
	public WebElement stippendFixedSalary;

	@FindBy(xpath = "//input[@formcontrolname='fromRange']")
	public WebElement rangeFromsalary;

	@FindBy(xpath = "//input[@formcontrolname='toRange']")
	public WebElement rangeTosalary;

	@FindBy(xpath = "//div[@class='create-background']/div[4]/span")
	public WebElement placementInfo;

	@FindBy(xpath = "//div[@class='radio-btns']/div/div")
	public List<WebElement> placementDateType;

	@FindBy(xpath = "(//input[@autocomplete='off'])[1]")
	public WebElement placementDate;

	@FindBy(xpath = "(//input[@autocomplete='off'])[2]")
	public WebElement lastDatetoApply;

	@FindBy(xpath = "//chevronrighticon//ancestor::button")
	public WebElement forwardArrow;

	@FindBy(xpath = "//td//span")
	public List<WebElement> date;

	@FindBy(xpath = "//p-checkbox[@formcontrolname='pre_placement_talk']/div")
	public WebElement prePlacementtalk;

	@FindBy(xpath = "(//input[@autocomplete='off'])[3]")
	public WebElement talkDate;

	@FindBy(xpath = "//p-checkbox[@formcontrolname='resume_selection']/div")
	public WebElement requestResumeSelection;

	@FindBy(xpath = "//input[@formcontrolname='talk_venue']")
	public WebElement talkVenue;

	@FindBy(xpath = "//p-checkbox[@formcontrolname='opt_out_reason']/div")
	public WebElement declinereason;

	@FindBy(xpath = "//p-checkbox[@class='p-element ng-touched ng-dirty ng-valid']/div")
	public List<WebElement> declineReasons;

	// Actions
	public void clickDriveMenu() {
		driveMenu.click();
	}

	public void clickSingleProfileDriveBtn() {
		singleProfileDriveBtn.click();
	}

	public void enterDriveName() {
		String drivename = "NeoDrive" + BaseClass.randomeNumber(3);
		driveName.sendKeys(drivename);
	}

	public void singleSelectDriveType(String value) {
		driveTypeDropdown.click();
		BaseClass.Dropdown_selection(dropdownOptions, value);
	}

	public void multiSelectDriveType(String value1, String value2) {
		driveTypeDropdown.click();
		BaseClass.dropdown_multiselection(dropdownOptions, value1, value2);
	}

	public List<WebElement> getSelectDriveType() {
		return dropdownOptions;
	}

	public void enterDriveDescription() {
		driveDescription.sendKeys("Join us for our upcoming placement drive, where top companies "
				+ "will be recruiting talented students. This event offers a unique opportunity to "
				+ "interact with industry leaders and secure your dream job. Prepare your resumes, "
				+ "dress professionally, and bring your A-game. Don't miss out on this chance to jumpstart your career!");
	}

	public void uploadDriveFile() {
		uploadFile.sendKeys(System.getProperty("user-dir") + "//testData//driveFiles//file_example_ODP_1MB.odp");
	}

	public void enterDriveSpoc() {
		driveSpoc.sendKeys("vasanth");
	}

	public void clickCompanyinfo() {
		companyInfo.click();
	}

	public void selectCompanyName(String value) {
		selectCompany.click();
		BaseClass.Dropdown_selection(dropdownOptions, value);
	}

	public void selectCompanycategory(String value) {
		selectCompanycategory.click();
		BaseClass.Dropdown_selection(dropdownOptions, value);
	}

	public void enterLocation(int a) {
		loc.add("Coimbatore");
		loc.add("Bangalore");
		loc.add("Chennai");
		loc.add("Erode");
		loc.add("Salem");
		loc.add("Hyderabad");
		loc.add("Cochin");

		for (int i = 0; i < a; i++) {
			enterLocation.sendKeys(loc.get(i));
			enterLocation.sendKeys(Keys.RETURN);
		}
	}

	public void clickProfileSalaryinfo() {
		profileSalartInfo.click();
	}

	public void enterProfile() {
		designation.sendKeys("Developer");
		designation.sendKeys(Keys.RETURN);
	}

	public void selectSalaryOrStippendType(String value) {
		if (value.equalsIgnoreCase("Salary")) {
			salaryStipendType.get(0).click();
		} else if (value.equalsIgnoreCase("Stipend")) {
			salaryStipendType.get(1).click();
		}
	}

	public void selectPlacementDate(String value) {
		if (value.equalsIgnoreCase("Confirmed Date")) {
			placementDateType.get(0).click();
		} else if (value.equalsIgnoreCase("Tentative Date")) {
			placementDateType.get(1).click();
		} else if (value.equalsIgnoreCase("To be Announced")) {
			placementDateType.get(2).click();
		}
	}

	public void selectSalaryType(String value) {
		salaryDropdown.click();
		BaseClass.Dropdown_selection(dropdownOptions, value);
	}

	public void selectSalaryAndStippendType(String value) {
		switch (value) {
		case "Fixed Salary":
			salaryStipendType.get(0).click();
			break;
		case "Range":
			salaryStipendType.get(1).click();
			break;
		case "To be Announced":
			salaryStipendType.get(2).click();
			break;
		case "Fixed Stipend":
			salaryStipendType.get(3).click();
			break;
		case "Stippend - To be Announced":
			salaryStipendType.get(4).click();
			break;
		default:
			break;
		}
	}

	public void enterFixedSalary(int value) {
		fixedSalary.sendKeys(String.valueOf(value));
	}

	public void enableSalaryBreakup() {
		enableSalaryBreakup.click();
	}

	public void enterBreakupSalaryFixed(int value) {
		breakupFixedsalary.sendKeys(String.valueOf(value));
	}

	public void enterBreakupSalaryVariable(int value) {
		breakupVariableSalary.sendKeys(String.valueOf(value));
	}

	public void selectStippendType(String value) {
		stippedType.click();
		BaseClass.Dropdown_selection(dropdownOptions, value);
	}

	public void enterStippendFixedSalary(int value) {
		stippendFixedSalary.sendKeys(String.valueOf(value));
	}

	public void enterRangeSalary(int value1, int value2) {
		rangeFromsalary.sendKeys(String.valueOf(value1));
		rangeTosalary.sendKeys(String.valueOf(value2));
	}

	public void selectPlacementDate(int value) {
		placementDate.click();
		forwardArrow.click();
		for (WebElement ele : date) {
			int a = Integer.parseInt(ele.getText());
			if (a == value) {
				ele.click();
			}
		}
	}

	public void selectLastDateToApply(int value) {
		lastDatetoApply.click();
		forwardArrow.click();
		for (WebElement ele : date) {
			int a = Integer.parseInt(ele.getText());
			if (a == value) {
				ele.click();
			}
		}
	}

	public void fillPrePlacementTalk(int value, String value1) {
		talkDate.click();
		forwardArrow.click();
		for (WebElement ele : date) {
			int a = Integer.parseInt(ele.getText());
			if (a == value) {
				ele.click();
			}
		}
		talkVenue.sendKeys(value1);
	}

	public void enableResumrSelection() {
		requestResumeSelection.click();
	}

	public void declineReason(String value) {
		String[] options = value.split(",");
		
		for (int i = 0; i < options.length; i++) {
			int option = Integer.parseInt(options[i]);
			switch (option) {
			case 1:
				declineReasons.get(option-1).click();
				break;
			case 2:
				declineReasons.get(option-1).click();
				break;
			case 3:
				declineReasons.get(option-1).click();
				break;
			case 4:
				declineReasons.get(option-1).click();
				break;
			default:
				System.out.println("Unexpected value"+options[i]);
				break;
			}
		}

	}
}
