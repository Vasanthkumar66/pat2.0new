package factory;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.ManageStudentPage;
import pageObjects.manageDrive;

public class BaseClass {

	static WebDriver driver;
	static Properties p;
	static Logger logger;
	static ManageStudentPage macc;
	static manageDrive md;

	public static WebDriver initilizeBrowser() throws IOException {

		/*
		 * if(getProperties().getProperty("execution_env").equalsIgnoreCase("remote")) {
		 * DesiredCapabilities capabilities = new DesiredCapabilities();
		 * 
		 * //os if (getProperties().getProperty("os").equalsIgnoreCase("windows")) {
		 * capabilities.setPlatform(Platform.WIN11); } else if
		 * (getProperties().getProperty("os").equalsIgnoreCase("mac")) {
		 * capabilities.setPlatform(Platform.MAC); } else {
		 * System.out.println("No matching OS.."); } //browser switch
		 * (getProperties().getProperty("browser").toLowerCase()) { case "chrome":
		 * capabilities.setBrowserName("chrome"); break; case "edge":
		 * capabilities.setBrowserName("MicrosoftEdge"); break; default:
		 * System.out.println("No matching browser"); }
		 * 
		 * driver = new RemoteWebDriver(new
		 * URL("http://localhost:4444/wd/hub"),capabilities);
		 * 
		 * }else
		 */
		if (getProperties().getProperty("execution_env").equalsIgnoreCase("local")) {
			System.out.println("Browser name:" + getProperties().getProperty("browser").toLowerCase());
			switch (getProperties().getProperty("browser").toLowerCase()) {

			case "chrome":
				/*
				 * // Setup ChromeOptions ChromeOptions options = new ChromeOptions();
				 * 
				 * // Enable headless mode options.addArguments("--headless");
				 */

				String downloadPath = System.getProperty("user.dir") + "\\testData\\downloadData";
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--enable-notifications");

				// Set preferences to automatically allow notifications
				Map<String, Object> prefs = new HashMap<>();
				prefs.put("profile.default_content_setting_values.notifications", 1); // 1: Allow, 2: Block
				prefs.put("download.default_directory", downloadPath);
				prefs.put("download.prompt_for_download", false);
				prefs.put("download.directory_upgrade", true);
				prefs.put("safebrowsing.enabled", true);

				options.setExperimentalOption("prefs", prefs);

				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver(options);
				break;
			default:
				System.out.println("No matching browser");
				driver = null;
			}
		}
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));

		return driver;

	}

	public static WebDriver getDriver() {
		return driver;
	}

	public static Properties getProperties() throws IOException {
		FileReader file = new FileReader(System.getProperty("user.dir") + "\\src\\test\\resources\\config.properties");

		p = new Properties();
		p.load(file);
		return p;
	}

	public static Logger getLogger() {
		logger = LogManager.getLogger(); // Log4j
		return logger;
	}

	public static String randomeString() {
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}

	public static String randomeNumber(int no) {
		String generatedString = RandomStringUtils.randomNumeric(no);
		return generatedString;
	}

	public static String randomAlphaNumeric() {
		String str = RandomStringUtils.randomAlphabetic(5);
		String num = RandomStringUtils.randomNumeric(10);
		return str + num;
	}

	public static void elementToBeClickable(WebDriver driver, WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}

	public static void elementToVisibility(WebDriver driver, WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(ele));
		System.out.println("");
	}

	public static void allElementToVisibility(WebDriver driver, List<WebElement> ele) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfAllElements(ele));
		System.out.println(" ");
	}

	public static void Dropdown_selection(List<WebElement> ele, String value) {
		macc = new ManageStudentPage(driver);
		allElementToVisibility(driver, macc.getDataList());
		for (WebElement element : ele) {
			String str = element.getText();
			if (str.equalsIgnoreCase(value)) {
				element.click();
				break;
			}
		}
	}

	public static void dropdown_multiselection(List<WebElement> ele1, String value1, String value2) {
		md = new manageDrive(driver);
		allElementToVisibility(driver, md.getSelectDriveType());
		for (WebElement ele : ele1) {
			String type = ele.getText();
			if (type.equalsIgnoreCase(value1) || type.equalsIgnoreCase(value2)) {
				ele.click();
			}
		}
	}

	public static void Dropdown_selectionNested(List<WebElement> ele, List<WebElement> ele1, String value1,
			String values2) {
		for (WebElement element : ele) {
			for (WebElement element1 : ele1) {
				element1.click();
			}
		}
	}

	public static void moveToTwoElement(WebDriver driver, WebElement ele, WebElement ele1) {
		Actions action = new Actions(driver);
		action.moveToElement(ele).moveToElement(ele1).click().perform();
		System.out.println();
	}

}
