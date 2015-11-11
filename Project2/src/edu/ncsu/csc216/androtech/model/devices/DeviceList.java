package edu.ncsu.csc216.androtech.model.devices;

import java.util.NoSuchElementException;
import java.util.Scanner;

import edu.ncsu.csc216.androtech.model.util.SimpleIterator;

/**
 * A linked list used to organize and manage Devices
 * @author Tyler Albert and Zachary R. Jones
 */
public class DeviceList {

	/** The last Node in the list */
	static Node front;
	/** Iterator for traversing the linked list */
	static SimpleIterator<Device> cursor;
	/**
	 * Creates a linked list for Devices based off of a 
	 * prior supplied text file.
	 * @param inputFile a Scanner reading from the above text file
	 */
	public DeviceList(Scanner inputFile) 
	{
		cursor = iterator();
		/** Scanner for processing a line of text */
		Scanner lineReader = null;
		/** String representation of the kind of device */
		String kind;
		/** Int for the Device's service tier */
		int tier;
		/** A Device's serial number */
		String serialNum;
		/** A Device owner's name */
		String name;
		while(inputFile != null && inputFile.hasNextLine())
		{
			lineReader = new Scanner(inputFile.nextLine());
			if(lineReader.hasNext())
			{
				kind = lineReader.next();	
				if(lineReader.hasNextInt())
				{
					tier = lineReader.nextInt();		
					if(lineReader.hasNext())
					{
						serialNum = lineReader.next();
						if(lineReader.hasNext())
						{
							name = lineReader.nextLine();
							try{
								if(kind.equalsIgnoreCase("v"))
								{
									this.add(new VRDevice(serialNum, name, tier));
								}
								else if(kind.equalsIgnoreCase("c"))
								{
									this.add(new ComDevice(serialNum, name, tier));
								}
							}
							catch(BadDeviceInformationException b)
							{
								//Bad or wrongly formatted information was provided:
								//ignore the device
							}
						}
					}
				}
			}
			lineReader.close();
		}
	}
	/**
	 * Creates an empty linked list for holding Devices
	 */
	public DeviceList()
	{
		front = null;
	}
	/**
	 * Creates an iterator for traversing the
	 * list
	 * @return a simple iterator for Devices
	 */
	public SimpleIterator<Device> iterator()
	{
		return new Cursor();
	}
	/**
	 * Removes a Device from the linked list of Devices
	 * @param filter a String to filter Devices by the 
	 * owner's name
	 * @param index index of the Device in the filtered
	 * list to remove
	 * @return the removed Device
	 */
	public Device remove(String filter, int index)
	{
		/**Holder Device for traversing the list */
		Device d = null;
		if(DeviceList.front != null)
			{ //////5
			if(index == 0) //Put at the front
			{ ////////4
				d = front.device;
				front = front.next;
			} /////////4
			else
			{ ////////4
				cursor = new Cursor();
				int i = 0;
				while(cursor.hasNext() && i < index - 1)
				{
					cursor.next();
				//	if(d.getName().indexOf(filter) == 0)
				//	{
				//		i++;
				//	}
						i++;
				}
				if (!cursor.hasNext()) {
					throw new IndexOutOfBoundsException();
				}
				d = cursor.next();
			} ////////4
		} ///////5
		return d;
		//1) if device.front is null, just add d
	}
	/**
	 * Adds a Device to the end of that Device's
	 * priority section.
	 * @param d Device to be added
	 */
	public void add(Device d)
	{
		if(front == null)
		{
			front = new Node(d, null);
		}
		else 
		{
			if(front.device.compareToTier(d) < 0)
			{
				Node n = front;
				front = new Node(d, n);
			}
			else
			{
				Node current = front;
				while(current.next != null && current.next.device.compareToTier(d) >= 0 )
				{
					current = current.next;
				}
				current.next = new Node(d, current.next);
			}
		}
	}
	/**
	 * Returns a filtered String representation of the Devices
	 * in the list. Filters them based on whether the provided
	 * filter String is the prefix of the owner's name. If so
	 * they are included in the filtered list
	 * @param filter String to filter Devices with
	 * @return a filtered String representation of the Devices
	 * in the list.
	 */
	public String filteredList(String filter)
	{
		Node current = front;
		/** String representation of the list. */
		String deviceString = "";
		/** A holder Device for traversing the linked list */
		Device d;
		if(front != null)
		{
			d = front.device;
			if(d.getName().indexOf(filter.toLowerCase()) == 0 ||
					d.getName().indexOf(filter.toUpperCase()) == 0)
			{
				deviceString += d;
			}
			while(current.next != null)
			{
				current = current.next;
				d = current.device;
				if(d.getName().indexOf(filter.toLowerCase()) == 0 ||
						d.getName().indexOf(filter.toUpperCase()) == 0)
				{
					deviceString += "\n";
					deviceString += d;
				}	
			}
		}
		return deviceString;
	}
	/**
	 * An inner class of DeviceList that
	 * manages individual Nodes in a linked
	 * list of Devices
	 * @author Tyler Albert
	 *
	 */
	private class Node
	{
		/** Device stored in the Node */
		public Device device;
		/** Reference to the next Node */
		public Node next;
		/**
		 * Constructs a Node in a linked list that
		 * contains one data Object and a reference to
		 * the next Node in the list
		 * @param device Device stored in the Node
		 * @param next reference to the next Node
		 */
		public Node(Device device, Node next)
		{
			this.device = device;
			this.next = next;
		}
		
	}
	/**
	 * An iterator class to traverse the DeviceList linked list
	 * @author Tyler Albert and Zachary Jones
	 */
	private class Cursor implements SimpleIterator<Device>
	{
		private Node current;
		/**
		 * Sets the current Node equal to the front Node
		 */
		public Cursor()
		{
			current = DeviceList.front;
		}
		/**
		 * Return true if there is another Node in the list
		 * @return true if there is another Node in the list
		 * otherwise return false
		 */
		public boolean hasNext() {
			return (current != null);
		}
		/**
		 * Traverses one step through the linked list.
		 * @return the Device stored in the traversed Node
		 */
		public Device next() {
			if(current == null)
			{
				throw new NoSuchElementException();
			}
			Device d = current.device;
			current = current.next;
			return d;
		}
	}
}
