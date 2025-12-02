package ticketBooking;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RedBusBooking extends FirstTest {

    public static String BROWSER_URL = "chromeBrowser";
    public static String REDBUS_URL = "redbus_url";

    public static void main(String[] args) throws IOException {
        
        inIt();
        Launch(BROWSER_URL);
        navigateUrl(REDBUS_URL);
try {
    WebDriverWait wait = new WebDriverWait(driver, 5);
driver.findElement(By.xpath("//div[@aria-label='Train tickets']")).click();
 // Source city (Hyderabad)

    WebElement sourceBox = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//div[@role='combobox' and @aria-label='From']")));
    sourceBox.click();
   
    driver.findElement(By.xpath("//div[@class='inputWrapper___cbfa45']")).sendKeys("New Delhi");
    
// Wait for the destination combobox to be clickable
  WebElement destinationBox = wait.until(ExpectedConditions.elementToBeClickable(
      By.xpath("//div[@role='combobox' and @aria-label='To']")));
  destinationBox.click();

  // Send keys to the active input field (usually appears after clicking)
  driver.findElement(By.xpath("//input[@type='text' and @aria-label='To']")).sendKeys("Chennai");
//  WebElement activeInput = wait.until(ExpectedConditions.presenceOfElementLocated(
//      By.xpath("//input[@type='text' and @aria-label='To']")));
//  activeInput.sendKeys("Hyderabad");

  // Wait for the suggestion and click it
//  WebElement suggestion = wait.until(ExpectedConditions.elementToBeClickable(
//      By.xpath("//div[normalize-space()='New Delhi']]")));
//  suggestion.click();
  driver.findElement(By.xpath("//img[@title='Online Train Tickets Booking']")).click();
//driver.findElement(By.xpath("//button[@aria-label='Search buses']")).click();
 // Destination city (Chennai)
// WebElement destination = wait.until(ExpectedConditions.elementToBeClickable(
//     By.xpath("//input[@data-message='Enter Destination']")));
// destination.sendKeys("Hyderabad");
// wait.until(ExpectedConditions.elementToBeClickable(
//     By.xpath("//li[contains(text(),'Hyderabad')]"))).click();


 // ✅ Open the calendar
    //driver.findElement(By.xpath("//div[normalize-space()='Date of Journey']")).click();

    // ✅ Navigate to December 2025
    WebDriverWait wait1 = new WebDriverWait(driver,10);
    wait1.until(ExpectedConditions.elementToBeClickable(
        By.xpath("//i[@aria-label='Next month, December 2025']"))).click();

    // ✅ Select 25th December
    wait1.until(ExpectedConditions.elementToBeClickable(
        By.xpath("//span[normalize-space()='25']"))).click();

    // ✅ Click Search Buses
    wait1.until(ExpectedConditions.elementToBeClickable(
    	    By.xpath("//button[@aria-label='Search buses']"))).click();


    System.out.println("Bus search initiated for Kadapa → Chennai on 25th December.");
	
}catch(Exception e){
	e.printStackTrace();
	driver.quit();
	
}


    }
}
