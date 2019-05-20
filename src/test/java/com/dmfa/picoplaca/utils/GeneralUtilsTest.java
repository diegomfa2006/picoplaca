package com.dmfa.picoplaca.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.util.Date;

import org.junit.Test;

import com.dmfa.picoplaca.enums.RestrictionDaysEnum;

public class GeneralUtilsTest {
	
	@Test
	public void testIsValidLicensePlate() {
		assertTrue(GeneralUtils.isValidLicensePlate("PCG-2207"));
		assertTrue(GeneralUtils.isValidLicensePlate("PCG-207"));
		assertTrue(GeneralUtils.isValidLicensePlate("PCG0709"));
		assertFalse(GeneralUtils.isValidLicensePlate("PCG-07"));
		assertFalse(GeneralUtils.isValidLicensePlate("PCG-07899"));
		assertFalse(GeneralUtils.isValidLicensePlate("o"));
		assertFalse(GeneralUtils.isValidLicensePlate("111-1234"));
		assertFalse(GeneralUtils.isValidLicensePlate("x*?-!\"·"));
		assertFalse(GeneralUtils.isValidLicensePlate(""));
		assertFalse(GeneralUtils.isValidLicensePlate(null));
	}
	
	@Test
	public void testGetTheLastChar() {
		assertEquals("7", GeneralUtils.getTheLastChar("PCG-2207"));
		assertEquals("7", GeneralUtils.getTheLastChar("7"));
		assertEquals("", GeneralUtils.getTheLastChar(""));
		assertEquals("", GeneralUtils.getTheLastChar(null));
		
		assertNotEquals("7", GeneralUtils.getTheLastChar("PCG-2270"));
	}

	@Test
	public void testIsValidDate() {
		
	}
	
	@Test
	public void testGetDate() {
		
	}
	
	@Test
	public void testGetDay() throws ParseException {
		Date date = GeneralUtils.getDate("13/05/2019");
		assertEquals(RestrictionDaysEnum.MONDAY, GeneralUtils.getDay(date));
	}
}
