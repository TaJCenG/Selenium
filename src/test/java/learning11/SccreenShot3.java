package learning11;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SccreenShot3 {
	private static final Logger log = LogManager.getLogger(SccreenShot3.class);
	 public static void main(String[] args) {
		 WebDriverManager.chromedriver().setup();
	        WebDriver driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        try {
	            driver.get("https://www.amazon.in");
	            WebDriverWait wait = new WebDriverWait(driver,10);
	            WebElement customerServiceLink = wait.until(
	                ExpectedConditions.visibilityOfElementLocated(By.linkText("Customer Service")));
	            System.out.println("Customer Service: " + customerServiceLink.getText());
	            log.info("Customer Service: " + customerServiceLink.getText());
	            List<WebElement> allLinks = driver.findElements(By.tagName("a"));
	            for (WebElement link : allLinks) {
	                String text = link.getText();
	                String href = link.getAttribute("href");
	                if (!text.isEmpty()) {
	                    System.out.println(text + " --> " + href);
	                    log.info("screenshot: " + text + " --> " + href);
	                }
	            }
	            List<WebElement> navShopLinks = driver.findElements(By.xpath("//div[@id='nav-xshop']/a"));
	            System.out.println("Nav Shop Links Count: " + navShopLinks.size());
	            log.info("Nav Shop Links Count: " + navShopLinks.size());
	        } finally {
	            driver.quit();
	        }
	    }

}
