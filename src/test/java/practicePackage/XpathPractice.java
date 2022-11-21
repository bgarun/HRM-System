package practicePackage;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class XpathPractice {
public static void main(String[] args) {
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.amazon.in/");
	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	WebElement dropdown = driver.findElement(By.id("searchDropdownBox"));
	dropdown.click();
	Select s=new Select(dropdown);
	List<WebElement> options = s.getOptions();
	
	
	
	
}
}
