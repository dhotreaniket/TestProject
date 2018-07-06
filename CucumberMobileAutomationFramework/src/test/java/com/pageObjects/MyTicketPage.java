package com.pageObjects;

import org.openqa.selenium.support.PageFactory;
import com.utilties.ActionDriver;
import com.utilties.MobileDriver;
import com.utilties.TestBase;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class MyTicketPage extends TestBase{
	
	public MyTicketPage(AndroidDriver<MobileElement> driver) {
              TestBase.driver=driver;
              PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public static final String MY_TICKET_PAGE_CONTAINER_ID="com.firstgreatwestern.test:id/ticketContainer";
	
	public static final String MY_TICKETS_PAGE_SCROLL_ID="com.firstgreatwestern.test:id/ticketList";

	public static final String PICKUP_TICKET_PAGE_BOOKING_REFFERNCE_TEXT_ID="com.firstgreatwestern.test:id/booking_reference";
	
	@AndroidFindBy(id=PICKUP_TICKET_PAGE_BOOKING_REFFERNCE_TEXT_ID)
	public  MobileElement mePickUpTicketPageBookingRefferenceId;
	
	
	public MobileDriver mobileDriver;
	public SelectTrainPage selectTrainPage;
	
	public  void navigateToPickupTicketInfo(String sBookinngReferenceNumber) throws Exception{
		initActionDriver();
		initMobileDriver();
		String sActualText="Booking reference: "+sBookinngReferenceNumber+"";
		System.out.println("sActualText =" +sActualText);
		mobileDriver.scrollToVisibleTextById(MY_TICKETS_PAGE_SCROLL_ID, sActualText);
		String sDynamicXpathForBookedTicketOption="//android.widget.TextView[@text='Booking reference: "+sBookinngReferenceNumber+"']";
		actionDriver.clickElement("xpath",sDynamicXpathForBookedTicketOption);
		actionDriver.waitForVisibiltyOfElement("id", PICKUP_TICKET_PAGE_BOOKING_REFFERNCE_TEXT_ID);
	}
	
	public  String getBookingReferenceNumber_PickupTicketPage(){
		String sBookingRefrenceNumber=mePickUpTicketPageBookingRefferenceId.getText();
		return sBookingRefrenceNumber;
	}	
	
	public void initActionDriver() {
		actionDriver = new ActionDriver(TestBase.driver);
	}

	public void initMobileDriver() {
		mobileDriver = new MobileDriver(TestBase.driver);
	}
}
