package Seleniumsessions;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverWaitWithAlert {

	static WebDriver driver;
public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");	
		driver.findElement(By.name("proceed")).click();
		
		waitForAlert(10);
		accpetAlert(10);
	}

public static Alert waitForAlert(int timeout)
{
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
	return wait.until(ExpectedConditions.alertIsPresent());
}


public static void accpetAlert(int timeout)
{
 waitForAlert(timeout).accept();	
}
public static  void dismissAlert(int timeout)
{
	waitForAlert(timeout).dismiss();
	
}



}
