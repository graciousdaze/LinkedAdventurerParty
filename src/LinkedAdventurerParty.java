/**
 * A collection class that stores Adventurer objects by using a linked list
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

}
