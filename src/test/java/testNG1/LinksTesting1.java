package testNG1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import learning9.FirstTest;

public class LinksTesting1 extends FirstTest{
	
	public static String GOOGLE_URL = "googleurl";
	public static String BROWSER_URL = "chromeBrowser";
	public static String FLIPKART_URL = "flipkart_url";
	private static final Logger log = LogManager.getLogger(LinksTesting1.class);
	
	@BeforeMethod
	public void setup() throws Exception
	{
		System.out.println("startProcess");
	    inIt();
		test = rep.createTest("LinksTesting1");
		test.log(Status.PASS, "Initiating the Property Files...");
				
		Launch(BROWSER_URL);
		log.info("Openong the Browser : " + props.getProperty(BROWSER_URL));
		test.log(Status.PASS, "Opening the Browser : " + props.getProperty(BROWSER_URL));
						
		navigateUrl(GOOGLE_URL);
		log.info("Navigating to Url : " + props.getProperty(GOOGLE_URL));
		test.log(Status.PASS, "Navigated to app :-" + props.getProperty("googleurl"));
	}
	
	
	@Test
	public void linktesting1()
	
	 {
		String expval="Google Images";
		
		driver.findElement(By.linkText("Images")).click();	
		Reporter.log("Clicked on Image Link");
		String actval=driver.getTitle();
		
		Assert.assertEquals(actval, expval);
		
	 }
	
	@AfterMethod
	public void tearDown()
	{
		 System.out.println("endProcess");
		  	rep.flush();
			driver.quit();
	}

}
