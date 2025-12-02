package learning8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SecondClass {

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://money.rediff.com/gainers");
		String price = driver.findElement(By.xpath("//table[@class='dataTable']/tbody/tr[12]/td[4]")).getText();
		//String price = driver.findElement(By.xpath("//a[contains(text(),'Keerthi Industries L')]/parent::td/following-sibling::td[3]")).getText();
		System.out.println(price);
		Thread.sleep(5000);
		driver.quit();

	}

}
