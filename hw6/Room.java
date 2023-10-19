/*
Jumana Suleiman 
*/

public class Room{
	private String description;

	private Room north;
	private Room east;
	private Room west;
	private Room south;

	public Room(String description){
		this.description = description;
	}

	public void setNorth(Room north){
		this.north = north;
	}

	public void setEast(Room east){
		this.east = east;
	}

	public void setWest(Room west){
		this.west = west;
	}

	public void setSouth(Room south){
		this.south = south;
	}

	public void setExits(Room n, Room e, Room w, Room s){
		setNorth(n);
		setEast(e);
		setWest(w);
		setSouth(s);
	}

	public Room getNorth(){
		if(this.north == null){
			return null;
		}
		else{
		return this.north;
		}
	}

	public Room getEast(){
		if(this.east == null){
			return null;
		}
		else{
		return this.east;
		}
	}

	public Room getWest(){
		if(this.west == null){
			return null;
		}
		else{
		return this.west;
		}
	}

	public Room getSouth(){
		if(this.south == null){
			return null;
		}
		else{
		return this.south;
		}
	}

	public String getDescription(){
		return this.description;
	}

	public String getExits(){
		String roomExits = "";

		if(getNorth() != null){
			roomExits += "North \n";
		}
		if(getEast() != null){
			roomExits += "East \n";
		}
		if(getWest() != null){
			roomExits += "West \n";
		}
		if(getSouth() != null){
			roomExits += "South \n";
		}

		return roomExits;
	}

	public String toString(){
		return this.description + "\nIt's exits are:\n" +getExits();
	}
}