package learning7;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;


/*
 * Xpath
 */
public class FirstTest {

	public static WebDriver driver;
	public static String projectPath = System.getProperty("user.dir")+"//src//test//resources//";
	public static FileInputStream fis;
	public static Properties props;
	
	public static void inIt() throws IOException{
	
		fis = new FileInputStream(projectPath + "data.properties");
		props = new Properties();
		props.load(fis);
	}
	
	public static void Launch(String browser) {
		
		try {
		if(props.getProperty(browser).equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions co = new ChromeOptions();
			co.addArguments("user-data-dir=C:\\Users\\TajCh\\AppData\\Local\\Google\\Chrome\\User Data\\Profile 5");
			co.addArguments("--start-maximized");
			co.addArguments("--ignore-certificate-errors-spki-list");
			driver = new ChromeDriver(co);
		}else {
			System.out.println("No Browser Selected");
		}}catch(Exception e){
			System.out.println(e.getMessage());
		}
			
	}
	public static void navigateUrl(String url) {
		//driver.get(props.getProperty(url)); // this line just open the current url
		driver.navigate().to(props.getProperty(url)); //this line will open other url if present	
	}

	public static void typeText(String locator, String text) {
		//driver.findElement(By.xpath(locator)).sendKeys(text);	
		getElement(locator).sendKeys(text);
	}
	
	public static void clickElement(String submit) {	
		//driver.findElement(By.xpath(submit)).click();
		getElement(submit).click();
	}
	
	public static void clickLogin(String locator) 
	{
		getElement(locator).click();
	}
	
	public static WebElement getElement(String locatorKey) 
	{
		WebElement element = null;
		
		//Check for Element Presence
		if(!isElementPresent(locatorKey))
			// Report as Failure
			System.out.println("Element is not present :" + locatorKey);
			
		element = driver.findElement(getLocator(locatorKey));
		
		/*if(locatorKey.endsWith("_id")) {
			element = driver.findElement(By.id(props.getProperty(locatorKey)));
		}else if(locatorKey.endsWith("_name")) {
			element = driver.findElement(By.name(props.getProperty(locatorKey)));
		}else if(locatorKey.endsWith("_classname")) {
			element = driver.findElement(By.className(props.getProperty(locatorKey)));
		}else if(locatorKey.endsWith("_xpath")) {
			element = driver.findElement(By.xpath(props.getProperty(locatorKey)));
		}else if(locatorKey.endsWith("_css")) {
			element = driver.findElement(By.cssSelector(props.getProperty(locatorKey)));
		}else if(locatorKey.endsWith("_linktext")) {
			element = driver.findElement(By.linkText(props.getProperty(locatorKey)));
		}else if(locatorKey.endsWith("_partiallinktext")) {
			element = driver.findElement(By.partialLinkText(props.getProperty(locatorKey)));
		}*/
		
		return element;
	}

	public static boolean isElementPresent(String locatorKey) 
	{
		System.out.println("Checking for Element present : " +  locatorKey);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		
		
		try 
		{
			wait.until(ExpectedConditions.presenceOfElementLocated(getLocator(locatorKey)));
			
			/*if(locatorKey.endsWith("_id")) {
				wait.until(ExpectedConditions.presenceOfElementLocated(By.id(props.getProperty(locatorKey))));
			}else if(locatorKey.endsWith("_name")) {
				wait.until(ExpectedConditions.presenceOfElementLocated(By.name(props.getProperty(locatorKey))));
			}else if(locatorKey.endsWith("_classname")) {
				wait.until(ExpectedConditions.presenceOfElementLocated(By.className(props.getProperty(locatorKey))));
			}else if(locatorKey.endsWith("_xpath")) {
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(props.getProperty(locatorKey))));
			}else if(locatorKey.endsWith("_css")) {
				wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(props.getProperty(locatorKey))));
			}else if(locatorKey.endsWith("_linktext")) {
				wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText(props.getProperty(locatorKey))));
			}else if(locatorKey.endsWith("_partiallinktext")) {
				wait.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText(props.getProperty(locatorKey))));
			}*/
		} 
		catch (Exception e) 
		{
			return false;
		}
		
		return true;
	}
	
	public static By getLocator(String locatorKey)
	{
		By by = null;
		
		if(locatorKey.endsWith("_id")) {
			by = By.id(props.getProperty(locatorKey));
		}else if(locatorKey.endsWith("_name")) {
			by = By.name(props.getProperty(locatorKey));
		}else if(locatorKey.endsWith("_classname")) {
			by = By.className(props.getProperty(locatorKey));
		}else if(locatorKey.endsWith("_xpath")) {
			by = By.xpath(props.getProperty(locatorKey));
		}else if(locatorKey.endsWith("_css")) {
			by = By.cssSelector(props.getProperty(locatorKey));
		}else if(locatorKey.endsWith("_linktext")) {
			by = By.linkText(props.getProperty(locatorKey));
		}else if(locatorKey.endsWith("_partiallinktext")) {
			by = By.partialLinkText(props.getProperty(locatorKey));
		}
		
		return by;
	}
	
}
