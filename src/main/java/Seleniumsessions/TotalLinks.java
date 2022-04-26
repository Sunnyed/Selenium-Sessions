package Seleniumsessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TotalLinks {

	static WebDriver driver;
	public static void main(String[] args) {
		
		//Total links on the page
		//print the text of each link
		//exclude the blank text
		//capture the text in list and return
		
		
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		driver.get("https://www.amazon.in");
		
		List<WebElement> linkslist = driver.findElements(By.tagName("a"));
		System.out.println("Total links are" + linkslist.size());
		
//		for(WebElement e : linkslist)
//		{
//			String text = e.getText();
//			if(!text.isEmpty())
//			{
//			System.out.println(text);
//			}
//		}
//		
//		for (int i = 0; i <linkslist.size(); i++)
//		{
//			String text = linkslist.get(i).getText();
//			if(!text.isEmpty())
//			{
//				System.out.println(text);
//			}
//		}
		
		By tag = By.tagName("a");
		System.out.println(getElements(tag).size());

		List<String> link = getLinkTextLinks(tag);
		System.out.println(link.size());
	}
	
	public static List<WebElement> getElements(By locator)
	{
		return driver.findElements(locator);
	}
	
	public static List<String> getLinkTextLinks(By locator) 
	{
		List<WebElement> eleList = getElements(locator);
		List<String> eleText = new ArrayList<String>();
		for(WebElement e : eleList)
		{
			String text = e.getText();
			if(!text.isEmpty())
			{
				eleText.add(text);
			}
		}
		return eleText;
	}

}
