package Seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageTest {

	public static void main(String[] args) {


		BrowserUtil util = new BrowserUtil();
		WebDriver driver = util.launchBrowser("chrome");
		util.launchUrl("https://demo.opencart.com/index.php?route=account/login");
		String pagetitle = util.getPageTitle();
		System.out.println(pagetitle);
		String pageurl = util.getPageUrl();
		System.out.println(pageurl);
		
		By email = By.id("input-email");
		By password = By.id("input-password");
		
		ElemtUtil elutil = new ElemtUtil(driver);
		elutil.doSendKeys(email, "abc@gmail.com");
		elutil.doSendKeys(password, "abc1234");
		
		util.closeBrowser();
		
	}

}
