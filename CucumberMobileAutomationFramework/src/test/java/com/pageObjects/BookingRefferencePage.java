package com.pageObjects;

import org.openqa.selenium.support.PageFactory;
import com.utilties.ActionDriver;
import com.utilties.MobileDriver;
import com.utilties.TestBase;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import com.pageObjects.MyTicketPage;

public class BookingRefferencePage extends TestBase{
	
	public BookingRefferencePage(AndroidDriver<MobileElement> driver) {
		TestBase.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public MobileDriver mobileDriver;
	public SelectTrainPage selectTrainPage;
	
	public static final String BOOKING_REFFERENCE_NUMBER_TEXT_XPATH="//android.widget.TextView[@text='Your Booking Reference']";
	
	public static final String BOOKING_REFFERENCE_NUMBER_TEXT_ID="com.firstgreatwestern.test:id/txtBookingRefference";
	
	public static final String NAVIGATE_TO_MY_TICKET_PAGE_BUTTON_ID="com.firstgreatwestern.test:id/btnGoMyTickets";
	
	@AndroidFindBy(id=NAVIGATE_TO_MY_TICKET_PAGE_BUTTON_ID)
	MobileElement sNavigateToMyTicketPageButtonID;
	
	@AndroidFindBy(xpath=BOOKING_REFFERENCE_NUMBER_TEXT_XPATH)
	MobileElement sBookingRefferenceNumberTextXPath;
	
	@AndroidFindBy(id=BOOKING_REFFERENCE_NUMBER_TEXT_ID)
	MobileElement sBookingRefferenceNumberTextId;
	
	public  String getBookingReferenceNumber(){
		TestBase.sBookingRefferenceNumber=sBookingRefferenceNumberTextId.getText();
		System.out.println("sBookingReferenceNumber = " + TestBase.sBookingRefferenceNumber);
		return TestBase.sBookingRefferenceNumber;
	}
	
	public  void navigateToMyTicketPage() throws Exception{
		initActionDriver();
		initMobileDriver();
		sNavigateToMyTicketPageButtonID.click();
		actionDriver.sleepThread(5);
		actionDriver.waitForVisibiltyOfElement("id", MyTicketPage.MY_TICKET_PAGE_CONTAINER_ID);
	}

	public void initActionDriver() {
		actionDriver = new ActionDriver(TestBase.driver);
	}

	public void initMobileDriver() {
		mobileDriver = new MobileDriver(TestBase.driver);
	}
}
