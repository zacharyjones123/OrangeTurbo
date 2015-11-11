/**
 * 
 */
package edu.ncsu.csc216.androtech.model.repair_center;

import edu.ncsu.csc216.androtech.model.devices.Device;
import edu.ncsu.csc216.androtech.model.devices.VRDevice;

/**
 * This class constructs individual VRDroids
 * 
 * @author Zachary R. Jones
 * @author Tyler Albert
 *
 */
public class VRDroid extends TechDroid {
	
	/**
	 * The constructor of the VRDroid class
	 */
	public VRDroid() {
		super("V");
	}
	
	/**
	 * Assigns a Device to a VRDroid
	 * 
	 * @param device Device to be assigned
	 * @throws DroidDeviceMismatchException if anything other than a VRDevice
	 * is assigned to a VRDroid
	 */
	public void assign(Device device) throws DroidBusyException, DroidDeviceMismatchException {
		if(!(device instanceof VRDevice))
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
