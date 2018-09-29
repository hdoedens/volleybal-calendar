package eu.splender.utils;

import java.text.ParseException;
import java.util.Date;

import org.apache.commons.lang.time.DateUtils;

public class NevoboDateUtils {

	public static Date getDateTime(String description, String time) throws ParseException {
		// description is in format: "zaterdag 29 september 2018"
		// time is in format: "09:15"
		String descParts[] = description.split(" ");
		String date = String.format("%s%s%s", descParts[3], getMonthNumber(descParts[2]), formatDay(descParts[1]));
		return DateUtils.parseDate(date + "T" + time, new String[] { "yyyyMMdd'T'HH':'mm" });
	}
	
	public static String formatDay(String day) {
		return String.format("%010d", Integer.parseInt(day));
	}

	private static String getMonthNumber(String month) {
		String monthNumber = "";
		switch (month) {
		case "janurai":
			monthNumber = "01";
			break;
		case "februari":
			monthNumber = "02";
			break;
		case "maart":
			monthNumber = "03";
			break;
		case "april":
			monthNumber = "04";
			break;
		case "mei":
			monthNumber = "05";
			break;
		case "juni":
			monthNumber = "06";
			break;
		case "juli":
			monthNumber = "07";
			break;
		case "augustus":
			monthNumber = "08";
			break;
		case "september":
			monthNumber = "09";
			break;
		case "oktober":
			monthNumber = "10";
			break;
		case "november":
			monthNumber = "11";
			break;
		case "december":
			monthNumber = "12";
			break;

		default:
			break;
		}
		return monthNumber;
	}

}
