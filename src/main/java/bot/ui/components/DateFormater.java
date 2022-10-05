package bot.ui.components;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public abstract class DateFormater {
	
	public static String getYesterday() {
		
		Date data = new Date();
		Calendar cal =  Calendar.getInstance();
		cal.setTime(data);
		cal.add(Calendar.DATE, -1);
		data = cal.getTime();
		
		SimpleDateFormat dayFormat = new SimpleDateFormat("dd-MM-aaaa");
		
		return dayFormat.format(data);
	}
	
	public static String getDaysBefore(Integer days) {

		Date data = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(data);
		cal.add(Calendar.DATE, -days);
		data = cal.getTime();

		SimpleDateFormat dayFormat = new SimpleDateFormat("dd-MM-aaaa");

		return dayFormat.format(data);
	}

}
