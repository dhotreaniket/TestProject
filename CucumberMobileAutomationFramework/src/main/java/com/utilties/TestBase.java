/* ======================================================================= *
 *  (c) Copyright 2018-2019, ATOS India , WorldLine 
 *  All Rights Reserved
 *  Company Confidential
 *  Author :Aniket Dhotre
 *  Das Id :A681205
 * ======================================================================= *
 */

/**
 * It is one of the important class in framework. Execution start from this class
 *  Reading property file , log file and Launching of app code is written in this class
 *  When any new page is created ,object is declared here
 *  Every "Page" and "Step Defination" should be extended to this class
 */

package com.utilties;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;
import com.configreader.PropertyFile;
import com.pageObjects.BookingRefferencePage;
import com.pageObjects.BuyPage;
import com.pageObjects.PaymentGatewayPage;
import com.pageObjects.ReviewYourOrderPage;
import com.pageObjects.SeatsAndExtrasPage;
import com.pageObjects.SelectTicketPage;
import com.pageObjects.SelectTrainPage;
import com.pageObjects.SignInPage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;


public class TestBase {

	/**The Project Name*/
	public static String sProjectName;

	/**The PlatForm Name*/
	public static String sPlatformName;

	/**Appium_Url*/
	public static String sAppium_URl;

	/**The Real Device Type*/
	public static String sDeviceType;

	/**The Virtual Device Type*/
	public static String sVirtualDeviceName;

	/**The Device Name*/
	public static String sDeviceName;

	/**The Platform Version*/
	public static String sPlatformVersion;

	/**The App Package*/
	public static String sAppPackage;

	/**The App Activity*/
	public static String sAppActivity;

	/**The App Wait Activity*/
	public static String sAppWaitActivity;

	/**The Extent Report Path*/
	public static String sExtentReportPath;

	/**The ScreenShot Path Path*/
	public static String sScreenShotPath;

	/**Android Driver*/
	public static AndroidDriver<MobileElement> driver;

	/**Android Desired Capabilies*/
	public static DesiredCapabilities capabilities;

	/**Action Driver variable*/
	public static ActionDriver actionDriver;


	/**The Flag to check whether or not reporting and other setup is done*/	
	public static boolean bFlag = false;

	/**The Property File Object*/	
	private PropertyFile oPropertyFile;

	/**The ImplicitWait*/	
	public static int iImplicitWait=80;

	/**Booking Reference variable is declared here*/
	public static String  sBookingRefferenceNumber;

	public BuyPage buyPage;
	public TestBase testBase;
	public SelectTrainPage selectTrainPage;
	public SelectTicketPage selectTicketPage;
	public SeatsAndExtrasPage seatsAndExtrasPage;
	public ReviewYourOrderPage reviewYourOrderPage;
	public SignInPage signInPage;
	public PaymentGatewayPage paymentGatewayPage;
	public BookingRefferencePage bookingRefferencePage;
	public String sDisplayedBookingReferenceNumber;


	/**
	 * Default Constructor of the TestBase class
	 * Reading Configuration and other information
	 * @throws FileNotFoundException 
	 */
	public TestBase(){
		if (bFlag == false){
			try {
				Log.info("Automated Test Execution started");
				oPropertyFile = new PropertyFile();
				readApplicationConfiguration();
				bFlag = true;
			} catch (Exception e) {
				Log.error("while setting up execution enviornment", e);
			}
		}
	}

	/**
	 * Reads config.properties file 
	 */
	
	public void readApplicationConfiguration() {
		oPropertyFile = new PropertyFile();
		InputStream in = this.getClass().getResourceAsStream("/config.properties");
		oPropertyFile.loadFile(in);
		sProjectName = oPropertyFile.getValue("ProjectName");
		Log.info("Project Name :  "+sProjectName);

		sPlatformName = oPropertyFile.getValue("PlatformName");
		Log.info("sPlatformName :  "+sPlatformName);

		sAppium_URl = oPropertyFile.getValue("Appium_URl");
		Log.info("sAppium_URl :  "+sAppium_URl);

		sDeviceType = oPropertyFile.getValue("DeviceType");
		Log.info("sDeviceType  :  "+sDeviceType);

		sDeviceName = oPropertyFile.getValue("DeviceName");
		Log.info("sDeviceName  :  "+sDeviceName);

		sVirtualDeviceName = oPropertyFile.getValue("VirtualDeviceName");
		Log.info("VirtualDeviceName  :  "+sVirtualDeviceName);

		sPlatformVersion = oPropertyFile.getValue("platformVersion");
		Log.info("sPlatformVersion  :  "+sPlatformVersion);

		sAppPackage = oPropertyFile.getValue("appPackage");
		Log.info("sAppPackage  :  "+sAppPackage);

		sAppActivity = oPropertyFile.getValue("appActivity");
		Log.info("sAppActivity  :  "+sAppActivity);

		sAppWaitActivity = oPropertyFile.getValue("appWaitActivity");
		Log.info("sAppWaitActivity  :  "+sAppWaitActivity);

		sExtentReportPath = oPropertyFile.getValue("extentpath");
		Log.info("ExtentReportPath  :  "+sExtentReportPath);

		sScreenShotPath = oPropertyFile.getValue("screenshotpath");
		Log.info("ScreenShotPath  :  "+sScreenShotPath);
		System.out.println("ScreenShotPath :"+sScreenShotPath);

		Log.info("Read Application Configuration successful !");
		System.out.println("Read Application Configuration  successfully!");
	}

	/**
	 * Initialization of mobile device and launching of app is performed here 
	 */

	public AndroidDriver<MobileElement> initDriver_And_LaunchApp() throws Exception {
		try {
			capabilities= new DesiredCapabilities();
			System.out.println("App is launching........");
			if(sPlatformName.equalsIgnoreCase("Android")){
				capabilities.setCapability(MobileCapabilityType.PLATFORM,MobilePlatform.ANDROID);
			}
			if(sDeviceType.equalsIgnoreCase("RealDevice")){
				capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, sDeviceName);
			}
			else if(sDeviceType.equalsIgnoreCase("VirtualDevice")) {
				capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, sVirtualDeviceName);
			}
			capabilities.setCapability("platformVersion", sPlatformVersion);
			capabilities.setCapability("platformName", "Android");
			capabilities.setCapability(MobileCapabilityType.AUTO_WEBVIEW, true);
			capabilities.setCapability("autoWebview","true");
			capabilities.setCapability("automationName","selendroid");
			capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "1000");
			capabilities.setCapability("autoGrantPermissions","true");
			capabilities.setCapability("autoDismissAlerts", true);
			capabilities.setCapability("android:exported", "true");
			capabilities.setCapability("automationName","Appium");
			capabilities.setCapability("appPackage", sAppPackage);
			capabilities.setCapability("appActivity", sAppActivity);
			capabilities.setCapability("appWaitActivity",sAppWaitActivity);
			capabilities.setCapability("unicodeKeyboard", true);
			capabilities.setCapability("resetKeyboard", true);
			try {
				driver=new AndroidDriver<MobileElement>(new URL(sAppium_URl), capabilities);
				driver.manage().timeouts().implicitlyWait(iImplicitWait, TimeUnit.SECONDS);	
				System.out.println("App Successfully Launch........");
				return driver;
			} catch (Exception e) {
				System.out.println(e);
				System.out.println("App  Launch Failed while setting URL");
				return null;
			}
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("App Launch Fail while setting configuration for device");
			return null;
		}
	}	
}
