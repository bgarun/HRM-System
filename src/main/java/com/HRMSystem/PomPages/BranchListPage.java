package com.HRMSystem.PomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BranchListPage {

	@FindBy(xpath="(//button[@class='btn btn-primary'])[1]")
	private WebElement addbrnchbtn;
	
	@FindBy(id="example1_next")
	private WebElement nextbtn;
	
	public BranchListPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getAddbrnchbtn() {
		return addbrnchbtn;
	}

	public WebElement getNextbtn() {
		return nextbtn;
	}

	public void addbranchbtn() {
		addbrnchbtn.click();
	}
	
	public void nextbtn() {
		nextbtn.click();
	}
	
	

}
