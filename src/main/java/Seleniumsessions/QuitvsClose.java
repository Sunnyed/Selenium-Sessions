package Seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class QuitvsClose {

	public static void main(String[] args) {


		System.setProperty("webdriver.chrome.driver", "C:\\Naveen\\Selenium\\chromedriver_win32_latest\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		String s = driver.getTitle();
		System.out.println(s);
		driver.quit();

	}

}
