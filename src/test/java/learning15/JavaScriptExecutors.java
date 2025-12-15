package learning15;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScriptExecutors {

	public static void main(String[] args) {


		 WebDriverManager.chromedriver().setup();
	        WebDriver driver = new ChromeDriver();
	        driver.manage().window().maximize();

	        try {

	            driver.get("https://www.facebook.com/");
	            WebDriverWait wait = new WebDriverWait(driver, 10);

	            WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
	            JavascriptExecutor js = (JavascriptExecutor) driver;
	            js.executeScript("arguments[0].value='FaceBook';", emailField);

	            String title = js.executeScript("return document.title").toString();
	            System.out.println("Page Title: " + title);

	            driver.navigate().back();
	            driver.navigate().forward();
	            driver.navigate().refresh();

	            js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
//	            WebElement footer = driver.findElement(By.cssSelector("footer"));
//	            js.executeScript("arguments[0].scrollIntoView(true);", footer);

	        } catch (Exception e) {
	        	System.err.println("Error occurred: " + e.getMessage());
	            e.printStackTrace();
	        } finally {
	            driver.quit();
	        }
	}

}
