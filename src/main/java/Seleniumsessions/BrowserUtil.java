package Seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserUtil {
	
	public WebDriver driver ;
	
	/**
	 * This Method is used to initialize the driver on the basis of choosen browser 
	 * @param browserName
	 * @return WebDriver
	 */
	
	
	public WebDriver launchBrowser(String browserName)
	{
		
		System.out.println("Browser name is" +browserName);
		
		if(browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Naveen\\Selenium\\chromedriver_win32_latest\\chromedriver.exe");
			driver = new ChromeDriver();		
		}
		else
		{
			System.out.println("Please enter the correct browser" + browserName);
		}
		
		return driver;
		
	}
	
	public void launchUrl(String url)
	{
		
		if (url == null)
		{
			System.out.println("Enter the correct url");
			return;
		}
		if(url.contains("https") || url.contains("http"))
		{
			driver.get(url);
		}
		else
		{
			System.out.println("please enter the correct url");
			return;
		}
	}
	
	public String getPageTitle()
	{
		return driver.getTitle();
	}
	
	public String getPageUrl()
	{
		return driver.getCurrentUrl();
	}

	public void closeBrowser()
	{
		driver.close();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
