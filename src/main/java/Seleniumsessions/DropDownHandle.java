package Seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownHandle {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {


		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial");
		
//		WebElement ele = driver.findElement(By.id("Form_submitForm_Country"));
//		Select sel = new Select(ele);
////		sel.selectByIndex(9);
//		sel.selectByValue("India");
////		sel.selectByVisibleText("Austria ");
//		
//		Thread.sleep(5000);
//		WebElement ele1 = driver.findElement(By.id("Form_submitForm_State"));
//		
//		Select sel1 = new Select(ele1);
//		sel1.selectByValue("Assam");
		
		// Now instaed of creating the multiple select object, we can create a util function
		
		By country = By.id("Form_submitForm_Country");
		By state = By.id("Form_submitForm_State");
		doSelectByVisibleText(country, "India");
		Thread.sleep(3000);
		doSelectByVisibleText(state, "Goa");
		
	}

	public static WebElement getElement(By locator)
	{
		return driver.findElement(locator);
	}
	
	public static void doSelectByVisibleText(By locator, String text)
	{
		Select select = new Select(getElement(locator));
		select.selectByVisibleText(text);
	}
	
	
	public static void doSelectByValue(By locator, String value)
	{
		Select select = new Select(getElement(locator));
		select.selectByValue(value);
	}
	
	public static void doSelectByIndex(By locator, int index)
	{
		Select select = new Select(getElement(locator));
		select.selectByIndex(index);
	}
}
