package com.HRMSystem.PomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCorporatePage {

	@FindBy(name="corporate_name")
	private WebElement corporatetxt;
	
	@FindBy(name="corp")
	private WebElement savebtn;
	
	public AddCorporatePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getCorporatetxt() {
		return corporatetxt;
	}

	public WebElement getSavebtn() {
		return savebtn;
	}
	
	public void addcorporate(String CorpName) {
		corporatetxt.sendKeys(CorpName);
		savebtn.click();
	}
}
