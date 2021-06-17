package com.linktestapp.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.linktestapp.testbase.FeaturesPage;
import com.linktestapp.testbase.TestBase;

public class HomePage extends TestBase{

	FeaturesPage featurepage;
	
	@FindBy(xpath="//a[@class='lb-txt-bold lb-txt-none lb-txt lb-current-page-link']")
	WebElement featureLink;
	
	public HomePage() {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}
	
	public FeaturesPage clickFeatureLink() {
		featureLink.click();
		return new FeaturesPage();
	}
}
