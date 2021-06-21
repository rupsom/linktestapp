package com.linktestapp.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.linktestapp.testbase.TestBase;

public class FeaturesPage extends TestBase{

	@FindBy(xpath="")
	WebElement faqLink;
	
	public FeaturesPage() {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}
	
	public void clickFAQLink() {
		faqLink.click();
	}
}
