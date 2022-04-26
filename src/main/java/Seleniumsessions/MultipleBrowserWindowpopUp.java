package Seleniumsessions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultipleBrowserWindowpopUp {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
	
		//Clicking on the links from the parent Window
		
		driver.findElement(By.xpath("//img[@alt = 'OrangeHRM on Facebook']")).click();
		driver.findElement(By.xpath("//img[@alt = 'LinkedIn OrangeHRM group']")).click();
		driver.findElement(By.xpath("//img[@alt = 'OrangeHRM on twitter']")).click();
		driver.findElement(By.xpath("//img[@alt = 'OrangeHRM on youtube']")).click();
		
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> it = handles.iterator();
		String parentWindowID = it.next();
		System.out.println("parentWindowID : " + parentWindowID);
		
		String childwindowID1 = it.next();
		System.out.println("childWindowID1 :" +childwindowID1);
		
		String childWindowId2 = it.next();
		System.out.println("childWindowId2 :" +childWindowId2);
		
		String childWindowId3 = it.next();
		System.out.println("childWindowId3 :" +childWindowId3);
		
		String childWindowId4 = it.next();
		System.out.println("childWindowId3 :" +childWindowId4);
		
		driver.switchTo().window(childwindowID1);
		String ChildWindowtitle1 = driver.getTitle();
		System.out.println("ChildWindowtitle1 :" + ChildWindowtitle1);
		driver.close();
		
		driver.switchTo().window(childWindowId2);
		String ChildWindowtitle2 = driver.getTitle();
		System.out.println("ChildWindowtitle2 :" + ChildWindowtitle2);
		driver.close();
		
		driver.switchTo().window(childWindowId3);
		String ChildWindowtitle3 = driver.getTitle();
		System.out.println("ChildWindowtitle3 :" + ChildWindowtitle3);
		driver.close();
		
		driver.switchTo().window(childWindowId4);
		String ChildWindowtitle4 = driver.getTitle();
		System.out.println("ChildWindowtitle4 :" + ChildWindowtitle4);
		
		driver.close();
		
		driver.switchTo().window(parentWindowID);
		String parentWindowTitle = driver.getTitle();
		System.out.println("parentWindowTitle :" + parentWindowTitle );
		
		driver.quit();
	}

}
