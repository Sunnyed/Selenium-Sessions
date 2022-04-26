package Seleniumsessions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElemtUtil {
	
	
	private WebDriver driver;

	public ElemtUtil(WebDriver driver) 
	{
		this.driver = driver;
	}
	
	public  WebElement getElement(By locator)
	{
		return driver.findElement(locator);
		
	}
	public  List<WebElement> getElements(By locator)
	{
		return driver.findElements(locator);
	}
	
	public String doElementGetText(By locator)
	{
		return getElement(locator).getText();
	}
	public  void doSendKeys(By locator , String value)
	{
		getElement(locator).sendKeys(value);
	}
	public  By getBy(String locatorType , String locatorValue)
	{
		By locator = null;
		switch (locatorType.toLowerCase()) {
		case "id":
			locator = By.id(locatorValue);
			break;
		case "name":
			locator = By.name(locatorValue);
			break;	
		case "className":
			locator = By.className(locatorValue);
			break;	
		case "xpath":
			locator = By.xpath(locatorValue);
			break;
		case "tagName":
			locator = By.tagName(locatorValue);
			break;
		default:
			break;
		}
		return locator;
	}
	
	public boolean doIsDisplayed(By locator)
	{
		return getElement(locator).isDisplayed();
	}
	
	public boolean doIsEnabled(By locator)
	{
		return getElement(locator).isEnabled();
	}
	
	public  void doClick(By locator )
	{
		getElement(locator).click();
	}
	
	public  List<String> getLinkTextLinks(By locator) 
	{
		List<WebElement> eleList = getElements(locator);
		List<String> eleText = new ArrayList<String>();
		for(WebElement e : eleList)
		{
			String text = e.getText();
			if(!text.isEmpty())
			{
				eleText.add(text);
			}
		}
		return eleText;
	}

	//******************************************Drop Down Utils ************************************************//
	
	
	public  void doSelectByVisibleText(By locator, String text)
	{
		Select select = new Select(getElement(locator));
		select.selectByVisibleText(text);
	}
	
	
	public  void doSelectByValue(By locator, String value)
	{
		Select select = new Select(getElement(locator));
		select.selectByValue(value);
	}
	
	public  void doSelectByIndex(By locator, int index)
	{
		Select select = new Select(getElement(locator));
		select.selectByIndex(index);
	}
	public  List<String> doGetDropDownOptions(By locator)
	{
		Select select = new Select(driver.findElement(locator));
		List<WebElement> optionslist = select.getOptions();
		System.out.println(optionslist.size());
		//if you want to add the values to the list then create a empty list and add the values to it
		
		List<String> optionsValList = new ArrayList<String>();
		for (WebElement e : optionslist)
		{
			String text = e.getText();
			//System.out.println(text);
			optionsValList.add(text);
		}
		return optionsValList;
	}
	public  void doSelectDropDownValues(By locator, String value)
	{
		Select select = new Select(getElement(locator));
		List<WebElement> OptionsList = select.getOptions();
		for(WebElement e : OptionsList) 
		{
			String text = e.getText();
			if(text.equals("value"))
			{
				e.click();
				break;
			}
		}
			
	}
	
	
	//*********************************Jquery Drop Down ********************************//
	
	public  void selectChoice(By locator, String... value)
	{
		List<WebElement> choicelist = driver.findElements(locator);
		if(!value[0].equalsIgnoreCase("all"))
		{
		for(WebElement e : choicelist)
			{
				String text = e.getText();

				for(int i =0; i<value.length; i++)
				{
				if(text.equals(value[i]))
				{
					e.click();
					break;
				}
				}
			}
		}
		else
		{
			//this is for selecting all the choices
			try {
			for(WebElement e : choicelist )
			{
				e.click();
			}
			} catch(ElementNotInteractableException e)
			{
				System.out.println("All the choices are clicked");
			}
		}
	}
	
	//====================WebTableHandle==========================================
	
	public  String getWkTaker(String name)
	{
		return driver.findElement(By.xpath("//a[contains(text(), '"+name+"')]/../following-sibling::div/span")).getText();
	}
	
	
	
	
	//===================ExplicitWait=================================================
	
	public  WebElement  waitForElementPresent(By locator , int timeout)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	public  WebElement waitForElementTobeVisible(By locator , int timeout)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	//Explicitwait with polling
	
	public  WebElement waitForElementPresent(By locator , int timeout, int pollingTime)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout), Duration.ofMillis(pollingTime));
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	public  void waitForElementToBeVisible(By locator , int timeout , int pollingTime)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout), Duration.ofMillis(pollingTime));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	//ExplicitWait with Alert
	
	public  Alert waitForAlert(int timeout)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.alertIsPresent());
	}


	public  void accpetAlert(int timeout)
	{
	 waitForAlert(timeout).accept();	
	}
	public void dismissAlert(int timeout)
	{
		waitForAlert(timeout).dismiss();
		
	}
	//------------------ExplicitWait for url--------------------------//
	
	public  String waitForUrl(int timeout, String fraction)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		if(wait.until(ExpectedConditions.urlContains("fraction")))
		{
			return driver.getCurrentUrl();
		}
		
		return null;
	}
	public  String waitForUrlToBe(int timeout, String urlValue)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		if(wait.until(ExpectedConditions.urlToBe("urlValue")))
		{
			return driver.getCurrentUrl();
		}
		
		return null;
	}
	public  String waitforUrlMatches(int timeout, String url)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		if(wait.until(ExpectedConditions.urlMatches("url")))
		{
			return driver.getCurrentUrl();
		}
		return null;
	}
	
	//------------------------Explicit wait for Title-------------------------
	
	public  String waitForTitleContains(int timeout, String titleFraction)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		if (wait.until(ExpectedConditions.titleContains(titleFraction)))
		{
			return driver.getTitle()	;
		}
		return null;
	}

	public  String waitForTitleIs(int timeout, String title)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		if (wait.until(ExpectedConditions.titleIs(title)))
		{
			return driver.getTitle()	;
		}
		return null;
	}
	
		
}
