package com.HRMSystem.PomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.HRMSystem.Generic_Libraries.WebDriver_Utilities;

public class HRAssistantEditEmployeePage extends WebDriver_Utilities {

	@FindBy(name="employee_companyid")
	private WebElement companyIdtxt;
	
	@FindBy(name="employee_file201")
	private WebElement fileupload;
	
	@FindBy(name="employee_image")
	private WebElement imageupload;
	
	@FindBy(name="edit_emplo")
	private WebElement updatebtn;
	
	public HRAssistantEditEmployeePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getCompanyIdtxt() {
		return companyIdtxt;
	}
	
	public WebElement getFileupload() {
		return fileupload;
	}

	public WebElement getImageupload() {
		return imageupload;
	}
	
	public WebElement getUpdatebtn() {
		return updatebtn;
	}

	public void companyIdtxt(WebDriver driver,String ID, String file, String img) {
		//waitForElemnetToBeClickAble(driver, companyIdtxt);
		companyIdtxt.click();
		companyIdtxt.clear();
		companyIdtxt.sendKeys(ID);
		fileupload.sendKeys(file);
		imageupload.sendKeys(img);
		updatebtn.click();
	}
}
