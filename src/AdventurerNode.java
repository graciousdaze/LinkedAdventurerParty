/**
 * Used as a part of a linked list that stores adventurer objects. Each node
 * contains an adventurer object and a link to the next node in the list.
 * 
 * @author Grace O'Brien
 * March 5th, 2020
 *
 */
public class AdventurerNode {
	
	private Adventurer data;	//Adventurer being held
	private AdventurerNode link;	//Link to the next node in list
	
	public AdventurerNode(Adventurer data, AdventurerNode link)
	{
		this.data = data;
		this.link = link;
	}
	
	/**
	 * Updates the node's data
	 * 
	 * @param data Adventurer to replace the data
	 */
	public void setData(Adventurer data)
	{
		this.data = data;
	}
	
	/**
	 * Returns the node's data
	 * 
	 * @return The node's data, an Adventurer object
	 */
	public Adventurer getData()
	{
		return data;
	}
	
	/**
	 * Updates the node's link
	 * 
	 * @param link The AdventurerNode for link to be updated to
	 */
	public void setLink(AdventurerNode link)
	{
		this.link = link;
	}
	
	/**
	 * Return's the Node's link, which is the next node in the list
	 * 
	 * @return The AdventurerNode that is next in the list
	 */
	public AdventurerNode getLink()
	{
		return link;
	}

}
