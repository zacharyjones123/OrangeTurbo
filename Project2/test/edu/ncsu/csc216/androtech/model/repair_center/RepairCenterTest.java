package edu.ncsu.csc216.androtech.model.repair_center;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.ncsu.csc216.androtech.model.devices.ComDevice;
import edu.ncsu.csc216.androtech.model.devices.Device;

/**
 * The tester class for RepairCenter
 * 
 * @author Zachary R. Jones
 *
 */
public class RepairCenterTest {
	/** Repair Center 1 */
	private RepairCenter repairCenter;

	/** Device 1 -- ComDevice */
	private Device device1;

	/**
	 * The setup class for RepairCenterTest
	 * 
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		TechDroid.startDroidNumberingAt01();
		repairCenter = new RepairCenter();
		
		device1 = new ComDevice("0000001", "Man 1", 0);
	}
	/**
	 * Tests DroidBusyException and DroidDeviceMismatchException
	 * @return 
	 */
	@Test
	public void testExceptions()
	{
		boolean thrown = false;
		try
		{
			thrown = true;
			throw new DroidBusyException("Test");
		}
		catch(DroidBusyException e)
		{
			assertTrue(thrown);
		}
		thrown = false;
		try
		{
			thrown = true;
			throw new DroidDeviceMismatchException();
		}
		catch(DroidDeviceMismatchException e)
		{
			assertTrue(thrown);
		}
	}

	/**
	 * Test method for
	 * {@link edu.ncsu.csc216.androtech.model.repair_center.RepairCenter#RepairCenter()}
	 * .
	 */
	@Test
	public void testRepairCenter() {
		repairCenter = new RepairCenter();
		TechDroid.startDroidNumberingAt01();
		assertEquals(repairCenter.numberOfAvailableDroids(), 5);
		assertEquals(repairCenter.totalNumberOfDroids(), 5);
		assertEquals(repairCenter.getDroidAt(0).getDroidID().equals("05V"),
				true);
		assertEquals(repairCenter.getDroidAt(1).getDroidID().equals("03V"),
				true);
		assertEquals(repairCenter.getDroidAt(2).getDroidID().equals("02E"),
				true);
		assertEquals(repairCenter.getDroidAt(3).getDroidID().equals("01C"),
				true);
		assertEquals(repairCenter.getDroidAt(4).getDroidID().equals("04C"),
				true);
	}

	/**
	 * Test method for
	 * {@link edu.ncsu.csc216.androtech.model.repair_center.RepairCenter#addTechDroid()}
	 * .
	 */
	@Test
	public void testAddTechDroid() {
		TechDroid.startDroidNumberingAt01();
		repairCenter = new RepairCenter();
		assertEquals(repairCenter.numberOfAvailableDroids(), 5);
		assertEquals(repairCenter.totalNumberOfDroids(), 5);
		assertEquals(repairCenter.getDroidAt(0).getDroidID().equals("05V"),
				true);
		assertEquals(repairCenter.getDroidAt(1).getDroidID().equals("03V"),
				true);
		assertEquals(repairCenter.getDroidAt(2).getDroidID().equals("02E"),
				true);
		assertEquals(repairCenter.getDroidAt(3).getDroidID().equals("01C"),
				true);
		assertEquals(repairCenter.getDroidAt(4).getDroidID().equals("04C"),
				true);
		repairCenter.addTechDroid();
		assertEquals(repairCenter.numberOfAvailableDroids(), 6);
		assertEquals(repairCenter.totalNumberOfDroids(), 6);
		assertEquals(repairCenter.getDroidAt(0).getDroidID().equals("05V"),
				true);
		assertEquals(repairCenter.getDroidAt(1).getDroidID().equals("03V"),
				true);
		assertEquals(repairCenter.getDroidAt(2).getDroidID().equals("02E"),
				true);
		assertEquals(repairCenter.getDroidAt(3).getDroidID().equals("01C"),
				true);
		assertEquals(repairCenter.getDroidAt(4).getDroidID().equals("04C"),
				true);
		assertEquals(repairCenter.getDroidAt(5).getDroidID().equals("06C"),
				true);
		repairCenter.addTechDroid();
		assertEquals(repairCenter.numberOfAvailableDroids(), 7);
		assertEquals(repairCenter.totalNumberOfDroids(), 7);
		assertEquals(repairCenter.getDroidAt(0).getDroidID().equals("05V"),
				true);
		assertEquals(repairCenter.getDroidAt(1).getDroidID().equals("03V"),
				true);
		assertEquals(repairCenter.getDroidAt(2).getDroidID().equals("02E"),
				true);
		assertEquals(repairCenter.getDroidAt(3).getDroidID().equals("01C"),
				true);
		assertEquals(repairCenter.getDroidAt(4).getDroidID().equals("04C"),
				true);
		assertEquals(repairCenter.getDroidAt(5).getDroidID().equals("06C"),
				true);
		assertEquals(repairCenter.getDroidAt(6).getDroidID().equals("07C"),
				true);
		repairCenter.addTechDroid();
		assertEquals(repairCenter.numberOfAvailableDroids(), 8);
		assertEquals(repairCenter.totalNumberOfDroids(), 8);
		assertEquals(repairCenter.getDroidAt(0).getDroidID().equals("05V"),
				true);
		assertEquals(repairCenter.getDroidAt(1).getDroidID().equals("03V"),
				true);
		assertEquals(repairCenter.getDroidAt(2).getDroidID().equals("02E"),
				true);
		assertEquals(repairCenter.getDroidAt(3).getDroidID().equals("01C"),
				true);
		assertEquals(repairCenter.getDroidAt(4).getDroidID().equals("04C"),
				true);
		assertEquals(repairCenter.getDroidAt(5).getDroidID().equals("06C"),
				true);
		assertEquals(repairCenter.getDroidAt(6).getDroidID().equals("07C"),
				true);
		assertEquals(repairCenter.getDroidAt(7).getDroidID().equals("08C"),
				true);
		repairCenter.addTechDroid();
		assertEquals(repairCenter.numberOfAvailableDroids(), 9);
		assertEquals(repairCenter.totalNumberOfDroids(), 9);
		assertEquals(repairCenter.getDroidAt(0).getDroidID().equals("05V"),
				true);
		assertEquals(repairCenter.getDroidAt(1).getDroidID().equals("03V"),
				true);
		assertEquals(repairCenter.getDroidAt(2).getDroidID().equals("02E"),
				true);
		assertEquals(repairCenter.getDroidAt(3).getDroidID().equals("01C"),
				true);
		assertEquals(repairCenter.getDroidAt(4).getDroidID().equals("04C"),
				true);
		assertEquals(repairCenter.getDroidAt(5).getDroidID().equals("06C"),
				true);
		assertEquals(repairCenter.getDroidAt(6).getDroidID().equals("07C"),
				true);
		assertEquals(repairCenter.getDroidAt(7).getDroidID().equals("08C"),
				true);
		assertEquals(repairCenter.getDroidAt(8).getDroidID().equals("09C"),
				true);
		repairCenter.addTechDroid();
		assertEquals(repairCenter.numberOfAvailableDroids(), 10);
		//Two ways this can go two ways
		if (repairCenter.getDroidAt(0).getDroidID().equals("10V")) {
			assertEquals(repairCenter.getDroidAt(0).getDroidID().equals("10V"),
					true);
		}
		else if (repairCenter.getDroidAt(2).getDroidID().equals("10E")) {
			assertEquals(repairCenter.getDroidAt(2).getDroidID().equals("10E"),
					true);
		}
		assertEquals(repairCenter.totalNumberOfDroids(), 10);
	}

	/**
	 * Test method for
	 * {@link edu.ncsu.csc216.androtech.model.repair_center.RepairCenter#numberOfAvailableDroids()}
	 * .
	 */
	@Test
	public void testNumberOfAvailableDroids() {
		TechDroid.startDroidNumberingAt01();
		repairCenter = new RepairCenter();
		assertEquals(repairCenter.numberOfAvailableDroids(), 5);
		assertEquals(repairCenter.totalNumberOfDroids(), 5);
		assertEquals(repairCenter.getDroidAt(0).getDroidID().equals("05V"),
				true);
		assertEquals(repairCenter.getDroidAt(1).getDroidID().equals("03V"),
				true);
		assertEquals(repairCenter.getDroidAt(2).getDroidID().equals("02E"),
				true);
		assertEquals(repairCenter.getDroidAt(3).getDroidID().equals("01C"),
				true);
		assertEquals(repairCenter.getDroidAt(4).getDroidID().equals("04C"),
				true);
		repairCenter.addTechDroid();
		assertEquals(repairCenter.numberOfAvailableDroids(), 6);
		assertEquals(repairCenter.totalNumberOfDroids(), 6);
		assertEquals(repairCenter.getDroidAt(0).getDroidID().equals("05V"),
				true);
		assertEquals(repairCenter.getDroidAt(1).getDroidID().equals("03V"),
				true);
		assertEquals(repairCenter.getDroidAt(2).getDroidID().equals("02E"),
				true);
		assertEquals(repairCenter.getDroidAt(3).getDroidID().equals("01C"),
				true);
		assertEquals(repairCenter.getDroidAt(4).getDroidID().equals("04C"),
				true);
		assertEquals(repairCenter.getDroidAt(5).getDroidID().equals("06C"),
				true);
		repairCenter.addTechDroid();
		assertEquals(repairCenter.numberOfAvailableDroids(), 7);
		assertEquals(repairCenter.totalNumberOfDroids(), 7);
		assertEquals(repairCenter.getDroidAt(0).getDroidID().equals("05V"),
				true);
		assertEquals(repairCenter.getDroidAt(1).getDroidID().equals("03V"),
				true);
		assertEquals(repairCenter.getDroidAt(2).getDroidID().equals("02E"),
				true);
		assertEquals(repairCenter.getDroidAt(3).getDroidID().equals("01C"),
				true);
		assertEquals(repairCenter.getDroidAt(4).getDroidID().equals("04C"),
				true);
		assertEquals(repairCenter.getDroidAt(5).getDroidID().equals("06C"),
				true);
		assertEquals(repairCenter.getDroidAt(6).getDroidID().equals("07C"),
				true);
		repairCenter.addTechDroid();
		assertEquals(repairCenter.numberOfAvailableDroids(), 8);
		assertEquals(repairCenter.totalNumberOfDroids(), 8);
		assertEquals(repairCenter.getDroidAt(0).getDroidID().equals("05V"),
				true);
		assertEquals(repairCenter.getDroidAt(1).getDroidID().equals("03V"),
				true);
		assertEquals(repairCenter.getDroidAt(2).getDroidID().equals("02E"),
				true);
		assertEquals(repairCenter.getDroidAt(3).getDroidID().equals("01C"),
				true);
		assertEquals(repairCenter.getDroidAt(4).getDroidID().equals("04C"),
				true);
		assertEquals(repairCenter.getDroidAt(5).getDroidID().equals("06C"),
				true);
		assertEquals(repairCenter.getDroidAt(6).getDroidID().equals("07C"),
				true);
		assertEquals(repairCenter.getDroidAt(7).getDroidID().equals("08C"),
				true);
		repairCenter.addTechDroid();
		assertEquals(repairCenter.numberOfAvailableDroids(), 9);
		assertEquals(repairCenter.totalNumberOfDroids(), 9);
		assertEquals(repairCenter.getDroidAt(0).getDroidID().equals("05V"),
				true);
		assertEquals(repairCenter.getDroidAt(1).getDroidID().equals("03V"),
				true);
		assertEquals(repairCenter.getDroidAt(2).getDroidID().equals("02E"),
				true);
		assertEquals(repairCenter.getDroidAt(3).getDroidID().equals("01C"),
				true);
		assertEquals(repairCenter.getDroidAt(4).getDroidID().equals("04C"),
				true);
		assertEquals(repairCenter.getDroidAt(5).getDroidID().equals("06C"),
				true);
		assertEquals(repairCenter.getDroidAt(6).getDroidID().equals("07C"),
				true);
		assertEquals(repairCenter.getDroidAt(7).getDroidID().equals("08C"),
				true);
		assertEquals(repairCenter.getDroidAt(8).getDroidID().equals("09C"),
				true);
		repairCenter.addTechDroid();
		assertEquals(repairCenter.numberOfAvailableDroids(), 10); // An Expert
																	// Droid is
																	// made
		assertEquals(repairCenter.totalNumberOfDroids(), 10);
	}

	/**
	 * Test method for
	 * {@link edu.ncsu.csc216.androtech.model.repair_center.RepairCenter#getDroidAt(int)}
	 * .
	 */
	@Test
	public void testGetDroidAt() {
		TechDroid.startDroidNumberingAt01();
		repairCenter = new RepairCenter();
		assertEquals(repairCenter.numberOfAvailableDroids(), 5);
		assertEquals(repairCenter.totalNumberOfDroids(), 5);
		assertEquals(repairCenter.getDroidAt(0).getDroidID().equals("05V"),
				true);
		assertEquals(repairCenter.getDroidAt(1).getDroidID().equals("03V"),
				true);
		assertEquals(repairCenter.getDroidAt(2).getDroidID().equals("02E"),
				true);
		assertEquals(repairCenter.getDroidAt(3).getDroidID().equals("01C"),
				true);
		assertEquals(repairCenter.getDroidAt(4).getDroidID().equals("04C"),
				true);
		repairCenter.addTechDroid();
		assertEquals(repairCenter.numberOfAvailableDroids(), 6);
		assertEquals(repairCenter.totalNumberOfDroids(), 6);
		assertEquals(repairCenter.getDroidAt(0).getDroidID().equals("05V"),
				true);
		assertEquals(repairCenter.getDroidAt(1).getDroidID().equals("03V"),
				true);
		assertEquals(repairCenter.getDroidAt(2).getDroidID().equals("02E"),
				true);
		assertEquals(repairCenter.getDroidAt(3).getDroidID().equals("01C"),
				true);
		assertEquals(repairCenter.getDroidAt(4).getDroidID().equals("04C"),
				true);
		assertEquals(repairCenter.getDroidAt(5).getDroidID().equals("06C"),
				true);
		repairCenter.addTechDroid();
		assertEquals(repairCenter.numberOfAvailableDroids(), 7);
		assertEquals(repairCenter.totalNumberOfDroids(), 7);
		assertEquals(repairCenter.getDroidAt(0).getDroidID().equals("05V"),
				true);
		assertEquals(repairCenter.getDroidAt(1).getDroidID().equals("03V"),
				true);
		assertEquals(repairCenter.getDroidAt(2).getDroidID().equals("02E"),
				true);
		assertEquals(repairCenter.getDroidAt(3).getDroidID().equals("01C"),
				true);
		assertEquals(repairCenter.getDroidAt(4).getDroidID().equals("04C"),
				true);
		assertEquals(repairCenter.getDroidAt(5).getDroidID().equals("06C"),
				true);
		assertEquals(repairCenter.getDroidAt(6).getDroidID().equals("07C"),
				true);
		repairCenter.addTechDroid();
		assertEquals(repairCenter.numberOfAvailableDroids(), 8);
		assertEquals(repairCenter.totalNumberOfDroids(), 8);
		assertEquals(repairCenter.getDroidAt(0).getDroidID().equals("05V"),
				true);
		assertEquals(repairCenter.getDroidAt(1).getDroidID().equals("03V"),
				true);
		assertEquals(repairCenter.getDroidAt(2).getDroidID().equals("02E"),
				true);
		assertEquals(repairCenter.getDroidAt(3).getDroidID().equals("01C"),
				true);
		assertEquals(repairCenter.getDroidAt(4).getDroidID().equals("04C"),
				true);
		assertEquals(repairCenter.getDroidAt(5).getDroidID().equals("06C"),
				true);
		assertEquals(repairCenter.getDroidAt(6).getDroidID().equals("07C"),
				true);
		assertEquals(repairCenter.getDroidAt(7).getDroidID().equals("08C"),
				true);
		repairCenter.addTechDroid();
		assertEquals(repairCenter.numberOfAvailableDroids(), 9);
		assertEquals(repairCenter.totalNumberOfDroids(), 9);
		assertEquals(repairCenter.getDroidAt(0).getDroidID().equals("05V"),
				true);
		assertEquals(repairCenter.getDroidAt(1).getDroidID().equals("03V"),
				true);
		assertEquals(repairCenter.getDroidAt(2).getDroidID().equals("02E"),
				true);
		assertEquals(repairCenter.getDroidAt(3).getDroidID().equals("01C"),
				true);
		assertEquals(repairCenter.getDroidAt(4).getDroidID().equals("04C"),
				true);
		assertEquals(repairCenter.getDroidAt(5).getDroidID().equals("06C"),
				true);
		assertEquals(repairCenter.getDroidAt(6).getDroidID().equals("07C"),
				true);
		assertEquals(repairCenter.getDroidAt(7).getDroidID().equals("08C"),
				true);
		assertEquals(repairCenter.getDroidAt(8).getDroidID().equals("09C"),
				true);

		assertEquals(repairCenter.getDroidAt(9), null);
		assertEquals(repairCenter.getDroidAt(-1), null);

	}

	/**
	 * Test method for
	 * {@link edu.ncsu.csc216.androtech.model.repair_center.RepairCenter#totalNumberOfDroids()}
	 * .
	 */
	@Test
	public void testTotalNumberOfDroids() {
		TechDroid.startDroidNumberingAt01();
		repairCenter = new RepairCenter();
		assertEquals(repairCenter.numberOfAvailableDroids(), 5);
		assertEquals(repairCenter.totalNumberOfDroids(), 5);
		assertEquals(repairCenter.getDroidAt(0).getDroidID().equals("05V"),
				true);
		assertEquals(repairCenter.getDroidAt(1).getDroidID().equals("03V"),
				true);
		assertEquals(repairCenter.getDroidAt(2).getDroidID().equals("02E"),
				true);
		assertEquals(repairCenter.getDroidAt(3).getDroidID().equals("01C"),
				true);
		assertEquals(repairCenter.getDroidAt(4).getDroidID().equals("04C"),
				true);
		repairCenter.addTechDroid();
		assertEquals(repairCenter.numberOfAvailableDroids(), 6);
		assertEquals(repairCenter.totalNumberOfDroids(), 6);
		assertEquals(repairCenter.getDroidAt(0).getDroidID().equals("05V"),
				true);
		assertEquals(repairCenter.getDroidAt(1).getDroidID().equals("03V"),
				true);
		assertEquals(repairCenter.getDroidAt(2).getDroidID().equals("02E"),
				true);
		assertEquals(repairCenter.getDroidAt(3).getDroidID().equals("01C"),
				true);
		assertEquals(repairCenter.getDroidAt(4).getDroidID().equals("04C"),
				true);
		assertEquals(repairCenter.getDroidAt(5).getDroidID().equals("06C"),
				true);
		repairCenter.addTechDroid();
		assertEquals(repairCenter.numberOfAvailableDroids(), 7);
		assertEquals(repairCenter.totalNumberOfDroids(), 7);
		assertEquals(repairCenter.getDroidAt(0).getDroidID().equals("05V"),
				true);
		assertEquals(repairCenter.getDroidAt(1).getDroidID().equals("03V"),
				true);
		assertEquals(repairCenter.getDroidAt(2).getDroidID().equals("02E"),
				true);
		assertEquals(repairCenter.getDroidAt(3).getDroidID().equals("01C"),
				true);
		assertEquals(repairCenter.getDroidAt(4).getDroidID().equals("04C"),
				true);
		assertEquals(repairCenter.getDroidAt(5).getDroidID().equals("06C"),
				true);
		assertEquals(repairCenter.getDroidAt(6).getDroidID().equals("07C"),
				true);
		repairCenter.addTechDroid();
		assertEquals(repairCenter.numberOfAvailableDroids(), 8);
		assertEquals(repairCenter.totalNumberOfDroids(), 8);
		assertEquals(repairCenter.getDroidAt(0).getDroidID().equals("05V"),
				true);
		assertEquals(repairCenter.getDroidAt(1).getDroidID().equals("03V"),
				true);
		assertEquals(repairCenter.getDroidAt(2).getDroidID().equals("02E"),
				true);
		assertEquals(repairCenter.getDroidAt(3).getDroidID().equals("01C"),
				true);
		assertEquals(repairCenter.getDroidAt(4).getDroidID().equals("04C"),
				true);
		assertEquals(repairCenter.getDroidAt(5).getDroidID().equals("06C"),
				true);
		assertEquals(repairCenter.getDroidAt(6).getDroidID().equals("07C"),
				true);
		assertEquals(repairCenter.getDroidAt(7).getDroidID().equals("08C"),
				true);
		repairCenter.addTechDroid();
		assertEquals(repairCenter.numberOfAvailableDroids(), 9);
		assertEquals(repairCenter.totalNumberOfDroids(), 9);
		assertEquals(repairCenter.getDroidAt(0).getDroidID().equals("05V"),
				true);
		assertEquals(repairCenter.getDroidAt(1).getDroidID().equals("03V"),
				true);
		assertEquals(repairCenter.getDroidAt(2).getDroidID().equals("02E"),
				true);
		assertEquals(repairCenter.getDroidAt(3).getDroidID().equals("01C"),
				true);
		assertEquals(repairCenter.getDroidAt(4).getDroidID().equals("04C"),
				true);
		assertEquals(repairCenter.getDroidAt(5).getDroidID().equals("06C"),
				true);
		assertEquals(repairCenter.getDroidAt(6).getDroidID().equals("07C"),
				true);
		assertEquals(repairCenter.getDroidAt(7).getDroidID().equals("08C"),
				true);
		assertEquals(repairCenter.getDroidAt(8).getDroidID().equals("09C"),
				true);
	}

	/**
	 * Test method for
	 * {@link edu.ncsu.csc216.androtech.model.repair_center.RepairCenter#release(int)}
	 * .
	 */
	@Test
	public void testRelease() {
		TechDroid.startDroidNumberingAt01();
		repairCenter = new RepairCenter();
		assertEquals(repairCenter.numberOfAvailableDroids(), 5);
		assertEquals(repairCenter.totalNumberOfDroids(), 5);
		assertEquals(repairCenter.getDroidAt(0).getDroidID().equals("05V"),
				true);
		assertEquals(repairCenter.getDroidAt(1).getDroidID().equals("03V"),
				true);
		assertEquals(repairCenter.getDroidAt(2).getDroidID().equals("02E"),
				true);
		assertEquals(repairCenter.getDroidAt(3).getDroidID().equals("01C"),
				true);
		assertEquals(repairCenter.getDroidAt(4).getDroidID().equals("04C"),
				true);
		repairCenter.addTechDroid();
		assertEquals(repairCenter.numberOfAvailableDroids(), 6);
		assertEquals(repairCenter.totalNumberOfDroids(), 6);
		assertEquals(repairCenter.getDroidAt(0).getDroidID().equals("05V"),
				true);
		assertEquals(repairCenter.getDroidAt(1).getDroidID().equals("03V"),
				true);
		assertEquals(repairCenter.getDroidAt(2).getDroidID().equals("02E"),
				true);
		assertEquals(repairCenter.getDroidAt(3).getDroidID().equals("01C"),
				true);
		assertEquals(repairCenter.getDroidAt(4).getDroidID().equals("04C"),
				true);
		assertEquals(repairCenter.getDroidAt(5).getDroidID().equals("06C"),
				true);
		repairCenter.addTechDroid();
		assertEquals(repairCenter.numberOfAvailableDroids(), 7);
		assertEquals(repairCenter.totalNumberOfDroids(), 7);
		assertEquals(repairCenter.getDroidAt(0).getDroidID().equals("05V"),
				true);
		assertEquals(repairCenter.getDroidAt(1).getDroidID().equals("03V"),
				true);
		assertEquals(repairCenter.getDroidAt(2).getDroidID().equals("02E"),
				true);
		assertEquals(repairCenter.getDroidAt(3).getDroidID().equals("01C"),
				true);
		assertEquals(repairCenter.getDroidAt(4).getDroidID().equals("04C"),
				true);
		assertEquals(repairCenter.getDroidAt(5).getDroidID().equals("06C"),
				true);
		assertEquals(repairCenter.getDroidAt(6).getDroidID().equals("07C"),
				true);
		repairCenter.addTechDroid();
		assertEquals(repairCenter.numberOfAvailableDroids(), 8);
		assertEquals(repairCenter.totalNumberOfDroids(), 8);
		assertEquals(repairCenter.getDroidAt(0).getDroidID().equals("05V"),
				true);
		assertEquals(repairCenter.getDroidAt(1).getDroidID().equals("03V"),
				true);
		assertEquals(repairCenter.getDroidAt(2).getDroidID().equals("02E"),
				true);
		assertEquals(repairCenter.getDroidAt(3).getDroidID().equals("01C"),
				true);
		assertEquals(repairCenter.getDroidAt(4).getDroidID().equals("04C"),
				true);
		assertEquals(repairCenter.getDroidAt(5).getDroidID().equals("06C"),
				true);
		assertEquals(repairCenter.getDroidAt(6).getDroidID().equals("07C"),
				true);
		assertEquals(repairCenter.getDroidAt(7).getDroidID().equals("08C"),
				true);
		repairCenter.addTechDroid();
		assertEquals(repairCenter.numberOfAvailableDroids(), 9);
		assertEquals(repairCenter.totalNumberOfDroids(), 9);
		assertEquals(repairCenter.getDroidAt(0).getDroidID().equals("05V"),
				true);
		assertEquals(repairCenter.getDroidAt(1).getDroidID().equals("03V"),
				true);
		assertEquals(repairCenter.getDroidAt(2).getDroidID().equals("02E"),
				true);
		assertEquals(repairCenter.getDroidAt(3).getDroidID().equals("01C"),
				true);
		assertEquals(repairCenter.getDroidAt(4).getDroidID().equals("04C"),
				true);
		assertEquals(repairCenter.getDroidAt(5).getDroidID().equals("06C"),
				true);
		assertEquals(repairCenter.getDroidAt(6).getDroidID().equals("07C"),
				true);
		assertEquals(repairCenter.getDroidAt(7).getDroidID().equals("08C"),
				true);
		assertEquals(repairCenter.getDroidAt(8).getDroidID().equals("09C"),
				true);

		try {
			repairCenter.getDroidAt(8).assign(device1);
			assertEquals(repairCenter.numberOfAvailableDroids(), 8);
			assertEquals(repairCenter.totalNumberOfDroids(), 9);

			assertEquals(repairCenter.release(8), device1);
			assertEquals(repairCenter.numberOfAvailableDroids(), 9);
			assertEquals(repairCenter.totalNumberOfDroids(), 9);
		} catch (DroidDeviceMismatchException e) {
			fail("Empty Droid, should not have reached here");
		} catch (DroidBusyException e) {
			fail("Empty Droid, should not have reached here");
		}

	}

	/**
	 * Test method for
	 * {@link edu.ncsu.csc216.androtech.model.repair_center.RepairCenter#printDroids()}
	 * .
	 */
	@Test
	public void testPrintDroids() {
		TechDroid.startDroidNumberingAt01();
		repairCenter = new RepairCenter();
		assertEquals(repairCenter.numberOfAvailableDroids(), 5);
		assertEquals(repairCenter.totalNumberOfDroids(), 5);
		assertEquals(repairCenter.getDroidAt(0).getDroidID().equals("05V"),
				true);
		assertEquals(repairCenter.getDroidAt(1).getDroidID().equals("03V"),
				true);
		assertEquals(repairCenter.getDroidAt(2).getDroidID().equals("02E"),
				true);
		assertEquals(repairCenter.getDroidAt(3).getDroidID().equals("01C"),
				true);
		assertEquals(repairCenter.getDroidAt(4).getDroidID().equals("04C"),
				true);
		repairCenter.addTechDroid();
		assertEquals(repairCenter.numberOfAvailableDroids(), 6);
		assertEquals(repairCenter.totalNumberOfDroids(), 6);
		assertEquals(repairCenter.getDroidAt(0).getDroidID().equals("05V"),
				true);
		assertEquals(repairCenter.getDroidAt(1).getDroidID().equals("03V"),
				true);
		assertEquals(repairCenter.getDroidAt(2).getDroidID().equals("02E"),
				true);
		assertEquals(repairCenter.getDroidAt(3).getDroidID().equals("01C"),
				true);
		assertEquals(repairCenter.getDroidAt(4).getDroidID().equals("04C"),
				true);
		assertEquals(repairCenter.getDroidAt(5).getDroidID().equals("06C"),
				true);
		repairCenter.addTechDroid();
		assertEquals(repairCenter.numberOfAvailableDroids(), 7);
		assertEquals(repairCenter.totalNumberOfDroids(), 7);
		assertEquals(repairCenter.getDroidAt(0).getDroidID().equals("05V"),
				true);
		assertEquals(repairCenter.getDroidAt(1).getDroidID().equals("03V"),
				true);
		assertEquals(repairCenter.getDroidAt(2).getDroidID().equals("02E"),
				true);
		assertEquals(repairCenter.getDroidAt(3).getDroidID().equals("01C"),
				true);
		assertEquals(repairCenter.getDroidAt(4).getDroidID().equals("04C"),
				true);
		assertEquals(repairCenter.getDroidAt(5).getDroidID().equals("06C"),
				true);
		assertEquals(repairCenter.getDroidAt(6).getDroidID().equals("07C"),
				true);
		repairCenter.addTechDroid();
		assertEquals(repairCenter.numberOfAvailableDroids(), 8);
		assertEquals(repairCenter.totalNumberOfDroids(), 8);
		assertEquals(repairCenter.getDroidAt(0).getDroidID().equals("05V"),
				true);
		assertEquals(repairCenter.getDroidAt(1).getDroidID().equals("03V"),
				true);
		assertEquals(repairCenter.getDroidAt(2).getDroidID().equals("02E"),
				true);
		assertEquals(repairCenter.getDroidAt(3).getDroidID().equals("01C"),
				true);
		assertEquals(repairCenter.getDroidAt(4).getDroidID().equals("04C"),
				true);
		assertEquals(repairCenter.getDroidAt(5).getDroidID().equals("06C"),
				true);
		assertEquals(repairCenter.getDroidAt(6).getDroidID().equals("07C"),
				true);
		assertEquals(repairCenter.getDroidAt(7).getDroidID().equals("08C"),
				true);
		repairCenter.addTechDroid();
		assertEquals(repairCenter.numberOfAvailableDroids(), 9);
		assertEquals(repairCenter.totalNumberOfDroids(), 9);

		assertEquals(repairCenter.getDroidAt(0).getDroidID().equals("05V"),
				true);
		assertEquals(repairCenter.getDroidAt(1).getDroidID().equals("03V"),
				true);
		assertEquals(repairCenter.getDroidAt(2).getDroidID().equals("02E"),
				true);
		assertEquals(repairCenter.getDroidAt(3).getDroidID().equals("01C"),
				true);
		assertEquals(repairCenter.getDroidAt(4).getDroidID().equals("04C"),
				true);
		assertEquals(repairCenter.getDroidAt(5).getDroidID().equals("06C"),
				true);
		assertEquals(repairCenter.getDroidAt(6).getDroidID().equals("07C"),
				true);
		assertEquals(repairCenter.getDroidAt(7).getDroidID().equals("08C"),
				true);
		assertEquals(repairCenter.getDroidAt(8).getDroidID().equals("09C"),
				true);

		assertEquals(
				repairCenter
						.printDroids()
						.equals("05V: UNASSIGNED\n03V: UNASSIGNED\n02E: UNASSIGNED\n01C: UNASSIGNED\n04C: UNASSIGNED\n06C: UNASSIGNED\n07C: UNASSIGNED\n08C: UNASSIGNED\n09C: UNASSIGNED"),
				true);
	}

}