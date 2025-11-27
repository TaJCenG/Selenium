package learning5;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

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
		driver.findElement(By.xpath(locator)).sendKeys(text);	
	}
	
	public static void clickElement(String submit) {	
		driver.findElement(By.xpath(submit)).click();
	}
	
}
