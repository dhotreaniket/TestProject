package com.pageObjects;

import com.utilties.ActionDriver;
import com.utilties.MobileDriver;
import com.utilties.TestBase;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.openqa.selenium.support.PageFactory;

import com.pageObjects.ReviewYourOrderPage;

public class SeatsAndExtrasPage extends TestBase{

	public ActionDriver actionDriver;
	public MobileDriver mobileDriver;

	public SeatsAndExtrasPage(AndroidDriver<MobileElement> driver) {
		TestBase.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	/////////////// SEAT AND EXTRAS PAGE CONSTANTS RESERVATION CONSTANTS ///////////////////////////////

	public static final String SEATS_AND_EXTRAS_PAGE_SEAT_RESERVATION_CONTAINER_ID="com.firstgreatwestern.test:id/seatReservationContainer";

	public static final String SEATS_AND_EXTRAS_CONTINUE_TO_TICKET_DELIVERY_BUTTON_ID="com.firstgreatwestern.test:id/searchTickets";


	/////////////// SEAT RESERVATION PAGE  ///////////////////////////////

	public static final String SEAT_RESERVATION_PAGE_rvSeatsAndExtras_ID="com.firstgreatwestern.test:id/rvSeatsAndExtras";

	public static final String SEAT_RESERVATION_PAGE_SCROLL_ID="com.firstgreatwestern.test:id/rvSeatsAndExtras";

	public static final String SEAT_RESERVATION_PAGE_CONFIRM_SELECTION_BUTTON_ID="com.firstgreatwestern.test:id/btnAction";

	public static final String SEAT_RESERVATION_ERROR_POPUP_OK_BUTTON_ID="android:id/button3";
	
	/////////////// TICKET DELIVERY PAGE CONSTANTS ///////////////////////////////

	public static final String TICKET_DELIVERY_PAGE_CONTINUE_TO_ORDER_SUMMARY_BUTTON_ID="com.firstgreatwestern.test:id/searchTickets";

	public static final String TICKET_DELIVERY_PAGE_HOW_WOULD_YOU_LIKE_YOUR_TICKETS_XPATH="//android.widget.TextView[@text='How would you like your tickets?']";

	/////////////// TICKET DELIVERY PAGE MOBILE ELEMENTS ///////////////////////////////

	@AndroidFindBy(id=TICKET_DELIVERY_PAGE_CONTINUE_TO_ORDER_SUMMARY_BUTTON_ID)
	MobileElement meContinueToOrderSummaryConstants_Id;
	
	@AndroidFindBy(id=TICKET_DELIVERY_PAGE_HOW_WOULD_YOU_LIKE_YOUR_TICKETS_XPATH)
	MobileElement meHowWouldYouLikeYourTickets_Text_Xpath;
	
	/////////////// SEAT AND EXTRAS PAGE CONSTANTS RESERVATION CONSTANTS ///////////////////////////////

	@AndroidFindBy(id=SEATS_AND_EXTRAS_PAGE_SEAT_RESERVATION_CONTAINER_ID)
	MobileElement meSeatsAndExtrasPageSeatReservationContainerId;
	
	@AndroidFindBy(id=SEATS_AND_EXTRAS_CONTINUE_TO_TICKET_DELIVERY_BUTTON_ID)
	MobileElement meSeatsAndExtrasPageContinueToTicketDeliveryButtonID;


	/////////////// SEAT RESERVATION MOBILE ELEMENTS ///////////////////////////////

	@AndroidFindBy(id=SEAT_RESERVATION_PAGE_CONFIRM_SELECTION_BUTTON_ID)
	MobileElement meSeatReservationConfirmSelectionButtonId;

	@AndroidFindBy(id=SEAT_RESERVATION_PAGE_SCROLL_ID)
	MobileElement meSeatReservationScrollId;

	@AndroidFindBy(id=SEAT_RESERVATION_PAGE_rvSeatsAndExtras_ID)
	MobileElement meSeatsAndReservationPage_rvSeatsAndExtras_ID;

	@AndroidFindBy(id=SEAT_RESERVATION_ERROR_POPUP_OK_BUTTON_ID)
	MobileElement meSeatReservationPageOkButtonID;

      ////////////////////// SEAT RESERVATION METHODS //////////////////////////////////////////
	
	public void selectSeatReservation() throws Exception{
		initActionDriver();
		initMobileDriver();
		meSeatsAndExtrasPageSeatReservationContainerId.click();
		actionDriver.waitForElementToBeClickable("id", SEAT_RESERVATION_PAGE_rvSeatsAndExtras_ID);
	}
	
	//////////////////////// SEAT RESERVATION PAGE METHODS   ////////////////////////////////////////////////
	
	public  void selectSeatType(String sLikeToFace,String sAisleSeat,String sTableOrAirLineSeat,String sOther) throws Exception{
		String sDynamicXpath_LikeToFace_Option="//android.widget.RadioButton[@text='"+sLikeToFace+"']";
		actionDriver.clickElement("xpath",sDynamicXpath_LikeToFace_Option);

		mobileDriver.scrollToVisibleTextById(SEAT_RESERVATION_PAGE_SCROLL_ID, sAisleSeat);
		String sDynamicXpath_AisleSeat_Option="//android.widget.RadioButton[@text='"+sAisleSeat+"']";
		actionDriver.clickElement("xpath",sDynamicXpath_AisleSeat_Option);

		mobileDriver.scrollToVisibleTextById(SEAT_RESERVATION_PAGE_SCROLL_ID, sTableOrAirLineSeat);
		String sDynamicXpath_AirLineSeat_Option="//android.widget.RadioButton[@text='"+sTableOrAirLineSeat+"']";
		actionDriver.clickElement("xpath",sDynamicXpath_AirLineSeat_Option);

		mobileDriver.scrollToVisibleTextById(SEAT_RESERVATION_PAGE_SCROLL_ID, sOther);
		String sDynamicXpath_Other_Option="//android.widget.Switch[@text='"+sOther+"']";
		actionDriver.clickElement("xpath",sDynamicXpath_Other_Option);		
	}

	public void confirmSelection() throws Exception{
		meSeatReservationConfirmSelectionButtonId.click();
		try {
			actionDriver.waitForElementToBeClickable(10, "id", SEAT_RESERVATION_ERROR_POPUP_OK_BUTTON_ID);
			meSeatReservationPageOkButtonID.click();
		} catch (Exception e) {
			System.out.println("Pop did not exist");
		}
		actionDriver.waitForElementToBeClickable("id", SEATS_AND_EXTRAS_CONTINUE_TO_TICKET_DELIVERY_BUTTON_ID);
		//waitForElementToBeClickableById("com.firstgreatwestern.test:id/seatReservationContainer");
	//	waitForElementToBeClickableById("com.firstgreatwestern.test:id/searchTickets");
	}

	//////////////////////////// TICKET DELIVERY METHOD //////////////////////////////////////////////
	
	public  void clickContinueToTicketDelivery() throws Exception{
		meSeatsAndExtrasPageContinueToTicketDeliveryButtonID.click();
		actionDriver.waitForVisibiltyOfElement("xpath", TICKET_DELIVERY_PAGE_HOW_WOULD_YOU_LIKE_YOUR_TICKETS_XPATH);
	}

	public void clickContinueToOrderSummary() throws Exception{
		meContinueToOrderSummaryConstants_Id.click();
		actionDriver.waitForVisibiltyOfElement("xpath", ReviewYourOrderPage.REVIEW_YOUR_ORDER_TEXT_XPATH);
	}
	
	public void initActionDriver() {
		actionDriver = new ActionDriver(TestBase.driver);
	}

	public void initMobileDriver() {
		mobileDriver = new MobileDriver(TestBase.driver);
	}
}
