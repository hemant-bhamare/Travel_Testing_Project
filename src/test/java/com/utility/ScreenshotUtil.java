package com.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import com.BaseTest.TravelBaseClass;

public class ScreenshotUtil extends TravelBaseClass {

    public static void takeScreenshot(String testName) {
        // Timestamp format for file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

        // Take screenshot and store in a temporary file
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        // Dynamic path based on project root
        String folderPath = System.getProperty("user.dir") + File.separator + "Screenshotsv";
        String filePath = folderPath + File.separator + testName + "_" + timeStamp + ".png";

        // Create folder if it does not exist
        File screenshotDir = new File(folderPath);
        if (!screenshotDir.exists()) {
            screenshotDir.mkdirs();
        }

        try {
            FileHandler.copy(src, new File(filePath));
            System.out.println("Screenshot saved at: " + filePath);
        } catch (IOException e) {
            System.err.println("Failed to save screenshot: " + e.getMessage());
        }
    }
}