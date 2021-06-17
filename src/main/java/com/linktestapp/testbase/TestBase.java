package com.linktestapp.testbase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.linktestapp.utility.Utility;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public static String url;
	
	public TestBase(){
		// TODO Auto-generated constructor stub
		FileInputStream fipconf;
		try {
			fipconf = new FileInputStream(Utility.CONFIGURATION_PATH);
			prop = new Properties();
			prop.load(fipconf);	
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		 
	}
	
	public static void initialization() {
		
		String browser = prop.getProperty("browser");
		 url = prop.getProperty("url");
		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", Utility.CHROME_DRIVER_PATH);
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(Utility.IMPLICITLY_WAIT_PAGELOAD, TimeUnit.SECONDS);
			driver.get(url);
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", Utility.FIREFOX_DRIVER_PATH);
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(Utility.IMPLICITLY_WAIT_PAGELOAD, TimeUnit.SECONDS);
			driver.get(url);
		}
		else
			System.out.println("NO ACCURATE BROWSER IS FOUND");
	}
}
