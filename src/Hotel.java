
public class Hotel {
	private String name;
	private String address;
	private int starRating;
	private RoomType[] roomTypes;
	private int numRooms = 0;

	public Hotel(String _name, String _address, int _starRating, int _numRoomTypes) {
		name = _name;
		address = _address;
		starRating = _starRating;
		//numRooms = _numRoomTypes;
		roomTypes = new RoomType[_numRoomTypes];
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public int getStarRatings() {
		return starRating;
	}

	public RoomType getRoomTypes(int _numRoomTypes) {
		return roomTypes[_numRoomTypes];
	}

	public int getNumRoomTypes() {
		return roomTypes.length;
	}

	public boolean setRoomType(RoomType _roomTypes) {
		// int x=roomTypes.length;
		if (numRooms < roomTypes.length) {
			roomTypes[numRooms++] = _roomTypes;
			return true;
		} else {
			return false;
		}

	}

	public String toStrong() {
		return "Hotel: " + name + "\nAddress: " + address + "\nStarRating: " + starRating;
	}
}
