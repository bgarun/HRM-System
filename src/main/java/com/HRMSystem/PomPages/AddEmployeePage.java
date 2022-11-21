package com.HRMSystem.PomPages;

import java.util.Map;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.HRMSystem.Generic_Libraries.WebDriver_Utilities;



public class AddEmployeePage extends WebDriver_Utilities{

	@FindBy(name="emplo")
	private WebElement savebtn;
	
	@FindBy(name="employee_department")
	private WebElement deptDropDown;
	
	@FindBy(name="employee_branches")
	private WebElement branchDropDown;
	
	@FindBy(name="employee_file201")
	private WebElement fileUpload;
	
	@FindBy(name="employee_image")
	private WebElement imageUpload;
	
	public AddEmployeePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getDeptDropDown() {
		return deptDropDown;
	}

	public WebElement getBranchDropDown() {
		return branchDropDown;
	}
	
	public WebElement getFileUpload() {
		return fileUpload;
	}

	public WebElement getImageUpload() {
		return imageUpload;
	}

	public WebElement getSavebtn() {
		return savebtn;
	}
	
	public void addEmployee(Map<String, String> map, WebDriver driver,String dept, String branch, String file, String Image ) {
		for(Entry<String, String> set:map.entrySet()) {
			driver.findElement(By.name((set.getKey()))).sendKeys(set.getValue());
		}
		select(deptDropDown, dept);
		select(branchDropDown, branch);
		fileUpload.sendKeys(file);
		imageUpload.sendKeys(Image);
		savebtn.click();
	}

	
	
}
