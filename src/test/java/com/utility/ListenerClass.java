package com.utility;

import org.testng.ITestListener;
import org.testng.ITestResult;


public class ListenerClass implements ITestListener{
	public void onTestFailure(ITestResult result) {
		ScreenshotUtil.takeScreenshot(result.getName());
	}
}
