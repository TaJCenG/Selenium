package learning3;

import java.io.IOException;

public class secondClass extends FirstTest{

	public static void main(String[] args) throws IOException, InterruptedException {
		
			inIt();		
			Launch("chromeBrowser");
			navigateUrl("amazon_url");
			navigateUrl("flipkart_url");
			driver.manage().window().maximize(); // FOR  FULL WINDOW MODE
			
			String title =driver.getTitle();
			System.out.println(title);
			
			String url =driver.getCurrentUrl();
			System.out.println(url);
			
			driver.manage().deleteAllCookies();
			
			driver.navigate().back();
			Thread.sleep(3000);
			driver.navigate().forward();
			Thread.sleep(3000);
			driver.navigate().refresh();
			Thread.sleep(3000);
			driver.close();
			driver.quit();
			
	}

}
