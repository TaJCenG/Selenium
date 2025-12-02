package learning9;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



public class secondClass extends FirstTest{
	
	public static String AMAZON_URL = "amazon_url";
	public static String BROWSER_URL = "chromeBrowser";
	public static String FLIPKART_URL = "flipkart_url";
	private static final Logger log = LogManager.getLogger(secondClass.class);
	public static void main(String[] args) throws IOException, InterruptedException {
		
			inIt();		
			log.info("Init the properties files....");
			Launch(BROWSER_URL);
			log.info("Openong the Browser : " + props.getProperty("chromeBrowser") );
			navigateUrl(AMAZON_URL);
			log.info("Navigating to Url : " + props.getProperty("amazon_url"));
			typeText("//input[@id='twotabsearchtextbox']","RedTape Sneakers");
			log.info("Selecting the option Books By using the locator : " + props.getProperty("amazonsearchdropbox_id"));
			log.info("Entering Text Harry Potter By using locator : " + props.getProperty("amazonsearchtextbox_id"));
			clickElement("//input[@id='nav-search-submit-button']");
			log.info("Clicked on Element By using locator : " + props.getProperty("amazonsearchbutton_xpath"));
			Thread.sleep(5000);
			driver.quit();
			
	}
 

}
