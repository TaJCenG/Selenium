package testNG1;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import learning9.FirstTest;

public class SecondTest extends FirstTest{
	
	@BeforeMethod
	  public void startProcess(String btype) throws Exception 
	  {
		  System.out.println("startProcess");
		    inIt();
			test = rep.createTest("SecondTest");
			test.log(Status.INFO, "Init the properties files....");
			
			Launch(btype);
			test.log(Status.PASS, "Opening the Browser : " + props.getProperty("chromebrowser"));
			
			navigateUrl("amazonurl");
			test.log(Status.INFO, "Navigating to Url : " + props.getProperty("amazonurl"));
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
		  System.out.println("endProcess");
		  rep.flush();
		  driver.quit();
	  }

}
