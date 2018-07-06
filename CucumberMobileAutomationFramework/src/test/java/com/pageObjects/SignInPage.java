package com.pageObjects;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.utilties.ActionDriver;
import com.utilties.MobileDriver;
import com.utilties.TestBase;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import com.pageObjects.ReviewYourOrderPage;

public class SignInPage {
	
	public ActionDriver actionDriver;
	public MobileDriver mobileDriver;
		
	public SignInPage(AndroidDriver<MobileElement> driver) {
		TestBase.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public static final String EMAIL_ADDRESS_TEXTFIELD_ID="com.firstgreatwestern.test:id/inputEmailLayout";
	public static final String PASSWORD_TEXTFIELD_ID="com.firstgreatwestern.test:id/inputPasswordEditText";
	public static final String SIGN_IN_BUTTON_ID="com.firstgreatwestern.test:id/btnAction";
	
	@FindBy(id=EMAIL_ADDRESS_TEXTFIELD_ID)
	MobileElement meEmailAddressTextFieldId;
	
	@FindBy(id=PASSWORD_TEXTFIELD_ID)
	MobileElement mePasswordTextFieldId;
	
	@FindBy(id=SIGN_IN_BUTTON_ID)
	MobileElement meSignInButtonId;
	
	public  void signIN(String sEmailAddress,String sPassword) throws Exception{	
		meEmailAddressTextFieldId.clear();
		meEmailAddressTextFieldId.sendKeys(sEmailAddress);
		mePasswordTextFieldId.sendKeys(sPassword);
		meSignInButtonId.click();
		initActionDriver();
		initMobileDriver();
		actionDriver.sleepThread(10);
		this.actionDriver.waitForElementToBeClickable("id", ReviewYourOrderPage.REVIEW_YOUR_ORDER_GO_TO_CHECKOUT_BUTTON_ID);
	}
	
	public void initActionDriver() {
		actionDriver = new ActionDriver(TestBase.driver);
	}

	public void initMobileDriver() {
		mobileDriver = new MobileDriver(TestBase.driver);
	}

}
