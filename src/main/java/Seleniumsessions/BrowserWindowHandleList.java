package Seleniumsessions;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserWindowHandleList {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		
		//Clicking on the links from the parent Window
		
		driver.findElement(By.xpath("//img[@alt = 'OrangeHRM on Facebook']")).click();
		driver.findElement(By.xpath("//img[@alt = 'LinkedIn OrangeHRM group']")).click();
		driver.findElement(By.xpath("//img[@alt = 'OrangeHRM on twitter']")).click();
		driver.findElement(By.xpath("//img[@alt = 'OrangeHRM on youtube']")).click();
		
		Set<String> handles=driver.getWindowHandles();
	    List<String> handleslist = new ArrayList<String>(handles);
	    
	    	String parentWindowID = handleslist.get(0);
			 String chaildWindowId1=  handleslist.get(1);
			 String childWindowId2=   handleslist.get(2);
			 String childWindowId3= handleslist.get(3);
			 String childWindowId4=handleslist.get(4);
			 
			 driver.switchTo().window(childWindowId4);
			 System.out.println(driver.getTitle());
			 driver.close();
			 
			 driver.switchTo().window(parentWindowID);
			 System.out.println(driver.getTitle());
			 driver.quit();
			 
			 
	     
	  

	}

}
