/**
 * 
 */
package edu.ncsu.csc216.androtech.model.devices;

/**
 * This exception class is used to throw an exception if the information
 * that the user inputed for a device is ivalid.
 * 
 * @author Zachary R. Jones
 * @author Tyler Albert
 */
public class BadDeviceInformationException extends Exception {
	/**
	 * Constructs a generic BadDeviceInformationException
	 */
	public BadDeviceInformationException()
	{
		super("Bad Device Information was provided");
	}
	/**
	 * Constructs a BadDeviceInformationException with a changeable message
	 * @param message the message to be displayed to the user.
	 */
	public BadDeviceInformationException(String message)
	{
		super(message);
	}
}
