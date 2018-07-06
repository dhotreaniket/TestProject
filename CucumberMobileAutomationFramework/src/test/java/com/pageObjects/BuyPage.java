package com.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.utilties.ActionDriver;
import com.utilties.MobileDriver;
import com.utilties.TestBase;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import com.pageObjects.SelectTrainPage;

public class BuyPage extends TestBase{

	public static final String BUY_FROM_TEXT_FIELD_ID="com.firstgreatwestern.test:id/fromTextView";

	public static final String SEARCH_BOX_TEXT_FIELD_ID="com.firstgreatwestern.test:id/search_src_text";

	public static final String FIRST_ELEMENT_ON_SEARCH_TEXT_BOX_ID="com.firstgreatwestern.test:id/stationNameTextView";

	public static final String BUY_TO_TEXT_FIELD_ID="com.firstgreatwestern.test:id/toTextView";

	public static final String BUY_TICKET_TYPE_OPTION_NAME="Ticket type";

	public static final String FIRST_OPTION_ON_BY_TICKET_TYPE_ID="com.firstgreatwestern.test:id/ticketTypeTitle";

	public static final String NUMBER_OF_ADULT_VALUE_XPATH="//android.widget.TextView[@text='Adult']/parent::android.widget.LinearLayout[@index='0']/following-sibling::android.widget.LinearLayout[@index='1']//android.widget.TextView[@index='0']";

	public static final String NUMBER_OF_CHILD_VALUE_XPATH="//android.widget.TextView[@text='Child']/parent::android.widget.LinearLayout[@index='0']/following-sibling::android.widget.LinearLayout[@index='1']//android.widget.TextView";

	public static final String ADULT_PLUS_SIGN_ID="com.firstgreatwestern.test:id/plusButton";

	public static final String ADULT_MINUS_SIGN_ID="com.firstgreatwestern.test:id/minusButton";

	public static final String CHILD_PLUS_SIGN_XPATH="//android.widget.TextView[@text='Child']/parent::android.widget.LinearLayout[@index='0']/following-sibling::android.widget.LinearLayout[@index='1']//android.widget.ImageButton[@index='2']";

	public static final String CHILD_MINUS_SIGN_XPATH="//android.widget.TextView[@text='Child']/parent::android.widget.LinearLayout[@index='0']/following-sibling::android.widget.LinearLayout[@index='1']//android.widget.ImageButton[@index='0']";

	public static final String LEAVES_AT_OPTION_NAME="LEAVE AT";

	public static final String OUTWARD_OPTION_NAME="Outward";

	public static final String MINUTE_VALUE_XPATH="//android.widget.NumberPicker[@index='0']/android.widget.EditText[@index='1']";

	public static final String MINUTE_TAP_BUTTON_XPATH="//android.widget.NumberPicker[@index='0']/android.widget.Button[@index='0']";

	public static final String SECONDS_VALUE_XPATH="//android.widget.NumberPicker[@index='2']/android.widget.EditText[@index='1']";

	public static final String SECONDS_TAP_BUTTON_XPATH="//android.widget.NumberPicker[@index='2']/android.widget.Button[@index='0']";

	public static final String DATE_PICKER_BUTTON_XPATH="//android.support.v4.view.ViewPager[@resource-id='com.firstgreatwestern.test:id/datePager']";

	public static final String CALENDER_HEADER_YEAR_TEXT_ID="android:id/date_picker_header_year";

	public static final String MONTH_HEADER_TEXT_XPATH="//android.widget.LinearLayout[@index='0']/android.widget.TextView[@index='1']";

	public static final String NEXT_MONTH_BUTTON_ID="android:id/next";

	public static final String YEAR_OPTION_CALENDER_ID="android:id/date_picker_header_year";

	public static final String HEADER_DATE_DATE_PICKER_ID="android:id/date_picker_header_year";

	public static final String OK_BUTTON_CALLENDER_ID="android:id/button1";

	public static final String DONE_BUTTON_OUTWARD_POPUP_ID="android:id/button1";

	public static final String ADD_RAILCARDS_BUTTON_NAME="Add Railcards";

	public static final String RAIL_CARD_TITLE_ID="com.firstgreatwestern.test:id/railcardTitle";

	public static final String FIND_TICKETS_BUTTON_ID="com.firstgreatwestern.test:id/searchTickets";


	@AndroidFindBy(id=SelectTrainPage.SELECT_TRAIN_PAGE_TITLE_ID)
	public  MobileElement meSelectTrainPageTitileId;

	@AndroidFindBy(id=FIND_TICKETS_BUTTON_ID)
	public  MobileElement meFindTicketsButtonId;

	@AndroidFindBy(id=RAIL_CARD_TITLE_ID)
	public  MobileElement meRailCardTileID;

	@FindBy(name=ADD_RAILCARDS_BUTTON_NAME)
	public  MobileElement meAddRailCardsName;

	@AndroidFindBy(id=DONE_BUTTON_OUTWARD_POPUP_ID)
	public  MobileElement medoneButtonOnOutWardPopUP;

	@AndroidFindBy(id=OK_BUTTON_CALLENDER_ID)
	public  MobileElement meOkButtonOnCallender;

	@AndroidFindBy(id=YEAR_OPTION_CALENDER_ID)
	public  MobileElement meYearOptionOnCalender;

	@AndroidFindBy(id=NEXT_MONTH_BUTTON_ID)
	public  MobileElement meNextMonthButtonID;

	@AndroidFindBy(xpath=MONTH_HEADER_TEXT_XPATH)
	public  MobileElement meMonthHeaderValueXpath;

	@AndroidFindBy(xpath=DATE_PICKER_BUTTON_XPATH)
	public  MobileElement meDatePickerButtonXpath;

	@AndroidFindBy(xpath=SECONDS_TAP_BUTTON_XPATH)
	public  MobileElement meSecondsTapButtonXpath;

	@AndroidFindBy(xpath=SECONDS_VALUE_XPATH)
	public  MobileElement meSecondsValueXpath;

	@AndroidFindBy(xpath=MINUTE_TAP_BUTTON_XPATH)
	public  MobileElement meMinuteTapButtonXpath;

	@AndroidFindBy(xpath=MINUTE_VALUE_XPATH)
	public  MobileElement meMinuteValueXpath;	

	@FindBy(name=LEAVES_AT_OPTION_NAME)
	public  MobileElement meLeavesAtOptionName;	

	@FindBy(name=OUTWARD_OPTION_NAME)
	public  MobileElement meOutWardOptionName;

	@AndroidFindBy(xpath=CHILD_PLUS_SIGN_XPATH)
	public  MobileElement meChildPlusSignXpath;

	@AndroidFindBy(xpath=CHILD_MINUS_SIGN_XPATH)
	public  MobileElement meChildMinuSignXpath;

	@AndroidFindBy(id=ADULT_PLUS_SIGN_ID)
	public  MobileElement meAdultPlusSignId;

	@AndroidFindBy(id=ADULT_MINUS_SIGN_ID)
	public  MobileElement meAdultMinusSignId;

	@AndroidFindBy(xpath=NUMBER_OF_CHILD_VALUE_XPATH)
	public  MobileElement meNumberOfChildValueXpath;

	@AndroidFindBy(xpath=NUMBER_OF_ADULT_VALUE_XPATH)
	public  MobileElement meNumberOfAdultValueXpath;

	@FindBy(name=BUY_TICKET_TYPE_OPTION_NAME)
	public  MobileElement meBuyTicket_Type_Option_Name;

	@AndroidFindBy(id=BUY_FROM_TEXT_FIELD_ID)
	public  MobileElement meBuy_From_Text_Field;

	@AndroidFindBy(id=SEARCH_BOX_TEXT_FIELD_ID)
	private WebElement meSearch_Text_Box;

	@AndroidFindBy(id=FIRST_ELEMENT_ON_SEARCH_TEXT_BOX_ID)
	private WebElement meFirstOption_OnSearch_TextBox;

	@AndroidFindBy(id=BUY_TO_TEXT_FIELD_ID)
	public  MobileElement meTo_Text_Field;

	@AndroidFindBy(id=FIRST_OPTION_ON_BY_TICKET_TYPE_ID)
	public  MobileElement meFirst_Option_On_Buy_Ticket_Type;

	public ActionDriver actionDriver;
	public BuyPage buyPage;
	public MobileDriver mobileDriver;
	public SelectTrainPage selectTrainPage;

	public BuyPage(AndroidDriver<MobileElement> driver){
		TestBase.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	public  void  selectFromLoaction(String sFromLocationName) throws Exception{	
		initActionDriver();
		initMobileDriver();
		System.out.println("Select From Location......");
		System.out.println("Click on From...." +BUY_FROM_TEXT_FIELD_ID);
		meBuy_From_Text_Field.click();
		actionDriver.waitForVisibiltyOfElement("id", SEARCH_BOX_TEXT_FIELD_ID);
		meSearch_Text_Box.clear();
		meSearch_Text_Box.sendKeys(sFromLocationName);
		actionDriver.waitForElementToBeClickable("id", FIRST_ELEMENT_ON_SEARCH_TEXT_BOX_ID);
		meFirstOption_OnSearch_TextBox.click();
		actionDriver.sleepThread(5);
	}
	
	public void enterFromLocationInToTextField(String sFromLocationName) throws Exception{
		initActionDriver();
		initMobileDriver();
		System.out.println("Select From Location......");
		System.out.println("Click on From...." +BUY_FROM_TEXT_FIELD_ID);
		meBuy_From_Text_Field.click();
		actionDriver.waitForVisibiltyOfElement("id", SEARCH_BOX_TEXT_FIELD_ID);
		meSearch_Text_Box.clear();
		meSearch_Text_Box.sendKeys(sFromLocationName);
	}

	public  void  selectToLoaction(String sToLocationName) throws Exception{	
		System.out.println("Select To Location......");
		meTo_Text_Field.click();
		actionDriver.waitForVisibiltyOfElement("id",SEARCH_BOX_TEXT_FIELD_ID);
		meSearch_Text_Box.clear();
		meSearch_Text_Box.sendKeys(sToLocationName);
		actionDriver.waitForElementToBeClickable("id", FIRST_ELEMENT_ON_SEARCH_TEXT_BOX_ID);
		System.out.println("To Location selected......");
		meFirstOption_OnSearch_TextBox.click();
		actionDriver.sleepThread(5);	
	}

	public boolean verify_From_Station_Available(String sFromStation){
		try {
			this.actionDriver.waitForVisibiltyOfElement(5,"FIRST_ELEMENT_ON_SEARCH_TEXT_BOX_ID", sFromStation);
			return  true;
		} catch (Exception e) {
			return false;
		}
	}

	public void ticketType(String sTicketType) throws Exception{
		System.out.println("Select Ticket Type......");
		meBuyTicket_Type_Option_Name.click();
		actionDriver.waitForElementToBeClickable("id",FIRST_OPTION_ON_BY_TICKET_TYPE_ID);
		meFirst_Option_On_Buy_Ticket_Type.click();
		actionDriver.sleepThread(5);	
		System.out.println("Ticket type is selected");
	}

	public void selectNumberOfAdults(int iDesiredNumberOfAdult){
		System.out.println("Select Number of Adults......");
		String sActualNumberofAdultSelected=meNumberOfAdultValueXpath.getAttribute("text");

		int iActualNumberofAdultSelected=Integer.parseInt(sActualNumberofAdultSelected);
		if(iDesiredNumberOfAdult>iActualNumberofAdultSelected){
			while(!meNumberOfAdultValueXpath.getAttribute("text").equals(""+iDesiredNumberOfAdult+"")){
				//Clicking on plus sign until desired and actual do not became same
				meAdultPlusSignId.click();
				System.out.println("Clicked on plus sign Number of Adult ");
			}
		}
		else if (iDesiredNumberOfAdult<iActualNumberofAdultSelected) {
			while(!meNumberOfAdultValueXpath.getAttribute("text").equals(""+iDesiredNumberOfAdult+"")){
				//clicking on minu sign
				meAdultMinusSignId.click();
				System.out.println("Clicked on minus sign Number of Adult ");
			}
		}	
	}

	public  void selectNumberOfChilds(int iDesiredNumberOfChild){
		String sActualNumberofChildSelected=meNumberOfChildValueXpath.getAttribute("text");
		int iActualNumberofChildSelected=Integer.parseInt(sActualNumberofChildSelected);
		if(iDesiredNumberOfChild>iActualNumberofChildSelected){
			while(!meNumberOfChildValueXpath.getAttribute("text").equals(""+iDesiredNumberOfChild+"")){
				//Clicking on plus sign
				meChildPlusSignXpath.click();
				System.out.println("Clicked on plus sign Number of Child ");
			}
		}
		else if (iDesiredNumberOfChild<iActualNumberofChildSelected) {
			while(!meNumberOfChildValueXpath.getAttribute("text").equals(""+iDesiredNumberOfChild+"")){
				//Clicking on minus sign path
				meChildMinuSignXpath.click();
				System.out.println("Clicked on minus sign Number of Child ");
			}
		}
	}

	public void selectOutwardDateAndTime(String sDesiredHour,String sDesiredMinute,String sDayNumber,String sMonth,String sYear) throws Exception{
		initActionDriver();
		navigateToOutWardWindow();
		selectLeaveAt();
		selectHour(sDesiredHour);
		selectMinutes(sDesiredMinute);
		selectDayNumberMonthAndYear(sDayNumber, sMonth, sYear);
		meOkButtonOnCallender.click();
		actionDriver.waitForVisibiltyOfElement("id",DONE_BUTTON_OUTWARD_POPUP_ID);
		medoneButtonOnOutWardPopUP.click();
	}

	public void navigateToOutWardWindow() throws Exception{
		meOutWardOptionName.click();
		actionDriver.waitForElementToBeClickable("name","LEAVE AT");
	}

	public void selectLeaveAt() throws InterruptedException{
		meLeavesAtOptionName.click();
		actionDriver.sleepThread(1);
	}

	public void selectHour(String sDesiredMinute){
		String sActualMinute=meMinuteValueXpath.getAttribute("text");
		while(!sDesiredMinute.equals(sActualMinute)){
			meMinuteTapButtonXpath.click();
			sActualMinute=meMinuteValueXpath.getAttribute("text");
		}
	}

	public void selectMinutes(String sDesiredSeconds){
		String sActualSeconds=meSecondsValueXpath.getAttribute("text");
		while(!sDesiredSeconds.equals(sActualSeconds)){
			meSecondsTapButtonXpath.click();
			sActualSeconds=meSecondsValueXpath.getAttribute("text");
		}
	}

	public void selectDayNumberMonthAndYear(String sDayNumber, String sMonth,String sYear) throws Exception{
		meDatePickerButtonXpath.click();
		actionDriver.waitForElementToBeClickable("id",CALENDER_HEADER_YEAR_TEXT_ID);
		selectDayNumberAndMonth(sDayNumber, sMonth);
		selectYear(sYear);
	}

	public void selectDayNumberAndMonth(String sDayNumber,String sMonth) throws Exception{
		String sDynamic_DayNumber_Xpath = "//android.widget.ViewAnimator[@index='1']//android.view.View[@text='"+sDayNumber+"']";
		System.out.println("sDayNumber" +sDayNumber);
		System.out.println("sDayNumber" +sMonth);
		while(!meMonthHeaderValueXpath.getAttribute("text").contains(sMonth)){
			System.out.println("Actual Date = "+meMonthHeaderValueXpath.getAttribute("text"));
			meNextMonthButtonID.click();
			actionDriver.sleepThread(1);
			sDynamic_DayNumber_Xpath="//android.widget.ViewAnimator[@index='1']//android.view.View[@text='"+sDayNumber+"']";
			actionDriver.waitForElementToBeClickable("xpath",sDynamic_DayNumber_Xpath);
			actionDriver.clickElement("xpath", sDynamic_DayNumber_Xpath);
			actionDriver.sleepThread(1);
		}
		actionDriver.clickElement("xpath", sDynamic_DayNumber_Xpath);
	}

	public void selectYear(String sYear) throws Exception{
		String sDynamicXpath_Year_Header="//android.widget.TextView[@text='"+sYear+"']";
		String sDynamicXpath_ActualYearToBeSelected="//android.widget.ViewAnimator[@index='1']//android.widget.TextView[@text='"+sYear+"']";
		meYearOptionOnCalender.click();
		actionDriver.waitForElementToBeClickable("xpath",sDynamicXpath_Year_Header);
		actionDriver.clickElement("xpath", sDynamicXpath_ActualYearToBeSelected);
		System.out.println("Element Clicked on XPATH = "+"//android.widget.ViewAnimator[@index='1']//android.widget.TextView[@text='"+sYear+"']");
		actionDriver.waitForElementToBeClickable("id",HEADER_DATE_DATE_PICKER_ID);
	}

	public void selectRailCard(String sRailCard) throws Exception{
		initActionDriver();
		meAddRailCardsName.click();
		actionDriver.waitForVisibiltyOfElement("id",RAIL_CARD_TITLE_ID);
		actionDriver.clickElement("name", sRailCard);
	}

	public void clickOnfindTickets() throws Exception{
		meFindTicketsButtonId.click();
		actionDriver.waitForVisibiltyOfElement("id",SelectTrainPage.SELECT_TRAIN_PAGE_TITLE_ID);
	}

	public void initActionDriver() {
		actionDriver = new ActionDriver(TestBase.driver);
	}

	public void initMobileDriver() {
		mobileDriver = new MobileDriver(TestBase.driver);
	}
}
