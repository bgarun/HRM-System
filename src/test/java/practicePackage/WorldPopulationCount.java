package practicePackage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.HRMSystem.Generic_Libraries.BaseClass;


public class WorldPopulationCount extends BaseClass{

	@Test
	public void population() {
		int count=1;
		while(true) {
			
		List<WebElement> pop = driver.findElements(By.xpath("//div[@class='maincounter-number']"));
		
		for(WebElement e:pop) {
			System.out.println(e.getText());
		}
		
		}
	}

}
