package learning;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirstTest {

	public static WebDriver driver;
	
	public static void inIt() throws IOException{
		
//		FileInputStream fi = new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//");
//		Properties p = new Properties();
//		p.load(fi);
		
		//String val = p.getProperty("chromeBrowser");
		System.out.println(System.getProperty("user.dir") );
		
	}
	
	public static void Launch(String browser) {
		
		if(browser.equals("chromeBrowser")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}else {
			System.out.println("No Browser Selected");
		}
			
	}
	public static void navigateUrl(String url) {
		driver.get(url);
		
	}
	

}
