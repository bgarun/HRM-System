package com.HRMSystem.PomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddBranchPage {
@FindBy(name="branches_name")
private WebElement branchtxt;

@FindBy(name="bran")
private WebElement savebtn;

public AddBranchPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}

public WebElement getBranchtxt() {
	return branchtxt;
}

public WebElement getSavebtn() {
	return savebtn;
}

public void branchtxt(String branchname) {
	branchtxt.sendKeys(branchname);
	savebtn.click();
}





}
