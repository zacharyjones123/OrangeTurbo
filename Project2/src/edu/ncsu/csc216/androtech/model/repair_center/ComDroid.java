/**
 * 
 */
package edu.ncsu.csc216.androtech.model.repair_center;

import edu.ncsu.csc216.androtech.model.devices.Device;
import edu.ncsu.csc216.androtech.model.devices.ComDevice;

/**
 * This class constructs individual ComDroids
 * 
 * @author Zachary R. Jones
 * @author Tyler Albert
 *
 */
public class ComDroid extends TechDroid {
	
	/**
	 * The constructor of the ComDroid class
	 */
	public ComDroid() {
		super("C");
	}
	
	/**
	 * Assigns a Device to a ComDroid
	 * 
	 * @param device Device to be assigned
	 * @throws DroidDeviceMismatchException if anything other than a ComDevice
	 * is assigned to a ComDroid
	 */
	public void assign(Device device) throws DroidBusyException, DroidDeviceMismatchException {
		if(!(device instanceof ComDevice))
		{
			throw new DroidDeviceMismatchException("Device " 
														+ device.getSerialNum() 
														+ " incompatible with " 
														+ this.getDroidID());
		}
		else
		{
			super.assign(device);
		}
	}

}