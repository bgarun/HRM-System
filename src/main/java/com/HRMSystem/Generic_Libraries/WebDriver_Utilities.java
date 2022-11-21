package com.HRMSystem.Generic_Libraries;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

/**
 * This class is used to write WebDriver specific methods
 * @author B G ARUNKUMAR
 */

public class WebDriver_Utilities {
	/**
	 * This method is used to wait for page load
	 * @param driver
	 */
public void waitForPageLoad(WebDriver driver) {
	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	
}
/**
 * This method is used until element to be visible
 * @param driver
 * @param element
 */

public void waitForElementToBeVisible(WebDriver driver, WebElement element) {
	WebDriverWait wait=new WebDriverWait(driver, 20);
	wait.until(ExpectedConditions.visibilityOf(element));
}

/**
 * This Method is used until element to be clickable
 * @param driver
 * @param element
 */
public void waitForElemnetToBeClickAble(WebDriver driver, WebElement element) {
WebDriverWait wait = new WebDriverWait(driver,10);
wait.until(ExpectedConditions.elementToBeClickable(element));
}
/**
 * This Method enables the user to handle drop down by index
 * @param element
 * @param Index
 */

public void select(WebElement element, int Index) {
	Select sel=new Select(element);
	sel.selectByIndex(Index);
}
/**
 *  This Method enables the user to handle drop down by Index value
 * @param value
 * @param element
 */
public void select(String value, WebElement element) {
	Select sel=new Select(element);
	sel.selectByValue(value);
}

/**
 *  This Method enables the user to handle drop down by Visible Text
 * @param element
 * @param text
 */
public void select(WebElement element, String text) {
	Select sel=new Select(element);
	sel.selectByVisibleText(text);
	
}
/**
 * This Method is used for MouseHover Action
 * @param driver
 * @param ele
 */

public void mouseHover(WebDriver driver,WebElement ele) {
	Actions a=new Actions(driver);
	a.moveToElement(ele).perform();
}

/**
 * This method is used for Right Click action on Web page
 * @param driver
 */
public void rightclick(WebDriver driver) {
	Actions a=new Actions(driver);
	a.contextClick().perform();
	
}

/**
 * This Method is used for Right click action
 * @param driver
 * @param ele
 */
public void rightclick(WebDriver driver,WebElement ele) {
	Actions a=new Actions(driver);
	a.contextClick(ele).perform();
	
}

/**
 * This Method is used for Double click on element Action
 * @param driver
 * @param ele
 */
public void doubleClick(WebDriver driver,WebElement ele) {
	Actions a=new Actions(driver);
	a.doubleClick(ele).perform();
}

/**
 * This method is used to double click on Web page
 */
public void doubleClick(WebDriver driver) {
	Actions a=new Actions(driver);
	a.doubleClick().perform();
}

/**
 * This Method is used for Drag and Drop Action
 * @param driver
 * @param src
 * @param target
 */
public void draganddrop(WebDriver driver,WebElement src,WebElement target) {
	Actions a=new Actions(driver);
	a.dragAndDrop(src, target).perform();
}

/**
 * This Method is used to switch to frame
 * @param driver
 */
public void switchtoframe(WebDriver driver, int index) {
	driver.switchTo().frame(index);
}

public void switchtoframe(WebDriver driver, WebElement address) {
	driver.switchTo().frame(address);
}

public void swithToFrame(WebDriver driver , String nameOrID) {
driver.switchTo().frame(nameOrID);
}

/**
 * This Method is used to switch back to frame
 * @param driver
 */
public void switchbackframe(WebDriver driver) {
	driver.switchTo().defaultContent();
}

/**
 * This Method is used to accept the Alert pop up
 * @param driver
 */
public void alertpopupaccept(WebDriver driver) {
	driver.switchTo().alert().accept();
}

/**
 * This Method is used to Cancel the Alert pop up
 * @param driver
 */
public void alertpopupcancel(WebDriver driver) {
	driver.switchTo().alert().dismiss();
}

/**
 * This Method is used to Switch to Tabs
 * @param driver
 */
public void switchTabs(WebDriver driver) {
	Set<String> child = driver.getWindowHandles();
	for(String b:child) {
		driver.switchTo().window(b);
	}
}

/**
 * This Method is used for Random Scrolling Action
 * @param driver
 * @param x
 * @param y
 */
public void scrollBar(WebDriver driver) {
	JavascriptExecutor js=(JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,800)","");
}

/**
 * This method will scroll until specified element is found
 * @param driver
 * @param element
 */
public void scrollAction(WebDriver driver, WebElement element)
{
	JavascriptExecutor jse = (JavascriptExecutor) driver;
	int y = element.getLocation().getY();
	jse.executeScript("window.scrollBy(0,"+y+")", element);
	//jse.executeScript("argument[0].scrollIntoView()", element);
}

public void scrollTillEnd(WebDriver driver)
{
	JavascriptExecutor jse = (JavascriptExecutor) driver;
	
	jse.executeScript("window.scrollTo(0,document.body.scrollHeight)");
}

/**
 * This Method is used Switch to window
 * @param driver
 * @param partialWindowTitle
 */
public void swithToWindow(WebDriver driver , String partialWindowTitle) {
	 Set<String> set = driver.getWindowHandles();
	 Iterator<String> it = set.iterator();
	 while (it.hasNext()) {
	 String wID = it.next();
	 driver.switchTo().window(wID);
	 String currentWindowTitle = driver.getTitle();
	 if(currentWindowTitle.contains(partialWindowTitle )) {
	 break;
	 }
	 }
	}

/**
 * This Method is used to TakeScreenShot
 * @param driver
 * @param screenshotName
 * @throws Throwable
 */
public void takeScreenshot(WebDriver driver, String screenshotName) throws Throwable {
	 TakesScreenshot ts=(TakesScreenshot)driver;
	 File src=ts.getScreenshotAs(OutputType.FILE);
	 File dest=new File("./Screenshot/"+screenshotName+".PNG");
	 FileUtils.copyFile(src, dest);
	 }

/**
 * This Method will press enter key
 */
public void passEnterKey(WebDriver driver) {
Actions act = new Actions(driver);
act.sendKeys(Keys.ENTER).perform();
} 
	
/**
 * This Method will press enter key
 * @param driver
 * @throws Throwable
 */
public void EnterKey(WebDriver driver) throws Throwable {
Robot rb=new Robot();
rb.keyPress(KeyEvent.VK_ENTER);
} 

public void EnterRelease(WebDriver driver) throws Throwable {
Robot rb=new Robot();
rb.keyRelease(KeyEvent.VK_ENTER);
} 

public void maximizeWindow(WebDriver driver) {
	driver.manage().window().maximize();
}


}
