package learning14;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Action2 {

	public static void main(String[] args) {


		 WebDriverManager.chromedriver().setup();
	        WebDriver driver = new ChromeDriver();
	        driver.manage().window().maximize();

	        try {
	            driver.get("https://jqueryui.com/droppable/");

	            WebDriverWait wait = new WebDriverWait(driver, 10);

	            // Step 1: Switch to iframe
	            WebElement frame = wait.until(ExpectedConditions.presenceOfElementLocated(By.className("demo-frame")));
	            driver.switchTo().frame(frame);

	            // Step 2: Locate draggable and droppable elements
	            WebElement drag = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("draggable")));
	            WebElement drop = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("droppable")));

	            // Step 3: Perform drag and drop
	            Actions actions = new Actions(driver);
	            actions.dragAndDrop(drag, drop).perform();

	            System.out.println("Drag and drop performed successfully!");

	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            driver.quit();
	        }
	}

}
