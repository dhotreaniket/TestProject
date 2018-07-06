package com.stepdefination;

import org.junit.Assert;
import com.pageObjects.BookingRefferencePage;
import com.pageObjects.BuyPage;
import com.pageObjects.PaymentGatewayPage;
import com.pageObjects.ReviewYourOrderPage;
import com.pageObjects.SeatsAndExtrasPage;
import com.pageObjects.SelectTicketPage;
import com.pageObjects.SelectTrainPage;
import com.pageObjects.SignInPage;
import com.utilties.TestBase;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import pageConstants.CardDetailsConstants;

public class ByPageStepDefination extends TestBase{

	public String sFromLocation="Leeds";
	public String sToLocationName="Manchester Piccadilly";
	public String sTicketType="Single";	
	public int iSelectNumberOfAdults=2;
	public int iSelectNumberOfChilds=3;
	public String sRailCard="16-25 Railcard";
	public String sDesiredHour="06";
	public String sDesiredMinute="40";
	public String sDayNumber="18";
	public String sMonth="Jul";
	public String sYear="2018";
	public String sFromTime="06:06";
	public String sSeletTicketType="Std Advance";
	public String sLikeToFace="Forwards";
	public String sAisleSeat="Window";
	public String sTableOrAirSeat="Table seat";
	public String sOther="Near toilet OFF";
	public String sBookingReferenceNumber;
	public String sFilePath= "C://Users//A681205//Desktop//FGMAScreenshot";


	@Before({"@LaunchApp"})
	public void initialize() throws Exception {
		testBase=new TestBase();
		testBase.readApplicationConfiguration();
		TestBase.driver=testBase.initDriver_And_LaunchApp();
	}

	@Given("^Enter \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void enter_RequiredDetails_On_BuyPage(String fromlocation, String tolocation, String tickettype, int numberofadults, int numberofchilds) throws Throwable {
		initialize_BuyPage();
		this.buyPage.selectFromLoaction(fromlocation);
		this.buyPage.selectToLoaction(tolocation);
		this.buyPage.ticketType(tickettype);
		this.buyPage.selectNumberOfAdults(numberofadults);
		this.buyPage.selectNumberOfChilds(numberofchilds);		
	}

	@And("^\"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void enter_OutWard_Date_And_Time(String desiredhour, String desiredminute, String daynumber, String month, String year) throws Throwable {
		this.buyPage.selectOutwardDateAndTime(desiredhour, desiredminute, daynumber, month, year);
	}

	@Then("^Select \"([^\"]*)\" and click on find tickets and navigate to Select Train Page$")
	public void select_RailCards_And_Click_On_FindTickets(String railcard) throws Throwable {
		this.buyPage.selectRailCard(railcard);
		this.buyPage.clickOnfindTickets();
	}

	@And("^Select Train for given \"([^\"]*)\" and navigate To Select Ticket Page$")
	public void select_Train_For_Given_From_Time_And_Navigate_To_Select_Ticket_Page(String fromtime) throws Throwable {
		initialize_SelectTrainPage();
		this.selectTrainPage.selectTrain(fromtime);
	}

	@Then("^Select Ticket \"([^\"]*)\" and navigate to Seats and Extras$")
	public void select_Ticket_And_Navigate_To_Seats_And_Extras(String tickettype) throws Throwable {
		initialize_SelectTicketPage();
		this.selectTicketPage.selectTicket(tickettype);
	}

	@And("^Select Seat Reservation Option and navigate to Seats and Extras Page$")
	public void select_seat_reservation_option_and_navigate_to_seats_and_extras_page() throws Throwable {
		initialize_SelectSeatsAndExtras();
		this.seatsAndExtrasPage.selectSeatReservation();
	}

	@Then("^Select \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" option$")
	public void select_Various_Seat_Reservation_Option(String liketoface, String aisleseat, String tableorairseat, String other) throws Throwable {
		this.seatsAndExtrasPage.selectSeatType(liketoface, aisleseat, tableorairseat,other);
	}

	@And("^Click on Confirm selection and navigate to Seats and Extras Page$")
	public void click_on_confirm_selection_and_navigate_to_seats_and_extras_page() throws Throwable {
		this.seatsAndExtrasPage.confirmSelection();
	}

	@Then("^Click on Continue to Ticket delivery and click on Continue to Order Summary$")
	public void click_on_continue_to_ticket_delivery_and_click_on_continue_to_order_summary() throws Throwable {
		this.seatsAndExtrasPage.clickContinueToTicketDelivery();
		this.seatsAndExtrasPage.clickContinueToOrderSummary();
	}

	@And("^Click on Go To CheckOut and enter Sign in Details if available$")
	public void click_on_go_to_checkout_and_enter_sign_in_details_if_available() throws Throwable {
		initialize_ReviewYourOrder();
		this.reviewYourOrderPage.clickGoToCheckout();
		try {
			initalize_SignInPage();
			System.out.println("Card Details = "+ CardDetailsConstants.EMAIL_ADDRESS);
			this.signInPage.signIN(CardDetailsConstants.EMAIL_ADDRESS, CardDetailsConstants.PASSWORD);
			this.reviewYourOrderPage.clickGoToCheckout();
		} catch (Exception e) {
			System.out.println("USER IS ALLREADY SIGNED IN !!!!!");
		}
	}

	@And("^Go to To Payment Page and enter Card Details and click on Submit$")
	public void go_to_to_payment_page_and_enter_card_details_and_click_on_submit() throws Throwable {
		initalize_PaymentGatewayPage();
		this.paymentGatewayPage.enterCardDetails(CardDetailsConstants.CARD_NUMBER, CardDetailsConstants.FULL_NAME, CardDetailsConstants.INPUT_CARD_START_MONTH, CardDetailsConstants.INPUT_CARD_START_YEAR, CardDetailsConstants.INPUT_CARD_EXPIRATION_MONTH, CardDetailsConstants.INPUT_CARD_EXPIRATION_YEAR, CardDetailsConstants.INPUT_CARD_CVV_MASK, CardDetailsConstants.INPUT_ADDRESS_POST_CODE, CardDetailsConstants.INPUT_ADDRESS_LINE1, CardDetailsConstants.INPUT_ADDRESS_TOWN_CITY, CardDetailsConstants.INPUT_ADDRESS_COUNTRY);
	}

	@Then("^you will navigate to Booking Reference Page and get Booking Reference Number$")
	public void you_will_navigate_to_booking_reference_page_and_get_booking_reference_number() throws Throwable {
		initalize_BookingRefferencePage();
		sBookingRefferenceNumber=this.bookingRefferencePage.getBookingReferenceNumber();

	}	

	@And("^Navigate to My Ticket Page, go to Booked Ticket and verify the Booking Refference Number$")
	public void navigate_to_my_ticket_page_go_to_booked_ticket_and_verify_the_booking_refference_number() throws Throwable {
		this.bookingRefferencePage.navigateToMyTicketPage();
		sDisplayedBookingReferenceNumber= this.bookingRefferencePage.getBookingReferenceNumber();
		Assert.assertTrue("Booking Refference did not match", sBookingReferenceNumber.toString().equals(sDisplayedBookingReferenceNumber.toString()));	 
	}

	@Given("^Enter \"([^\"]*)\" Station$")
	public void enter_wrong_station(String fromstation) throws Throwable {
		initialize_BuyPage();
		this.buyPage.enterFromLocationInToTextField(fromstation);		
	}

	@And("^\"([^\"]*)\" is unavailable$")
	public void station_unavailable(String fromstation) throws Throwable {
		initialize_BuyPage();
		this.buyPage.verify_From_Station_Available(fromstation);
		boolean flag=this.buyPage.verify_From_Station_Available(fromstation);
		System.out.println("flag = "+flag);
		Assert.assertFalse(flag);

	}

	public void initialize_BuyPage(){
		this.buyPage= new BuyPage(TestBase.driver);
	}

	public void initialize_SelectTrainPage(){
		this.selectTrainPage =new SelectTrainPage(TestBase.driver);
	}

	public void initialize_SelectTicketPage(){
		this.selectTicketPage =new SelectTicketPage(TestBase.driver);
	}

	public void initialize_SelectSeatsAndExtras(){
		this.seatsAndExtrasPage =new SeatsAndExtrasPage(TestBase.driver);
	}

	public void initialize_ReviewYourOrder(){
		this.reviewYourOrderPage =new ReviewYourOrderPage(TestBase.driver);
	}

	public void initalize_SignInPage(){
		this.signInPage=new SignInPage(TestBase.driver);
	}

	public void initalize_PaymentGatewayPage(){
		this.paymentGatewayPage= new PaymentGatewayPage(TestBase.driver);
	}

	public void initalize_BookingRefferencePage(){
		this.bookingRefferencePage= new BookingRefferencePage(TestBase.driver);
	}
}

