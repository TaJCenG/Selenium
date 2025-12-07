package priceAlert;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

//public class WhatsAppCall {
	public class WhatsAppMessage{
   // public void makeCall(String contactName) {
	 public void sendMessage(String contactName, String message) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

       /* try {
            // Step 1: Open WhatsApp Web
            driver.get("https://web.whatsapp.com/");
            System.out.println("Scan the QR code to log in...");

            // Step 2: Wait for QR scan and chats to load
            WebDriverWait wait = new WebDriverWait(driver,60);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[role='textbox']")));

            // Step 3: Search for your contact
            WebElement searchBox = driver.findElement(By.cssSelector("div[role='textbox']"));
            searchBox.sendKeys(contactName);
            Thread.sleep(2000);

            // Step 4: Click on the chat
            WebElement chat = driver.findElement(By.xpath("//span[@title='" + contactName + "']"));
            chat.click();

             Step 5: Click the call button (voice call)
            WebElement callButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("span[data-icon='audio-call']")
            ));
            callButton.click();
            
            System.out.println("WhatsApp call initiated to " + contactName + "!");

        }*/
        
        try {
            // Step 1: Open WhatsApp Web
            driver.get("https://web.whatsapp.com/");
            System.out.println("Scan the QR code to log in...");

            // Step 2: Wait for QR scan and chats to load
            WebDriverWait wait = new WebDriverWait(driver, 60);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[role='textbox']")));

            // Step 3: Search for your contact
            WebElement searchBox = driver.findElement(By.cssSelector("div[role='textbox']"));
            searchBox.sendKeys(contactName);
            Thread.sleep(2000);

            // Step 4: Click on the chat
            WebElement chat = driver.findElement(By.xpath("//span[@title='" + contactName + "']"));
            chat.click();

            // Step 5: Type and send the message
         // More reliable locator for the message input box
            WebElement messageBox = driver.findElement(By.xpath("//div[@contenteditable='true' and @data-tab='10']"));
            messageBox.sendKeys(message);
            messageBox.sendKeys(Keys.ENTER);

            System.out.println("Message sent to " + contactName + ": " + message);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
