package Seleniumsessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class waitForUrlConcept {

	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://demo.opencart.com/index.php?route=account/login");
		By email = By.id("input-email");
		By password = By.name("input-password");
		By loginbtn = By.xpath("//input[@value = 'Login']");

		waitForElementToBeVisible(email, 10, 2).sendKeys("xyz12345xyz@gmail.com");
		getElement(password).sendKeys("test@123");
		getElement(loginbtn).click();
		waitForUrl(10, "route=account/account");
		
		waitForTitleContains(10, "My");
	}

	public static String waitForTitleContains(int timeout, String titleFraction)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		if (wait.until(ExpectedConditions.titleContains(titleFraction)))
		{
			return driver.getTitle()	;
		}
		return null;
	}

	public static String waitForTitleIs(int timeout, String title)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		if (wait.until(ExpectedConditions.titleIs(title)))
		{
			return driver.getTitle()	;
		}
		return null;
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public static String waitForUrl(int timeout, String fraction) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		if (wait.until(ExpectedConditions.urlContains("fraction"))) {
			return driver.getCurrentUrl();
		}

		return null;
	}

	public static WebElement waitForElementToBeVisible(By locator, int timeout, int pollingTime) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout), Duration.ofMillis(pollingTime));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public static String waitForUrlToBe(int timeout, String urlValue) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		if (wait.until(ExpectedConditions.urlToBe("urlValue"))) {
			return driver.getCurrentUrl();
		}

		return null;
	}

	public static String waitforUrlMatches(int timeout, String url) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		if (wait.until(ExpectedConditions.urlMatches("url"))) {
			return driver.getCurrentUrl();
		}
		return null;
	}

}
