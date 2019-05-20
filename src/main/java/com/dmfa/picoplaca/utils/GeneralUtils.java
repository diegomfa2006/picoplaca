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
	
	public static boolean isValidDate(String dateTime) {
		try {
			getDate(dateTime);
			return true;
		} catch (ParseException e) {
			return false;
		}
		
	}
	
	public static Date getDate(String dateTime) throws ParseException {
		return new SimpleDateFormat("dd/MM/yyyy").parse(dateTime);
	}
	
	public static Date getTime(String dateTime) throws ParseException {
		return new SimpleDateFormat("HH:mm").parse(dateTime);
	}
	
	public static RestrictionDaysEnum getDay(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return RestrictionDaysEnum.findDay(cal.get(Calendar.DAY_OF_WEEK));
	}
}
