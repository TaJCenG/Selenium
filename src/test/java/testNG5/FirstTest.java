package testNG5;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import learning10.ExtentManager;

public class FirstTest {

	public static WebDriver driver;
	public static String projectPath = System.getProperty("user.dir")+"//src//test//resources//";
	public static FileInputStream fis;
	public static Properties props;
	public static ExtentReports rep;
	public static ExtentTest test;
	public static String filePath = null;
	
	static
	{
		Date dt = new Date();
		filePath = dt.toString().replace(':', '_').replace(' ', '_');
	}
	
	public static void inIt() throws IOException{
	
		fis = new FileInputStream(projectPath + "data.properties");
		props = new Properties();
		props.load(fis);        
		
		rep = ExtentManager.getInstance();
	}
	
	public static void Launch(String browser) {
		
		try {
		if(browser.equals("chrome")) {
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
		driver.get(props.getProperty(url)); // this line just open the current url
		//driver.navigate().to(props.getProperty(url)); //this line will open other url if present	
	}

	public static void typeText(String locator, String text) {
		driver.findElement(By.xpath(locator)).sendKeys(text);	
	}
	
	public static void clickElement(String submit) {	
		driver.findElement(By.xpath(submit)).click();
	}
	
}
