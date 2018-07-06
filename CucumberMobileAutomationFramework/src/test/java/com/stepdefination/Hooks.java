/* ======================================================================= *
 *  (c) Copyright 2018-2019, ATOS India , WorldLine 
 *  All Rights Reserved
 *  Company Confidential
 *  Author :Aniket Dhotre
 *  Das Id :A681205
 * ======================================================================= *
 */

/**
 * Hooks are used in this page
 * closing mobile app and screenshot generation after every failure scenario is generated here and 
 * screen shot is attached to the reports
 * IMORTANT : Please create screen shot folder as mentioned in the config.properties so screen shot will be stored in that folder
 */

package com.stepdefination;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import com.cucumber.listener.Reporter;
import com.google.common.io.Files;
import com.utilties.TestBase;
import cucumber.api.Scenario;
import cucumber.api.java.After;

public class Hooks extends TestBase{
	@After(order=0)
	public void tearDownApp() throws Exception {
		try {
			TestBase.driver.quit();
			System.out.println("App Closed Sucessfully");
		} catch (Exception e) {
			System.out.println("Failed to close App");
		}
	}
	
	@After(order = 1)
	public void afterScenario(Scenario scenario) {
		if (scenario.isFailed()) {
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			try {
				//This takes a screenshot from the driver at save it to the specified location
				File sourcePath = ((TakesScreenshot) TestBase.driver).getScreenshotAs(OutputType.FILE);
				
				//Building up the destination path for the screenshot to save
				//Also make sure to create a folder 'screenshots' with in the cucumber-report folder
				File destinationPath = new File(""+TestBase.sScreenShotPath+""+screenshotName+".png");
				System.out.println("destinationPath = " +destinationPath);
				//Copy taken screenshot from source location to destination location
				Files.copy(sourcePath, destinationPath);   
 
				//This attach the specified screenshot to the test
				Reporter.addScreenCaptureFromPath(destinationPath.toString());
			} catch (IOException e) {
			} 
		}
	}
}
