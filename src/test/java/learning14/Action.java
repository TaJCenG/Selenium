package learning14;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Action {
	
	public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        try {
            driver.get("https://www.snapdeal.com/");
            WebDriverWait wait = new WebDriverWait(driver, 10);
            // Step 1: Click on Login/Sign In button (top right corner)
            WebElement loginLink = wait.until(
                    ExpectedConditions.elementToBeClickable(By.linkText("Login"))
                );
                loginLink.click();

            // Step 2: Hover over "Your Account" option
            WebElement yourAccount = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.linkText("Your Account"))
            );
            Actions actions = new Actions(driver);
            actions.moveToElement(yourAccount).perform();

            // Step 3: Click "Your Account"
            yourAccount.click();

            System.out.println("Successfully clicked on 'Your Account'!");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        	Thread.sleep(9000);
        	driver.quit();
        }
    }

}
