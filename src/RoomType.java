
public class RoomType {
	private String name;
	private int regularPrice;
	private int salePrice;
	private int maximumOccupancy;
	private int numberOfRooms;
	private int numberOfVacancies;
	
	public RoomType(String _name,int _regularPrice, int _salePrice, int _maximumOccupancy,int _numberOfRooms,int _numberOfVacancies)
	{
		name=_name;
		regularPrice=_regularPrice;
		salePrice=_salePrice;
		maximumOccupancy=_maximumOccupancy;
		numberOfRooms=_numberOfRooms;
		numberOfVacancies=_numberOfVacancies;
	}
	public String getName()
	{
		return name;
	}
	public int getRegularPrice()
	{
		return regularPrice;
	}
	public int getSalePrice()
	{
		return salePrice;
	}
	public int getMaximumOccupancy()
	{
		return maximumOccupancy;
	}
	public int getNumberOfRooms()
	{
		return numberOfRooms;
	}
	public int getNumberOfVacancies()
	{
		return numberOfVacancies;
	}
	public void setSalePrice(int _salePrice)
	{
		salePrice=_salePrice;
	}
	 public String toString()
	{
		return name+regularPrice+salePrice+numberOfRooms+numberOfVacancies;
	}
}
