package testNG6;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;


public class SecondTest extends FirstTest{
	
	public static String BROWSER_URL = "chromeBrowser";
	public static String AMAZON_URL = "amazon_url";
	
	@BeforeMethod
	@Parameters("browser")
	  public void startProcess(String btype) throws Exception 
	  {
		  System.out.println("startProcess SecondTest");
		    inIt();
			test = rep.createTest("SecondTest");
			test.log(Status.INFO, "Init the properties files....");
			
			Launch(btype);
			test.log(Status.PASS, "Opening the Browser : " + props.getProperty(BROWSER_URL));
			
			navigateUrl(AMAZON_URL);
			test.log(Status.INFO, "Navigating to Url : " + props.getProperty(AMAZON_URL));
	  }
	  
	  @Test
	  public void amazon() 
	  {
		  System.out.println("amazon");
		  typeText("//input[@id='twotabsearchtextbox']","RedTape Sneakers");
			test.log(Status.PASS,"Entering Text RedTape Sneakers By using locator : " + props.getProperty("amazonsearchtextbox_id"));
			
			clickElement("//input[@id='nav-search-submit-button']");
			test.log(Status.INFO, "Clicked on Element By using locator : " + props.getProperty("amazonsearchbutton_xpath"));
	  }

	  @AfterMethod
	  public void endProcess()
	  {
		  System.out.println("endProcess SecondTest");
		  rep.flush();
		  driver.quit();
	  }

}
