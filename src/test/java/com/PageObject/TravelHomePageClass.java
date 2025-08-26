package com.PageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.BaseTest.TravelBaseClass;

public class TravelHomePageClass extends TravelBaseClass {

	// Constructor
	public TravelHomePageClass() {
		PageFactory.initElements(driver,this);
	}

	// WebElements with XPath
	@FindBy(xpath = "//input[@name='first_name']")public WebElement firstName;
	@FindBy(xpath = "//input[@name='last_name']")public WebElement lastName;
	@FindBy(xpath = "//input[@name='whatsapp']")public WebElement mobileNum;
	@FindBy(xpath = "//input[@name='business_name']")public WebElement businessName;
	@FindBy(xpath = "//input[@name='email']")public WebElement email;
	@FindBy(xpath = "//span[@id='numb1']")public WebElement value1;
	@FindBy(xpath = "//span[@id='numb2']")public WebElement value2;
	@FindBy(xpath = "//input[@placeholder='Result ?']")public WebElement captcha;
	@FindBy(xpath = "//button[@id='demo']")public WebElement submitButton;
	@FindBy(xpath = "//h2//strong[text()=' Thank you!']")public WebElement successMessage;

	// Actions
	public void enterFirstName(String fname) {
		wait.until(ExpectedConditions.visibilityOf(firstName));
		firstName.sendKeys(fname);
	}

	public void enterLastName(String lname) {
		lastName.sendKeys(lname);
	}

	public void enterMobileNum(String mob) {
		wait.until(ExpectedConditions.visibilityOf(mobileNum));
		mobileNum.sendKeys(mob);
	}

	public void enterBusinessName(String bname) {
		businessName.sendKeys(bname);
	}

	public void enterEmail(String emailId) {
		email.sendKeys(emailId);
	}

	public void enterCaptcha() {
		 int num1 = Integer.parseInt(value1.getText().trim());
		    int num2 = Integer.parseInt(value2.getText().trim());
		    int sum = num1 + num2;
		    captcha.sendKeys(String.valueOf(sum));
	}
	
	public void clickSubmit() throws InterruptedException {
		Thread.sleep(2000);//wait.until(ExpectedConditions.visibilityOf(submitButton));
		submitButton.click();
	}
	public void successMsg() {
		try {
			wait.until(ExpectedConditions.visibilityOf(successMessage));
			String ThankyouMsg = successMessage.getText();
			System.out.println(ThankyouMsg);
		} catch (Exception e) {
			
			e.getMessage();
		}
	}

}
