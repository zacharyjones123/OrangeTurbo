
package edu.ncsu.csc216.androtech.model.devices;

/**
 * This class constructors individual VRDevices
 * 
 * @author Zachary R. Jones
 * @author Tyler Albert
 *
 */
public class VRDevice extends Device {
	/** When formatting, the maximum number of spaces before the tier string is added */
	private static final int MAX_CHARACTERS_BEFORE_TIER = 12;

	/**
	 * Constructs a VRDevice with a serial number, owner's name and service tier index
	 * 
	 * @param serialNum the Device's serial number
	 * @param name the owner's name
	 * @param tierIndex the Device's service tier
	 * @throws BadDeviceInformationException if the serial number or owner's name are empty/null
	 */
	public VRDevice(String serialNum, String name, int tierIndex) throws BadDeviceInformationException {
		super(serialNum, name, tierIndex);
	}
	
	/**
	 * Returns a String representation of a VRDevice in the format:
	 * 
	 * <V> <Service tier> <Serial number> <Owner's name>
	 * 
	 * @return a String representation of a Device
	 */
	public String toString()
	{ //12 total characters before Serial num
		/** String representation of a VRDevice */
		String vRString = "V ";
		vRString += CUSTOMER_TIER[this.getTier()];
		/**Spacing before Tier */
		int length = vRString.length();
		for(int i = 0; i < MAX_CHARACTERS_BEFORE_TIER - length; i++) {
			vRString += " ";
		}
		vRString += this.getSerialNum().trim();
		vRString += " ";
		//Used to right align the Serial Num (formatting)
		vRString += this.getName().trim();
		return vRString;
	}
}
