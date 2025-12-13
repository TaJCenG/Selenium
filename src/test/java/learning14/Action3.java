package learning14;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Action3 {

	public static void main(String[] args) throws InterruptedException {


		 WebDriverManager.chromedriver().setup();
	        WebDriver driver = new ChromeDriver();
	        driver.manage().window().maximize();

	        try {
	            driver.get("https://jqueryui.com/slider/");
	            WebDriverWait wait = new WebDriverWait(driver, 10);
	            
	            // Step 1: Switch to iframe
	            WebElement frame = wait.until(ExpectedConditions.presenceOfElementLocated(By.className("demo-frame")));
	            driver.switchTo().frame(frame);

	            // Step 2: Locate slider handle
	            WebElement sliderHandle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='slider']/span")));

	            // Step 3: Perform slide action
	            Actions actions = new Actions(driver);
	            actions.dragAndDropBy(sliderHandle, 100, 40).perform();

	            System.out.println("Slider moved successfully!");

	            // Step 4: Switch back to main page
	            driver.switchTo().defaultContent();

	            // Step 5: Right-click on "Selectable" link
	            WebElement selectableLink = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Selectable")));
	            actions.contextClick(selectableLink).perform();

	            System.out.println("Context click performed on 'Selectable' link!");

	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	        	Thread.sleep(2000);
	            driver.quit();
	        }
	}

}
