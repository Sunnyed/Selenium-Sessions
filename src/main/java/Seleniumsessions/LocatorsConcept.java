package Seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class LocatorsConcept {

	static WebDriver drr;
	public static void main(String[] args) {
		
		//WebDriverManager.chromedriver().setup();
		//WebDriver driver = new ChromeDriver();
		
		System.setProperty("webdriver.chrome.driver", "C:\\Naveen\\Selenium\\chromedriver_win32_latest\\chromedriver.exe");
		 drr = new ChromeDriver();
		drr.get("https://demo.opencart.com/index.php?route=account/login");
		
		//1. id
		//drr.findElement(By.id("input-email")).sendKeys("naveened@gmail.com");;
		//drr.findElement(By.id("input-password")).sendKeys("123456");
		
		//2.
		
//		WebElement email = drr.findElement(By.id("input-email"));
//		WebElement password = drr.findElement(By.id("input-password"));
//		
//		email.sendKeys("naveened@gmail.com");
//		password.sendKeys("test@abc");
		
		//3. By locator
		
//		By email = By.id("input-email");
//		By password = By.id("input-password");
//		
//		WebElement emailid = drr.findElement(email);
//		WebElement pass=drr.findElement(password);
//	
//		emailid.sendKeys("naveened@gmail.com");
//		pass.sendKeys("abc@test");
		
		//4. By locator Generic function
		
//		By email = By.id("input-email");
//		By password = By.id("input-password");
//		getElement(email).sendKeys("abc@gmail.com");
//		getElement(password).sendKeys("abc123");
		
		
		//5. By locator Generic function
		
//		By email = By.id("input-email");
//		By password = By.id("input-password");
//		
//		doSendKeys(email, "abc@gmail.com");
//		doSendKeys(password, "abc123");
		
		//6. By locator Generic function in utility class
		
//		By email = By.id("input-email");
//		By password = By.id("input-password");
//		
//		ElemtUtil util = new ElemtUtil(drr);
//		util.doSendKeys(email, "abc@gmail.com");
//		util.doSendKeys(password, "abc123");
		
		//7 Use BrowserUtil and ElemtUtil
		
		//8. String locators--> By locator
		
		String email_id = "input-email";
		String pwd = "input-password";
		ElemtUtil utils = new ElemtUtil(drr);
		By eid = utils.getBy("ID", email_id);
		By pwdid = utils.getBy("ID", pwd);
		
		
		utils.doSendKeys(eid, "abhytgcg@gmail.com");
		utils.doSendKeys(pwdid, "dhvlhd");
		
		
		}
	
	
	
	
	
	public static WebElement getElement(By locator)
	{
		return drr.findElement(locator);
		
	}
	public static void doSendKeys(By locator , String value)
	{
		getElement(locator).sendKeys(value);
	}
}
