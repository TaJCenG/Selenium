package learning2;

import java.io.IOException;

public class secondClass extends FirstTest{

	public static void main(String[] args) throws IOException {
		
		System.out.println("App started" );
		
			inIt();
			
			System.out.println("App came back in secondclass for launch" );	
			Launch("chromeBrowser");
			System.out.println("App came back from launch and want to navigate" );
			navigateUrl("amazon_url");
	
		

	}

}
