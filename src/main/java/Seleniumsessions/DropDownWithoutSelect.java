package Seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownWithoutSelect {
	
	static WebDriver driver;
	
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial");
		
		List<WebElement> countrylist = driver.findElements(By.xpath("//select[@id='Form_submitForm_Country']/option"));
		for(WebElement e : countrylist)
		{
			String text = e.getText();
			if(text.equals("India"))
			{
				e.click();
			break;
		}
		}

	}

	
	public static void doDropDownWithoutSelect(By locator, String value)
	{
		List<WebElement> countrylist = driver.findElements(By.xpath("//select[@id='Form_submitForm_Country']/option"));
		for(WebElement e : countrylist)
		{
			String text = e.getText();
			if(text.equals("value"))
			{
				e.click();
			break;
		}
		}
	}
}
