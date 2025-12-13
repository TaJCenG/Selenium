package learning13;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Frames {

	public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        try {
            driver.get("https://www.tutorialspoint.com/selenium/practice/frames.php");

            // Step 1: Switch to iframe1 (by id or name)
            driver.switchTo().frame(1);
            WebDriverWait wait = new WebDriverWait(driver, 10);
            WebElement seleniumLink = wait.until(
                ExpectedConditions.elementToBeClickable(By.linkText("Selenium Tutorial"))
            );
            // scroll and click
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", seleniumLink);
            seleniumLink.click();
            driver.switchTo().defaultContent();
            System.out.println("Clicked Selenium Tutorial link inside iframe1!");
          
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
