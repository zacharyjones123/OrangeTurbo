/**
 * 
 */
package edu.ncsu.csc216.androtech.model.util;

/**
 * This interface gives methods that are used by the Cursor class
 * in order to continually run through the list of devices.
 * 
 * @author Tyler Albert
 * @author Zachary R. Jones
 * @param <E> an <Object>
 */
public interface SimpleIterator<E> {
	
	/**
	 * Determines whether there is a next device
	 * on the device list
	 * 
	 * @return true if there is a next Device
	 * otherwise returns false
	 */
	boolean hasNext();
	
	/**
	 * Moves to the next device
	 * @return the next Object in the list
	 */
	E next();

}
