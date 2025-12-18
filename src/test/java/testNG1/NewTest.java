package testNG1;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class NewTest {
  
  @Test(priority=1)
  public void f() {
	  System.out.println("f -17");
  }
  
  @Test(priority=2,enabled=false)
  public void a() {
	  System.out.println("a -22");
  }
  
  @Test(priority=3)
  public void z() {
	  System.out.println("z -27");
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("beforeMethod - 31");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("afterMethod - 36");
  }

  @BeforeClass
  public void beforeClass() {
	  System.out.println("beforeClass - 41");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("afterClass - 46");
  }
  

  @BeforeTest
  public void beforeTest() {
	  System.out.println("beforeTest - 52");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("afterTest - 57");
  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("beforeSuite - 62");
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("afterSuite - 67");
  }

}
