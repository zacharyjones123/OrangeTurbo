package edu.ncsu.csc216.androtech.model.repair_center;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.ncsu.csc216.androtech.model.devices.BadDeviceInformationException;
import edu.ncsu.csc216.androtech.model.devices.ComDevice;
import edu.ncsu.csc216.androtech.model.devices.Device;
import edu.ncsu.csc216.androtech.model.devices.VRDevice;

/**
 * The tester class for VRDroid
 * 
 * @author Zachary R. Jones
 *
 */
public class VRDroidTest {
	/** VR Droid 1 */
	
	private TechDroid vrDroid1;
	/** VR Droid 2 */
	private TechDroid vrDroid2;
	/** Device 1 -- VRDevice */
	private Device device1;
	/** Device 2 -- ComDevice */
	private Device device2;

	/**
	 * The setup class for VRDroidTest
	 * 
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		vrDroid1 = new VRDroid();
		vrDroid2 = new VRDroid();
		device1 = new ComDevice("0000001", "Man 1", 0);
		device2 = new VRDevice("0000002", "Man 2", 0);
	}

	/**
	 * Test method for
	 * {@link edu.ncsu.csc216.androtech.model.repair_center.VRDroid#assign(edu.ncsu.csc216.androtech.model.devices.Device)}
	 * .
	 * @throws BadDeviceInformationException 
	 * @throws DroidBusyException 
	 */
	@Test
	public void testAssign() throws BadDeviceInformationException, DroidBusyException { // Droid Busy Exception
		boolean thrown = false;
		
		TechDroid.startDroidNumberingAt01();
		vrDroid1 = new VRDroid();
		// 1)Device is a VRDevice
		try {
			vrDroid1.assign(device2);
			// Now the TechDroid assign() is called
			// Another if-then loop is called
			// a) assigned == false
			// The assigned now == true
			assertEquals(vrDroid1.isAssigned(), true);
			// The assignedDevice is also changed to this device

			// b) assigned == true
			// I) The same device is used
			vrDroid1.assign(device2);
			fail("Should not have gotten past here, assigning same device twice");
			// II) different VRDevice

		} catch (DroidDeviceMismatchException e) {
			thrown = true;

		} catch (DroidBusyException e) {
			thrown = true;

		}
		assertTrue(thrown);
		// 2)Device is a ComDevice
		try {
			vrDroid2.assign(device1);
			fail("Was supposed to fail if not a VRDevice");
		} catch (DroidDeviceMismatchException e) {
			thrown = true;

		} catch (DroidBusyException e) {
			thrown = true;

		}
		assertTrue(thrown);
	}

	/**
	 * Test method for
	 * {@link edu.ncsu.csc216.androtech.model.repair_center.VRDroid#VRDroid()}.
	 */
	@Test
	public void testVRDroid() { // DONE
		TechDroid.startDroidNumberingAt01();
		vrDroid1 = new VRDroid();
		assertEquals(vrDroid1.getDroidID(), "01V");
		assertEquals(vrDroid1.isAssigned(), false);

	}

}
