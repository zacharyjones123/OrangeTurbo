package edu.ncsu.csc216.androtech.model.management;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

import edu.ncsu.csc216.androtech.model.devices.ComDevice;
import edu.ncsu.csc216.androtech.model.devices.Device;
import edu.ncsu.csc216.androtech.model.devices.DeviceList;
import edu.ncsu.csc216.androtech.model.devices.Prioritizable;
import edu.ncsu.csc216.androtech.model.devices.VRDevice;
import edu.ncsu.csc216.androtech.model.repair_center.RepairCenter;

/**
 * The tester class for ServiceManager
 * 
 * @author Zachary R. Jones
 *
 */
public class ServiceManagerTest {

	// Scanner
	private Scanner scanner;

	// Service Manager
	/** A Service Manager -- without file */
	private ServiceManager serviceManager;

	// Devices
	/** A vrDevice */
	private Device vRDevice1;
	/** A comDevice */
	private Device comDevice1;

	/**
	 * The setup for the ServiceManagerTest
	 * 
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {

		// Service Manager
		serviceManager = new ServiceManager();
		new ServiceManager(new Scanner(new File(
				"teacherExample.txt")));

		new RepairCenter();

		new DeviceList();

		// Devices
		vRDevice1 = new VRDevice("0987-N-817", "Fath Hoth", 2);
		comDevice1 = new ComDevice("0987-N-817", "Fath Hoth", 2);
	}

	/**
	 * Test method for
	 * {@link edu.ncsu.csc216.androtech.model.management.ServiceManager#ServiceManager()}
	 * .
	 */
	@Test
	public void testServiceManager() {
		serviceManager = new ServiceManager();
		assertEquals(serviceManager.printWaitList(""), "");
	}

	/**
	 * Test method for
	 * {@link edu.ncsu.csc216.androtech.model.management.ServiceManager#ServiceManager(java.util.Scanner)}
	 * .
	 */
	@Test
	public void testServiceManagerScanner() {
		boolean thrown = true;
		try {
			scanner = new Scanner(new File("oneDevice.txt"));
			serviceManager = new ServiceManager(scanner);
			assertTrue(serviceManager.printWaitList("").equals("V Gold      0987-N-817 Fath Hoth"));
		} catch (FileNotFoundException e) {
			thrown = false;
		}
		assertTrue(thrown);
		// assertEquals(serviceManager.printWaitList(
	}

	/**
	 * Test method for
	 * {@link edu.ncsu.csc216.androtech.model.management.ServiceManager#assignDroids()}
	 * .
	 */
	@Test
	public void testAssignDroids() {
		serviceManager = new ServiceManager();
		serviceManager.putOnWaitingList(vRDevice1);
		serviceManager.putOnWaitingList(comDevice1);
		assertEquals(serviceManager.printWaitList(""),
				"V Gold      0987-N-817 Fath Hoth\nC Gold      0987-N-817 Fath Hoth");
		serviceManager.assignDroids();
		assertEquals(serviceManager.printWaitList("").equals(""), true);
		assertEquals(serviceManager.printDroids().equals("05V: 0987-N-817 Fath Hoth\n03V: UNASSIGNED\n02E:"
				+ " UNASSIGNED\n01C: UNASSIGNED\n04C: 0987-N-817 Fath Hoth"), true);
	}

	/**
	 * Test method for
	 * {@link edu.ncsu.csc216.androtech.model.management.ServiceManager#remove(java.lang.String, int)}
	 * .
	 */
	@Test
	public void testRemove() {
		boolean thrown = true;
		try {
			scanner = new Scanner(new File("oneDevice.txt"));
			serviceManager = new ServiceManager(scanner);
			assertEquals(serviceManager.printWaitList(""),
					"V Gold      0987-N-817 Fath Hoth");
			serviceManager.remove("" , 0);
			assertTrue(serviceManager.printWaitList("").equals(""));
		} catch (FileNotFoundException e) {
			thrown = false;
		}
		assertTrue(thrown);
	}

	/**
	 * Test method for
	 * {@link edu.ncsu.csc216.androtech.model.management.ServiceManager#releaseFromService(int)}
	 * .
	 */
	@Test
	public void testReleaseFromService() {
		boolean thrown = true;
		try {
			scanner = new Scanner(new File("oneDevice.txt"));
			serviceManager = new ServiceManager(scanner);
			assertEquals(serviceManager.printWaitList(""),
					"V Gold      0987-N-817 Fath Hoth");
			serviceManager.assignDroids();
			assertTrue(serviceManager.printDroids().equals("05V: 0987-N-817 Fath Hoth\n03V:"
					+ " UNASSIGNED\n02E: UNASSIGNED\n01C: UNASSIGNED\n04C: UNASSIGNED"));
			serviceManager.releaseFromService(0);
			assertTrue(serviceManager.printDroids().equals("05V: UNASSIGNED\n03V:"
					+ " UNASSIGNED\n02E: UNASSIGNED\n01C: UNASSIGNED\n04C: UNASSIGNED"));
		} catch (FileNotFoundException e) {
			thrown = false;
		}
		assertTrue(thrown);
	}

	/**
	 * Test method for
	 * {@link edu.ncsu.csc216.androtech.model.management.ServiceManager#addNewDroid()}
	 * .
	 */
	@Test
	public void testAddNewDroid() {
		serviceManager = new ServiceManager();
		assertTrue(serviceManager.printDroids().equals("05V: UNASSIGNED\n03V: UNASSIGNED\n02E: "
				+ "UNASSIGNED\n01C: UNASSIGNED\n04C: UNASSIGNED"));
		serviceManager.addNewDroid();
		assertTrue(serviceManager.printDroids().equals("05V: UNASSIGNED\n03V: UNASSIGNED\n02E: "
				+ "UNASSIGNED\n01C: UNASSIGNED\n04C: UNASSIGNED\n06C: UNASSIGNED"));

	}

	/**
	 * Test method for
	 * {@link edu.ncsu.csc216.androtech.model.management.ServiceManager#printWaitList(java.lang.String)}
	 * .
	 */
	@Test
	public void testPrintWaitList() {
		boolean thrown = true;
		try {
			scanner = new Scanner(new File("oneDevice.txt"));
			serviceManager = new ServiceManager(scanner);
			assertEquals(serviceManager.printWaitList(""),
					"V Gold      0987-N-817 Fath Hoth");
		} catch (FileNotFoundException e) {
			thrown = false;
		}
		assertTrue(thrown);
	}

	/**
	 * Test method for
	 * {@link edu.ncsu.csc216.androtech.model.management.ServiceManager#printDroids()}
	 * .
	 */
	@Test
	public void testPrintDroids() {
		serviceManager = new ServiceManager();
		boolean thrown = true;
		try {
			scanner = new Scanner(new File("oneDevice.txt"));
			serviceManager = new ServiceManager(scanner);
			assertEquals(serviceManager.printDroids().equals("05V: UNASSIGNED\n03V: UNASSIGNED\n02E: UNASSIGNED\n01C: UNASSIGNED\n04C: UNASSIGNED"), true);
			assertEquals(serviceManager.printWaitList("").equals("V Gold      0987-N-817 Fath Hoth"), true);
			serviceManager.assignDroids();
			assertEquals(serviceManager.printWaitList("").equals(""), true);
			assertEquals(serviceManager.printDroids().equals("05V: 0987-N-817 Fath Hoth\n03V: UNASSIGNED\n02E: UNASSIGNED\n01C: UNASSIGNED\n04C: UNASSIGNED"), true);
		} catch (FileNotFoundException e) {
			thrown = false;
		}
		assertTrue(thrown);
	}

	/**
	 * Test method for
	 * {@link edu.ncsu.csc216.androtech.model.management.ServiceManager#putOnWaitingList(java.lang.String, java.lang.String, java.lang.String, int)}
	 * .
	 */
	@Test
	public void testPutOnWaitingListStringStringStringInt() {
		serviceManager.putOnWaitingList("V", "0987-N-817" , "Fath Hoth" , 3);
		assertEquals(serviceManager.printWaitList("").equals("V Platinum  0987-N-817 Fath Hoth"), true);
	}

	/**
	 * Test method for
	 * {@link edu.ncsu.csc216.androtech.model.management.ServiceManager#putOnWaitingList(edu.ncsu.csc216.androtech.model.devices.Prioritizable)}
	 * .
	 */
	@Test
	public void testPutOnWaitingListPrioritizable() {
		Prioritizable p1 = vRDevice1;
		Prioritizable p2 = comDevice1;
		serviceManager = new ServiceManager();
		serviceManager.putOnWaitingList(p1);
		serviceManager.putOnWaitingList(p2);
		assertEquals(serviceManager.printWaitList("").equals("V Gold      0987-N-817 Fath Hoth\nC Gold      0987-N-817 Fath Hoth"), true);
	}

}