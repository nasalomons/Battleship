package ships;

import battlefield.Coordinates;


/* The Tugboat class is a mutable class that extends Ship. It is the smallest of all the Ships at a size of two. */
public class Tugboat implements Ship{

	private Coordinates coordinates;
	private boolean hitStatus;
	private boolean sunkStatus;
	private Tugboat otherPart;
	
	public Tugboat(Coordinates startCoordinates, Coordinates endCoordinates, Tugboat otherPart) {
		if((startCoordinates.getRow()-endCoordinates.getRow()==1&&startCoordinates.getCol()==endCoordinates.getCol())
				||(startCoordinates.getRow()-endCoordinates.getRow()==-1&&startCoordinates.getCol()==
				endCoordinates.getCol())||(startCoordinates.getCol()-endCoordinates.getCol()==1&&
				startCoordinates.getRow()==endCoordinates.getRow())||(startCoordinates.getCol()
				-endCoordinates.getCol()==-1&&startCoordinates.getRow()==endCoordinates.getRow())) {
			this.coordinates = startCoordinates;
			this.otherPart = otherPart;
		} else {
			throw new RuntimeException("Invalid Tugboat Coordinates:" + startCoordinates + ", " + 
					endCoordinates);
		}
	}
	
	/* Returns the coordinates of the Tugboat. */
	public Coordinates getCoordinates() {
		return coordinates;
	}
	
	/* Sets hitStatus to true. */
	public void beHit() {
		hitStatus = true;
	}
	/* Sets sunkStatus to true. */
	public void beSunk() {
		sunkStatus = true;
	}
	
	/* This method returns the hitStatus of the Tugboat. */
	public boolean isHit() {
		return hitStatus;
	}
	
	/* Returns a reference to the Ship object the current object is "attached" to. */
	public Ship getOtherPart() {
		return otherPart;
	}
	
	/* The toString method of the Tugboat class that returns a String. It will return a String that looks like
	 * [H] if the Sea's hitStatus is true and a String that looks like [T] if it's false. */
	public String toString() {
		if(sunkStatus) {
			return "[s]";
		} else if(hitStatus) {
			return "[h]";
		} else {
			return "[T]";
		}
	}
}
