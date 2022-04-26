package Seleniumsessions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserWindowPopUp {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		//parent Window
		driver.get("https://opensource-demo.orangehrmlive.com/");
		//Child Window
		driver.findElement(By.xpath("//img[@alt = 'OrangeHRM on Facebook']")).click();
		
		Set<String> winIDs = driver.getWindowHandles();
		Iterator<String> it = winIDs.iterator();
		String parentWindowID = it.next();
		System.out.println("ParentWindowId :" + parentWindowID);
		
		String childWindowID = it.next();
		System.out.println("childWindowID :" + childWindowID);
		
		
		driver.switchTo().window(childWindowID);
		String ChildWindowtitle = driver.getTitle();
		System.out.println(ChildWindowtitle);
		
		//close the child window
		driver.close();
		
		//Go back to parent window
		
		driver.switchTo().window(parentWindowID);
		String parentWindowtitle = driver.getTitle();
		System.out.println(parentWindowtitle);
	}

}
