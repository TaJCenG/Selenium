package testNG3;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class CheckBox1 extends FirstTest{
	
	public static String CHECKBOX_URL = "chekboxurl";
	public static String BROWSER_URL = "chromeBrowser";
	public static String FLIPKART_URL = "flipkart_url";
	private static final Logger log = LogManager.getLogger(RadioButton1.class);
	
	@BeforeMethod
	@Parameters("browser")
	public void beforeMethod(String btype) throws Exception 
	{
		System.out.println("startProcess CheckBox1");
	    inIt();
		test = rep.createTest("CheckBox1");
		test.log(Status.PASS, "Initiating the Property Files...");
				
		Launch(btype);
		log.info("Openong the Browser : " + props.getProperty(BROWSER_URL));
		test.log(Status.PASS, "Opening the Browser : " + props.getProperty(BROWSER_URL));
						
		navigateUrl(CHECKBOX_URL);
		log.info("Navigating to Url : " + props.getProperty(CHECKBOX_URL));
		test.log(Status.PASS, "Navigated to app :-" + props.getProperty(CHECKBOX_URL));
	}
	  
	  
	@Test
	public void checkboxTest()
	{
		List<WebElement> check=driver.findElements(By.xpath("//td[@class='table5']/input[@type='checkbox']"));
		for(int i=0;i<check.size();i++)
		{
			System.out.println(check.get(i).getAttribute("value")+"--"+check.get(i).getAttribute("checked"));
			//System.out.println(check.get(i).isSelected());
		}
	}
 

  @AfterMethod
  public void afterMethod() 
  {
	  System.out.println("endProcess CheckBox1");
	  	rep.flush();
		driver.quit();
  }
}
