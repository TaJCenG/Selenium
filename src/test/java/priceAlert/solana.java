package priceAlert;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class solana {
	
	 public static void main(String[] args) {
	        WebDriverManager.chromedriver().setup();
	        WebDriver driver = new ChromeDriver();
	        driver.manage().window().maximize();

	        driver.get("https://www.delta.exchange/app/futures/trade/SOL/SOLUSD?chart_orderbook_tab=chart");

	        boolean songPlayed = false;

	        while (!songPlayed) {
	            try {
	            	WebDriverWait wait = new WebDriverWait(driver, 10);
	            	WebElement priceElement = wait.until(
	                        ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.style--rcey_"))
	                    );

	                String priceText = priceElement.getText().replace("$", "").replace(",", "").trim();
	                double price = Double.parseDouble(priceText);

	                System.out.println("Current Price: " + price);

	                if (price < 127.0) {
	                    LocalSongPlayer.playSong("C:\\Users\\TajCh\\Downloads\\The-Big-Hash-GIRLS-(TrendyBeatz.com).mp3");
	                    System.out.println("Price dropped below 127! Song played.");
	                    songPlayed = true; // exit loop
	                }

	                Thread.sleep(5000); // wait 5 seconds before checking again
	            } catch (NoSuchElementException | TimeoutException e) {
	                System.out.println("Price element not found. Retrying...");
	            } catch (InterruptedException e) {
	            e.printStackTrace();
	        } finally {
	            driver.quit();
	        }
	    }
	 }
}
