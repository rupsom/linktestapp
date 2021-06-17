package com.linktestapp.tests;

import org.testng.annotations.BeforeTest;

import com.linktestapp.pages.HomePage;
import com.linktestapp.testbase.FeaturesPage;
import com.linktestapp.testbase.TestBase;

public class FeaturesPageTest extends TestBase{

	HomePage hmpg;
	FeaturesPage fpage;
	
	@BeforeTest
	public void setup() {
		initialization();
		hmpg = new HomePage();
		fpage = hmpg.clickFeatureLink();
	}

}
