package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FormatDateUtils {
	
	public static String formatToVnDate (String date) {
		SimpleDateFormat usFormat = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat vnFormat = new SimpleDateFormat("dd/MM/yyyy");
		try {
			Date usDate = usFormat.parse(date);
			String vnDate = vnFormat.format(usDate);
			return vnDate;
		} catch (Exception e) {
			e.printStackTrace();
			return date;
		}
	}
	
}
