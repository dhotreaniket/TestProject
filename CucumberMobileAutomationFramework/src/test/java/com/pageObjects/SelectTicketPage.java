package com.pageObjects;

import com.utilties.ActionDriver;
import com.utilties.MobileDriver;
import com.utilties.TestBase;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.openqa.selenium.support.PageFactory;

import com.pageObjects.SeatsAndExtrasPage;

public class SelectTicketPage extends TestBase{
	
	public SelectTicketPage(AndroidDriver<MobileElement> driver) {
		TestBase.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	public static final String SELECT_TICKET_PAGE_TICKET_TYPE_ID="com.firstgreatwestern.test:id/ticketType";
	public static final String SELECT_TRAIN_FIRST_FRAME_LAYOUT_XPATH="//android.widget.FrameLayout[@index='0']";

	public ActionDriver actionDriver;
	public MobileDriver mobileDriver;
	
	@AndroidFindBy(id=SELECT_TICKET_PAGE_TICKET_TYPE_ID)
	MobileElement meSelectTicketPageTicketTypeID;
	
	@AndroidFindBy(xpath=SELECT_TRAIN_FIRST_FRAME_LAYOUT_XPATH)
	MobileElement meSelectTrainFirstFrameLayoutXpath;
	
	@AndroidFindBy(xpath=SeatsAndExtrasPage.SEATS_AND_EXTRAS_PAGE_SEAT_RESERVATION_CONTAINER_ID)
	MobileElement meSeatsAndExtrasPageSeatReservationContainerId;

	
	public void selectTicket(String sTicketType) throws Exception{
		initActionDriver();
		initMobileDriver();
		//waitForElementToBeClickableByXPATH("//android.widget.TextView[@text='"+sTicketType+"']/parent::android.widget.LinearLayout[@index='0']/parent::android.widget.LinearLayout[@index='0']/parent::android.widget.RelativeLayout[@index='0]/parent::android.widget.LinearLayout[@index='0']/parent::android.widget.FrameLayout[@index='0']");	
		//driver.findElement(By.xpath("//android.widget.TextView[@text='"+sTicketType+"']/parent::android.widget.LinearLayout[@index='0']/parent::android.widget.LinearLayout[@index='0']/parent::android.widget.RelativeLayout[@index='0]/parent::android.widget.LinearLayout[@index='0']/parent::android.widget.FrameLayout[@index='0']")).click();
		meSelectTrainFirstFrameLayoutXpath.click();
		actionDriver.waitForElementToBeClickable("id", SeatsAndExtrasPage.SEATS_AND_EXTRAS_PAGE_SEAT_RESERVATION_CONTAINER_ID);
	}
	
	public void initActionDriver() {
		actionDriver = new ActionDriver(TestBase.driver);
	}

	public void initMobileDriver() {
		mobileDriver = new MobileDriver(TestBase.driver);
	}
}
