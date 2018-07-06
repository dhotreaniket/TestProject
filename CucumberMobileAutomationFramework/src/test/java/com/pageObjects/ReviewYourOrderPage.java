package com.pageObjects;

import org.openqa.selenium.support.PageFactory;

import com.utilties.ActionDriver;
import com.utilties.MobileDriver;
import com.utilties.TestBase;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ReviewYourOrderPage extends TestBase{

	public ActionDriver actionDriver;
	public MobileDriver mobileDriver;

	public ReviewYourOrderPage(AndroidDriver<MobileElement> driver) {
		TestBase.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public static final String REVIEW_YOUR_ORDER_TEXT_XPATH="//android.widget.TextView[@text='Review Your Order']";
	
	public static final String REVIEW_YOUR_ORDER_SCROLL_ID="com.firstgreatwestern.test:id/nestedScollView";
	
	public static final String REVIEW_YOUR_ORDER_GO_TO_CHECKOUT_BUTTON_ID="com.firstgreatwestern.test:id/btnAction";
	
	@AndroidFindBy(id=REVIEW_YOUR_ORDER_GO_TO_CHECKOUT_BUTTON_ID)
	MobileElement meGoToCheckOutButton;
	
	@AndroidFindBy(xpath=REVIEW_YOUR_ORDER_TEXT_XPATH)
	MobileElement meReviewYourOrderText;

	public void clickGoToCheckout() throws Exception{
		initActionDriver();
		initMobileDriver();
		try {
			this.mobileDriver.scrollToVisibleTextById(REVIEW_YOUR_ORDER_SCROLL_ID, "Go to checkout");
		} catch (Exception e) {
			this.mobileDriver.scrollToVisibleTextById(REVIEW_YOUR_ORDER_SCROLL_ID, "Sign in to purchase");
		}
		meGoToCheckOutButton.click();
		//waitForElementToVisibleByXPATH("//android.widget.TextView[@text='Payment']");
		this.actionDriver.sleepThread(10);
	}
	
	public void click_CheckOutButton(){
		meGoToCheckOutButton.click();
	}
	
	public void initActionDriver() {
		actionDriver = new ActionDriver(TestBase.driver);
	}

	public void initMobileDriver() {
		mobileDriver = new MobileDriver(TestBase.driver);
	}	
}
