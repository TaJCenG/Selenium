package priceAlert;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PriceAlert {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        try {
            driver.get("https://www.delta.exchange/app/futures/trade/SOL/SOLUSD?chart_orderbook_tab=chart");

            while (true) {
                WebDriverWait wait = new WebDriverWait(driver, 10); // Selenium 3 style
                WebElement priceElement = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.style--rcey_"))
                );

                String priceText = priceElement.getText().replace("$", "").replace(",", "").trim();
                double price = Double.parseDouble(priceText);

                System.out.println("Current Price: " + price);

                if (price >= 132.0 && price <= 133.2 && price <= 134.0) {
                    // Play song from internet
                    //new PriceAlert().playSong("https://www.soundhelix.com/examples/mp3/SoundHelix-Song-1.mp3");
                	
                	//Play song from local downloads
                   // LocalSongPlayer.playSong("C:\\Users\\TajCh\\Downloads\\The-Big-Hash-GIRLS-(TrendyBeatz.com).mp3");
                	
                	// Call WhatsAppCall class
                    //WhatsAppCall call = new WhatsAppCall();
                   // call.makeCall("Taj"); // replace with your contact name in WhatsApp
                    
                    WhatsAppMessage messenger = new WhatsAppMessage();
                    messenger.sendMessage("Taj", "Price Alert: SOLUSD has reached between 132 and 133!");

                   // break;

                    System.out.println("Price is between 132 and 133! Song played.");
                    break; // exit loop after alert
                }

                Thread.sleep(5000); // wait 5 seconds before checking again
            }
        } catch (NoSuchElementException | TimeoutException e) {
            System.out.println("Price element not found. Retrying...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
