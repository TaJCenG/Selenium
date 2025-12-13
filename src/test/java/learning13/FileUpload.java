package learning13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FileUpload {
	
	public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        try {
            // Step 1: Open pCloud Transfer
            driver.get("https://transfer.pcloud.com/");

            // Step 2: Wait for "Click here to add files" link and click
            WebDriverWait wait = new WebDriverWait(driver, 10);
            WebElement addFilesLink = wait.until(
                ExpectedConditions.elementToBeClickable(By.linkText("Click here to add files"))
            );
            addFilesLink.click();

            // Step 3: Run AutoIT script to handle native file upload dialog
           // Runtime.getRuntime().exec("C:\\Users\\ravi\\Desktop\\fp.exe");
            
            WebElement fileInput = driver.findElement(By.cssSelector("input[type='file']"));
            fileInput.sendKeys("C:\\Users\\TajCh\\OneDrive\\Desktop\\Bedroom.jpg");


            System.out.println("File upload initiated via Alternative (Without AutoIT).");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        	Thread.sleep(2000);
            driver.quit();
        }
    }

}
