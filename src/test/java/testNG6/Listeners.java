package testNG6;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class Listeners extends FirstTest implements ITestListener 
{

	public void onTestStart(ITestResult result) 
	{
		Reporter.log("Test Started Running :" + result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) 
	{
		if(result.isSuccess())
		{
			try 
			{
				File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				FileHandler.copy(scrFile, new File("E:\\Courses\\SELENIUM_Java_\\amazon_S" + ".png"));
			
				Reporter.log("<a href='" + new File("E:\\Courses\\SELENIUM_Java_\\amazon_S" + ".png" + "'> <img src='" + new File("E:\\Courses\\SELENIUM_Java_\\amazon_S" + ".png" + "' height='100' width='100'/> </a>")));
				Reporter.log("Test has Success:" + result.getMethod().getMethodName());
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
			
	}

	public void onTestFailure(ITestResult result) 
	{
		if(!result.isSuccess())
		{
			try 
			{
				File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				FileHandler.copy(scrFile, new File("E:\\Courses\\SELENIUM_Java_\\amazon_F" + ".png"));
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
			
			Reporter.log("<a href='" + new File("E:\\Courses\\SELENIUM_Java_\\amazon_F" + ".png" + "'> <img src='" + new File("E:\\Courses\\SELENIUM_Java_\\amazon_F" + ".png" + "' height='100' width='100'/> </a>")));
			Reporter.log("Test has Failed:" + result.getMethod().getMethodName());
			Reporter.log(result.getThrowable().getMessage());
		}
	}

	public void onTestSkipped(ITestResult result) 
	{
		Reporter.log("Test is skipped :" + result.getMethod().getMethodName());
	}
}
