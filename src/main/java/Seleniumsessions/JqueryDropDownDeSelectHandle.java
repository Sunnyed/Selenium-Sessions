package Seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JqueryDropDownDeSelectHandle {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {


		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");
		driver.findElement(By.id("justAnInputBox")).click();
		Thread.sleep(2000);
		By choice = By.xpath("//span[@class ='comboTreeItemTitle'] ");
		
		//TC: single selection
		//selectChoice(choice, "choice 3");
		
		//Multiselect
		//selectChoice(choice,  "choice 1", "choice 2");
		
		//SelectALl
		
		selectChoice(choice, "All");
		Thread.sleep(3000);
		deSelectChoice(choice, "remove");
		
	}
	
	public  static void selectChoice(By locator, String... value)
	{
		List<WebElement> choicelist = driver.findElements(locator);
		if(!value[0].equalsIgnoreCase("all"))
		{
		for(WebElement e : choicelist)
			{
				String text = e.getText();

				for(int i =0; i<value.length; i++)
				{
				if(text.equals(value[i]))
				{
					e.click();
					break;
				}
				}
			}
		}
		else
		{
			//this is for selecting all the choices
			try {
			for(WebElement e : choicelist )
			{
				e.click();
			}
			} catch(ElementNotInteractableException e)
			{
				System.out.println("All the choices are clicked");
			}
		}
	}
	
	public static void deSelectChoice(By locator, String... value)
	{
		List<WebElement> choicelist = driver.findElements(locator);	
		if(!value[0].equalsIgnoreCase("remove"))
		for(WebElement e : choicelist)
			{
				String text = e.getText();

				for(int i =0; i<value.length; i++)
				{
				if(text.equals(value[i]))
				{
					e.click();
					break;
				}
				}
			}
		else
		{
			//this is for selecting all the choices
			try {
			for(WebElement e : choicelist )
			{
				e.click();
			}
			} catch(ElementNotInteractableException e)
			{
				System.out.println("All the choices are deSelected");
			}
		}
		
	}

}
