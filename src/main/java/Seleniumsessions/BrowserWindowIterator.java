package Seleniumsessions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserWindowIterator {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
driver.get("https://opensource-demo.orangehrmlive.com/");
		
		
		//Clicking on the links from the parent Window
		
		driver.findElement(By.xpath("//img[@alt = 'OrangeHRM on Facebook']")).click();
		driver.findElement(By.xpath("//img[@alt = 'LinkedIn OrangeHRM group']")).click();
		driver.findElement(By.xpath("//img[@alt = 'OrangeHRM on twitter']")).click();
		
	Set<String> handles=	driver.getWindowHandles();
	Iterator<String> it = handles.iterator();
	String parentWindowID = driver.getWindowHandle();
	System.out.println(parentWindowID);
		
	while(it.hasNext())
	{
		String childwindowID = it.next();
		driver.switchTo().window(childwindowID);
		System.out.println(driver.getTitle());
		if(it.next().equals(parentWindowID))
		{
			driver.switchTo().window(parentWindowID);
			System.out.println(driver.getTitle());
		}
		else {
			driver.close();
		}
		
	}
		

	}

}
