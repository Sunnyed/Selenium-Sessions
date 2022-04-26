package Seleniumsessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExplicitWaitConcept {

	static WebDriver driver;
	
	public static void main(String[] args) {
		
		
		//Implicit wait--- Its a global wait, which applies for all the webelement
		//Explicit wait--- Its a wait, which applies only to specific webelement and also non webElement(alerts,title etc)
		//  1. WebDriverwait
		//  2. FluentWait
		
		//WebDriverWait extends Fluentwait----Implements Wait Interface--- until()

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("https://www.amazon.in/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.in%2F%3Fref_%3Dnav_signin&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&");
		
	By email = By.id("ap_email");
	By password = By.name("password");
	By loginbtn = By.id("continue");
	
	//waitForElementPresent(loginbtn, 30).click();
	waitForElementTobeVisible(email, 10).sendKeys("abc@gmail.com");
		
	}

	public static WebElement getElement(By locator)
	{
		return driver.findElement(locator);
	}
	
	public static WebElement  waitForElementPresent(By locator , int timeout)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	public static WebElement waitForElementTobeVisible(By locator , int timeout)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	
	
}
