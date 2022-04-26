package Seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTableCheckbox {

	static WebDriver driver;
	
	
	public static void main(String[] args) {
		
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://datatables.net/extensions/select/examples/initialisation/checkbox.html");
		
		//driver.findElement(By.xpath("//td[contains(text(), 'Bradley Greer')]/../following-sibling::tr/td[contains(@class , ' select-checkbox')]")).click();
		
		getwebTableCheckbox("Caesar Vance");

	}
	
	public static void getwebTableCheckbox(String name)
	{
		driver.findElement(By.xpath("//td[contains(text(), '"+name+"')]/../td[contains(@class , ' select-checkbox')]")).click();
	}

}
