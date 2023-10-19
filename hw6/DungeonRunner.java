/*
Jumana Suleiman 
*/

import java.util.Scanner;
import java.util.Random;

public class DungeonRunner{
	public static void main(String[] args){
		Dungeon dungeon = new Dungeon();
		Scanner input = new Scanner(System.in);
		Random ran = new Random();
		int randomNum = ran.nextInt(6);
		Room currentRoom = dungeon.getRoom0();

		System.out.println("What would you like the player name to be?");
		String playerName = input.nextLine();
		Player thePlayer = new Player(playerName, 100, 30, 3);

		boolean playerExitGame = false;

		while(playerExitGame == false){

			System.out.println(player.getName() + ",you are in the " + currentRoom);
			System.out.println("n:go to the north\n"+
			"s:go to the south\n" +
			"w:go to the west\n" +
			"e:go to the east\n" + 
			"q:quit the game and exit the program.");
			Character choice = Character.toLowerCase(input.nextLine().charAt(0));

			if(choice.equals('n')){
				if(currentRoom.getNorth() == null){
					System.out.println("There's no exit at North.");
				}
				else 
					currentRoom = currentRoom.getNorth(); 
			}

			else if(choice.equals('e')){
				if(currentRoom.getEast() == null){
					System.out.println("There's no exit at East.");
				}
				else
					currentRoom = currentRoom.getEast();
			}

			else if(choice.equals('w')){
			 	if(currentRoom.getWest() == null){
					System.out.println("There's no exit at West.");
				}
				else
					currentRoom = currentRoom.getWest();
			}

			else if(choice.equals('s')){
				if(currentRoom.getSouth() == null){
					System.out.println("There's no exit at South.");
				}
				else
					currentRoom = currentRoom.getSouth();
			}

			else if(choice.equals('q')){
			playerExitGame = true;
			}

			else{
			System.out.println("Pick a valid direction!");
			}

			if(randomNum == 2){
				thePlayer.getHealth() = 100;
				System.out.println(thePlayer.getName() + " found a healing potion, your health is now 100");
			}

			if(randomNum == 4){
				System.out.println("YOU HAVE FOUND A MONSTER!");
				Monster theMonster = new Monster("goblin", 12, 3, 25);
				System.out.println(theMonster.getName() + "has spawned");

				
			}
		}
	}
}