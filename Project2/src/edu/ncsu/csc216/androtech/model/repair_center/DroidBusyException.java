/**
 * 
 */
package edu.ncsu.csc216.androtech.model.repair_center;

/**
 * DroidBusyException is thrown when an assigned
 * TechDroid is assigned another Device
 * 
 * @author Tyler Albert
 * @author Zachary R. Jones
 *
 */
public class DroidBusyException extends Exception {
	/**
	 * Constructs an exception that is called
	 * when an assigned
     * TechDroid is assigned another Device
	 */
	public DroidBusyException()
	{
		super("TechDroid is already assigned");
	}
	/**
	 * Constructs a throw that is called
	 * when an assigned
     * TechDroid is assigned another Device
     * @param message the message that can be displayed when the
     * exception is thrown
	 */
	public DroidBusyException(String message)
	{
		super(message);
	}
}
