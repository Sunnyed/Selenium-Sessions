package Seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropConcept {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Naveen\\Selenium\\chromedriver_win32_latest\\chromedriver.exe");
		 WebDriver driver = new ChromeDriver();
		 driver.get("https://jqueryui.com/resources/demos/droppable/default.html");
		
		WebElement sourceele= driver.findElement(By.id("draggable"));
		 WebElement targetele =driver.findElement(By.id("dropable"));
		 
		 Actions act = new Actions(driver);
		 
		// act.clickAndHold()

	}

}
