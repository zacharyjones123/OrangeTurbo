
package edu.ncsu.csc216.androtech.model.devices;

/**
 * This class constructs individual ComDevices
 * 
 * @author Zachary R. Jones
 * @author Tyler Albert
 */
public class ComDevice extends Device {
	/** When formatting, the maximum number of spaces before the tier string is added */
	private static final int MAX_CHARACTERS_BEFORE_TIER = 12;
	/**
	 * Constructs a ComDevice with a serial number, owner's name and service tier index
	 * 
	 * @param serialNum the ComDevice's serial number
	 * @param name the owner's name
	 * @param tierIndex the Device's service tier
	 * @throws BadDeviceInformationException if the serial number or owner's name are empty/null
	 */
	public ComDevice(String serialNum, String name, int tierIndex) throws BadDeviceInformationException {
		super(serialNum, name, tierIndex);
	}
	
	/**
	 * Returns a String representation of a ComDevice in the format:
	 * 
	 * <C> <Service tier> <Serial number> <Owner's name>
	 * 
	 * @return a String representation of a Device
	 */
	public String toString()
	{
		/** String representation of a ComDevice */
		String comString = "C ";
		comString += CUSTOMER_TIER[this.getTier()];
		//Spacing before Tier
		int length = comString.length();
		for(int i = 0; i < MAX_CHARACTERS_BEFORE_TIER - length; i++) {
			comString += " ";
		}
		comString += this.getSerialNum();
		comString += " ";
		//Used to right align the Serial Num (formatting)
		comString += this.getName();
		return comString;
	}
}