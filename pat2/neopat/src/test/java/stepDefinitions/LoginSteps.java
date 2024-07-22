package stepDefinitions;

import java.util.HashMap;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LoginPage;
import pageObjects.ManageStudentPage;
import utilities.DataReader;

public class LoginSteps {
     WebDriver driver;
     LoginPage lp;
     ManageStudentPage macc;
  
     List<HashMap<String, String>> datamap; //Data driven

 
    @When("user enters email as {string} and password as {string}")
    public void user_enters_email_as_and_password_as(String email, String pwd) {
    	BaseClass.getLogger().info("Entering email and password.. ");
    	
    	lp=new LoginPage(BaseClass.getDriver());
       	lp.setEmail(email);
        lp.setPassword(pwd);
        }

    @When("the user clicks on the Login button")
    public void click_on_login_button() throws InterruptedException {
        lp.clickLogin();
        BaseClass.getLogger().info("clicked on login button...");
        Thread.sleep(5000);
        
    }


    @Then("the user should be redirected to the Manage Student Page")
    public void the_user_should_be_redirected_to_the_manage_student_page() throws InterruptedException {
    	macc=new ManageStudentPage(BaseClass.getDriver());
		boolean targetpage=macc.validateManageStudentPage();

		if(targetpage == true) {
			BaseClass.getLogger().info("logged in successfully");
			 Assert.assertTrue(true);
		} else {
			BaseClass.getLogger().info("login Failure");
			 Assert.assertTrue(false);
		}
		
    }

    //*******   Data Driven test **************
    @Then("the user should be redirected to the Manage student Page by passing email and password with excel row {string}")
    public void the_user_should_be_redirected_to_the_manage_student_page_by_passing_email_and_password_with_excel_row(String rows) throws InterruptedException
    {
        datamap=DataReader.data(System.getProperty("user.dir")+"\\testData\\neopat.xlsx", "Sheet1");

        int index=Integer.parseInt(rows)-1;
        String email= datamap.get(index).get("username");
        String pwd= datamap.get(index).get("password");
        String exp_res= datamap.get(index).get("res");

        lp=new LoginPage(BaseClass.getDriver());
        BaseClass.getLogger().info("Entering email and password.. ");
        lp.setEmail(email);
        lp.setPassword(pwd);

        lp.clickLogin();
        Thread.sleep(5000);
        macc=new ManageStudentPage(BaseClass.getDriver());
        try
        {
            boolean targetpage=macc.validateManageStudentPage();
            System.out.println("target page: "+ targetpage);
            if(exp_res.equals("Valid"))
            {
                if(targetpage==true)
                {
					
                    Assert.assertTrue(true);
                    BaseClass.getLogger().info("Logged in successfully");
                }
                else
                {
                    Assert.assertTrue(false);
                    BaseClass.getLogger().info("Login failure");
                }
            }

            if(exp_res.equals("Invalid"))
            {
                if(targetpage==true)
                {
                    
                    Assert.assertTrue(false);
                    BaseClass.getLogger().info("Login failure");
                }
                else
                {
                    Assert.assertTrue(true);
                    BaseClass.getLogger().info("Login failure");
                }
            }


        }
        catch(Exception e)
        {

            Assert.assertTrue(false);
        }
      }
 
}
