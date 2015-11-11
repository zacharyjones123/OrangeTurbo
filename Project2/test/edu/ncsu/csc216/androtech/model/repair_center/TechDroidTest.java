package edu.ncsu.csc216.androtech.model.repair_center;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.ncsu.csc216.androtech.model.devices.BadDeviceInformationException;
import edu.ncsu.csc216.androtech.model.devices.ComDevice;
import edu.ncsu.csc216.androtech.model.devices.Device;
import edu.ncsu.csc216.androtech.model.devices.VRDevice;

/**
 * The test class for TechDroid
 * 
 * @author Zachary R. Jones
 *
 */
public class TechDroidTest {
	/** Com Droid 1 */
	private TechDroid comDroid1;
	/** VR Droid 1 */
	private TechDroid vrDroid1;
	/** ExpertDroid 1 */
	private TechDroid expertDroid1;

	/** Other Droid 4 */
	private TechDroid otherDroid4;
	/** Other Droid 5 */
	private TechDroid otherDroid5;
	/** Other Droid 6 */
	private TechDroid otherDroid6;
	/** Other Droid 7 */
	private TechDroid otherDroid7;
	/** Other Droid 8 */
	private TechDroid otherDroid8;
	/** Other Droid 9 */
	private TechDroid otherDroid9;
	/** Other Droid 10 */
	private TechDroid otherDroid10;
	/** other Droid11 */
	private TechDroid otherDroid11;
	/** Device 1 -- ComDevice */
	private Device device1;
	/** Device 2 -- VRDevice */
	private Device device2;
	/** Device 3 -- ComDevice */
	private Device device3;
	/** Device 4 -- VRDevice */
	private Device device4;

	/**
	 * The setup class for TechDroidTest
	 * 
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		comDroid1 = new ComDroid();
		vrDroid1 = new VRDroid();
		expertDroid1 = new ExpertDroid();

		otherDroid4 = new ComDroid();
		otherDroid5 = new ComDroid();
		otherDroid6 = new ComDroid();
		otherDroid7 = new ComDroid();
		otherDroid8 = new ComDroid();
		otherDroid9 = new ComDroid();
		otherDroid10 = new ComDroid();
		otherDroid11 = new ComDroid();

		device1 = new ComDevice("0000001", "Man 1", 0);
		device2 = new VRDevice("0000002", "Man 2", 0);
		device3 = new ComDevice("0000003", "Man 3", 0);
		device4 = new VRDevice("0000004", "Man 4", 0);
	}

	/**
	 * Test method for
	 * {@link edu.ncsu.csc216.androtech.model.repair_center.TechDroid#startDroidNumberingAt01()}
	 * .
	 */
	@Test
	public void testStartDroidNumberingAt01() {
		// Need a way to see what the Starting Number in TechDroid actually is
		TechDroid.startDroidNumberingAt01();
		comDroid1 = new ComDroid();
		assertEquals(comDroid1.getDroidID().equals("01C"), true);
		TechDroid.startDroidNumberingAt01();
		vrDroid1 = new VRDroid();
		assertEquals(vrDroid1.getDroidID().equals("01V"), true);
	}

	/**
	 * Test method for
	 * {@link edu.ncsu.csc216.androtech.model.repair_center.TechDroid#TechDroid(java.lang.String)}
	 * .
	 */
	@Test
	public void testTechDroid() { // Done
		// test for ComDroids
		TechDroid.startDroidNumberingAt01();
		comDroid1 = new ComDroid();
		assertEquals(comDroid1.getDroidID().equals("01C"), true);

		// test for VRDroids
		vrDroid1 = new VRDroid();
		assertEquals(vrDroid1.getDroidID().equals("02V"), true);

		// test for ExpertDroids
		expertDroid1 = new ExpertDroid();
		assertEquals(expertDroid1.getDroidID().equals("03E"), true);
		otherDroid4 = new ComDroid();
		assertEquals(otherDroid4.getDroidID().equals("04C"), true);
		otherDroid5 = new ComDroid();
		assertEquals(otherDroid5.getDroidID().equals("05C"), true);
		otherDroid6 = new ComDroid();
		assertEquals(otherDroid6.getDroidID().equals("06C"), true);
		otherDroid7 = new ComDroid();
		assertEquals(otherDroid7.getDroidID().equals("07C"), true);
		otherDroid8 = new ComDroid();
		assertEquals(otherDroid8.getDroidID().equals("08C"), true);

		// test along the boundaries of the ZERO_BOUND
		otherDroid9 = new ComDroid();
		assertEquals(otherDroid9.getDroidID().equals("09C"), true);
		otherDroid10 = new ComDroid();
		assertEquals(otherDroid10.getDroidID().equals("10C"), true);
		otherDroid11 = new ComDroid();
		assertEquals(otherDroid11.getDroidID().equals("11C"), true);

	}

	/**
	 * Test method for
	 * {@link edu.ncsu.csc216.androtech.model.repair_center.TechDroid#getDroidID()}
	 * .
	 */
	@Test
	public void testGetDroidID() { // DONE
		TechDroid.startDroidNumberingAt01();
		// test for ComDroids
		comDroid1 = new ComDroid();
		assertEquals(comDroid1.getDroidID(), "01C");

		// test for VRDroids
		vrDroid1 = new VRDroid();
		assertEquals(vrDroid1.getDroidID(), "02V");

		// test for ExpertDroids
		expertDroid1 = new ExpertDroid();
		assertEquals(expertDroid1.getDroidID(), "03E");
	}

	/**
	 * Test method for
	 * {@link edu.ncsu.csc216.androtech.model.repair_center.TechDroid#isAssigned()}
	 * .
	 */
	@Test
	public void testIsAssigned() { // DONE
		TechDroid.startDroidNumberingAt01();
		// test for ComDroids
		comDroid1 = new ComDroid();
		assertEquals(comDroid1.isAssigned(), false);

		// test for VRDroids
		vrDroid1 = new VRDroid();
		assertEquals(vrDroid1.isAssigned(), false);

		// test for ExpertDroids
		expertDroid1 = new ExpertDroid();
		assertEquals(expertDroid1.isAssigned(), false);

	}

	/**
	 * Test method for
	 * {@link edu.ncsu.csc216.androtech.model.repair_center.TechDroid#release()}
	 * .
	 */
	@Test
	public void testRelease() {
		try {
			TechDroid.startDroidNumberingAt01();
			// a) ComDroid
			comDroid1 = new ComDroid();
			assertEquals(comDroid1.isAssigned(), false);
			comDroid1.assign(device1);
			assertEquals(comDroid1.isAssigned(), true);
			assertEquals(comDroid1.release(), device1);
			assertEquals(comDroid1.isAssigned(), false);

			// b) VRDroid
			vrDroid1 = new VRDroid();
			assertEquals(vrDroid1.isAssigned(), false);
			vrDroid1.assign(device2);
			assertEquals(vrDroid1.isAssigned(), true);
			assertEquals(vrDroid1.release(), device2);
			assertEquals(vrDroid1.isAssigned(), false);

			// c) ExpertDroid
			expertDroid1 = new ExpertDroid();
			assertEquals(expertDroid1.isAssigned(), false);
			expertDroid1.assign(device1);
			assertEquals(expertDroid1.isAssigned(), true);
			assertEquals(expertDroid1.release(), device1);
			assertEquals(expertDroid1.isAssigned(), false);

		} catch (DroidDeviceMismatchException e) {
			fail("The way the test is set up, this should not be thrown");
		} catch (DroidBusyException e) {
			fail("The way the test is set up, this hould not be thrown");
		}

		// Tests for trying to set up Droid that already has a device
		// a) ComDroid
		comDroid1 = new ComDroid();
		assertEquals(comDroid1.isAssigned(), false);
		assertEquals(comDroid1.release(), null);

		// b) VRDroid
		vrDroid1 = new VRDroid();
		assertEquals(vrDroid1.isAssigned(), false);
		assertEquals(vrDroid1.release(), null);

		// c) ExpertDroid
		expertDroid1 = new ExpertDroid();
		assertEquals(expertDroid1.isAssigned(), false);
		assertEquals(expertDroid1.release(), null);
	}

	/**
	 * Test method for
	 * {@link edu.ncsu.csc216.androtech.model.repair_center.TechDroid#assign(edu.ncsu.csc216.androtech.model.devices.Device)}
	 * .
	 * @throws DroidBusyException 
	 * @throws BadDeviceInformationException 
	 */
	@Test
	public void testAssign() throws DroidBusyException, BadDeviceInformationException { // Need to figure out how to show it throwing the
								// exceptions
		// test for ComDroids (Not Assigned)
		try {
			TechDroid.startDroidNumberingAt01();
			comDroid1 = new ComDroid();
			assertEquals(comDroid1.isAssigned(), false);
			comDroid1.assign(device1);
			assertEquals(comDroid1.isAssigned(), true);
		} catch (DroidDeviceMismatchException e) {
			fail("Empty Droid, should not have reached here");
		} catch (DroidBusyException e) {
			fail("Empty Droid, should not have reached here");
		}

		// test for ComDroids (Assigned)
		boolean thrown = false;
		try {
			comDroid1 = new ComDroid();
			assertEquals(comDroid1.isAssigned(), false);
			comDroid1.assign(device1);
			assertEquals(comDroid1.isAssigned(), true);
			comDroid1.assign(device3);
			fail("Should not have gotten past here, assigning same device twice");
		} catch (DroidDeviceMismatchException e) {
			thrown = true;
		} catch (DroidBusyException e) {
			thrown = true;
		}
		assertTrue(thrown);

		// test for VRDroids (Not Assigned).
		try {
			vrDroid1 = new VRDroid();
			assertEquals(vrDroid1.isAssigned(), false);
			vrDroid1.assign(device2);
			assertEquals(vrDroid1.isAssigned(), true);
		} catch (DroidDeviceMismatchException e) {
			fail("Empty Droid, should not have reached here");
		} catch (DroidBusyException e) {
			fail("Empty Droid, should not have reached here");
		}

		// test for VRDRoids (Assigned)
		boolean thrown2 = false;
		try {
			vrDroid1 = new VRDroid();
			assertEquals(vrDroid1.isAssigned(), false);
			vrDroid1.assign(device2);
			assertEquals(vrDroid1.isAssigned(), true);
			vrDroid1.assign(device4);
			fail("Should not have gotten past here, assigning same device twice");
		} catch (DroidDeviceMismatchException e) {
			thrown2 = true;
		} catch (DroidBusyException e) {
			thrown2 = true;
		}
		assertTrue(thrown2);

		// test for ExpertDroids (Not Assigned)
		try {
			expertDroid1 = new ExpertDroid();
			assertEquals(expertDroid1.isAssigned(), false);
			expertDroid1.assign(device1);
			assertEquals(expertDroid1.isAssigned(), true);
		} catch (DroidDeviceMismatchException e) {
			fail("Empty Droid, should not have reached here");
		} catch (DroidBusyException e) {
			fail("Empty Droid, should not have reached here");
		}

		// test for ExpertDroids (Assigned)
		boolean thrown3 = false;
		try {
			expertDroid1 = new ExpertDroid();
			assertEquals(expertDroid1.isAssigned(), false);
			expertDroid1.assign(device1);
			assertEquals(expertDroid1.isAssigned(), true);
			expertDroid1.assign(device1);
			fail("Should not have gotten past here, assigning same device twice");
		} catch (DroidDeviceMismatchException e) {
			thrown3 = true;
		} catch (DroidBusyException e) {
			thrown3 = true;
		}
		assertTrue(thrown3);

	}

	/**
	 * Test method for
	 * {@link edu.ncsu.csc216.androtech.model.repair_center.TechDroid#toString()}
	 * .
	 * @throws DroidBusyException 
	 * @throws BadDeviceInformationException 
	 */
	@Test
	public void testToString() throws DroidBusyException, BadDeviceInformationException { // Done
		try {
			TechDroid.startDroidNumberingAt01();
			// test for ComDroids (Not Assigned).
			comDroid1 = new ComDroid();
			assertEquals(comDroid1.toString(), "01C: UNASSIGNED");

			// test for ComDroids (Assigned).
			comDroid1.assign(device1);
			assertEquals(comDroid1.toString(), "01C: 0000001 Man 1");

			// test for VRDroids (Not Assigned).
			vrDroid1 = new VRDroid();
			assertEquals(vrDroid1.toString(), "02V: UNASSIGNED");

			// test for VRDroids (Assigned).
			vrDroid1.assign(device2);
			assertEquals(vrDroid1.toString(), "02V: 0000002 Man 2");

			// test for ExpertDroids (Not Assigned).
			expertDroid1 = new ExpertDroid();
			assertEquals(expertDroid1.toString(), "03E: UNASSIGNED");

			// test for ExpertDroids (Assigned).
			expertDroid1.assign(device1);
			assertEquals(expertDroid1.toString(), "03E: 0000001 Man 1");
		} catch (DroidDeviceMismatchException e) {
			throw new BadDeviceInformationException();
		} catch (DroidBusyException e) {
			throw new DroidBusyException();
		}
	}

}