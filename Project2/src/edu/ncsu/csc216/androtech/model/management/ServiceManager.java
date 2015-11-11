package edu.ncsu.csc216.androtech.model.management;

import java.util.Scanner;

import edu.ncsu.csc216.androtech.model.devices.BadDeviceInformationException;
import edu.ncsu.csc216.androtech.model.devices.ComDevice;
import edu.ncsu.csc216.androtech.model.devices.Device;
import edu.ncsu.csc216.androtech.model.devices.DeviceList;
import edu.ncsu.csc216.androtech.model.devices.Prioritizable;
import edu.ncsu.csc216.androtech.model.devices.VRDevice;
import edu.ncsu.csc216.androtech.model.repair_center.ComDroid;
import edu.ncsu.csc216.androtech.model.repair_center.DroidBusyException;
import edu.ncsu.csc216.androtech.model.repair_center.DroidDeviceMismatchException;
import edu.ncsu.csc216.androtech.model.repair_center.ExpertDroid;
import edu.ncsu.csc216.androtech.model.repair_center.RepairCenter;
import edu.ncsu.csc216.androtech.model.repair_center.TechDroid;
import edu.ncsu.csc216.androtech.model.repair_center.VRDroid;

/**
 * The central model for the AndroTech Repair Facility.
 * Manages both a list of Devices and a list of TechDroids capable
 * of servicing those Devices
 * 
 * @author Zachary R. Jones
 * @author Tyler Albert
 */
public class ServiceManager implements Manager {
	/** A repair center that manages TechDroids */
	private RepairCenter androTech = new RepairCenter();
	/** A DeviceList for managing Devices */
	private DeviceList devicesWaiting;
	/**
	 * Constructs a ServiceManager, the model for the AndroTech
	 * repair facility.
	 */
	public ServiceManager() {
		devicesWaiting = new DeviceList();
	}
	
	/**
	 * An alternative constructor of the Service Manager with a Scanner.
	 * @param inputFile a Scanner reading from a provided file
	 */
	public ServiceManager(Scanner inputFile) {	
		devicesWaiting = new DeviceList(inputFile);
	}
	
	/**
	 * This method assigns Devices to appropriate TechDroids
	 * for service
	 */
	public void assignDroids() {
		/** Scanner for reading in lines from the Device waiting list list */
		Scanner deviceListReader = new Scanner(devicesWaiting.filteredList(""));
		/** A String representation of a Device, read in from the list of Devices */
		String deviceLine = "";
		/** Counting variable */
		int i = 0;
		while(deviceListReader.hasNextLine())
		{
			deviceLine = deviceListReader.nextLine();
			if(deviceLine.substring(0 , 1).equalsIgnoreCase("v"))
			{
				/** A TechDroid capable of servicing a VRDevice */
				TechDroid vRAble = getNextVRAbleDroid();
				if(vRAble != null)
				{
					try {
						vRAble.assign(devicesWaiting.remove("", i));
						i--;
					} catch (DroidBusyException e) {
						//do nothing
					} catch (DroidDeviceMismatchException e) {
						//do nothing
					}
				}
			}
			else if(deviceLine.substring(0 , 1).equalsIgnoreCase("c"))
			{
				/** A TechDroid capable of servicing a ComDevice */
				TechDroid comAble = getNextComAbleDroid();
				if(comAble != null)
				{
					try {
						comAble.assign(devicesWaiting.remove("", i));
						i--;
					} catch (DroidBusyException e) {
						//do nothing
					} catch (DroidDeviceMismatchException e) {
						//do nothing
					}
				}
			}
			i++;
		}
		deviceListReader.close();
	}
	
	/**
	 * Removes a Device from the filtered waiting list based on
	 * the provided index
	 * @param filter a String to filter Device's by. Filters by 
	 * owner's name
	 * @param index the index within the filtered list to remove 
	 * the Device at
	 * @return the removed Device
	 */
	public Prioritizable remove(String filter, int index) {
		return devicesWaiting.remove(filter, index);
	}
	
	/**
	 * Releases a Device from being serviced by a TechDroid
	 * based on index
	 * @param index the index of the TechDroid to release its Device
	 * from service
	 * @return the Device released
	 */
	public Prioritizable releaseFromService(int index) {
		if(androTech.getDroidAt(index) != null)
		{
			return androTech.getDroidAt(index).release();
		}
		return null;
	}
	
	/**
	 * Adds a new TechDroid to the 
	 * RepairCenter
	 */
	public void addNewDroid() {
		androTech.addTechDroid();
	}
	
	/**
	 * Prints out the wait list depending on
	 * a provided filter
	 * @param filter A String filter to filter the 
	 * Device list by owner's name
	 * @return a String representation of the Device List
	 */
	public String printWaitList(String filter) {
		return devicesWaiting.filteredList(filter);
	}
	
	/**
	 * Returns a String representation of all TechDroids
	 * at the RepairCenter
	 * @return a String representation of all TechDroids
	 * at the RepairCenter
	 */
	public String printDroids() {
		return androTech.printDroids();
		
	}
	
	/**
	 * Puts a new Device on the waiting list for service
	 * @param kind a 1 letter representation of what type of Device it is
	 * @param serialNum The Device's serial number
	 * @param name The Device's owner's name
	 * @param tierIndex The Device's service plan
	 */
	public void putOnWaitingList(String kind, String serialNum, String name, int tierIndex) {
		if(kind.equalsIgnoreCase("v"))
		{
			try {
				devicesWaiting.add(new VRDevice(serialNum, name, tierIndex));
			} catch (BadDeviceInformationException e) {
				//Do nothing
			}
		}
		else if(kind.equalsIgnoreCase("c"))
		{
			try {
				devicesWaiting.add(new ComDevice(serialNum, name, tierIndex));
			} catch (BadDeviceInformationException e) {
				//Do nothing
			}
		}
	}
	
	/**
	 * Puts a Device on the waiting list for service
	 * @param p a Prioritizable Object, most likely a Device
	 */
	public void putOnWaitingList(Prioritizable p) {
		if(p instanceof Device)
		{
			devicesWaiting.add((Device) p);
		}
	}
	/**
	 * Finds the next unassigned TechDroid capable of servicing
	 * VRDevices
	 * @return a TechDroid capable of servicing VRDevices
	 */
	private TechDroid getNextVRAbleDroid()
	{
		for(int i = 0; i < androTech.totalNumberOfDroids(); i++)
		{
			if((androTech.getDroidAt(i) instanceof VRDroid 
					|| androTech.getDroidAt(i) instanceof ExpertDroid)
						&& !androTech.getDroidAt(i).isAssigned())
			{
				return androTech.getDroidAt(i);
			}
		}
		return null;
	}
	/**
	 * Finds the next unassigned TechDroid capable of servicing
	 * ComDevices
	 * @return a TechDroid capable of servicing ComDevices
	 */
	private TechDroid getNextComAbleDroid()
	{
		for(int i = androTech.totalNumberOfDroids() - 1; i >= 0 ; i--)
		{
			if((androTech.getDroidAt(i) instanceof ComDroid 
					|| androTech.getDroidAt(i) instanceof ExpertDroid)
						&& !androTech.getDroidAt(i).isAssigned())
			{
				return androTech.getDroidAt(i);
			}
		}
		return null;
	}
}