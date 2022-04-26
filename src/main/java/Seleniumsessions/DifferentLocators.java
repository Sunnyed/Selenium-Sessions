package Seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DifferentLocators {

	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {


		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		driver.get("https://demo.opencart.com/index.php?route=account/login");
		
		//1. ID-- ID will be unique in the webpage
		
		
		//2. name: it can be duplicate
		
		//driver.findElement(By.name("email")).sendKeys("abc@gmail.com");
//		String emailName = "email";
//		String passwordName = "password";
//	
		ElemtUtil eleUtil = new ElemtUtil(driver);
//		By email_name = eleUtil.getBy("name", emailName);
//		eleUtil.doSendKeys(email_name, "abc@gmail.com");
//		
//		By password_name = eleUtil.getBy("name", passwordName);
//		eleUtil.doSendKeys(password_name, "123456");
		
//		By emailName = By.name("email");
//		By passwordName = By.name("password");
//		eleUtil.doSendKeys(emailName, "abc@gmail.com");
//		eleUtil.doSendKeys(passwordName, "password123");
		
		
		//3. className: It can also be a dupicate value
		
//		String emailClassName = "form-control";
//		String passwordClassName = "form-control";
//		
//		eleUtil.doSendKeys(eleUtil.getBy("className", emailClassName), "abc@gmailcom");
		
		//4. tagName--- html tag not the attribute
		
		driver.findElement(By.tagName("Your Account Has Been Created!")).getText();
		
	}
		

}
