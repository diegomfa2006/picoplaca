package com.dmfa.picoplaca.services.impl;

import java.util.Date;

import com.dmfa.picoplaca.beans.ParametersBean;
import com.dmfa.picoplaca.enums.RankOfTimeEnum;
import com.dmfa.picoplaca.enums.RestrictionDaysEnum;
import com.dmfa.picoplaca.exceptions.GeneralException;
import com.dmfa.picoplaca.services.EvaluatorService;
import com.dmfa.picoplaca.utils.GeneralUtils;

public class EvaluatorServiceImpl implements EvaluatorService {

	/**
	 *Method that predict if the vehicle has pico y placa
	 */
	public boolean validate(ParametersBean params) throws GeneralException {
		try {
			if(GeneralUtils.isValidLicensePlate(params.getLicensePlateNumber()) &&
					GeneralUtils.isValidDate(params.date)) {
				Date date = GeneralUtils.getDate(params.getDate());
				RestrictionDaysEnum day = GeneralUtils.getDay(date);
				String numDay = GeneralUtils.getTheLastChar(params.getLicensePlateNumber());
				
				return hasRestriction(day, numDay, GeneralUtils.getTime(params.getTime()));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new GeneralException();
		}
		return false;
		
	}

	
	/**
	 * Method that validate has restriction by day, the last character of plate and time
	 * @param day RestrictionDaysEnum by date
	 * @param numDay the last character of plate
	 * @param time to road
	 * @return true if car has restriction
	 */
	public boolean hasRestriction(RestrictionDaysEnum day, String numDay, Date time) {
		if(existDay(day.getNumbers() ,numDay)) {
			for (RankOfTimeEnum rank : RankOfTimeEnum.values()) {
				if(isBetween(rank.getStartTime(), rank.getEndTime(), time)) {
					return true;
				}
			}
			
		}
		
		return false;
	}
	
	/**
	 * Validate that day exist in the days with restriction
	 * @param numRestriction array the numbers with restrictions in a day
	 * @param numDay number to eval
	 * @return true if exist day in the array
	 */
	public boolean existDay(int[] numRestriction, String numDay) {
		if (numRestriction != null) {
			for (int day : numRestriction) {
				if (day == Integer.parseInt(numDay)) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	/**
	 * Validate if time is between two times
	 * 
	 * @param startTime
	 * @param endTime
	 * @param time
	 * @return true if the time is between times
	 */
	public boolean isBetween(Date startTime, Date endTime, Date time) {
		
		if((startTime.before(time) || startTime.equals(time)) && (endTime.after(time) || endTime.equals(time) )) {
			return true;
		}
		return false;
	}
	
}
