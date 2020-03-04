/**
 * A collection class that stores Adventurer objects by using a linked list
 * 
 * Invariants:
 * 1. The elements in the bag are stored in a linked list
 * 2. The start of the list is stored in a variable called head
 * 3. The total number of items in the list are stored in a variable manyItems
 * 
 * @author Grace O'Brien
 * March 5th, 2020
 *
 */
public class LinkedAdventurerParty {
	
	private AdventurerNode head;	//Tracks beginning of linked list
	private int manyItems; 			//Represents size of linked list
	
	public LinkedAdventurerParty()
	{
		head = null;
		manyItems = 0;
	}
	
	/**
	 * Returns the current size of the list
	 * 
	 * @return The number of nodes in the list
	 */
	public int size()
	{
		return manyItems;
	}
	
	/**
	 * Returns the entire contents of the collection as a string, with
	 * each node data formatted on a single line
	 * 
	 * @return The contents of the list as a string
	 */
	public String toString()
	{
		String result = "Adventurer Party:\n";	//Store result
		AdventurerNode current = head;			//Track current node
		
		//While current node is not null
		while(current != null)
		{
			//Add the current node's data as string and set current
			//to the next node in the list
			result = result + current.getData().toString() +"\n";
			current = current.getLink();
		}
		
		return result;
	}
	
	/**
	 * Adds a new element to the beginning of the list
	 * 
	 * @param element Adventurer data to be added to the new node
	 */
	public void add(Adventurer element)
	{
		head = new AdventurerNode(element, head);
		manyItems++;
	}
	
	/**
	 * Adds a new element to a specified position in the list:
	 * 
	 * If position > number of elements in the list, the element is added to the end
	 *    position == 1, the element is added to head of list
	 *    position < 1, the element is not added to the list
	 *    
	 * Otherwise, the element is added to the specified position in the list
	 * 
	 * @param position Position to add the element in at
	 * @param element Adventurer data to be added into the list
	 */
	public void add(int position, Adventurer element) 
	{
		AdventurerNode current = head;
		
		//If position is greater than the number of elements in the list...
		if(position > manyItems)
		{
			//...add the new element at the end of the list
			while(current.getLink() != null)
			{
				current = current.getLink();
			}
			
			current.setLink(new AdventurerNode(element, current.getLink()));
			manyItems++;
		}
		//If position is 1 add to the head
		else if(position == 1)
		{
			this.add(element);
		}
		//If position is not 0 or negative...
		else if(position > 0)
		{
			int count = 2;	//Keep track of current position in list
			
			//While the count is not equal to the position
			while(count != position)
			{
				//Set current to the next node and increment count
				current = current.getLink();
				count++;
			}
			
			//Add the new node in at the designated position
			current.setLink(new AdventurerNode(element, current.getLink()));
			manyItems++;
		}
		
	}
	
	/**
	 * This method removes an adventurer object from the list
	 * 
	 * @param target The adventurer to be removed from the list
	 * @return True If a match was found and removed
	 * 		   False If no matches are found, and thus no object removed
	 */
	public boolean remove(Adventurer target)
	{
		
		try 
		{
			AdventurerNode current = head;
		
			//Check if the head node equals the target...
			if(current.getData().equals(target))
			{
				//...if so, set head to its link and return true
				head = head.getLink();
				manyItems--;
				return true;
			}
		
			//While the current node is not null...
			while(current.getLink() != null)
			{
				//...check if the data in the current's link equals the target
				if(current.getLink().getData().equals(target))
				{
					//...if it is equal, set the link for the current node, to
					//the link held by the node to be removed
					current.setLink(current.getLink().getLink());
					manyItems--;
					return true;
				}
			
				//...otherwise set current to the current node's link
				current = current.getLink();
			}
		
			//Return false if no match was found
			return false;
		}
		catch(Exception e)
		{
			System.out.println(e);
			return false;
		}
	}
	
	/**
	 * This method removes an object from a list at the given position
	 * 
	 * @param position The position of the item to be removed
	 * @return True If an item was found at the position and removed
	 * 		   False If position was less than 1 or beyond list length
	 */
	public boolean remove(int position)
	{
		try
		{
			//If position is 1...
			if(position == 1)
			{
				//...set head to the next node in the list
				head = head.getLink();
				manyItems--;
				return true;
			}
			//Else if position is less than 1 or beyond list length...
			else if(position < 1 || position > manyItems)
			{
				//...position does not exist in list, return false
				return false;
			}
			else
			{
				int count = 1;					//Flag to track current position
				AdventurerNode current = head;	//Flag to track current node
			
				//While the count does not equal position minus 1...
				while(count != position-1)
				{
					//...set the current node to the next node in the list
					current = current.getLink();
					count++;
				}
			
				//Once current is set to the node prior to the node to be removed
				//set the current node's link to the link of the next node
				current.setLink(current.getLink().getLink());
				manyItems--;
				return true;
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
			return false;
		}
		
	}
	
	/**
	 * This method counts the number of adventurers in the list whose search key falls within the given range
	 * 
	 * @param start Adventurer object, where the range begins
	 * @param end Adventurer object, where the range ends
	 * @return Total number of items that fall within the range
	 */
	public int countRange(Adventurer start, Adventurer end)
	{
		
		int total = 0;	//Tracks items in range
		AdventurerNode current = head; //Tracks current node
		
		//While the current node to compare to is not null...
		while(current != null)
		{
			//Check if the current node's data falls between the start and end range
			if(current.getData().compareTo(start) <= 0 && current.getData().compareTo(end) >= 0)
				total++;
				
			//Set current to next node in list
			current = current.getLink();
		}
		
		return total;
	}

	/**
	 * Grabs an item at the given position and returns it
	 * 
	 * @param position Location of the item to be returned
	 * @return Adventurer object if an item exists at the given position
	 * 		   Null if the position is less than 1 or beyond list length
	 */
	public Adventurer grab(int position)
	{
		//If position is less than 1 or beyond list length, return null
		if(position < 1 || position > manyItems)
			return null;
		
		int count = 1;	//Tracks current position
		AdventurerNode current = head;	//Tracks current node
		
		//While the current position is not equal to target position
		while(count != position)
		{
			//Set current to next node in the list and increment count
			current = current.getLink();
			count++;
		}
		
		//Return the adventurer object held in the node at the position
		return current.getData();
	}
	
	/**
	 * This method searches for an object in the list and returns the position
	 * of its first occurrence
	 * 
	 * @param target Adventurer object to search for
	 * @return int > 0, If the object is found its position is returned
	 * 		   -1		If the object is not found 
	 */
	public int positionOf(Adventurer target)
	{
		int count = 1;	//Tracks current position
		AdventurerNode current = head;	//Tracks current node
		
		//While the current node being checked is not null...
		while(current != null)
		{
			//If the current node's data is equal to the target, return the position
			if(current.getData().compareTo(target) == 0)
				return count;
			
			//Otherwise set the current node to the next node in the list
			//and increment the position count
			current = current.getLink();
			count++;
		}
		
		//Return -1 if the target is not found in the list
		return -1;
	}
	
	/**
	 * Updates the data at a specified position
	 * 
	 * @param position	Position of the data to be updated
	 * @param element	New data to be updated to
	 */
	public void set(int position, Adventurer element)
	{
		//If the position is greater than 0 and does not exceed the list length...
		if(position > 0 && position <= manyItems)
		{
			int count = 1;	//Track current position
			AdventurerNode current = head;	//Track current node
		
			//While current position is not equal to target position...
			while(count != position)
			{
				//Set current node to next node in list, and increment the position
				current = current.getLink();
				count++;
			}
			
			//Once the target node is found, update its data with the new data
			current.setData(element);
		}
	}
	
	/**
	 * Searches for an Adventurer in the list, if found, the data is updated
	 * and replaced with new Adventurer
	 * 
	 * @param oldThing	Adventurer object data to be replaced
	 * @param newThing  Adventurer object data to update to
	 * @return	True	If the data is successfully found and updated
	 * 			False 	If the data is not found, and not updated
	 */
	public boolean replace(Adventurer oldThing, Adventurer newThing)
	{
		//Find the position of the old item
		int position = this.positionOf(oldThing);
		
		//If resulting position is not negative...
		if(position > 0)
		{
			//...replace the object at the position with the new object and return true
			this.set(position, newThing);
			return true;
		}
		
		//Otherwise return false
		return false;
	}
	
	/**
	 * Returns the total value of the int data contained in each Adventurer
	 * item in the list
	 * 
	 * @return int total value of the levels of all the Adventurers in the list
	 */
	public int totalValue()
	{
		int total = 0;	//Tracks current total
		AdventurerNode current = head;	//Tracks current node
		
		//While the current node is not null...
		while(current != null)
		{
			//...add the current Adventurer object's level to the total
			total += current.getData().getLevel();
			//Set current node to the next node in the list
			current = current.getLink();
		}
		
		//Return the total number of levels
		return total;
	}
	
	/**
	 * Creates a new linked list of all the objects in the calling list
	 * that are less than or equal to the param based on the search key
	 * 
	 * @param element	Adventurer object to be compared to
	 * @return	LinkedAdventurerParty, a new list with all the objects that are
	 * 			equal to or less than the element compared to
	 */
	public LinkedAdventurerParty lessThanEqualTo(Adventurer element)
	{
		//New list to be added to
		LinkedAdventurerParty newParty = new LinkedAdventurerParty();
		AdventurerNode current = head;	//Tracks current Node
		
		//While the current node is not null...
		while(current != null)
		{
			//...check if the node is less than or equal to the element and add to list if so
			if(current.getData().compareTo(element) <= 0)
				newParty.add(current.getData());
			
			//Set current node to next node in list
			current = current.getLink();
		}
		
		//Return the new list
		return newParty;
	}
	
	/**
	 * Creates a new linked list of all the objects in the calling list
	 * that are greater than the param object based on the search key
	 * 
	 * @param element	Adventurer object to be compared to
	 * @return	LinkedAdventurerParty, a new list with all the objects that are
	 * 			greater than the element compared to
	 */
	public LinkedAdventurerParty greaterThan(Adventurer element)
	{
		//New list to be added to
		LinkedAdventurerParty newParty = new LinkedAdventurerParty();
		AdventurerNode current = head;	//Tracks current Node
		
		//While the current node is not null...
		while(current != null)
		{
			//...check if the node is less than or equal to the element and add to list if so
			if(current.getData().compareTo(element) > 0)
				newParty.add(current.getData());
			
			//Set current node to next node in list
			current = current.getLink();
		}
		
		//Return the new list
		return newParty;
	}
	
	/**
	 * This method searches the list for the object with the greatest
	 * search key
	 * 
	 * @return The Adventurer object with the greatest search key
	 */
	public Adventurer getMax()
	{
		try 
		{
		
			AdventurerNode current = head.getLink();	//Tracks current node
			Adventurer currentMax = head.getData();		//Tracks current max object
		
			//While the current node is not null...
			while(current != null)
			{
				//...if the current node's data is greater than currentMax, update the 
				//currentMax to the current node's data
				if(current.getData().compareTo(currentMax) > 0)
					currentMax = current.getData();
			
				//Set current node to next node in list
				current = current.getLink();
			}
		
			//Return the object that is the maximum in the list
			return currentMax;
		}
		catch(Exception e)
		{
			System.out.println(e);
			return null;
		}
	}
	
	/**
	 * This method searches the list for the object with the lowest search key
	 * 
	 * @return The Adventurer object with the lowest search key
	 */
	public Adventurer getMin()
	{
		try
		{
			AdventurerNode current = head.getLink();	//Tracks current node
			Adventurer currentMin = head.getData();		//Tracks current min object
		
			//While the current node being checked is not null...
			while(current != null)
			{
				//If the current node's data is less than the current min, set as new min
				if(current.getData().compareTo(currentMin) < 0)
					currentMin = current.getData();

				//Set current node to the next node in the list
				current = current.getLink();
			}
		
			//Return the lowest object found
			return currentMin;
		}
		catch(Exception e)
		{
			System.out.println(e);
			return null;
		}
	}
	
	/**
	 * Inserts items into the list in alphabetical order based on the search key
	 * 
	 * @param element Adventurer object to be added into the list
	 */
	public void insert(Adventurer element)
	{
		AdventurerNode current = head;	//Tracks current node
		boolean positionFound = false;	//Tracks if the new element's position is found
		
		//If the list is 0, add element at head
		if(manyItems == 0)
		{
			head = new AdventurerNode(element, head);
			manyItems++;
		}
		//If the new element is greater than the data at head, add element at head
		else if(current.getData().compareTo(element) < 0)
		{
			head = new AdventurerNode(element, head);
			manyItems++;
		}
		else
		{
			//While the current node's link is not null and position has not been found...
			while(current.getLink() != null && !positionFound)
			{
				//...check the data of the next node in the list compared to the new item
				if(current.getLink().getData().compareTo(element) <= 0)
				{
					//If the new element is greater than or equal to the next data in the list,
					//set the current node's link to a new adventurer node with the new data and the original next node as link
					current.setLink(new AdventurerNode(element, current.getLink()));
					positionFound = true;	//Mark position as being found
					manyItems++;
				}
				
				//Set current node to next node in list
				current = current.getLink();
			}
			
			//If the position has not been found after traversing the list, add element to end of list
			if(!positionFound)
			{
				current.setLink(new AdventurerNode(element, current.getLink()));
				manyItems++;
			}
			
		}
	}
}
