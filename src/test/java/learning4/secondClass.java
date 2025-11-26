package learning4;

import java.io.IOException;

public class secondClass extends FirstTest{
	
	public static String AMAZON_URL = "amazon_url";
	public static String BROWSER_URL = "chromeBrowser";
	public static String FLIPKART_URL = "flipkart_url";

	public static void main(String[] args) throws IOException, InterruptedException {
		
			inIt();		
			Launch(BROWSER_URL);
			//driver.manage().window().maximize(); // FOR  FULL WINDOW MODE
			navigateUrl(AMAZON_URL);
			navigateUrl(FLIPKART_URL);
			Thread.sleep(10000);
			driver.quit();
			
	}

}
