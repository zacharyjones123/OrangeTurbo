package edu.ncsu.csc216.androtech.model.devices;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * The tester clas for VRDevice
 * 
 * @author Zachary R. Jones
 *
 */
public class VRDeviceTest {
	/** VRDevice 1 */
	private Device vrDevice1;
	/** VRDevice 2 */
	private Device vrDevice2;
	/**
	 * Test method for
	 * {@link edu.ncsu.csc216.androtech.model.devices.VRDevice#toString()}.
	 * @throws BadDeviceInformationException 
	 */
	@Test
	public void testToString() throws BadDeviceInformationException { // Just need to handle the exceptions
		boolean thrown = false;
		try {
			// Test VRDevices
			vrDevice1 = new VRDevice("79-27DC", "Carter, June W", 3);
			assertEquals(vrDevice1.toString().equals("V Platinum  79-27DC Carter, June W"), true);
			vrDevice2 = new VRDevice("NC123456", "Doe, Jane", 2);
			assertEquals(vrDevice2.toString().equals("V Gold      NC123456 Doe, Jane"), true);
			new VRDevice("", "Jones, Zach", 0);
			fail("Should not reach this point with bad serial number");
		} catch (BadDeviceInformationException e) {
			thrown = true;
		}
		assertTrue(thrown);

	}

	/**
	 * Test method for
	 * {@link edu.ncsu.csc216.androtech.model.devices.VRDevice#VRDevice(java.lang.String, java.lang.String, int)}
	 * .
	 */
	@Test
	public void testVRDevice() { // Just need to handle the exceptions
		try {
		// Test VRDevices
		vrDevice1 = new VRDevice("0000001", "Man 1", 0);
		assertEquals(vrDevice1.getSerialNum(), "0000001");
		assertEquals(vrDevice1.getName(), "Man 1");
		assertEquals(vrDevice1.getTier(), 0);
		} catch (BadDeviceInformationException e) {
			fail("Bad Device Information Exception");
		}

	}

}