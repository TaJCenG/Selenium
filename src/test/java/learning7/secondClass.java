package learning7;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/*
 * search in amazon
 * click login on flipkart
 * enter number
 * request otp
 */ 
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
			//typeText("amazonsearchtextbox_id","RedTape Sneakers");
			//driver.findElement(By.cssSelector("#twotabsearchtextbox")).clear(); // this code will clear the data which entered in textbox
			driver.findElement(By.linkText("Customer Service")).click();
			List<WebElement> links = driver.findElements(By.tagName("a"));
			
			for(int i=0;i<links.size();i++)
			{
				if(!links.get(i).getText().isEmpty())
				{
					System.out.println(links.get(i).getText());
				}}
			//clickElement("amazonsearchbutton_xpath");
			Thread.sleep(2000);
			//navigateUrl(FLIPKART_URL);
			//driver.findElement(By.xpath("//div[@class='H6-NpN _3N4_BX']"));
			//driver.findElement(By.xpath("//input[@class='_18u87m _3WuvDp']")).sendKeys("9398312254");
			//driver.findElement(By.xpath("//button[@class='_1wGnMD rX1XT4 _2nD2xJ']")).click();
			//clickLogin("flipkartlogin_xpath");
		//	typeText("flipkart_xpath", "9398312254");
			//typeText("flipkartLogin_Number_xpath", "9398312254");
			//clickElement("flipkartsubmit_xpath");
			//clickElement("flipkartLoginSubmit_xpath");
			//Thread.sleep(3000);
			
			driver.quit();
			
	}
 

}
