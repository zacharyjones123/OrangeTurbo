/**
 * 
 */
package edu.ncsu.csc216.androtech.model.repair_center;

import edu.ncsu.csc216.androtech.model.devices.Device;

/**
 * Manages information about a TechDroid that repairs certain Devices at a
 * repair facility.
 * 
 * @author Zachary R. Jones
 * @author Tyler Albert
 *
 */
public abstract class TechDroid {

	/** Is TechDroid assigned */
	private boolean assigned;
	/** The ID of the TechDroid */
	private String droidID;
	/** The next TechDroid in line */
	private static int nextNumber = 1;
	/** The Device assigned to the current TechDroid */
	private Device assignedDevice;
	/** A holder Device to be used to return removed Devices */
	private Device returnDevice;
	/** String representation of a TechDroid */
	private String droidString;
	/** Indicator to concatenate a leading 0 if a number is 1 character */
	private static final int ZERO_BOUND = 10;

	/**
	 * Is a static method that resets the static nextNumber variable to 1.
	 */
	public static void startDroidNumberingAt01() {
		nextNumber = 1;
	}

	/**
	 * Constructs a TechDroid with an ID
	 * 
	 * @param droidID the TechDroids ID
	 */
	public TechDroid(String droidID) {
		if (nextNumber < ZERO_BOUND) {
			this.droidID = "0" + nextNumber + droidID;
		} else {
			this.droidID = nextNumber + droidID;
		}
		nextNumber++;
		this.assigned = false;
	}

	/**
	 * The getter method for droidID.
	 * 
	 * @return the TechDroid's ID
	 */
	public String getDroidID() {
		return droidID;
	}

	/**
	 * The getter method for whether the TechDroid is assigned.
	 * 
	 * @return true if the TechDroid is assigned otherwise return false
	 */
	public boolean isAssigned() {
		return assigned;
	}

	/**
	 * This method releases the device that is being serviced by this TechDroid
	 * 
	 * @return the released Device
	 */
	public Device release() {
		// If the droid has a device
		if (assigned) {
			assigned = false;
			returnDevice = assignedDevice;
			assignedDevice = null;
			return returnDevice;
		} else {
			returnDevice = null;
			assignedDevice = null;
			return returnDevice;
		}
	}

	/**
	 * This method assigns a Device to the TechDroid
	 * 
	 * @param device
	 *            Device to be assigned to a TechDroid
	 * @throws DroidBusyException
	 *             if the TechDroid is already assigned a Device
	 * @throws DroidDeviceMismatchException
	 *             if the TechDroid is assigned an incompatible Device
	 */
	public void assign(Device device) throws DroidBusyException,
			DroidDeviceMismatchException {
		if (!assigned) {
			assigned = true;
			assignedDevice = device;
		}
		else if(assigned) {
			throw new DroidBusyException();
		}
	}

	/**
	 * This method returns a String representation of a TechDroid
	 * 
	 * @return a String representation of a TechDroid
	 */
	public String toString() {
		if (!assigned) {
			droidString = droidID + ": " + "UNASSIGNED";
		} else {
			droidString = droidID + ": " + assignedDevice.getSerialNum() + " "
					+ assignedDevice.getName();
		}
		return droidString;
	}

}
