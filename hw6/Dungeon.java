/*
Jumana Suleiman 
*/

public class Dungeon{
	private Room livingRoom;
	private Room lowerHall;
	private Room kitchen;
	private Room bathroom;
	private Room upperHall;
	private Room bedroom;
	private Room patio;

	public Dungeon(){
		//rooms
		livingRoom = new Room("Living Room");
		lowerHall = new Room("Lower Hall");
		kitchen = new Room("Kitchen");
		bathroom = new Room("Bathroom");
		upperHall = new Room("Upper Hall");
		bedroom = new Room("Bedroom");
		patio = new Room("Patio");

		//exits //here
		livingRoom.setExits(bathroom, lowerHall, null, null);
		lowerHall.setExits(upperHall, kitchen, livingRoom, null);
		kitchen.setExits(bedroom, null, lowerHall, null);
		bathroom.setExits(null, upperHall, null, livingRoom);
		upperHall.setExits(patio, bedroom, bathroom, lowerHall);
		bedroom.setExits(null, null, upperHall, kitchen);
		patio.setExits(null, null, null, upperHall);

	}

	public Room getRoom0(){
		return lowerHall;
	}
}