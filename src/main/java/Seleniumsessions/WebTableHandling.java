package Seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTableHandling {

	static WebDriver driver;
	
	public static void main(String[] args) {


		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.cricbuzz.com/live-cricket-scorecard/46036/lsg-vs-rcb-31st-match-indian-premier-league-2022");
		
		//String wkTaker = driver.findElement(By.xpath("//a[contains(text(), 'Kohli')]/../following-sibling::div/span")).getText();
		//System.out.println(wkTaker);
		
		String wk = getWkTaker("Kohli");
		System.out.println(wk);
		
		getScoreCardList("Kohli");

	}
	
	public static String getWkTaker(String name)
	{
		return driver.findElement(By.xpath("//a[contains(text(), '"+name+"')]/../following-sibling::div/span")).getText();
	}

	public static void getScoreCardList(String name)
	{
		List<WebElement> scoreList = driver.findElements(By.xpath("//a[contains(text(), '"+name+"')]/../following-sibling::div"));
		for(int i =1 ; i<scoreList.size(); i++)
		{
			String score = scoreList.get(i).getText();
			System.out.println(score);
		}
		
		
		
		
	}
}
