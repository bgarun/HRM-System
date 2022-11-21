package practicePackage;

import java.util.Collections;
import java.util.List;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownPrintingReverse {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		WebElement dropdown = driver.findElement(By.id("searchDropdownBox"));
		dropdown.click();
		Select s=new Select(dropdown);
		TreeSet<String> set = new TreeSet<String>(Collections.reverseOrder());
		List<WebElement> options = s.getOptions();
		for(WebElement b:options) {
			String text = b.getText();
			set.add(text);
		}
		for(String c:set) {
			System.out.println(c);
		}
		driver.close();
		

	}

}
