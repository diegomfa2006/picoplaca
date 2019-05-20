package com.dmfa.picoplaca.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;

import com.dmfa.picoplaca.enums.RestrictionDaysEnum;

/**
 * @author dfuentes
 *
 * Util class for many uses
 *
 */
public class GeneralUtils {
	
	private static final String DATE_FORMAT = "dd/MM/yyyy";
	public static final Pattern licensePlatePattern = Pattern.compile("[a-zA-Z]{3}[\\-]?\\d{3,4}");
	public static final Pattern timePattern = Pattern.compile("[a-zA-Z]{3}[\\-]?\\d{3,4}");
	
	/**
	 * Method that validate if license plate is correct 
	 * 
	 * @param value is the license plate number
	 * @return whether the license plate number is valid return true 
	 */
	public static boolean isValidLicensePlate(String value) {
		if(value != null && !value.isEmpty()) {
			return licensePlatePattern.matcher(value).matches();
		}else {
			return false;
		}
		
	}
	
	/**
	 * Method that get the last character of string.
	 * 
	 * @param value is the string to get value
	 * @return the last character
	 */
	public static String getTheLastChar(String value) {	
		if(value != null && !value.isEmpty()) {
			return value.substring(value.length()-1);
		}else {
			return "";
		}
	}
	
	/**
	 * Method that validate that date
	 * 
	 * @param date date in String
	 * @return true if date is valid
	 */
	public static boolean isValidDate(String date) {
		if (date == null) {
			return false;
		}

		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
		sdf.setLenient(false);

		try {
			sdf.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	/**
	 * Method that parse the date
	 * 
	 * @param date in String
	 * @return Date
	 * @throws ParseException exception in the parser
	 */
	public static Date getDate(String date) throws ParseException {
		return new SimpleDateFormat(DATE_FORMAT).parse(date);
	}
	
	/**
	 * Method that parse the time
	 * 
	 * @param time in String
	 * @return Date
	 * @throws ParseException exception in the parser
	 */
	public static Date getTime(String time) throws ParseException {
		return new SimpleDateFormat("HH:mm").parse(time);
	}
	
	/**
	 * Method that return the day by date
	 * 
	 * @param date 
	 * @return RestrictionDaysEnum with the day
	 */
	public static RestrictionDaysEnum getDay(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return RestrictionDaysEnum.findDay(cal.get(Calendar.DAY_OF_WEEK));
	}
}
