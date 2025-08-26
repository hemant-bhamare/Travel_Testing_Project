package com.TestClass;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.BaseTest.TravelBaseClass;
import com.PageObject.TravelHomePageClass;
import com.utility.ScreenshotUtil;


public class TravelTestClass extends TravelBaseClass {
	
	 private static boolean formSubmitted = false;
	
    @DataProvider(name = "formData")
    public Object[][] getFormData() {
        return new Object[][] {
            // firstName, lastName, mobileNum, businessName, email
            {"John", "Doe", "9759395397", "Demo Business", "john@gmail.com"},  // positive
            {"", "Doe", "9759395397", "Demo Business", "john@gmail.com"},      // negative - empty firstName
            {"John", "", "9759395397", "Demo Business", "john@gmail.com"},     // negative - empty lastName
            {"Jane", "Smith", "", "Test Business", "jane@test.com"},           // negative - empty mobileNum
            {"Alan", "Walker", "9759395397", "", "alan@gmail.com"},            // negative - empty businessName
            {"Alice", "Wong", "9759395397", "Alpha LLC", ""},                  // negative - empty email
        };
    }

    @Test(dataProvider = "formData")
    public void testTravelForm(String firstName, String lastName, String mobileNum, String businessName, String email, ITestContext context) throws InterruptedException {
        TravelHomePageClass thp = new TravelHomePageClass();
        
        if (formSubmitted || Boolean.TRUE.equals(context.getAttribute("formSubmitted"))) {
            throw new SkipException("Form already submitted successfully. Skipping remaining tests.");
        }

        thp.enterFirstName(firstName);
        thp.enterLastName(lastName);
        thp.enterMobileNum(mobileNum);
        thp.enterBusinessName(businessName);
        thp.enterEmail(email);
        thp.enterCaptcha();       // This is internally calculated
        thp.clickSubmit();        // Click the button
        
     // Check for success message
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            WebElement msg = wait.until(ExpectedConditions.visibilityOf(thp.successMessage));
            if (msg.isDisplayed()) {
                System.out.println("Success message found. Stopping further tests.");
                context.setAttribute("formSubmitted", true); // Set global flag
                Assert.assertTrue(true);
                throw new SkipException("Stopping further data inputs after successful form submission.");
            }
        } catch (Exception e) {
            System.out.println("Success message not found. Proceeding with next data.");
            ScreenshotUtil.takeScreenshot("testTravelForm"); // <-- Add this line to capture screenshot
            Assert.fail("Success message not found"); // <-- Optional, if you want to mark it failed
        }
    }
 }


