
package edu.ncsu.csc216.androtech.model.repair_center;

import java.util.Random;

import edu.ncsu.csc216.androtech.model.devices.Device;

/**
 * The RepairCenter Class manages a list of TechDroids
 * capable of servicing Devices. Manages the addition, removal, 
 * and retrieval of TechDroids.
 * @author Zachary R. Jones
 * @author Tyler Albert
 *
 */
public class RepairCenter {
	/** The amount of droids available */
	private int size;
	/** Number of TechDroids capable of servicing VRDevices */
	private int vRCapableDroids;
	/** The total number of available TechDroids */
	private int numberOfAvailableDroids;
	/** Random field for creating TechDroids */
	private static Random rand = new Random();
	/**
	 * The minimum ratio of VR capable 
	 * TechDroids to total TechDroids. 
	 */
	private static final double VR_RATIO = 1.0 / 3;
	/** Used to generate numbers between 0-2 */
	private static final int MAX_RANDOM_RANGE = 3;
	/** 
	 * VRDroids have twice the likelihood of being generated as ExpertDroids.
	 * This is simulated by generating an ExpertDroid if 2 is produced, and anything
	 * else producing a VRDroid
	 */
	private static final int EXPERTDROID_CUTOFF = 2;
	/** The list of Droids that are in the Repair Center */
	private TechDroid[] droids;
	
	
	/** The max number of droids available */
	public final static int MAX_DROIDS = 30; 
	/** The default size of the array because of initial TechDroids */
	public final static int DEFAULT_SIZE = 5;
	/**
	 * The constructor of the Repair Center.
	 */
	public RepairCenter() {
		TechDroid.startDroidNumberingAt01();
		droids = new TechDroid[MAX_DROIDS];
		size = 0;
		initDroids();
	}
	
	/**
	 * Initializes 5 default TechDroids
	 */
	private void initDroids() {
		/** Initial ComDroid */
		TechDroid comDroid1 = new ComDroid();
		/** Initial ExpertDroid */
		TechDroid expertDroid1 = new ExpertDroid();
		/** Initial VRDroid */
		TechDroid vRDroid1 = new VRDroid();
		/** Initial ComDroid */
		TechDroid comDroid2 = new ComDroid();
		/** Initial VRDroid */
		TechDroid vRDroid2 = new VRDroid();
		
		droids[size++] = vRDroid2;
		vRCapableDroids++;
		droids[size++] = vRDroid1;
		vRCapableDroids++;
		droids[size++] = expertDroid1;
		vRCapableDroids++;
		droids[size++] = comDroid1;
		droids[size++] = comDroid2;
		
		this.numberOfAvailableDroids = 5;
	}
	/**
	 * Generates new TechDroid using a Random number generator
	 * @return a new TechDroid
	 */
	private TechDroid generateDroid()
	{
		if((vRCapableDroids) / (size + 1.0) >= VR_RATIO)
		{
			return new ComDroid();
		}
		else
		{
			if(rand.nextInt(MAX_RANDOM_RANGE) < EXPERTDROID_CUTOFF)
			{
				return new VRDroid();
			}
			else
			{
				return new ExpertDroid();
			}
		}
	}
	/**
	 * This method is used to add TechDroids to the Repair Center. 
	 * If the number of TechDroids has reached the maximum, no TechDroids are
	 * created
	 */
	public void addTechDroid() 
	{
		/** A newly generated TechDroid */
		TechDroid newDroid = generateDroid();
		if(size < MAX_DROIDS)
		{
			if(newDroid instanceof ComDroid)
			{
				droids[size] = newDroid;
				size++;
				numberOfAvailableDroids++;
			}
			else if(newDroid instanceof VRDroid)
			{
				for(int i = size + 1; i > 0; i--)
				{
					droids[i] = droids[i - 1];
				}
				droids[0] = newDroid; //Add on the left side
				size++;
				vRCapableDroids++;
				numberOfAvailableDroids++;
			}
			else if(newDroid instanceof ExpertDroid)
			{
				/** A counting variable */
				int i = size;
				while(!(droids[i - 1] instanceof VRDroid) 
							&& !(droids[i - 1] instanceof ExpertDroid)
							&& (i > 0))
				{
					droids[i] = droids[i - 1];
					i--;
				}
				droids[i] = newDroid;
				size++;
				vRCapableDroids++;
				numberOfAvailableDroids++;
			}
			
		}
	}
	
	/**
	 * Returns the number of available TechDroids
	 * @return the number of available TechDroids
	 */
	public int numberOfAvailableDroids() {
		int notAssignedDevices = 0;
		for(int i = 0; i < droids.length; i++) {
			if (droids[i] != null && !droids[i].isAssigned()) {
				notAssignedDevices++;
			}
		}
		this.numberOfAvailableDroids = notAssignedDevices;
		return numberOfAvailableDroids;
	}
	
	/**
	 * Returns the TechDroid at a certain index or null if
	 * the index is invalid
	 * 
	 * @param index Number of the index of the desired TechDroid.
	 * @return TechDroid at that certain index.
	 */
	public TechDroid getDroidAt(int index) {
		if(index >= size || index < 0)
		{
			return null;
		}
		return droids[index];
	}
	
	/**
	 * Returns the total number of TechDroids
	 * 
	 * @return the number of Tech droids.
	 */
	public int totalNumberOfDroids() {
		return size;
	}
	
	/**
	 * This method releases a droid at a certain index from a Device.
	 * 
	 * @param index Number of index of droid.
	 * @return the device that had a droid released from it.
	 */
	public Device release(int index) {
		if(index >= 0 && index < size)
		{
			numberOfAvailableDroids++;
			return droids[index].release();
		}
		return null;
	}
	
	/**
	 * Prints out the information about all of the droids in the
	 * Repair Center.
	 * 
	 * @return all information about the droids in the Repair Center
	 */
	public String printDroids() {
		String droidString = "";
		for(int i = 0; i < size; i++)
		{
			droidString += droids[i];
			if(i != size - 1)
			{
				droidString += "\n";
			}
		}
		return droidString;
	}
}
