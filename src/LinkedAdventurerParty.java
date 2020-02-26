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

}
