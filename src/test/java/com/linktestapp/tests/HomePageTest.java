package com.linktestapp.tests;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.linktestapp.pages.FeaturesPage;
import com.linktestapp.pages.HomePage;
import com.linktestapp.testbase.TestBase;
import com.linktestapp.utility.Utility;

public class HomePageTest extends TestBase{

	HomePage hmpg;
	FeaturesPage fpage;

	@BeforeTest
	public void setup() {
		initialization();
		hmpg = new HomePage();
	}
	
	@Test(priority = 1)
	public void testAllLinks() {
		// All links are workable check
		List<WebElement> list = driver.findElements(By.tagName("a"));
		System.out.println("Links - "+list.size());
		long entrytime = System.currentTimeMillis();
		Utility.checkingURL(list);
		long completetime = System.currentTimeMillis();
		long totaltimetaken = (completetime - entrytime)/1000;
		System.out.println("Total time taken to check the URLs - "+ totaltimetaken+ " seconds");
	}
	
	@Test(priority = 2, enabled = false)
	public void moveToFeatures() {
		fpage = hmpg.clickFeatureLink();
		System.out.println("Features is clicked");
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
