package edu.ncsu.csc216.androtech.model.devices;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * The tester class for Device class
 * 
 * @author Zachary R. Jones
 *
 */
public class DeviceTest {
	/** ComDevice 1 */
	private Device comDevice1;
	/** VRDevice 1 */
	private Device vrDevice1;
	/** Prioritizable 1 */
	private Prioritizable p;

	/**
	 * The setup for the DeviceTest
	 * 
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		comDevice1 = new ComDevice("0000002", "Man 2", 0);
	}

	/**
	 * Test method for
	 * {@link edu.ncsu.csc216.androtech.model.devices.Device#Device(java.lang.String, java.lang.String, int)}
	 * .
	 * @throws BadDeviceInformationException 
	 */
	@Test
	public void testDevice() throws BadDeviceInformationException { // Exceptions and the validation cases, What if device already exists
			// Test for ComDevices
			comDevice1 = new ComDevice("0000002", "Man 2", 0);
			assertEquals(comDevice1.getSerialNum(), "0000002");
			assertEquals(comDevice1.getName(), "Man 2");
			assertEquals(comDevice1.getTier(), 0);


			// Test for validateTier
			// a) higher limit
			comDevice1 = new ComDevice("0000002", "Man 2", 3);
			assertEquals(comDevice1.getTier(), 3);
			// b) past higher limit
			comDevice1 = new ComDevice("0000002", "Man 2", 4);
			assertEquals(comDevice1.getTier(), 3);
			// c) lower limit
			// ALREADY DONE
			// d) past lower limit
			comDevice1 = new ComDevice("0000002", "Man 2", -1);
			assertEquals(comDevice1.getTier(), 0);

			// Test for validateName
			// a) test 1 letter
			comDevice1 = new ComDevice("0000002", "a", 0);
			assertEquals(comDevice1.getName(), "a");
			// b) Regular name
			comDevice1 = new ComDevice("0000002", "Zachary Jones", 0);
			assertEquals(comDevice1.getName(), "Zachary Jones");
			// c) Null name
			boolean thrown = false;
			try {
				new ComDevice("0000002", "", 0);
				fail("Should have failed with null name");
			} catch (BadDeviceInformationException e) {
				thrown = true;
			}
			assertTrue(thrown);
			
			// d) Spaces
			boolean thrown2 = false;
			try {
				new ComDevice("0000002", "      ", 0);
				fail("Should have failed with spaces");
			} catch (BadDeviceInformationException e) {
				thrown2 = true;
			}
			assertTrue(thrown2);

			// test for validateSerialNum
			// a) test for 1 letter
			comDevice1 = new ComDevice("a", "Zachary Jones", 0);
			assertEquals(comDevice1.getSerialNum(), "a");
			// b) Regular Serial Number
			comDevice1 = new ComDevice("B59182710-2890", "Zachary Jones", 0);
			assertEquals(comDevice1.getSerialNum(), "B59182710-2890");
			// c) Null Serial Number
			boolean thrown3 = false;
			try {
				comDevice1 = new ComDevice("", "Zachary Jones", 0);
				fail("Should have failed with null");
			} catch (BadDeviceInformationException e) {
				thrown3 = true;
			}
			assertTrue(thrown3);
			
			// d) Spaces
			boolean thrown4 = false;
			try {
				comDevice1 = new ComDevice("     ", "Zachary Jones", 0);
				fail("Should have failed with null");
			} catch (BadDeviceInformationException e) {
				thrown4 = true;
			}
			assertTrue(thrown4);

			// Test for VRDevices
			vrDevice1 = new VRDevice("0000001", "Man 1", 0);
			assertEquals(vrDevice1.getSerialNum(), "0000001");
			assertEquals(vrDevice1.getName(), "Man 1");
			assertEquals(vrDevice1.getTier(), 0);

			
			// Test for validateTier
			// a) higher limit
			vrDevice1 = new VRDevice("0000001", "Man 1", 3);
			assertEquals(vrDevice1.getTier(), 3);
			// b) past higher limit
			vrDevice1 = new VRDevice("0000001", "Man 1", 4);
			assertEquals(vrDevice1.getTier(), 3);
			// c) lower limit
			// ALREADY DONE
			// d) past lower limit
			vrDevice1 = new VRDevice("0000001", "Man 1", -1);
			assertEquals(vrDevice1.getTier(), 0);

			// Test for validateName
			// a) test 1 letter
			vrDevice1 = new VRDevice("0000001", "a", 0);
			assertEquals(vrDevice1.getName(), "a");
			// b) Regular name
			vrDevice1 = new VRDevice("0000001", "Zachary Jones", 0);
			assertEquals(vrDevice1.getName(), "Zachary Jones");
			// c) Null name
			boolean thrown5 = false;
			try {
				vrDevice1 = new VRDevice("0000001", "", 0);
				fail("Should have failed with null name");
			} catch (BadDeviceInformationException e) {
				thrown5 = true;
			}
			assertTrue(thrown5);
			
			// d) Spaces
			boolean thrown6 = false;
			try {
				vrDevice1 = new VRDevice("0000001", "      ", 0);
				fail("Should have failed with spaces");
			} catch (BadDeviceInformationException e) {
				thrown6 = true;
			}
			assertTrue(thrown6);

			//test for validateSerialNum
			// a) test for 1 letter
			vrDevice1 = new VRDevice("a", "Zachary Jones", 0);
			assertEquals(vrDevice1.getSerialNum(), "a");
			// b) Regular Serial Number
			vrDevice1 = new VRDevice("B59182710-2890", "Zachary Jones", 0);
			assertEquals(vrDevice1.getSerialNum(), "B59182710-2890");
			// c) Null Serial Number
			boolean thrown7 = false;
			try {
				vrDevice1 = new VRDevice("", "Zachary Jones", 0);
				fail("Should have failed with null");
			} catch (BadDeviceInformationException e) {
				thrown7 = true;
			}
			assertTrue(thrown7);
			
			// d) Spaces
			boolean thrown8 = false;
			try {
				vrDevice1 = new VRDevice("     ", "Zachary Jones", 0);
				fail("Should have failed with null");
			} catch (BadDeviceInformationException e) {
				thrown8 = true;
			}
			assertTrue(thrown8);
	}

	/**
	 * Test method for
	 * {@link edu.ncsu.csc216.androtech.model.devices.Device#toString()}.
	 */
	@Test
	public void testToString() { // be careful about the overridden methods, and
		try {
			// Test for ComDevices
			Device d = new Device("0000002", "Man 2", 0);
			assertEquals(d.getTier(), 0);
			assertEquals(d.getSerialNum().equals("0000002"), true);
			assertEquals(d.getName().equals("Man 2"), true);
			assertEquals(d.toString().equals("No Plan  0000002 Man 2"), true);

			// Test for VRDevices
			vrDevice1 = new VRDevice("0000001", "Man 1", 0);
			assertEquals(vrDevice1.toString(), "V No Plan   0000001 Man 1");
			
			
		} catch (BadDeviceInformationException e) {
			fail();
		}


	}

	/**
	 * Test method for
	 * {@link edu.ncsu.csc216.androtech.model.devices.Device#meetsFilter(java.lang.String)}
	 * .
	 */
	@Test
	public void testMeetsFilter() { // DONE but for exceptions
		try {
			// Test for ComDevices
			comDevice1 = new ComDevice("0000002", "Man 2", 0);
			// a) Null
			assertEquals(comDevice1.meetsFilter(""), true);
			// b) ""
			assertEquals(comDevice1.meetsFilter(" "), true);
			// c) i)name.indexOf(filter.trim()) == 0);
			assertEquals(comDevice1.meetsFilter("M"), true);
			// lower case
			assertEquals(comDevice1.meetsFilter("m"), true);
			// Other letter
			assertEquals(comDevice1.meetsFilter("a"), false);

			// Test for VRDevices
			vrDevice1 = new VRDevice("0000001", "Man 1", 0);
			// a) Null
			assertEquals(vrDevice1.meetsFilter(""), true);
			// b) ""
			assertEquals(vrDevice1.meetsFilter(" "), true);
			// c) i)name.indexOf(filter.trim()) == 0);
			assertEquals(vrDevice1.meetsFilter("m"), true);
			// lower case
			assertEquals(vrDevice1.meetsFilter("m"), true);
			// Other letter
			assertEquals(vrDevice1.meetsFilter("a"), false);

		} catch (BadDeviceInformationException e) {
			//do nothing
		}
	}

	/**
	 * Test method for
	 * {@link edu.ncsu.csc216.androtech.model.devices.Device#getTier()}.
	 * @throws BadDeviceInformationException 
	 */
	@Test
	public void testGetTier() throws BadDeviceInformationException { // Done but for exceptions
			// Test for ComDevices
			comDevice1 = new ComDevice("0000002", "Man 2", 0);
			assertEquals(comDevice1.getTier(), 0);

			// Test for VRDevices
			vrDevice1 = new VRDevice("0000001", "Man 1", 0);
			assertEquals(vrDevice1.getTier(), 0);
		
		boolean thrown = false;
		try {
			vrDevice1 = new VRDevice("0000 001", "Man 1", 0);
			
		} catch (BadDeviceInformationException e) {
			thrown = true;
		}
		assertTrue(thrown);
	}

	/**
	 * Test method for
	 * {@link edu.ncsu.csc216.androtech.model.devices.Device#getName()}.
	 */
	@Test
	public void testGetName() { // Done but for exceptions
		boolean thrown = false;
		try {
			// Test for ComDevices
			comDevice1 = new ComDevice("0000002", "Man 2", 0);
			assertEquals(comDevice1.getName(), "Man 2");

			// Test for VRDevices
			vrDevice1 = new VRDevice("0000001", "Man 1", 0);
			assertEquals(vrDevice1.getName(), "Man 1");
			
			vrDevice1 = new VRDevice("0 000001", "Man 1", 0);

		} catch (BadDeviceInformationException e) {
			thrown = true;
		}
		assertTrue(thrown);
	}

	/**
	 * Test method for
	 * {@link edu.ncsu.csc216.androtech.model.devices.Device#getSerialNum()}.
	 */
	@Test
	public void testGetSerialNum() { // Done but for exceptions
		boolean thrown = false;
		try {
			// Test for ComDevices
			comDevice1 = new ComDevice("0000002", "Man 2", 0);
			assertEquals(comDevice1.getSerialNum(), "0000002");

			// Test for VRDevices
			vrDevice1 = new VRDevice("0000001", "Man 1", 0);
			assertEquals(vrDevice1.getSerialNum(), "0000001");
			
			vrDevice1 = new VRDevice("00 00001", "Man 1", 0);

		} catch (BadDeviceInformationException e) {
			thrown = true;
		}
		assertTrue(thrown);

		// BadDeviceInformationException
	}

	/**
	 * Test method for
	 * {@link edu.ncsu.csc216.androtech.model.devices.Device#compareToTier(edu.ncsu.csc216.androtech.model.devices.Prioritizable)}
	 * .
	 */
	@Test
	public void testCompareToTier() { // Need to look at what prioritizable
										// is/does
		boolean thrown = false;
		try {
			// Test for ComDevice
			// a) p has same tier
			comDevice1 = new ComDevice("0000002", "Man 2", 0);
			p = new ComDevice("0000003", "Man 3", 0);
			assertEquals(comDevice1.compareToTier(p), 0);
			// b) p has lesser tier
			comDevice1 = new ComDevice("0000002", "Man 2", 1);
			p = new ComDevice("0000003", "Man 3", 0);
			assertEquals(comDevice1.compareToTier(p), 1);
			// c) p has greater tier
			comDevice1 = new ComDevice("0000002", "Man 2", 0);
			p = new ComDevice("0000003", "Man 3", 1);
			assertEquals(comDevice1.compareToTier(p), -1);

			// Test for VRDevice
			// a) p has same tier
			vrDevice1 = new VRDevice("0000001", "Man 1", 0);
			p = new VRDevice("0000004", "Man 4", 0);
			assertEquals(vrDevice1.compareToTier(p), 0);
			// b) p has lesser tier
			vrDevice1 = new VRDevice("0000001", "Man 1", 1);
			p = new VRDevice("0000004", "Man 4", 0);
			assertEquals(vrDevice1.compareToTier(p), 1);
			// c) p has greater tier
			vrDevice1 = new VRDevice("0000001", "Man 1", 0);
			p = new VRDevice("0000004", "Man 4", 1);
			assertEquals(vrDevice1.compareToTier(p), -1);
			
			vrDevice1 = new VRDevice("00 00001", "Man 1", 0);

		} catch (BadDeviceInformationException e) {
			thrown = true;
		}
		assertTrue(thrown);
	}

}