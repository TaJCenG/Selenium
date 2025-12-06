package learning11;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SccreenShot2 {
	 public static void main(String[] args) {
	        WebDriverManager.chromedriver().setup();
	        WebDriver driver = new ChromeDriver();
	        driver.manage().window().maximize();

	        try {
	            driver.get("https://www.google.com");

	            List<WebElement> links = driver.findElements(By.linkText("rajinikanth"));
	            if (links.isEmpty()) {
	                // Timestamp for unique file names
	                String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
	                File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

	                String filePath = "E:\\Courses\\SELENIUM_Java_\\google_" + timestamp + ".jpeg";
	                FileHandler.copy(srcFile, new File(filePath));

	                System.out.println("Screenshot saved at: " + filePath);
	            }
	        } catch (IOException e) {
	            System.out.println("Failed to capture screenshot: " + e.getMessage());
	        } finally {
	            driver.quit();
	        }
	    }

}
