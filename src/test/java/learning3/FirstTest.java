package learning3;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

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
		
		if(props.getProperty(browser).equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}else {
			System.out.println("No Browser Selected");
		}
			
	}
	public static void navigateUrl(String url) {
	
		//driver.get(props.getProperty(url)); // this line just open the current url
		driver.navigate().to(props.getProperty(url)); //this line will open other url if present
		
	}
	

}
