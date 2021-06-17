package com.linktestapp.utility;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.linktestapp.testbase.TestBase;

public class Utility extends TestBase{

	public static String CONFIGURATION_PATH = "./\\src\\main\\java\\com\\linktestapp\\configurator\\configurator.properties";
	public static String CHROME_DRIVER_PATH = "./\\executors\\Drivers\\chromedriver.exe";
	public static String FIREFOX_DRIVER_PATH = "./\\executors\\Drivers\\geckodriver.exe";
	public static int IMPLICITLY_WAIT_PAGELOAD = 30;
	public static String checkingurl;
	public static HttpURLConnection huc = null;
	public static int respCode = 200;
	
	public static void checkingURL(List<WebElement> list) {
		
		//List<WebElement> list = driver.findElements(By.tagName("a"));
		Iterator<WebElement> listiterator = list.iterator();
		
		while(listiterator.hasNext()) {
			checkingurl = listiterator.next().getAttribute("href");
			
			if (checkingurl == null || checkingurl.isEmpty()) {
				System.out.println(checkingurl+"URL is Empty");
				continue;
			}
			
			if(!checkingurl.contains("amazon.com")) {
				System.out.println(checkingurl+ "URL not with domain");
				continue;
			}
			
			try {
				huc = (HttpURLConnection)(new URL(checkingurl).openConnection());
				huc.setRequestMethod("HEAD");
				huc.connect();
				respCode = huc.getResponseCode();
				
				if(respCode >=400){
					System.out.println("Broken url is "+checkingurl);
				}
				else
					System.out.println(checkingurl+" "+"No URL is broken");
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
