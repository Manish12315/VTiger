package genericUtility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
/**
 * This is a generic method to fetch calendar details
 * @param pattern
 * @return
 */
	public String getCalenderDetails(String pattern) {
		Calendar cal =Calendar.getInstance();
		Date date= cal.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		String value= sdf.format(date);
		return value;

	}
/**
 * This is a generic method to generate random number
 * @param bound
 * @return
 */
	public int generateRandomNumber( int bound) {
		Random r= new Random();
		int num =r.nextInt(bound);
		return num;
		
	}
	
}


