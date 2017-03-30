package vee;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class CheckDays {
	public static final List<String> listOfHolidays = Arrays.asList(
			"01/01/2011", "01/05/2011", "09/08/2011", "25/12/2011",
			"03/02/2011", "04/02/2011", "22/04/2011", "07/05/2011",
			"17/05/2011", "27/08/2011", "30/08/2011", "26/10/2011",
			"06/11/2011", "01/01/2012", "01/05/2012", "09/08/2012",
			"25/12/2012", "23/01/2012", "24/01/2012", "06/04/2012",
			"05/05/2012", "19/08/2012", "26/10/2012", "13/11/2012",
			"01/01/2013", "01/05/2013", "09/08/2013", "25/12/2013",
			"10/02/2013", "11/02/2013", "29/03/2013", "24/05/2013",
			"08/08/2013", "15/10/2013", "02/11/2013", "01/01/2014",
			"01/05/2014", "09/08/2014", "25/12/2014", "31/01/2014",
			"01/02/2014", "18/04/2014", "13/05/2014", "28/07/2014",
			"05/10/2014", "22/10/2014", "01/01/2015", "19/02/2015",
			"20/02/2015", "03/04/2015", "01/05/2015", "01/06/2015",
			"17/07/2015", "09/08/2015", "24/09/2015", "10/11/2015",
			"25/12/2015", "01/01/2016", "08/02/2016", "09/02/2016",
			"25/03/2016", "01/05/2016", "21/05/2016", "06/07/2016",
			"09/08/2016", "12/09/2016", "29/10/2016", "25/12/2016");

	public boolean isHoliday(long timestamp) {
		Date date = new Date(timestamp);
		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String time = formatter.format(date);
		System.out.println(time);
		return listOfHolidays.contains(time);
	}

	public long getHolidayNearWeedend(long timestamp) {
		String dayOfWeek = whichDayOfWeek(timestamp);
		if (dayOfWeek.equals("Monday"))
			return timestamp - 1 * 24 * 60 * 60 * 1000;
		if (dayOfWeek.equals("Tuesday"))
			return timestamp - 2 * 24 * 60 * 60 * 1000;
		if (dayOfWeek.equals("Wednesday"))
			return timestamp - 3 * 24 * 60 * 60 * 1000;
		if (dayOfWeek.equals("Thursday"))
			return timestamp - 4 * 24 * 60 * 60 * 1000;
		if (dayOfWeek.equals("Friday"))
			return timestamp - 5 * 24 * 60 * 60 * 1000;
		if (dayOfWeek.equals("Saturday"))
			return timestamp - 6 * 24 * 60 * 60 * 1000;
		else
			return timestamp - 7 * 24 * 60 * 60 * 1000;

	}

	public String whichDayOfWeek(long timestamp) {
		Calendar c = Calendar.getInstance();
		c.setTime(new Date(timestamp));
		int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
		if (dayOfWeek == 2)
			return "Monday";
		if (dayOfWeek == 3)
			return "Tuesday";
		if (dayOfWeek == 4)
			return "Wednesday";
		if (dayOfWeek == 5)
			return "Thursday";
		if (dayOfWeek == 6)
			return "Friday";
		if (dayOfWeek == 7)
			return "Saturday";
		return "Sunday";
	}

	public static void main(String[] args) {
		CheckDays c = new CheckDays();
		System.out.println(c.isHoliday(1478016000000l));
		System.out.println(c.whichDayOfWeek(1477843200000l));
	}
}
