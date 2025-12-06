package learning11;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SccreenShot4 {
	 public static void main(String[] args) throws IOException {
		 WebDriverManager.chromedriver().setup();
	        WebDriver driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        try {
	            driver.get("https://www.google.com");

	            List<WebElement> links = driver.findElements(By.xpath("//div[@id='SIvCob']/a"));
	            Actions actions = new Actions(driver);

	            for (WebElement link : links) {
	                // Timestamp
	                String timestamp = LocalDateTime.now()
	                        .format(DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss"));

	                String linkName = link.getText().replaceAll("\\s+", "_");

	                // Hover over the link (instead of clicking)
	                actions.moveToElement(link).perform();
	                // Take screenshot
	                File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	                Files.copy(srcFile.toPath(),
	                        Paths.get("E:\\Courses\\SELENIUM_Java_\\", linkName + "_" + timestamp + ".png"));
	            }
	        }finally {
	            driver.quit();
	        }
	 }
}
	    
