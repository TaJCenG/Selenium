package testNG4;

import java.util.Arrays;

import org.testng.TestNG;

public class RunParallel {
	
	public static void main(String[] args) 
	{
		
		TestNG obj = new TestNG();
		obj.setTestSuites(Arrays.asList(new String[] {System.getProperty("user.dir")+"//masterl.xml"}));
		obj.setSuiteThreadPoolSize(2);
		obj.run();
	}

}
