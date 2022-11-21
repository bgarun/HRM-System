package com.HRMSystem.PomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HROfficerEmployeeListPage {
	
	@FindBy(xpath="(//button[@class='btn btn-primary'])[1]")
	private WebElement addempbtn;
	
	@FindBy(id="example1_next")
	private WebElement nextbtn;
	
	@FindBy(xpath="//tbody/tr[last()]/td/i[@class='fa fa-trash']")
	private WebElement deletebtn;
	
	@FindBy(xpath="//i[@class='fa fa-user']")
	private WebElement usericon;
	
	@FindBy(xpath="(//a[@class='dropdown-item'])[2]")
	private WebElement logoutbtn;
	
	public HROfficerEmployeeListPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getAddempbtn() {
		return addempbtn;
	}
	
	public WebElement getDeletebtn() {
		return deletebtn;
	}

	public WebElement getNextbtn() {
		return nextbtn;
	}
	
	public WebElement getUsericon() {
		return usericon;
	}

	public WebElement getLogoutbtn() {
		return logoutbtn;
	}

	public void addempbtn() {
		addempbtn.click();
	}
	
	public void deletebtn() {
		deletebtn.click();
	}
	
	public void nextbtn() {
		nextbtn.click();
	}
	
	public void logout() {
		usericon.click();
		logoutbtn.click();
	}
}
