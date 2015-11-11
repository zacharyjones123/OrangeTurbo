package edu.ncsu.csc216.androtech.model.devices;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * The tester class for ComDevice
 * 
 * @author Zachary R. Jones
 *
 */
public class ComDeviceTest {
	/** ComDevice 1 */
	private Device comDevice1;
	/** ComDevice 2 */
	private Device comDevice2;
	/**
	 * The setup for ComDeviceTest
	 * 
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		comDevice1 = new ComDevice("NC123456", "Doe, Jane", 2);
		comDevice2 = new ComDevice("79-27DC", "Carter, June W", 3);
	}

	/**
	 * Test method for
	 * {@link edu.ncsu.csc216.androtech.model.devices.ComDevice#toString()}.
	 * 
	 * @throws BadDeviceInformationException
	 */
	@Test
	public void testToString() throws BadDeviceInformationException { // Just
																		// need
																		// to
																		// handle
																		// the
																		// exceptions
		// Test ComDevices
		assertEquals(
				comDevice1.toString().equals("C Gold      NC123456 Doe, Jane"),
				true);
		assertEquals(
				comDevice2.toString().equals(
						"C Platinum  79-27DC Carter, June W"), true);
	}

	/**
	 * Test method for
	 * {@link edu.ncsu.csc216.androtech.model.devices.ComDevice#ComDevice(java.lang.String, java.lang.String, int)}
	 * .
	 */
	@Test
	public void testComDevice() { // Just need to handle the exceptions
		// Test ComDevices
		assertEquals(comDevice1.getSerialNum(), "NC123456");
		assertEquals(comDevice1.getName(), "Doe, Jane");
		assertEquals(comDevice1.getTier(), 2);
	}

}