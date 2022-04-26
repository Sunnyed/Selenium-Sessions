package Seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoCartRegistration {

	static WebDriver driver ;
	public static void main(String[] args) {

		//This code is to automate the Registration page by entering all the values and clicking on continue
		//and verify the Registered successful message
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("https://demo.opencart.com/index.php?route=account/login");
		driver.findElement(By.xpath("//*[@id=\"column-right\"]/div/a[2]")).click();
		
//		driver.findElement(By.name("firstname")).sendKeys("ABCD");
//		driver.findElement(By.name("lastname")).sendKeys("yrte");
//		driver.findElement(By.name("email")).sendKeys("abc123456@gmail.com");
//		driver.findElement(By.name("telephone")).sendKeys("0123456478");
//		driver.findElement(By.name("password")).sendKeys("test@123");
//		driver.findElement(By.name("confirm")).sendKeys("test@123");
//		
//		driver.findElement(By.name("agree")).click();
		//driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]")).click();
		
		String firstName = "firstname";
		String lastName = "lastname";
		String email = "email";
		String telephone = "telephone";
		String password = "password";
		String passwordConfirm = "confirm";
		String checkBoxAgree = "agree";
		String continues = "//input[@type = 'submit']";
		String header = "h1";
		
		ElemtUtil ele = new ElemtUtil(driver);
		By first_Name = ele.getBy("name", firstName);
		By last_Name = ele.getBy("name", lastName);
		By register_email = ele.getBy("name", email);
		By register_telephone = ele.getBy("name", telephone);
		By register_password = ele.getBy("name", password);
		By register_confirm = ele.getBy("name", passwordConfirm);
		By agree = ele.getBy("name", checkBoxAgree);
		By continuue = ele.getBy("xpath", continues);
		By text = ele.getBy("tagName", header);
				
				
		ele.doSendKeys(first_Name, "abc");
		ele.doSendKeys(last_Name, "def");
		ele.doSendKeys(register_email, "xyz12345xyz@gmail.com");
		ele.doSendKeys(register_telephone, "123456");
		ele.doSendKeys(register_password, "test@123");
		ele.doSendKeys(register_confirm, "test@123");
		ele.doClick(agree);
		ele.doClick(continuue);
		
		ele.doElementGetText(text);		
		
		
		
	}

}
