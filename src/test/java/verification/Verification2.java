package verification;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Verification2 {
	private static final Logger log = LogManager.getLogger(Verification2.class);
	public static void main(String[] args) 
	{
		
		 WebDriverManager.chromedriver().setup();
	        WebDriver driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        try {
	            driver.get("https://www.amazon.in");
	          String actualLink = driver.findElement(By.linkText("Customer Service")).getText();
	    		//String actualLink = driver.findElement(By.linkText("Customer Service")).getAttribute("innerHTML");
	    		String expectLink = "Customer Serv";
	    		
	    		System.out.println("Actual Link : " +  actualLink);
	    		System.out.println("Expected Link : " +  expectLink);
	    		
	    		//if(actualLink.equals(expectLink))
	    		//if(actualLink.equalsIgnoreCase(expectLink))
	    		if(actualLink.contains(expectLink))
	    			System.out.println("Both Links are equal...");
	    		else
	    			System.out.println("Both Links are not equal...");
	        } catch (Exception e) {
	            System.out.println("Links issue: " + e.getMessage());
	            log.info("Links issue:  " + e.getMessage());
	        } finally {
	            driver.quit();
	        }
	}
}
