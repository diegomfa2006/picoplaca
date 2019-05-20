package com.dmfa.picoplaca.services.impl;

import java.util.Date;

import com.dmfa.picoplaca.beans.ParametersBean;
import com.dmfa.picoplaca.enums.RankOfTimeEnum;
import com.dmfa.picoplaca.enums.RestrictionDaysEnum;
import com.dmfa.picoplaca.services.EvaluatorService;
import com.dmfa.picoplaca.utils.GeneralUtils;

public class EvaluatorServiceImpl implements EvaluatorService {

	public boolean validate(ParametersBean params) {
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
		}
		return false;
		
	}

	
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
	
	public boolean existDay(int[] days, String numDay) {
		if (days != null) {
			for (int day : days) {
				if (day == Integer.parseInt(numDay)) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	public boolean isBetween(Date startTime, Date endTime, Date time) {
		
		if((startTime.before(time) || startTime.equals(time)) && (endTime.after(time) || endTime.equals(time) )) {
			return true;
		}
		return false;
	}
	
}
