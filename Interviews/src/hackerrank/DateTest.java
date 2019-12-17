package hackerrank;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {

	public DateTest() {
		
		SimpleDateFormat format = new SimpleDateFormat("dd MMM yyyy hh:mm:ss");
		String dateString = format.format( new Date()   );
		System.out.println(dateString);
		//Time zone >> 21 Nov 2018 20:29:38 GMT
	}

	public static void main(String[] args) {
		new DateTest();
	}
}
