package com.BaseTest;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TravelBaseClass {
		public static WebDriver driver = null;
		public static FileReader propFileReader;
		public static Properties properties = new Properties();
		public static WebDriverWait wait;
		@BeforeTest
		public void setup() throws IOException {
			//Read properties file...........................................
			if(driver==null) {
				propFileReader = new FileReader("C:\\Users\\Netizens\\Desktop\\TravelProject\\TravelAutoTesting\\ConfigurationFiles\\Config.properties");
				properties.load(propFileReader);
				System.out.println("filereader run");
			}
			//cross browser code.............................................
			if(properties.getProperty("Browser").equalsIgnoreCase("Chrome")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			}else if(properties.getProperty("Browser").equalsIgnoreCase("Edge")) {
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
			}
			System.out.println("cross Browser run");
			
			//browser launch code..............................................
			driver.manage().window().maximize();
			driver.get(properties.getProperty("URL"));
			System.out.println("browser launch");
			
			//wait
			wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		}
	/*	@AfterTest
		public void tearDown() {
			if(driver !=null) {
				driver.quit();
				System.out.println("Browser closed...!");
			}
		}	*/
	}

	
	
	

