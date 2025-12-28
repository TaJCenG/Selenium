package verification;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Verification {
	private static final Logger log = LogManager.getLogger(Verification.class);
	public static void main(String[] args) 
	{
		
		 WebDriverManager.chromedriver().setup();
	        WebDriver driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        try {
	            driver.get("https://www.amazon.in");
	            driver.findElement(By.id("twotabsearchtextbox")).sendKeys("sony");
	    		String text = driver.findElement(By.id("twotabsearchtextbox")).getAttribute("value");
	    		System.out.println("Text : " +  text);
	        } catch (Exception e) {
	            System.out.println("Cant find value: " + e.getMessage());
	            log.info("Cant find value:  " + e.getMessage());
	        } finally {
	            driver.quit();
	        }
	}
}
