/**
 * DESCRIPTION!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
 * 
 * @author Grace O'Brien
 * March 5th, 2020
 *
 */
public class AdventurerNode {
	
	private Adventurer data;
	private AdventurerNode link;
	
	public AdventurerNode(Adventurer data, AdventurerNode link)
	{
		this.data = data;
		this.link = link;
	}
	
	public void setData(Adventurer data)
	{
		this.data = data;
	}
	
	public Adventurer getData()
	{
		return data;
	}
	
	public void setLink(AdventurerNode link)
	{
		this.link = link;
	}
	
	public AdventurerNode getLink()
	{
		return link;
	}

}
