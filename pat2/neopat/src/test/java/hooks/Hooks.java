package hooks;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;




public class Hooks {

	 WebDriver driver;
	 Properties p;
     
	@Before
    public void setup() throws IOException
    {
    	driver=BaseClass.initilizeBrowser();
    	    	
    	p=BaseClass.getProperties();
    	driver.get(p.getProperty("appURL"));
    	driver.manage().window().maximize();
    
    			
	}
		
    
    @After
    public void tearDown(Scenario scenario) {
        		
       driver.quit();
       
    }
    

    @AfterStep
    public void addScreenshot(Scenario scenario) {
        
    	// this is for cucumber junit report
        if(scenario.isFailed()) {
        	
        	TakesScreenshot ts=(TakesScreenshot) driver;
        	byte[] screenshot=ts.getScreenshotAs(OutputType.BYTES);
        	scenario.attach(screenshot, "image/png",scenario.getName());
        	            
        }
		/*
		 * // Upload the report to FTP server try { String localFilePath =
		 * "C:/Users/VasanthkumarV/Desktop/neopat/test-output/SparkReport 12-07-24 11-12-19/Report/CucumberExtentReport.html"
		 * ; String remoteFilePath = "/remote/path/CucumberExtentReport.html"; String
		 * server = "ftp.server.com"; String user = "username"; String pass =
		 * "password"; FTPUpload.uploadFile(localFilePath, remoteFilePath, server, user,
		 * pass); } catch (IOException e) { e.printStackTrace(); }
		 */
      
    }
   
}
