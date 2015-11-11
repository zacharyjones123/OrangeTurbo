/**
 * 
 */
package edu.ncsu.csc216.androtech.model.repair_center;

/**
 * DroidDeviceMismatchException is thrown when a ComDevice is assigned to
 * a VRDroid or a VRDevice is assigned to a ComDroid.
 * 
 * @author Zachary R. Jones
 * @author Tyler Albert
 *
 */
public class DroidDeviceMismatchException extends Exception {
	/**
	 * Constructs an Exception that is thrown when
	 * when a ComDevice is assigned to
 	 * a VRDroid or a VRDevice is assigned to a ComDroid.
	 */
	public DroidDeviceMismatchException()
	{
		super("TechDroid and Device are incompatible");
	}
	/**
	 * Constructs an Exception that is thrown when
	 * when a ComDevice is assigned to
 	 * a VRDroid or a VRDevice is assigned to a ComDroid.
 	 * @param message the message that can be displayed when the exception
 	 * is thrown.
	 */
	public DroidDeviceMismatchException(String message)
	{
		super(message);
	}
}
