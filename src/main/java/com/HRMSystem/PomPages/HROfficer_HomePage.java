package com.HRMSystem.PomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HROfficer_HomePage {

	@FindBy(xpath="(//a[@class='nav-link'])[3]")
	private WebElement employeebtn;
	
	@FindBy(xpath="//p[text()='Add Employee']")
	private WebElement addemployeebtn;
	
	public HROfficer_HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getEmployeebtn() {
		return employeebtn;
	}

	public WebElement getAddemployeebtn() {
		return addemployeebtn;
	}
	
	public void addemployee() {
		employeebtn.click();
		addemployeebtn.click();
	}
}
