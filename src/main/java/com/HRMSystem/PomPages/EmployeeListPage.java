package com.HRMSystem.PomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.HRMSystem.Generic_Libraries.WebDriver_Utilities;

public class EmployeeListPage {
	
	
	@FindBy(xpath="(//button[@class='btn btn-primary'])[1]")
	private WebElement addempbtn;
	
	@FindBy(id="example1_next")
	private WebElement nextbtn;
	
	@FindBy(xpath="//tbody/tr[last()]/td[last()]/i[@class='fa fa-trash']")
	private WebElement deletebtn;

	@FindBy(xpath = "//tbody/tr[last()]/td[@class='sorting_1']/following-sibling::td[last()]/i[@class='fa fa-trash']")
	private WebElement deletePopupbtn;

	
	@FindBy(xpath="//i[@class='fa fa-user']")
	private WebElement usericon;
	
	@FindBy(xpath="//div[@class='card-body']//div[@class='dataTables_wrapper dt-bootstrap4 no-footer']/div[last()]//li[@class='paginate_button page-item active']")
	private WebElement lastpage;
	
	@FindBy(xpath="(//a[@class='dropdown-item'])[2]")
	private WebElement logoutbtn;
	
	public EmployeeListPage(WebDriver driver) {
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
	
	public void deletebtn(WebDriver driver, WebDriver_Utilities Wlib) {
		Wlib.waitForElemnetToBeClickAble(driver, deletebtn);
		Wlib.scrollTillEnd(driver);
		Wlib.scrollAction(driver, lastpage);
		lastpage.click();
		deletebtn.click();
		Wlib.waitForElementToBeVisible(driver, deletePopupbtn);
		deletePopupbtn.click();
	}
	
	public void logout() {
		usericon.click();
		logoutbtn.click();
	}
	
	public void nextbtn() {
		nextbtn.click();
	}
}
