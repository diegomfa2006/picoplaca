package com.dmfa.picoplaca.enums;

import java.text.ParseException;
import java.util.Date;

import com.dmfa.picoplaca.utils.GeneralUtils;

/**
 * @author dfuentes
 *
 * Enum that contain the rank of time of restriction.
 *
 */
public enum RankOfTimeEnum {
	MORNING("07:00", "09:30"),
	AFTERNOON("16:00", "19:30");
	
	private Date startTime;
	private Date endTime;
	
	/**
	 * Constructor
	 * 
	 * @param startTime is the initial time
	 * @param endTime is the final time
	 */
	private RankOfTimeEnum(String startTime, String endTime) {
		try {
			this.startTime=GeneralUtils.getTime(startTime);
			this.endTime=GeneralUtils.getTime(endTime);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @return the initial time
	 */
	public Date getStartTime() {
		return startTime;
	}

	/**
	 * @return the final time
	 */
	public Date getEndTime() {
		return endTime;
	}
	
	
}
