package Seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class navigateConcepts {

	public static void main(String[] args) {


		System.setProperty("webdriver.chrome.driver", "C:\\Naveen\\Selenium\\chromedriver_win32_latest\\chromedriver.exe");
		WebDriver dr = new ChromeDriver();
		dr.get("https://www.google.com");
		dr.navigate().back();
		dr.navigate().forward();
		dr.navigate().refresh();
		
	}

}
