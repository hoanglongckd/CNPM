package utils;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class FormatMoneyUtils {
	
	public static String convertToMoney (long number) {
		if (number < 1000)
			return String.valueOf(number);
		try {
			NumberFormat formatter = new DecimalFormat("###,###");
			String vnMoney = formatter.format(number);
			vnMoney = vnMoney.replaceAll(",", ".");
			return vnMoney;
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}

}
