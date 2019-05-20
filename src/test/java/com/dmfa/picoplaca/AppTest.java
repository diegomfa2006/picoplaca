package com.dmfa.picoplaca;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {

	@Test
	public void testApp() {
		App.main(new String[] { "PAS-001", "20/05/2019", "8:00" });
	}
}
