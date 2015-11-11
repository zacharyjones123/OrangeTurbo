package edu.ncsu.csc216.androtech.model.repair_center;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.ncsu.csc216.androtech.model.devices.ComDevice;
import edu.ncsu.csc216.androtech.model.devices.Device;
import edu.ncsu.csc216.androtech.model.devices.VRDevice;

/**
 * The tester class for ComDroid
 * 
 * @author Zachary R. Jones
 *
 */
public class ComDroidTest {
	/** Com Droid 1 */
	private TechDroid comDroid1;
	/** Com Droid 2 */
	private TechDroid comDroid2;
	/** Device 1 -- VRDevice */
	private Device device1;
	/** Device 2 -- ComDevice */
	private Device device2;

	/**
	 * The setup class for ComDroidTest
	 * 
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		comDroid1 = new ComDroid();
		comDroid2 = new ComDroid();
		device1 = new ComDevice("0000001", "Man 1", 0);
		device2 = new VRDevice("0000002", "Man 2", 0);
	}

	/**
	 * Test method for
	 * {@link edu.ncsu.csc216.androtech.model.repair_center.ComDroid#assign(edu.ncsu.csc216.androtech.model.devices.Device)}
	 * .
	 * @throws DroidDeviceMismatchException 
	 * @throws DroidBusyException 
	 */
	@Test
	public void testAssign() throws DroidDeviceMismatchException, DroidBusyException { // Droid Busy Exception
		TechDroid.startDroidNumberingAt01();
		comDroid1 = new VRDroid();
		// 1)Device is a ComDevice
		boolean thrown = false;
		try {
			comDroid1.assign(device1);
			// Now the TechDroid assign() is called
			// Another if-then loop is called
			// a) assigned == false
			// The assigned now == true
			assertEquals(comDroid1.isAssigned(), true);
			// The assignedDevice is also changed to this device

			// b) assigned == true
			// I) The same device is used
			comDroid1.assign(device1);
			fail("Should not have gotten past here, assigning same device twice");
			// II) different VRDevice
		} catch (DroidDeviceMismatchException e) {
			thrown = true;
		} catch (DroidBusyException e) {
			thrown = true;
		}
		assertTrue(thrown);

		// 2)Device is a VRDevice
		boolean thrown2 = false;
		try {
			comDroid2.assign(device2); // Exception should be thrown
			fail("Was supposed to fail if not a ComDevice");
		} catch (DroidDeviceMismatchException e) {
			thrown2 = true;
		} catch (DroidBusyException e) {
			thrown2 = true;
		}
		assertTrue(thrown2);
	}

	/**
	 * Test method for
	 * {@link edu.ncsu.csc216.androtech.model.repair_center.ComDroid#ComDroid()}
	 * .
	 */
	@Test
	public void testComDroid() { // DONE
		TechDroid.startDroidNumberingAt01();
		comDroid1 = new ComDroid();
		assertEquals(comDroid1.getDroidID().equals("01C"), true);
		assertEquals(comDroid1.isAssigned(), false);
	}

}