package learning10;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.aventstack.extentreports.Status;

import learning9.FirstTest;



public class secondClass extends FirstTest{
	
	public static String AMAZON_URL = "amazon_url";
	public static String BROWSER_URL = "chromeBrowser";
	public static String FLIPKART_URL = "flipkart_url";
	private static final Logger log = LogManager.getLogger(secondClass.class);
	public static void main(String[] args) throws IOException, InterruptedException {
		
			inIt();		
			log.info("Init the properties files....");
			test = rep.createTest("TC_01");
			test.log(Status.INFO, "Init the properties files....");
			Launch(BROWSER_URL);
			log.info("Openong the Browser : " + props.getProperty("chromeBrowser"));
			test.log(Status.PASS, "Opening the Browser : " + props.getProperty("chromebrowser"));
			
			navigateUrl(AMAZON_URL);
			log.info("Navigating to Url : " + props.getProperty("amazon_url"));
			test.log(Status.INFO, "Navigating to Url : " + props.getProperty("amazonurl"));
			
			typeText("//input[@id='twotabsearchtextbox']","RedTape Sneakers");
			test.log(Status.PASS,"Entering Text RedTape Sneakers By using locator : " + props.getProperty("amazonsearchtextbox_id"));
			
			clickElement("//input[@id='nav-search-submit-button']");
			log.info("Clicked on Element By using locator : " + props.getProperty("amazonsearchbutton_xpath"));
			test.log(Status.INFO, "Clicked on Element By using locator : " + props.getProperty("amazonsearchbutton_xpath"));
			
			rep.flush();
			Thread.sleep(5000);
			driver.quit();
			
	}
 

}
