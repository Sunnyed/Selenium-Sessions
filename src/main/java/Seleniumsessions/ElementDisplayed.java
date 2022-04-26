package Seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ElementDisplayed {

	static WebDriver driver;
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://demo.opencart.com/index.php?route=account/login");
		
		ElemtUtil ele = new ElemtUtil(driver);
		
		By emailId = By.id("input-email");
		if(ele.doIsDisplayed(emailId))
		{
			ele.doSendKeys(emailId, "abac@gmail.com");
		}
		
	}

}
