package Seleniumsessions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JsAlertPopup {

	public static void main(String[] args) throws InterruptedException {
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
//		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
//		driver.findElement(By.name("proceed")).click();
//		
//		Alert alert = driver.switchTo().alert();// it will work only with Java script popups
//		Thread.sleep(2000);
//		String test = alert.getText();
//		System.out.println(test);	
//		alert.accept();
		
		//alert.accept(); // it clicks on Ok button
		//alert.dismiss(); // it will escape the alert or cancel button
		
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.findElement(By.xpath("//li/button[contains(text() , 'Click for JS Alert')]")).click();
		
		Alert alert = driver.switchTo().alert();
		String text = alert.getText();
		System.out.println(text);
		alert.accept();
		
		WebElement ele = driver.findElement(By.id("result"));
		System.out.println(ele.getText());
		
		driver.findElement(By.xpath("//li/button[contains(text(), 'Click for JS Confirm')]")).click();
		
		Alert alert1 = driver.switchTo().alert();
		String textJSConfirm = alert1.getText();
		System.out.println(textJSConfirm);
		alert.accept();
		
		WebElement ele1 = driver.findElement(By.id("result"));
		System.out.println(ele1.getText());
		
		
		Thread.sleep(5000);
		driver.findElement(By.xpath("//li/button[contains(text(), 'Click for JS Prompt')]")).click();;
		
		Alert alert2 = driver.switchTo().alert();
		String textPromt = alert2.getText();
		System.out.println(textPromt);
		alert2.sendKeys("hi Java script");
		alert2.accept();

	}

}
