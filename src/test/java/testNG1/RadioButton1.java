package testNG1;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import learning9.FirstTest;

public class RadioButton1 extends FirstTest {
	
	public static String RADIO_URL = "radiourl";
	public static String BROWSER_URL = "chromeBrowser";
	public static String FLIPKART_URL = "flipkart_url";
	private static final Logger log = LogManager.getLogger(RadioButton1.class);
	
  @BeforeMethod
	public void beforeMethod() throws Exception 
	{
		System.out.println("startProcess");
	    inIt();
		test = rep.createTest("RadioButton1");
		test.log(Status.PASS, "Initiating the Property Files...");
				
		Launch(BROWSER_URL);
		log.info("Openong the Browser : " + props.getProperty(BROWSER_URL));
		test.log(Status.PASS, "Opening the Browser : " + props.getProperty(BROWSER_URL));
						
		navigateUrl(RADIO_URL);
		log.info("Navigating to Url : " + props.getProperty(RADIO_URL));
		test.log(Status.PASS, "Navigated to app :-" + props.getProperty(RADIO_URL));
	 }
	
	
	@Test
	public void radioButtonTest()
	{
		WebElement radio=driver.findElement(By.xpath("(//td[@class='table5'])[2]"));
		List<WebElement> rbutton=radio.findElements(By.name("group1"));
		for(int i=0;i<rbutton.size();i++)
		{
			System.out.println(rbutton.get(i).getAttribute("value")+ "----" + rbutton.get(i).getAttribute("checked"));
		}
	}


@AfterMethod
public void afterMethod() 
{
	  System.out.println("endProcess");
	  	rep.flush();
		driver.quit();
}

}
