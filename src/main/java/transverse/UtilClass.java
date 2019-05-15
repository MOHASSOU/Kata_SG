package main.java.transverse;

import java.util.Calendar;
import java.util.Date;

public class UtilClass {

	/**
	 * 
	 * @return a Calendar of the current date
	 */
	public static Calendar getCurrentDate() {
	    Calendar cal = Calendar.getInstance();
	    Date date=cal.getTime();
	    cal.setTime(date);

	    return cal;
	}
}
