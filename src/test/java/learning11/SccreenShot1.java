package learning11;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SccreenShot1 {
	private static final Logger log = LogManager.getLogger(SccreenShot1.class);
	public static void main(String[] args) throws Exception 
	{
		/* This code is correct but not the correcct way to right
		 * 
		 * WebDriverManager.chromedriver().setup(); WebDriver driver = new
		 * ChromeDriver(); driver.manage().window().maximize();
		 * driver.get("https://www.amazon.in");
		 * 
		 * File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 * FileHandler.copy(srcFile, new
		 * File("E:\\Courses\\SELENIUM_Java_\\amazon.png"));
		 * 
		 * Thread.sleep(5000); driver.quit();
		 */		
		 WebDriverManager.chromedriver().setup();
	        WebDriver driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        try {
	            driver.get("https://www.amazon.in");
	            // Timestamp for unique file names
	            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
	            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	            FileHandler.copy(srcFile, new File("E:\\Courses\\SELENIUM_Java_\\amazon_" + timestamp + ".png"));
	            log.info("Screenshot captured successfully!");
	            System.out.println("Screenshot captured successfully!");
	        } catch (IOException e) {
	            System.out.println("Failed to save screenshot: " + e.getMessage());
	            log.info("Failed to save screenshot: " + e.getMessage());
	        } finally {
	            driver.quit();
	        }
	}
}
