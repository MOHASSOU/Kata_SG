package main.java.transverse;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class UtilClass {

	/** To develop for more operation types **/
	public enum operationType
	{
		DEPOSIT,
		WITHDRAWAL
	}
	
	/**
	 * @return a Calendar of the current date
	 */
	public static Calendar getCurrentDate() {
	    Calendar cal = Calendar.getInstance();
	    Date date=cal.getTime();
	    cal.setTime(date);

	    return cal;
	}
	
	/**
	 * @param Calendar
	 * @return String
	 */
	public static String getStringFromCalendar(Calendar calendar)
	{
	Date date = Calendar.getInstance().getTime();
	DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
	return dateFormat.format(date);
	}
}
