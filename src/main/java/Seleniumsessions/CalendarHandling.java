package Seleniumsessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalendarHandling {

static WebDriver driver;
	
	public static void main(String[] args)  {


		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");
		
	driver.findElement(By.xpath("//input[@id = 'datepicker']")).click();

	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		//selectDay("25");
		selectFutureDate("March 2025", "30");
		
	}
	
	
	public static void selectFutureDate(String expMonthYear , String dateNum)
	{
		
		if(Integer.parseInt(dateNum) > 31)
		{
			System.out.println("Please enter the correct date ....");
		}
		
		if(expMonthYear.contains("February") && Integer.parseInt(dateNum) >29)
		{
			System.out.println("Please enter a valid date and month");
		}
		
		String actMonthYear = driver.findElement(By.cssSelector("div.ui-datepicker-title")).getText();
		System.out.println(actMonthYear);
		
		while(!expMonthYear.equalsIgnoreCase(actMonthYear))
		{
			//click next
			
			driver.findElement(By.xpath("//span[text() = 'Next']")).click();
			actMonthYear = driver.findElement(By.cssSelector("div.ui-datepicker-title")).getText();
		}
		selectDay(dateNum);
		
	}
	
	public static void selectDay(String dateNum)
	{
		driver.findElement(By.xpath("//a[text()= '"+dateNum+"']")).click();
	}

}
