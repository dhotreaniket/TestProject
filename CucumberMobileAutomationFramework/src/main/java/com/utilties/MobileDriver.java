/* ======================================================================= *
 *  (c) Copyright 2018-2019, ATOS India , WorldLine 
 *  All Rights Reserved
 *  Company Confidential
 *  Author :Aniket Dhotre
 *  Das Id :A681205
 * ======================================================================= *
 */

package com.utilties;

/**
 * Provides special mobile methods build using uiautomater. More method should be added as per requirement
 */

import java.util.Set;
import org.openqa.selenium.Dimension;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class MobileDriver {

	public ActionDriver actionDriver;

	public MobileDriver(AndroidDriver<MobileElement> driver) {
		TestBase.driver=driver;
	}

	/**
	 * Click on mobile element
	 * @throws Exception 
	 * @sId :id of mobile element
	 */

	public void clickByID(String sId) throws Exception{
		try {
			TestBase.driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().resourceId(\""+sId+"\").instance(0)")).click();
			Log.info("Click on mobile element for id = "+sId);
		} catch (Exception e) {
			Log.error("Click on mobile element for id = "+sId, e);
			throw new Exception();
		}
	}

	/**
	 * Get Text from mobile element
	 * @throws Exception 
	 * @sId :id of mobile text
	 */	
	public String getTextById(String sID) throws Exception{
		try {
			String sText=TestBase.driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().resourceId(\""+sID+"\").instance(0)")).getText();
			Log.info("Get Text By Id = " +sID);
			return sText;
		} catch (Exception e) {
			Log.error("Get Text By Id = " +sID, e);
			throw new Exception();
		}
	}

	/**
	 * Enter Text By using id
	 * @throws Exception 
	 * @sId :Id of mobile element
	 */	
	public void enterTextByID(String sId,String sText) throws Exception{
		try {
			TestBase.driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().resourceId(\""+sId+"\").instance(0)")).sendKeys(sText);
			Log.info("Enter Text by = "+sId+" & Text = "+sText);
		} catch (Exception e) {
			Log.error("Enter Text by ="+sId+" & Text = "+sText, e);
			throw new Exception();
		}
	}

	/**
	 * Clear and Enter Text By using id
	 * @throws Exception 
	 * @sId :Id of mobile element
	 */	
	public void enterTextAfterClearByID(String sId,String sText) throws Exception{
		try {
			MobileElement mobileElement=TestBase.driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().resourceId(\""+sId+"\").instance(0)"));
			mobileElement.clear();
			mobileElement.sendKeys(sText);
			Log.info("Clear and Enter Text by = "+sId+" & Text = "+sText);
		} catch (Exception e) {
			Log.error("Enter Text by ="+sId+" & Text = "+sText, e);
			throw new Exception();
		}		
	}

	/**
	 * Scroll to visible text using id as reference
	 * @throws Exception 
	 * @ScrollId :Id of mobile view to scroll
	 * @VisibleText :Text till we have to scroll
	 */	
	public void scrollToVisibleTextById(String sScrollId, String sVisibleText) throws Exception {
		try {
			TestBase.driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\""+sScrollId+"\")).scrollIntoView(new UiSelector().text(\""+sVisibleText+"\"));");
			Log.info("Scroll to Visible Text = "+sVisibleText+" for ScrollId = "+ sScrollId);
		} catch (Exception e) {
			Log.error("Scroll to Visible Text = "+sVisibleText+" for ScrollId = "+ sScrollId, e);
			throw new Exception();
		}
	}

	/**
	 * Scroll to visible text using class name
	 * @throws Exception 
	 * @sClassName :class name of mobile view to scroll
	 * @VisibleText :Text till we have to scroll
	 */	
	public void scrollToVisibleTextByClassName(String sClassName,String sVisibleText) throws Exception{
		try {
			TestBase.driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().className(\""+sClassName+"\")).scrollIntoView(new UiSelector().text(\""+sVisibleText+"\"));");	
			Log.info("Scroll to Visible Text = "+sVisibleText+" for Class Name = "+ sClassName);
		} catch (Exception e) {
			Log.error("Scroll to Visible Text = "+sVisibleText+" for ScrollId = "+ sClassName, e);
			throw new Exception();
		}
	}

	/**
	 * Scroll to visible text and click it by using class name
	 * @throws Exception 
	 * @sClassName :class name of mobile view to scroll
	 * @VisibleText :Text till we have to scroll
	 */	
	public void scrollToVisibleTextAndClickByClassName(String sClassName,String sVisibleText) throws Exception{
		try {
			TestBase.driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().className(\""+sClassName+"\")).scrollIntoView(new UiSelector().text(\""+sVisibleText+"\"));").click();
			Log.info("Scroll to Visible Text = "+sVisibleText+" for Class Name = "+ sClassName);
		} catch (Exception e) {
			Log.error("Scroll to Visible Text = "+sVisibleText+" for Class Name = "+ sClassName, e);
			throw new Exception();
		}
	}

	/**
	 * Scroll to visible text and click it by id
	 * @throws Exception 
	 * @sScrollId :id of mobile view to scroll
	 * @VisibleText :Text till we have to scroll
	 */	
	public void scrollToVisibleTextAndClickById(String sScrollId, String sVisibleText) throws Exception {	
		try {
			TestBase.driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\""+sScrollId+"\")).scrollIntoView(new UiSelector().text(\""+sVisibleText+"\"));").click();	
			Log.info("Scroll to Visible Text = "+sVisibleText+"for ScrollId = "+ sScrollId);
		} catch (Exception e) {
			Log.error("Scroll to Visible Text = "+sVisibleText+"for ScrollId = "+ sScrollId, e);
			throw new Exception();
		}
	}

	/**
	 * Scroll to Content Description by using Content Description as reference
	 * @throws Exception 
	 * @ContentDescription :Content Description of mobile view to scroll
	 * @ContentDescription2 :ContentDescription2 till we have to scroll
	 */
	public static void scrollToVisibleTextByContentDesc(String sContentDescription, String sContentDescription2) throws Exception {
		try {
			TestBase.driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().description(\""+sContentDescription+"\")).scrollIntoView(new UiSelector().description(\""+sContentDescription2+"\"));");
			Log.info("Scroll to Visible Text By Content Desc = "+sContentDescription+"for ScrollId = "+ sContentDescription);
		} catch (Exception e) {
			Log.error("Scroll to Visible Text By Content Desc = "+sContentDescription+"for ScrollId = "+ sContentDescription,e);
			throw new Exception();
		}
	}

	/**
	 * Scroll to Dimension ,it will be using size of existing mobile device to scroll
	 */
	public void scrollToDimension() throws InterruptedException {
		Dimension dimensions = TestBase.driver.manage().window().getSize();
		System.out.println("dimensions =" +dimensions);
		Double screenHeightStart = dimensions.getHeight() * 0.5;
		System.out.println("screenHeightStart =" +screenHeightStart);
		int scrollStart = screenHeightStart.intValue();
		System.out.println("scrollStart =" +scrollStart);
		Double screenHeightEnd = dimensions.getHeight() * 0.2;
		System.out.println("screenHeightEnd =" +screenHeightEnd);
		int scrollEnd = screenHeightEnd.intValue();
		System.out.println("scrollEnd =" +scrollEnd);
		TouchAction ta= new TouchAction(TestBase.driver);
		//  new TouchAction(driver).press(0, scrollStart).waitAction(2000)
		ta.press(0, scrollStart).waitAction().moveTo(0, scrollEnd).release().perform();
		System.out.println("Executed");
		initActionDriver();
		actionDriver.sleepThread(1);	
	}
	
	/**
	 * It will switch to web view from native app
	 */

	public  void switchToWebView(){
		Set<String> allContext = TestBase.driver.getContextHandles();
		for (String context : allContext) {
			System.out.println("context = "+ context);
			if (context.contains("WEBVIEW")){
				TestBase.driver.context(context);
				System.out.println("Trueeeee");
			}
			TestBase.driver.context(context);
			System.out.println("Not a webview,View ="+context);
		}	
	}

	public void initActionDriver() {
		actionDriver = new ActionDriver(TestBase.driver);
	}
}
