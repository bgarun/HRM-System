package com.HRMSystem.PomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CorporateListPage {

	@FindBy(xpath="//div[@class='card-header']/child::h3/button")
	private WebElement addcorpbtn;
	
	@FindBy(id="example1_next")
	private WebElement nextbtn;
	
	public CorporateListPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getAddcorpbtn() {
		return addcorpbtn;
	}

	public WebElement getNextbtn() {
		return nextbtn;
	}
	
	public void addcorporatebtn() {
		addcorpbtn.click();
	}
	
	public void nextbtn() {
		nextbtn.click();
	}
}
