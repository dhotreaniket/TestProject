/* ======================================================================= *
 *  (c) Copyright 2018-2019, ATOS India , WorldLine 
 *  All Rights Reserved
 *  Company Confidential
 *  Author :Aniket Dhotre
 *  Das Id :A681205
 * ======================================================================= *
 */

/**
 * Basic Runner class where execution of all feature file is controlled from here
 * After class configuration for report is also configured here
 */
package com.runners;

import java.io.File;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import com.cucumber.listener.Reporter;
import com.utilties.TestBase;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/com/bdd/feature/", 
		glue={ "com.stepdefination" },
		tags ={"@LaunchApp"},
		monochrome = true, 
	    plugin = { "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html" }) 


public class BookTicketRunner {
	
	@AfterClass
	public static void writeExtentReport() {
		Reporter.loadXMLConfig(new File(TestBase.sExtentReportPath));
		Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
	    Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
	    Reporter.setSystemInfo("Machine", 	"Windows 7" + " [64 Bit]");
	    Reporter.setSystemInfo("Selenium", "3.6.0");
	    Reporter.setSystemInfo("Maven", "3.6.2");
	    Reporter.setSystemInfo("Java Version", "1.8.0_151");
	    Reporter.assignAuthor("Aniket Dhotre");   
	    }
}
