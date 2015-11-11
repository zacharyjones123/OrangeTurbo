/**
 * 
 */
package edu.ncsu.csc216.androtech.model.devices;

/**
 * Class managing a Device to be repaired at the AndroTech Repair Center
 * @author Zachary R. Jones and Tyler Albert
 */
public class Device implements Prioritizable {
	/** The unique serial for a Device */
	private String serialNum;
	/** The name of the Device's owner */
	private String name;
	/**
	 * An integer representing the service plan tier
	 * The range for service plans is:
	 * 0 = no plan (lowest)
	 * 1 = silver
	 * 2 = gold
	 * 3 = platinum (highest)
	 */
	private int tierIndex;
	/** Array of tier Strings aligning to tierIndex  */
	public static final String[] CUSTOMER_TIER = {"No Plan  ", "Silver   ", "Gold     ", "Platinum "};
	/** Lowest service tier possible */
	private static final int MINIMUM_TIER = 0;
	/** Highest tier possible */
	private static final int MAXIMUM_TIER = 3;
	
	/**
	 * Constructs a Device with its serial number,
	 * owner's name, and service tier
	 * @param serialNum the Device's serial number
	 * @param name the Device's owner's name
	 * @param tierIndex the index corresponding to the Device's
	 * service plan
	 * @throws BadDeviceInformationException if the Customer name or Serial number
	 * are empty/null
	 */
	public Device(String serialNum, String name, int tierIndex) throws BadDeviceInformationException
	{
		this.serialNum = serialNum;
		this.name = name;
		this.tierIndex = tierIndex;
		validateSerialNum();
		validateName();
		validateTier();
	}
	/**
	 * Returns a String representation of a Device in the format:
	 * 
	 * <Service tier> <Serial number> <Owner's name>
	 * 
	 * @return a String representation of a Device
	 */
	public String toString()
	{
		return CUSTOMER_TIER[tierIndex] + 
				serialNum + 
				" " + 
				name;
	}
	/**
	 * Checks that a filter is the prefix to the Device's owner's name.
	 * @param filter a String to sort Devices by
	 * @return true if the filter is a prefix to the Device's owner's name
	 * Otherwise returns false.
	 */
	public boolean meetsFilter(String filter)
	{
		if(filter == null)
		{
			filter = "";
		}
		filter = filter.toLowerCase();
		return (filter.trim().equals("") ||
				filter.trim().equals(" ") ||
				name.substring(0, filter.trim().length()).equalsIgnoreCase(filter.trim()));
	}
	/**
	 * Returns the Device's service tier
	 * @return the Device's service tier
	 */
	public int getTier() {
		return tierIndex;
	}
	/**
	 * Returns the Device's owner's name
	 * @return the Device's owner's name
	 */
	public String getName()
	{
		return name;
	}
	/**
	 * Returns the Device's serial number
	 * @return the Device's serial number
	 */
	public String getSerialNum()
	{
		return serialNum;
	}
	/**
	 * Compares an Object to this Object based on tier
	 * @param p an Object that this is being compared to
	 * @return 0 if the Objects have matching tiers
	 * a positive number if this Object has a greater tier
	 * a negative number if this Object has a lesser tier
	 */
	public int compareToTier(Prioritizable p) {
		return (this.tierIndex - p.getTier());
	}
	/**
	 * Validates that the provided tier is between the minimum and maximum
	 * service tiers. If a tier is provided outside the range, it is assigned to the
	 * closed bound.
	 */
	private void validateTier()
	{
		if(tierIndex < MINIMUM_TIER)
		{
			tierIndex = MINIMUM_TIER;
		}
		else if(tierIndex > MAXIMUM_TIER)
		{
			tierIndex = MAXIMUM_TIER;
		}
	}
	/**
	 * Validates that the provided name is not empty.
	 * @throws BadDeviceInformationException if the provided name is null/empty
	 */
	private void validateName() throws BadDeviceInformationException
	{
		if(name == null || name.trim().length() == 0)
		{
			throw new BadDeviceInformationException("Owner name cannot be blank.");
		}
		name = name.trim();
	}
	/**
	 * Validates that the provided serial number is not empty.
	 * @throws BadDeviceInformationException if the provided serial number is null/empty
	 */
	private void validateSerialNum() throws BadDeviceInformationException
	{
		if(serialNum == null || serialNum.trim().length() == 0 || serialNum.trim().indexOf(' ') >= 0 )
		{
			throw new BadDeviceInformationException("Serial number cannot be blank.");
		}
		serialNum = serialNum.trim();
	}
}
