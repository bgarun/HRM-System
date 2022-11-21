package com.HRMSystem.PomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HRHead_HomePage {
	
@FindBy(xpath="(//a[@class='nav-link'])[3]")
private WebElement corporate;

@FindBy(xpath="//p[text()='Add Corporate']")
private WebElement addCorporate;

@FindBy(xpath="(//a[@class='nav-link'])[5]")
private WebElement branch;

@FindBy(xpath="//p[text()='Add Braches']")
private WebElement addBranch;

@FindBy(xpath="(//a[@class='nav-link'])[7]")
private WebElement employee;

@FindBy(xpath="//p[text()='Add Employee']")
private WebElement addEmployee;

public HRHead_HomePage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}

public WebElement getCorporate() {
	return corporate;
}

public WebElement getAddCorporate() {
	return addCorporate;
}

public WebElement getBranch() {
	return branch;
}

public WebElement getAddBranch() {
	return addBranch;
}

public WebElement getEmployee() {
	return employee;
}

public WebElement getAddEmployee() {
	return addEmployee;
}

public void corporate() {
	corporate.click();
	addCorporate.click();
}

public void branch() {
	branch.click();
	addBranch.click();
}

public void employee() {
	employee.click();
	addEmployee.click();
}


}
