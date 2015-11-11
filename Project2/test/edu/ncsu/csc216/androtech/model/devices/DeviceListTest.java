package edu.ncsu.csc216.androtech.model.devices;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

import edu.ncsu.csc216.androtech.model.util.SimpleIterator;

/**
 * The tester class for DeviceList class
 * @author Zachary R. Jones
 *
 */
public class DeviceListTest {
	/** DeviceList */
	private DeviceList deviceList;
	
	/** Device 1 -- ComDevice */
	private Device device1;
	/**
	 * The setup for DeviceListTest class
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		deviceList = new DeviceList();
		
		device1 = new ComDevice("0000001", "Man 1", 0);
		new VRDevice("0000002", "Man 2", 0);
		new ComDevice("0000003", "Man 3", 0);
		new VRDevice("0000004", "Man 4", 0);
		
		//Tests BadDeviceInformationException()
		try
		{
			throw new BadDeviceInformationException();
		}
		catch(BadDeviceInformationException e)
		{
			//do nothing
		}
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.androtech.model.devices.DeviceList#DeviceList(java.util.Scanner)}.
	 */
	@Test
	public void testDeviceListScanner() {
		try
		{
			Scanner sc = new Scanner(new File("noDevices.txt"));
			deviceList = new DeviceList(sc);
			assertTrue(!sc.hasNext());
			assertTrue(deviceList.front == null);
			sc = new Scanner(new File("oneDevice.txt"));
			deviceList = new DeviceList(sc);
			assertTrue(deviceList.front != null);
		}
		catch(FileNotFoundException e)
		{
			fail();
		}
		
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.androtech.model.devices.DeviceList#DeviceList()}.
	 */
	@Test
	public void testDeviceList() {
		deviceList = new DeviceList();
		assertTrue(deviceList.front == null);
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.androtech.model.devices.DeviceList#iterator()}.
	 */
	@Test
	public void testIterator() {
		deviceList = new DeviceList();
		deviceList.add(device1);
		SimpleIterator<Device> cursor = deviceList.iterator();
		assertEquals(deviceList.iterator().hasNext(), cursor.hasNext());
		assertEquals(deviceList.iterator().next(), cursor.next());
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.androtech.model.devices.DeviceList#remove(java.lang.String, int)}.
	 */
	@Test
	public void testRemove() {
		deviceList = new DeviceList();
		assertTrue(deviceList.front == null);
		deviceList.remove("",  0);
		assertTrue(deviceList.front == null);
		deviceList.remove("",  1);
		assertTrue(deviceList.front == null);
		deviceList.add(device1);
		assertTrue(deviceList.front != null);
		deviceList.remove("",  0);
		assertTrue(deviceList.front == null);
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.androtech.model.devices.DeviceList#add(edu.ncsu.csc216.androtech.model.devices.Device)}.
	 */
	@Test 
	public void testAdd() {
		deviceList = new DeviceList();
		assertTrue(deviceList.front == null);
		deviceList.add(device1);
		assertTrue(deviceList.front != null);
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.androtech.model.devices.DeviceList#filteredList(java.lang.String)}.
	 */
	@Test
	public void testFilteredList() {
		assertTrue(deviceList.filteredList("a").equals(""));
		deviceList.add(device1);
		assertTrue(deviceList.filteredList("m").equals("C No Plan   0000001 Man 1"));
		assertTrue(deviceList.filteredList("M").equals("C No Plan   0000001 Man 1"));
		deviceList.add(device1);
		assertTrue(deviceList.filteredList("m").equals("C No Plan   0000001 Man 1\nC No Plan   0000001 Man 1"));
	}
}