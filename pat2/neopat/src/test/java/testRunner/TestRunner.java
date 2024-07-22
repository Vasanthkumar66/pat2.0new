package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
					//features= {".//Features/bulkInvite.feature"},
					//features= {".//Features/Login.feature"},
					features= {".//Features/LoginDDTExcel.feature",".//Features/forgotPassword.feature/"},
					//features= {".//Features/Login.feature",".//Features/Registration.feature"},
					//features= {"@target/rerun.txt"},
					//features = {".//Features/LoginDDTExcel.feature",".//Features/forgotPassword.feature/",".//Features/SingleInvite.feature"},
					//features =  {".//Features/SingleInvite.feature"},
					glue={"stepDefinitions","hooks"},
					plugin= {"pretty", "html:reports/myreport.html", 
							  "rerun:target/rerun.txt",
							  "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
							},		
					dryRun=false,    // checks mapping between scenario steps and step definition methods
					monochrome=true,    // to avoid junk characters in output
					publish=true,
					//tags ="@sanity"
					tags = "@Regression or @sanity"
					//tags="@sanity and @regression" //Scenarios tagged with both @sanity and @regression
					//tags="@sanity and not @regression" //Scenarios tagged with @sanity but not tagged with @regression
					//tags="@sanity or @regression" //Scenarios tagged with either @sanity or @regression
		)
public class TestRunner {

		}
