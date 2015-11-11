/**
 * 
 */
package edu.ncsu.csc216.androtech.model.devices;

/**
 * An interface that describes priority/based behavior
 * @author Zachary R. Jones and Tyler Albert
 */
public interface Prioritizable {
	/**
	 * Returns the tier of the Object
	 * @return the tier of the Object
	 */
	public int getTier();
	/**
	 * Compares an Object to this Object based on tier
	 * @param p an Object that this is being compared to
	 * @return 0 if the Objects have matching tiers
	 * a positive number if this Object has a greater tier
	 * a negative number if this Object has a lesser tier
	 */
	public int compareToTier(Prioritizable p);
}
