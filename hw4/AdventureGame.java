/*
Jumana Suleiman 
HW4: Adventure Game
*/
import java.util.Arrays;
import java.util.Scanner;

public class AdventureGame{

	static final int NUMBER_OF_ROOMS = 7;
	static final int NORTH = 0;
	static final int EAST = 1;
	static final int WEST = 2;
	static final int SOUTH = 3;
	static final int LIVING_ROOM = 0;
	static final int LOWER_HALL = 1;
	static final int KITCHEN = 2;
	static final int BATHROOM = 3;
	static final int UPPER_HALL = 4;
	static final int BEDROOM = 5;
	static final int PATIO = 6;
	static final int NUMBER_OF_EXITS = 4;

	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		String [] roomDescription = new String[NUMBER_OF_ROOMS];
		roomDescription[LIVING_ROOM] = "You are in the Living Room, exits are north and east.";
		roomDescription[LOWER_HALL] = "You are in the Lower Hall, exits are north, east, and west.";
		roomDescription[KITCHEN] = "You are in the Kitchen, exits are north and west.";
		roomDescription[BATHROOM] = "You are in the Bathroom, exits are east and south.";
		roomDescription[UPPER_HALL] = "You are in the Upper Hall, exits are north, east, west, and south.";
		roomDescription[BEDROOM] = "You are in the Bedroom, exits are west and south.";
		roomDescription[PATIO] = "You are in the Patio, exits are south.";

		int[][] exits = new int[NUMBER_OF_ROOMS][];
		exits[LIVING_ROOM] = new int[]{BATHROOM, LOWER_HALL, -1, -1};
		exits[LOWER_HALL] = new int[]{UPPER_HALL, KITCHEN, LIVING_ROOM, -1};
		exits[KITCHEN] = new int[]{BEDROOM, -1, LOWER_HALL, -1};
		exits[BATHROOM] = new int[]{-1, UPPER_HALL, -1, LIVING_ROOM};
		exits[UPPER_HALL] = new int[]{PATIO, BEDROOM, BATHROOM, LOWER_HALL};
		exits[BEDROOM] = new int[]{-1, -1, UPPER_HALL, KITCHEN};
		exits[PATIO] = new int[]{-1, -1, -1, UPPER_HALL};

		int currentRoom = LOWER_HALL;
		Boolean playerExitGame = false;

		while(playerExitGame==false){
		System.out.println(roomDescription[currentRoom]);	
		System.out.println("n:go to the north\n"+
			"s:go to the south\n" +
			"w:go to the west\n" +
			"e:go to the east\n" + 
			"q:quit the game and exit the program.");

		Character choice = Character.toLowerCase(input.nextLine().charAt(0));

		if(choice.equals('n')){
			if(exits[currentRoom][NORTH] == -1){
				System.out.println("There's no exit at North.");
			}
			else{
			currentRoom = exits[currentRoom][NORTH]; 
		}
		}

		else if(choice.equals('e')){
			if(exits[currentRoom][EAST] == -1){
				System.out.println("There's no exit at East.");
			}
			else{
			currentRoom = exits[currentRoom][EAST]; 
		}
		}

		else if(choice.equals('w')){
			if(exits[currentRoom][WEST] == -1){
				System.out.println("There's no exit at West.");
			}
			else{
			currentRoom = exits[currentRoom][WEST]; 
		}
		}

		else if(choice.equals('s')){
			if(exits[currentRoom][SOUTH] == -1){
				System.out.println("There's no exit at South.");
			}
			else{
			currentRoom = exits[currentRoom][SOUTH]; 
		}
		}
		else if(choice.equals('q')){
			playerExitGame = true;
		}
		else{
			System.out.println("Pick a valid direction!");
		}

		}
	}
}