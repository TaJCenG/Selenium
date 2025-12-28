package verification;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.aventstack.extentreports.Status;

public class Verification3 extends FirstTest{
	public static String AMAZON_URL = "amazon_url";
	public static String BROWSER_URL = "chromeBrowser";
	public static String FLIPKART_URL = "flipkart_url";
	private static final Logger log = LogManager.getLogger(Verification3.class);
	public static void main(String[] args) 
	{
		try {
			
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
				
			String expectLink = "Customer Servi";
			
			
			if(!isLinksEqual(expectLink)) {
				//System.out.println("Both links are not equal...");
				reportFailure("Both links are not equal...");
			log.info("In !isLink Equal");}
			else {
				//System.out.println("Both links are equal...");
				reportSuccess("Both links are equal...");
				log.info("In Else");}
			
			rep.flush();
			
			
	        } catch (Exception e) {
	            System.out.println("Links issue: " + e.getMessage());
	            log.info("Links issue:  " + e.getMessage());
	        } finally {
	            driver.quit();
	        }
	}
}
