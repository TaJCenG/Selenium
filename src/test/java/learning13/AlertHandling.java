package learning13;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertHandling {
	
	public static void main(String[] args) 
	{
		 WebDriverManager.chromedriver().setup();
	        WebDriver driver = new ChromeDriver();
	        driver.manage().window().maximize();

	        try {
	            driver.get("https://demo.guru99.com/selenium/delete_customer.php");

	            // Enter customer ID
	            driver.findElement(By.name("cusid")).sendKeys("76757");

	            // Submit form
	            driver.findElement(By.name("submit")).click();

	            // Wait for alert to appear
	            WebDriverWait wait = new WebDriverWait(driver, 10);
	            Alert alert = wait.until(ExpectedConditions.alertIsPresent());

	            // Print alert text
	            System.out.println("Alert says: " + alert.getText());

	            // Accept the alert
	            alert.accept();

	            // Optional: handle the second alert (confirmation)
	            Alert confirmAlert = wait.until(ExpectedConditions.alertIsPresent());
	            System.out.println("Confirmation says: " + confirmAlert.getText());
	            confirmAlert.accept();

	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            driver.quit();
	        }
	}

}
