package com.HRMSystem.PomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.HRMSystem.Generic_Libraries.WebDriver_Utilities;

public class HRAssistEmployeeListPage extends WebDriver_Utilities {
	
	
	@FindBy(xpath="(//button[@class='btn btn-primary'])[1]")
	private WebElement addempbtn;
	
	@FindBy(id="example1_next")
	private WebElement nextbtn;
	
	@FindBy (xpath="//tbody/tr[last()]/td[last()]/i[@class='fa fa-edit']")
//	@FindAll(value = { @FindBy (xpath="//tbody/tr[last()]/td/i[@title='Edit Employee']"), @FindBy(xpath="//tbody/tr[last()]/td/i[@class='fa fa-edit']")})
//	@FindBy(xpath="//tbody/tr[last()]/td/i[@title='Edit Employee' and @class='fa fa-edit']")
	private WebElement editbtn;
	
	public HRAssistEmployeeListPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getAddempbtn() {
		return addempbtn;
	}

	public WebElement getNextbtn() {
		return nextbtn;
	}
	
	public WebElement getEditbtn() {
		return editbtn;
	}

	public void addempbtn() {
		addempbtn.click();
	}
	
	public void nextbtn() {
		nextbtn.click();
	}
	
	public void editbtn(WebDriver driver) {
		scrollAction(driver, editbtn);
		waitForElemnetToBeClickAble(driver, editbtn);
		editbtn.click();
	}
}
