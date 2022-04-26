package Seleniumsessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectOptionsConcepts {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {


		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial");
		
		By country = By.id("Form_submitForm_Country");
		By state = By.id("Form_submitForm_State");
		
//		WebElement ele = driver.findElement(country);
//		Select select = new Select(ele);
//		List<WebElement> countrylist= select.getOptions();
//		System.out.println(countrylist.size());
//		
//		for (WebElement e : countrylist)
//		{
//			String text = e.getText();
//			System.out.println(text);
//		}
//		ElemtUtil ele = new ElemtUtil(driver);
//		doGetDropDownOptions(country);
//		Thread.sleep(3000);
//		ele.doSelectByVisibleText(country, "India");
//		doGetDropDownOptions(state);
		
		// If you don't want to use the 3 methods of Select(SelectbyIndex, SelectByValue and SelectByVisibleTest)
		
		
//		Select select = new Select(driver.findElement(country));
//		List<WebElement> countrylist = select.getOptions();
//		for (WebElement e : countrylist )
//		{
//			String text = e.getText();
//			if(text.equals("India"))
//			{
//				e.click();
//				break;
//			}
//		}
		
		doSelectDropDownValues(country, "India");
		
		
		
	}

	public static WebElement getElement(By locator)
	{
		return driver.findElement(locator);
	}
	
	public static List<String> doGetDropDownOptions(By locator)
	{
		Select select = new Select(driver.findElement(locator));
		List<WebElement> optionslist = select.getOptions();
		System.out.println(optionslist.size());
		//if you want to add the values to the list then create a empty list and add the values to it
		
		List<String> optionsValList = new ArrayList<String>();
		for (WebElement e : optionslist)
		{
			String text = e.getText();
			System.out.println(text);
			optionsValList.add(text);
		}
		return optionsValList;
	}
	
	public static void doSelectDropDownValues(By locator, String value)
	{
		Select select = new Select(getElement(locator));
		List<WebElement> OptionsList = select.getOptions();
		for(WebElement e : OptionsList) 
		{
			String text = e.getText();
			if(text.equals(value))
			{
				e.click();
				break;
			}
		}
			
	}
}
