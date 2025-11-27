package learning5;

import java.io.IOException;

import org.openqa.selenium.By;

public class secondClass extends FirstTest{
	
	public static String AMAZON_URL = "amazon_url";
	public static String BROWSER_URL = "chromeBrowser";
	public static String FLIPKART_URL = "flipkart_url";

	public static void main(String[] args) throws IOException, InterruptedException {
		
			inIt();		
			Launch(BROWSER_URL);
			navigateUrl(AMAZON_URL);
			//driver.findElement(By.id("twotabsearchtextbox")).sendKeys("RedTape Sneakers");
			//driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
			typeText("//input[@id='twotabsearchtextbox']","RedTape Sneakers");
			clickElement("//input[@id='nav-search-submit-button']");
			Thread.sleep(5000);
			navigateUrl(FLIPKART_URL);
			//driver.findElement(By.xpath("//div[@class='H6-NpN _3N4_BX']"));
			//driver.findElement(By.xpath("//input[@class='_18u87m _3WuvDp']")).sendKeys("9398312254");
			//driver.findElement(By.xpath("//button[@class='_1wGnMD rX1XT4 _2nD2xJ']")).click();
			typeText("//input[@class='_18u87m _3WuvDp']", "9398312254");
			clickElement("//button[@class='_1wGnMD rX1XT4 _2nD2xJ']");
			Thread.sleep(5000);
			
			driver.quit();
			
	}
 

}
