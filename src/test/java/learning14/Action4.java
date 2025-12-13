package learning14;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Action4 {

	public static void main(String[] args) throws InterruptedException {


		 WebDriverManager.chromedriver().setup();
	        WebDriver driver = new ChromeDriver();
	        driver.manage().window().maximize();

	        try {
	        	 driver.get("https://www.google.com");

	             // Step 1: Type query
	             WebElement searchBox = driver.findElement(By.name("q"));
	             searchBox.sendKeys("hadoop tutorial");

	             String val = searchBox.getAttribute("value");

	             // Step 2: Wait for suggestions to appear
	             WebDriverWait wait = new WebDriverWait(driver, 10);
	             List<WebElement> suggestions = wait.until(
	                 ExpectedConditions.visibilityOfAllElementsLocatedBy(
	                     By.xpath("//*[@id=\"jZ2SBf\"]/div[1]")));

	             // Step 3: Loop through suggestions and click match
	             for (WebElement suggestion : suggestions) {
	                 String text = suggestion.getText();
	                 if (text.equalsIgnoreCase(val)) {
	                     suggestion.click();
	                     System.out.println("Clicked suggestion: " + text);
	                     break;
	                 }else
	                	 System.out.println("Nothing Clicked");
	             }

	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	        	Thread.sleep(2000);
	            driver.quit();
	        }
	}

}
