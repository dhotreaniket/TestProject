package com.pageObjects;

import org.openqa.selenium.support.PageFactory;

import com.utilties.ActionDriver;
import com.utilties.MobileDriver;
import com.utilties.TestBase;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import com.pageObjects.BookingRefferencePage;

public class PaymentGatewayPage extends TestBase{

	public PaymentGatewayPage(AndroidDriver<MobileElement> driver) {
		TestBase.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	public MobileDriver mobileDriver;
	public SelectTrainPage selectTrainPage;

	public static final String CARD_NUMBER_TEXTFIELD_ID="inputCardNumber";

	public static final String FULL_NAME_TEXTFIELD_ID="inputCardFullName";

	public static final String INPUT_CARD_START_MONTH_TEXTFIELD_ID="inputCardStartMonth";

	public static final String INPUT_CARD_START_MONTH_CLASS_NAME="android.widget.ListView";

	public static final String INPUT_CARD_START_YEAR_ID="inputCardStartYear";

	public static final String INPUT_CARD_START_YEAR_CLASS_NAME="android.widget.ListView";

	public static final String INPUT_CARD_EXPIRATION_MONTH_ID="inputCardExpirationMonth";

	public static final String INPUT_CARD_EXPIRATION_MONTH_CLASS_NAME="android.widget.ListView";

	public static final String INPUT_CARD_EXPIRATION_YEAR_ID="inputCardExpirationYear";

	public static final String INPUT_CARD_EXPIRATION_YEAR_CLASS_NAME="android.widget.ListView";

	public static final String INPUT_CARD_CVV_ID="inputCardCVVMask";

	public static final String INPUT_ADDRESS_POSTAL_CODE_ID="inputAddressPostcode";

	public static final String INPUT_ADDRESS_LINE_ID="inputAddressLine1";

	public static final String INPUT_ADDRESS_COUNTRY_NAME_ID="inputAddressCountry";

	public static final String INPUT_ADDRESS_COUNTRY_NAME_CLASS="android.widget.ListView";

	public static final String INPUT_ADDRESS_TOWN_CITY_ID="inputAddressTownCity";
	
	public static final String INPUT_ADDRESS_LINE_3_TEXTFIELD_ID="inputAddressLine3";
	
	public static final String TERMS_AND_CONDITION_CHECKBOX_ID="termsAndConditions";
	
	public static final String BUY_NOW_BUTTON_ID="processPayment";
	

	@AndroidFindBy(id=INPUT_CARD_EXPIRATION_MONTH_ID)
	MobileElement meInputCardExpirationMonth;

	@AndroidFindBy(id=INPUT_CARD_START_YEAR_ID)
	MobileElement meInputCardStartYearId;

	@AndroidFindBy(id=INPUT_CARD_START_MONTH_TEXTFIELD_ID)
	MobileElement meInputCardStartMonthID;

	@AndroidFindBy(id=CARD_NUMBER_TEXTFIELD_ID)
	MobileElement meCardNumberTextField;

	@AndroidFindBy(id=FULL_NAME_TEXTFIELD_ID)
	MobileElement meFullNameTextField;


	public  void enterCardDetails(String sCardNumber,String sFullName,String sInputCardStartMonth,String sInputCardStartYear,String sInputCardExpirationMonth,String sInputCardExpirationYear,String sInputCardCVVMask,String sInputAddressPostcode,String sInputAddressLine1,String sInputAddressTownCity,String sInputAddressCountry) throws Exception{
		initActionDriver();
		initMobileDriver();

		if(sCardNumber!=null){
			mobileDriver.enterTextByID(CARD_NUMBER_TEXTFIELD_ID, sCardNumber);
		}

		//Enter Full Name
		if(sFullName!=null){
			mobileDriver.enterTextByID(FULL_NAME_TEXTFIELD_ID, sFullName);	
		}

		if(sInputCardStartMonth!=null){
			//Select Input Card Start Month
			try {
				mobileDriver.clickByID(INPUT_CARD_START_MONTH_TEXTFIELD_ID);
				actionDriver.sleepThread(1);
				mobileDriver.scrollToVisibleTextAndClickByClassName(INPUT_CARD_START_MONTH_CLASS_NAME, sInputCardStartMonth);
				actionDriver.sleepThread(1);
				System.out.println("Start Month Selected = " +sInputCardStartMonth);
			} catch (Exception e) {
				System.out.println("Fail to Select Start Month");
			}
		}
 
		//Select Input Card Start Year
		/*	if(sInputCardStartYear!=null){
			try {
				mobileDriver.clickByID(INPUT_CARD_START_YEAR_ID);
				actionDriver.sleepThread(1);
				mobileDriver.scrollToVisibleTextAndClickByClassName(INPUT_CARD_START_YEAR_CLASS_NAME, sInputCardStartYear);
				actionDriver.sleepThread(1);
				System.out.println("Start Year Selected");
			} catch (Exception e) {
				System.out.println("Failed to Select Start Year");
			}
		}*/

		//Select Expiration  Month
		if(sInputCardExpirationMonth!=null)
			try {
				mobileDriver.clickByID(INPUT_CARD_EXPIRATION_MONTH_ID);
				actionDriver.sleepThread(1);
				mobileDriver.scrollToVisibleTextAndClickByClassName(INPUT_CARD_EXPIRATION_MONTH_CLASS_NAME, sInputCardExpirationMonth);
				actionDriver.sleepThread(2);
				System.out.println("Expiration Month Selected");
			} catch (Exception e) {
				System.out.println("Failed to Select Expiration Month");
			}

		//Select Expiration  Year
		if(sInputCardExpirationYear!=null)
			try {
				mobileDriver.clickByID(INPUT_CARD_EXPIRATION_YEAR_ID);
				actionDriver.sleepThread(1);
				mobileDriver.scrollToVisibleTextAndClickByClassName(INPUT_CARD_EXPIRATION_YEAR_CLASS_NAME, sInputCardExpirationYear);
				actionDriver.sleepThread(2);
				System.out.println("Expiration Year Selected");
			} catch (Exception e) {
				System.out.println("Fail to Select Expiration Year");
			}

		if(sInputCardCVVMask!=null){
			String sActualCVV=mobileDriver.getTextById(INPUT_CARD_CVV_ID);
			actionDriver.sleepThread(1);
			//Enter Card CVV
			while ((sActualCVV.equals(null))||!sActualCVV.equals(sInputCardCVVMask)) {
				mobileDriver.enterTextAfterClearByID(INPUT_CARD_CVV_ID, sInputCardCVVMask);
				actionDriver.sleepThread(2);
				sActualCVV=mobileDriver.getTextById(INPUT_CARD_CVV_ID);
				System.out.println("sActualCVV = " +sActualCVV);
			}
			actionDriver.sleepThread(1);
		}
		mobileDriver.scrollToDimension();	
		/* Billing Address */
		//Enter Postal Code
		if(sInputAddressPostcode!=null){
			mobileDriver.enterTextByID(INPUT_ADDRESS_POSTAL_CODE_ID, sInputAddressPostcode);
			actionDriver.sleepThread(1);
		}
		//driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().resourceId(\"addressSearchButton\").instance(0)")).click();
		mobileDriver.scrollToDimension();	

		//Enter Input Address
		if(sInputAddressLine1!=null){
			mobileDriver.enterTextByID(INPUT_ADDRESS_LINE_ID, sInputAddressLine1);
		}
		mobileDriver.scrollToDimension();	
		//Enter Country
		if(sInputAddressCountry!=null){
			mobileDriver.clickByID(INPUT_ADDRESS_COUNTRY_NAME_ID);
			mobileDriver.scrollToVisibleTextAndClickByClassName(INPUT_ADDRESS_COUNTRY_NAME_CLASS, sInputAddressCountry);
		}
		actionDriver.sleepThread(2);
		
		//Enter Town
		if(sInputAddressTownCity!=null){
			mobileDriver.enterTextByID(INPUT_ADDRESS_TOWN_CITY_ID, sInputAddressTownCity);
			actionDriver.sleepThread(1);
		}
		try {
			mobileDriver.clickByID(INPUT_ADDRESS_LINE_3_TEXTFIELD_ID);
			mobileDriver.scrollToDimension();
			mobileDriver.scrollToDimension();
			mobileDriver.scrollToDimension();
			mobileDriver.scrollToDimension();
			actionDriver.sleepThread(1);
			//Select CheckBox for Terms & Conditon
			mobileDriver.clickByID(TERMS_AND_CONDITION_CHECKBOX_ID);
			actionDriver.sleepThread(1);
			System.out.println("Successfully Clicked on Check box");
		} catch (Exception e) {
			System.out.println("Failed to scroll and to click on check Box, Trying again!!!");
			mobileDriver.scrollToDimension();
			mobileDriver.scrollToDimension();
			mobileDriver.scrollToDimension();
			mobileDriver.scrollToDimension();
			actionDriver.sleepThread(1);
			//Select CheckBox for Terms & Conditon			
			mobileDriver.clickByID(TERMS_AND_CONDITION_CHECKBOX_ID);
			actionDriver.sleepThread(1);
			System.out.println("Successfully Clicked on Checkbox");
		}	
		//Click on Buy Option
		mobileDriver.clickByID(BUY_NOW_BUTTON_ID);
		//Wait For Booking Reference Page
		try {
			actionDriver.waitForVisibiltyOfElement("xpath",BookingRefferencePage.BOOKING_REFFERENCE_NUMBER_TEXT_XPATH);
			System.out.println("Booking Reffernce Generated");
		} catch (Exception e) {
			System.out.println("Fail to generate Booking Refference");
		}
	}

	public void initActionDriver() {
		actionDriver = new ActionDriver(TestBase.driver);
	}

	public void initMobileDriver() {
		mobileDriver = new MobileDriver(TestBase.driver);
	}

}
