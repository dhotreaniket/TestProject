/* ======================================================================= *
 *  (c) Copyright 2018-2019, ATOS India , WorldLine 
 *  All Rights Reserved
 *  Company Confidential
 *  Author :Aniket Dhotre
 *  Das Id :A681205
 * ======================================================================= *
 */
package com.utilties;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

/**
 * Provides common methods for web and mobile . More method should be added as per requirement
 */

public class ActionDriver {

	/**Android Desired Capabilies*/
	public static DesiredCapabilities capabilities;
	public static AndroidDriver<MobileElement> driver;
	MobileElement mobileElement;

	private int TIME_OUT_EXPLICIT_WAIT=15;
	private int TIME_OUT_IMPLICIT_WAIT=15;

	public ActionDriver(AndroidDriver<MobileElement> driver) {
		TestBase.driver=driver;
	}

	/**
	 * Retrieves the locatertype with value
	 * @LocaterType :example id,class,xpath
	 * @LocaterType :actual value of locater type
	 */
	public By getLocator(String sLocatorType,String sLocatorValue){	
		if (sLocatorType.toLowerCase().equals("id"))
			return By.id(sLocatorValue);
		else if(sLocatorType.toLowerCase().equals("name"))
			return By.name(sLocatorValue);
		else if((sLocatorType.toLowerCase().equals("classname")) || (sLocatorType.toLowerCase().equals("class")))
			return By.className(sLocatorValue);
		else if((sLocatorType.toLowerCase().equals("tagname")) || (sLocatorType.toLowerCase().equals("tag")))
			return By.className(sLocatorValue);
		else if((sLocatorType.toLowerCase().equals("linktext")) || (sLocatorType.toLowerCase().equals("link")))
			return By.linkText(sLocatorValue);
		else if(sLocatorType.toLowerCase().equals("partiallinktext") || (sLocatorType.toLowerCase().equals("partiallink")))
			return By.partialLinkText(sLocatorValue);
		else if((sLocatorType.toLowerCase().equals("cssselector")) || (sLocatorType.toLowerCase().equals("css")))
			return By.cssSelector(sLocatorValue);
		else if(sLocatorType.toLowerCase().equals("xpath"))
			return By.xpath(sLocatorValue);
		else
			try {
				throw new Exception("sLocator type '" + sLocatorType + "' not defined!!");
			} catch (Exception e) {
				Log.error("while getting Web Object details", e);
				return null;
			}
	}

	/**
	 * Wait for visibility of element
	 * @throws Exception 
	 * @LocaterType :example id,class,xpath
	 * @LocaterType :actual value of locater type
	 */
	public void waitForVisibiltyOfElement(String sLocaterType,String sLocaterValue) throws Exception{
		try {
			WebDriverWait wait= new WebDriverWait(TestBase.driver,TIME_OUT_EXPLICIT_WAIT);
			wait.until(ExpectedConditions.visibilityOfElementLocated(getLocator(sLocaterType,sLocaterValue)));	
			Log.info("Waiting for element to be visible Locater Type = "+sLocaterType+" & locater value = " +sLocaterValue);
		} catch (Exception e) {
			Log.error("Waiting for element Locater Type = "+sLocaterType+" & locater value  =" +sLocaterValue, e);
			throw new Exception();
		}
	}
	
	/**
	 * Wait for visibility of element for given time
	 * @throws Exception 
	 * @LocaterType :example id,class,xpath
	 * @LocaterType :actual value of locater type
	 */
	public void waitForVisibiltyOfElement(int iTimeInSeconds,String sLocaterType,String sLocaterValue) throws Exception{
		try {
			WebDriverWait wait= new WebDriverWait(TestBase.driver,iTimeInSeconds);
			wait.until(ExpectedConditions.visibilityOfElementLocated(getLocator(sLocaterType,sLocaterValue)));	
			Log.info("Waiting for element to be visible Locater Type = "+sLocaterType+" & locater value = " +sLocaterValue);
		} catch (Exception e) {
			Log.error("Waiting for element Locater Type = "+sLocaterType+" & locater value = " +sLocaterValue, e);
			throw new Exception();
		}
	}

	/**
	 * Wait for element to be clickable
	 * @throws Exception 
	 * @LocaterType :example id,class,xpath
	 * @LocaterType :actual value of locater type
	 */
	public void waitForElementToBeClickable(String sLocaterType,String sLocaterValue) throws Exception{
		try {
			WebDriverWait wait= new WebDriverWait(TestBase.driver,TIME_OUT_EXPLICIT_WAIT);
			wait.until(ExpectedConditions.elementToBeClickable(getLocator(sLocaterType, sLocaterValue)));
			Log.info("Waiting for element to be clickable Locater Type = "+sLocaterType+" & locater value = " +sLocaterValue);
		} catch (Exception e) {
			Log.error("Waiting for element to be clickable Locater Type = "+sLocaterType+" & locater value = " +sLocaterValue, e);
			throw new Exception();
		}
	}

	/**
	 * Wait for element to be clickable with given time 
	 * @throws Exception 
	 * @sTimeInSeconds :Will wait for given time in seconds
	 * @LocaterType :example id,class,xpath
	 * @LocaterType :actual value of locater type
	 */
	public void waitForElementToBeClickable(int sTimeInSeconds,String sLocaterType,String sLocaterValue) throws Exception{
		try {
			WebDriverWait wait= new WebDriverWait(TestBase.driver,sTimeInSeconds);
			wait.until(ExpectedConditions.elementToBeClickable(getLocator(sLocaterType, sLocaterValue)));	
			Log.info("Waiting for element to be clickable for given time Locater Type = "+sLocaterType+" & locater value = " +sLocaterValue);
		} catch (Exception e) {
			Log.error("Waiting for element to be clickable Locater Type = "+sLocaterType+" & locater value = " +sLocaterValue, e);
			throw new Exception();
		}				
	}

	/**
	 * Wait for element to be clickable
	 * @throws Exception 
	 * WebElement : web element to be located
	 * @LocaterType :actual value of locater type
	 */
	public void waitForElementToBeClickable_ByWebElement(WebElement element) throws Exception{
		try {
			WebDriverWait wait= new WebDriverWait(TestBase.driver,TIME_OUT_EXPLICIT_WAIT);
			wait.until(ExpectedConditions.elementToBeClickable(element));
			Log.info("Waiting for element to be clickable ,web Element = "+element);
		} catch (Exception e) {
			Log.error("Waiting for element to be clickable ,web Element = "+element, e);
			throw new Exception();
		}		
	}

	/**
	 * Wait for element to be enable
	 * @throws Exception 
	 * @sTimeInSeconds :Will wait for given time in seconds
	 * @LocaterType :example id,class,xpath
	 * @LocaterType :actual value of locater type
	 */	
	public void waitForElementToBeEnable(String sLocaterType,String sLocaterValue) throws Exception{
		try {
			for(int i=0; i<7; ++i){
				Boolean flag = TestBase.driver.findElement(getLocator(sLocaterType, sLocaterValue)).isEnabled();
				if(flag==true)
					break;
				else
					sleepThread(5);
			}
			Log.info("Waiting for element to be enable for given time Locater Type = "+sLocaterType+" & locater value = " +sLocaterValue);
		} catch (Exception e) {	
			Log.error("Waiting for element to be enable Locater Type = "+sLocaterType+" & locater value = " +sLocaterValue, e);
			throw new Exception();
		}		
	}

	/**
	 * Wait for given time
	 * @throws Exception 
	 * @timeInSeconds : time in seconds
	 */	
	public  void sleepThread(int timeInSeconds) throws InterruptedException{
		Thread.sleep(1000*timeInSeconds);
	}

	/**
	 * Implicit Wait
	 */
	public void wait_Implicit(){
		TestBase.driver.manage().timeouts().implicitlyWait(TIME_OUT_IMPLICIT_WAIT, TimeUnit.SECONDS);	
	}

	/**
	 * Wait for element and switch to frame
	 * @throws Exception 
	 * @LocaterType :example id,class,xpath
	 * @LocaterType :actual value of locater type
	 */	
	public void waitAndSwitchToFrame(String sLocaterType,String sLocaterValue) throws Exception{
		try {
			WebDriverWait wait= new WebDriverWait(TestBase.driver,TIME_OUT_EXPLICIT_WAIT);
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(getLocator(sLocaterType, sLocaterValue)));
			Log.info("Wait and switch to frame for Locater Type = "+sLocaterType+" & locater value = " +sLocaterValue);
		} catch (Exception e) {
			Log.error("Wait and switch to frame Locater Type = "+sLocaterType+" & locater value = " +sLocaterValue, e);
			throw new Exception();
		}		
	}

	/**
	 * Close App
	 */	
	public void closeApp(){
		TestBase.driver.quit();
	}

	/**
	 * Select by visible text
	 * @throws Exception 
	 * @WebELement :WebElement for selecting Text
	 * @Text :Text to be selected
	 */	
	public static void selectByVisibleText(WebElement sWebELement,String sText) throws Exception{
		try {
			Select select= new Select(sWebELement);
			select.selectByVisibleText(sText);
			Log.info("Select By visible Text WebELement = "+sWebELement+" & sText = "+sText);
		} catch (Exception e) {
			Log.error("Select By visible Text WebELement = "+sWebELement+" & sText = "+sText, e);
			throw new Exception();
		}		
	}
	
	/**
	 * Select by value
	 * @throws Exception 
	 * @WebELement :WebElement for selecting value
	 * @Value :Value to be selected
	 */	
	public static void selectByValue(WebElement sWebELement,String sValue) throws Exception{
		try {
			Select select= new Select(sWebELement);
			select.selectByValue(sValue);
			Log.info("Select By visible Text WebELement ="+sWebELement+" & sText = " +sValue);
		} catch (Exception e) {
			Log.error("Select By visible Text WebELement ="+sWebELement+" & sText = " +sValue, e);
			throw new Exception();
		}		
	}

	/**
	 * Select by index
	 * @throws Exception 
	 * @WebELement :WebElement for selecting value
	 * @iIndex :Index to be selected
	 */	
	public static void selectByIndex(WebElement sWebELement,int iIndex) throws Exception{
		try {
			Select select= new Select(sWebELement);
			select.selectByIndex(iIndex);
			Log.info("Select By visible Text WebELement = "+sWebELement+" & sText = " +iIndex);
		} catch (Exception e) {
			Log.error("Select By visible Text WebELement ="+sWebELement+" & sText = " +iIndex, e);
			throw new Exception();
		}		
	}

	/**
	 * Click a particular element
	 * @throws Exception 
	 * @LocaterType :example id,class,xpath
	 * @LocaterType :actual value of locater type
	 */	
	public void clickElement(String sLocaterType,String sLocaterValue) throws Exception{
		try {
			TestBase.driver.findElement(getLocator(sLocaterType, sLocaterValue)).click();
			Log.info("Click a particular Element ="+sLocaterType+" & sText = " +sLocaterValue);
		} catch (Exception e) {
			Log.error("Click a element for Locater Type ="+sLocaterType+" & locater value=" +sLocaterValue, e);
			throw new Exception();
		}
	}

	/**
	 * Clears and Enter Text
	 * @throws Exception 
	 * @LocaterType :example id,class,xpath
	 * @LocaterType :actual value of locater type
	 */	
	public void enterTextAfterClear(String sLocatorType,String sLocatorValue,String sText) throws Exception{
		try {
			mobileElement=TestBase.driver.findElement(getLocator(sLocatorType, sLocatorValue));
			mobileElement.clear();
			mobileElement.sendKeys(sText);
			Log.info("Enter Text after Clear for Locater Type = "+sLocatorType+" & sLocatorValue = " +sLocatorValue);
		} catch (Exception e) {
			Log.error("Enter Text and clear for Locater Type = "+sLocatorType+" & slocater value=" +sLocatorValue, e);
			throw new Exception();
		}		
	}
}