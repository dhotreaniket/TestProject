package com.pageObjects;

import com.utilties.ActionDriver;
import com.utilties.MobileDriver;
import com.utilties.TestBase;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.openqa.selenium.support.PageFactory;

import com.pageObjects.SelectTicketPage;


public class SelectTrainPage extends TestBase{

	public SelectTrainPage(AndroidDriver<MobileElement> driver) {
		TestBase.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	public static final String SELECT_TRAIN_SCROLL_ID="com.firstgreatwestern.test:id/serviceList";
	public static final String SELECT_TRAIN_PAGE_TITLE_ID="com.firstgreatwestern.test:id/headerOrigin";
	
	@AndroidFindBy(id=SELECT_TRAIN_PAGE_TITLE_ID)
	public  MobileElement meSelectTrainPageTitileId;

	@AndroidFindBy(id=SelectTicketPage.SELECT_TICKET_PAGE_TICKET_TYPE_ID)
	MobileElement meSelectTicketPageTicketTypeID;

	@AndroidFindBy(id=SELECT_TRAIN_SCROLL_ID)
	MobileElement meSelectTrainId;

	public ActionDriver actionDriver;
	public MobileDriver mobileDriver;

	public  void selectTrain(String sFromTime) throws Exception{
		initActionDriver();
		initMobileDriver();
		mobileDriver.scrollToVisibleTextAndClickById(SELECT_TRAIN_SCROLL_ID, sFromTime);
		actionDriver.waitForVisibiltyOfElement("id",SelectTicketPage.SELECT_TICKET_PAGE_TICKET_TYPE_ID);
	}

	public void initActionDriver() {
		actionDriver = new ActionDriver(TestBase.driver);
	}

	public void initMobileDriver() {
		mobileDriver = new MobileDriver(TestBase.driver);
	}
}
