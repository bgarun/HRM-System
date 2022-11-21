package com.HRMSystem.PomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.HRMSystem.Generic_Libraries.WebDriver_Utilities;

public class LoginPage extends WebDriver_Utilities {

	@FindBy(name="hr_email")
	private WebElement usernametxt;
	
	@FindBy(name="hr_password")
	private WebElement passwordtxt;
	
	@FindBy(name="hr_type")
	private WebElement hrtypedropdown;
	
	@FindBy(name="login_hr")
	private WebElement submitbtn;
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getUsernametxt() {
		return usernametxt;
	}

	public WebElement getPasswordtxt() {
		return passwordtxt;
	}

	public WebElement getHrtypedropdown() {
		return hrtypedropdown;
	}
	
	public WebElement getSubmitbtn() {
		return submitbtn;
	}
	
	public void login(String un, String pwd, String text) {
		usernametxt.sendKeys(un);
		passwordtxt.sendKeys(pwd);
		select(hrtypedropdown, text);
		submitbtn.click();
		
	}

	
	}
	
	
	

