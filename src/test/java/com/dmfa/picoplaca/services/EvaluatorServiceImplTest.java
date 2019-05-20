package com.dmfa.picoplaca.services;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.util.Date;

import org.junit.Test;

import com.dmfa.picoplaca.beans.ParametersBean;
import com.dmfa.picoplaca.enums.RestrictionDaysEnum;
import com.dmfa.picoplaca.exceptions.GeneralException;
import com.dmfa.picoplaca.services.impl.EvaluatorServiceImpl;
import com.dmfa.picoplaca.utils.GeneralUtils;

public class EvaluatorServiceImplTest {

	@Test
	public void testValidate() throws GeneralException {
		EvaluatorServiceImpl eva = new EvaluatorServiceImpl();
		
		assertTrue(eva.validate(new ParametersBean("PCG-2004", "21/05/2019", "8:00")));
		assertFalse(eva.validate(new ParametersBean("PCG-2001", "21/05/2019", "8:00")));
		assertFalse(eva.validate(new ParametersBean("PCG-2001", "40/05/2019", "8:00")));
	}

	@Test
	public void testHasRestriction() throws ParseException {
		EvaluatorServiceImpl eva = new EvaluatorServiceImpl();
		
		assertTrue(eva.hasRestriction(RestrictionDaysEnum.MONDAY, "1", GeneralUtils.getTime("9:30")));
		assertTrue(eva.hasRestriction(RestrictionDaysEnum.MONDAY, "1", GeneralUtils.getTime("7:00")));
		assertTrue(eva.hasRestriction(RestrictionDaysEnum.MONDAY, "1", GeneralUtils.getTime("7:40")));
		assertFalse(eva.hasRestriction(RestrictionDaysEnum.MONDAY, "1", GeneralUtils.getTime("6:59")));
		assertFalse(eva.hasRestriction(RestrictionDaysEnum.MONDAY, "1", GeneralUtils.getTime("9:31")));
		
		assertTrue(eva.hasRestriction(RestrictionDaysEnum.MONDAY, "1", GeneralUtils.getTime("16:00")));
		assertTrue(eva.hasRestriction(RestrictionDaysEnum.MONDAY, "2", GeneralUtils.getTime("19:30")));
		assertTrue(eva.hasRestriction(RestrictionDaysEnum.MONDAY, "2", GeneralUtils.getTime("17:40")));
		assertFalse(eva.hasRestriction(RestrictionDaysEnum.MONDAY, "2", GeneralUtils.getTime("15:59")));
		assertFalse(eva.hasRestriction(RestrictionDaysEnum.MONDAY, "2", GeneralUtils.getTime("19:31")));
	}

	@Test
	public void testExistDay() {
		EvaluatorServiceImpl eva = new EvaluatorServiceImpl();
		assertTrue(eva.existDay(new int[] {1,2}, "1"));
		assertFalse(eva.existDay(new int[] {1,2}, "3"));
		assertFalse(eva.existDay(null, "3"));
	}
	
	@Test
	public void testIsBetween() throws ParseException {
		EvaluatorServiceImpl eva = new EvaluatorServiceImpl();
		Date start = GeneralUtils.getTime("16:00");
		Date end = GeneralUtils.getTime("17:00");
		Date time = GeneralUtils.getTime("16:00");
		assertTrue(eva.isBetween(start, end, time));
		
		time = GeneralUtils.getTime("17:00");
		assertTrue(eva.isBetween(start, end, time));
		
		time = GeneralUtils.getTime("15:59");
		assertFalse(eva.isBetween(start, end, time));
	}
}
