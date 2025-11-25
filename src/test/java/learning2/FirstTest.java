package learning2;

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
		System.out.println("App In 22 for init method" );
		
		fis = new FileInputStream(projectPath + "data.properties");

		props = new Properties();
		props.load(fis);
		
		String val = props.getProperty("chromeBrowser");
		System.out.println(fis );
		System.out.println("line no 30 : "+val );
		String url = props.getProperty("amazon_url");
		System.out.println(url );
		
	}
	
	public static void Launch(String browser) {
		System.out.println("App came in launch" );
		
		if(props.getProperty(browser).equals("chrome")) {
			String url = props.getProperty("amazon_url");
			System.out.println(url );
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}else {
			System.out.println("No Browser Selected");
		}
			
	}
	public static void navigateUrl(String url) {
		System.out.println("App came in navigate" );
		driver.get(props.getProperty(url));
		
	}
	

}
