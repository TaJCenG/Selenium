package learning11;

import java.io.IOException;
import java.util.Date;

public class SccreenShot5 {
	 public static void main(String[] args) throws IOException {
		 {
				Date dt = new Date();
				System.out.println(dt);
				String d = dt.toString().replace(':', '_').replace(' ', '_');
				System.out.println(d);
			}

	 }
}
	    
