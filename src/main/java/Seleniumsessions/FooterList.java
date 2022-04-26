package Seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FooterList {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {


		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		
		List<WebElement> footerlists = driver.findElements(By.xpath("//ul//a[@class = 'nav_a']"));
		for(WebElement e : footerlists)
		{
			String text = e.getText();
			System.out.println(text);
		}
		
		

	}

}
